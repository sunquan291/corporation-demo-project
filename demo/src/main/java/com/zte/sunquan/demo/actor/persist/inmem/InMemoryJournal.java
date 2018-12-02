package com.zte.sunquan.demo.actor.persist.inmem;

import akka.dispatch.Futures;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import akka.persistence.AtomicWrite;
import akka.persistence.PersistentImpl;
import akka.persistence.PersistentRepr;
import akka.persistence.journal.japi.AsyncWriteJournal;
import com.google.common.collect.Maps;
import org.apache.commons.lang.SerializationUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import scala.concurrent.Future;

import java.io.Serializable;
import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalLong;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class InMemoryJournal extends AsyncWriteJournal {

//    static final Logger LOG = LoggerFactory.getLogger(InMemoryJournal.class);
    private LoggingAdapter LOG = Logging.getLogger(context().system(), this);
    private static final Map<String, Map<Long, Object>> journals = new ConcurrentHashMap<>();

    @Override
    public Future<Void> doAsyncReplayMessages(final String persistenceId, final long fromSequenceNr,
                                              final long toSequenceNr, final long max, final Consumer<PersistentRepr> replayCallback) {
        LOG.info("doAsyncReplayMessages for {}: fromSequenceNr: {}, toSequenceNr: {}", persistenceId,
                fromSequenceNr, toSequenceNr);

        return Futures.future(() -> {

            Map<Long, Object> journal = journals.get(persistenceId);
            if (journal == null) {
                return null;
            }
            synchronized (journal) {
                int count = 0;
                Set<Long> needRecover = journal.keySet().stream().filter(sq -> sq >= fromSequenceNr && sq <= toSequenceNr)
                        .limit(max).collect(Collectors.toSet());
                needRecover.stream().forEach(sq -> {
                    Object data = journal.get(sq);
                    PersistentRepr persistentMessage =
                            new PersistentImpl(deserialize(data), sq, persistenceId,
                                    null, false, null, null);
                    replayCallback.accept(persistentMessage);
                });
            }
            return null;
        }, context().dispatcher());
    }

    private static Object deserialize(Object data) {
        return data instanceof byte[] ? SerializationUtils.deserialize((byte[]) data) : data;
    }

    @Override
    public Future<Long> doAsyncReadHighestSequenceNr(String persistenceId, long fromSequenceNr) {
        LOG.info("doAsyncReadHighestSequenceNr for {}: fromSequenceNr: {}", persistenceId, fromSequenceNr);

        Map<Long, Object> journal = journals.get(persistenceId);
        if (journal == null) {
            return Futures.successful(fromSequenceNr);
        }

        long sequenceNr = -1;
        synchronized (journal) {
            OptionalLong max = journal.keySet().stream().mapToLong(Long::longValue).max();
            if (max.isPresent() && max.getAsLong() >= fromSequenceNr) {
                sequenceNr = max.getAsLong();
            }
        }
        return Futures.successful(sequenceNr);
    }

    @Override
    public Future<Iterable<Optional<Exception>>> doAsyncWriteMessages(Iterable<AtomicWrite> messages) {
        return Futures.future(() -> {
            for (AtomicWrite write : messages) {
                PersistentRepr[] array = new PersistentRepr[write.payload().size()];
                write.payload().copyToArray(array);
                for (PersistentRepr repr : array) {
                    LOG.info("doAsyncWriteMessages: id: {}: seqNr: {}, payload: {}", repr.persistenceId(),
                            repr.sequenceNr(), repr.payload());
                    journals.putIfAbsent(repr.persistenceId(), Maps.newLinkedHashMap());
                    journals.get(repr.persistenceId()).put(repr.sequenceNr(),
                            repr.payload() instanceof Serializable ?
                                    SerializationUtils.serialize((Serializable) repr.payload()) : repr.payload());
                }
            }
            return Collections.emptyList();
        }, context().dispatcher());
    }

    @Override
    public Future<Void> doAsyncDeleteMessagesTo(String persistenceId, long toSequenceNr) {
        LOG.info("doAsyncDeleteMessagesTo: {}", toSequenceNr);
        Map<Long, Object> journal = journals.get(persistenceId);
        Set<Long> needDel = journals.get(persistenceId).keySet().stream()
                .filter(sq -> sq <= toSequenceNr)
                .collect(Collectors.toSet());
        needDel.stream().forEach(journal::remove);
        return Futures.successful(null);
    }
}
