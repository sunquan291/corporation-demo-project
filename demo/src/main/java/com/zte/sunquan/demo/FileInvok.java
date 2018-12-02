package com.zte.sunquan.demo;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.LongSummaryStatistics;
import java.util.stream.Collectors;
import java.util.stream.Stream;


/**
 * Created by 10184538 on 2017/7/12.
 */
public class FileInvok {
    @Test
    public void test() throws IOException {
        Path startPath = Paths.get("E:/sunquan-project");
        FindFileVisitor findFileVisitor = new FindFileVisitor();
        Files.walkFileTree(startPath, findFileVisitor);
        findFileVisitor.getFilenameList().forEach(System.out::println);
//        Files.walk(startPath)
//                .filter(p -> p.endsWith(".java"))
//                .forEach(System.out::println);
    }

    class FindFileVisitor extends SimpleFileVisitor<Path> {
        private List<String> filenameList = new ArrayList<String>();

        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            if (file.toString().endsWith(".java")) {
                filenameList.add(file.toString());
            }
            return FileVisitResult.CONTINUE;

        }

        public List<String> getFilenameList() {
            return filenameList;
        }

        public void setFilenameList(List<String> filenameList) {
            this.filenameList = filenameList;
        }
    }

    public int get() {
        System.out.println("get");
        return 0;
    }

    @Test
    public void testOption() {
        com.google.common.base.Optional optional = com.google.common.base.Optional.fromNullable(1);
        Object or = optional.or(get());
        System.out.println(or);
        optional.or(() -> {
            System.out.println("hell,world");
            return 0;
        });
        System.out.println(or);
    }

    class UserDomain {
        private long value;

        public UserDomain(long value) {
            this.value = value;
        }

        public long getValue() {
            return value;
        }

        public void setValue(long value) {
            this.value = value;
        }
    }

    @Test
    public void test2() {
        List<String> hello = Lists.newArrayList("d", "db", "da", "a", "b", "c");
        String collect = hello.stream().distinct().sorted().collect(java.util.stream.Collectors.joining(","));
        System.out.println(collect);
    }

    @Test
    public void test3() {
        List<UserDomain> userDomains = Lists.newArrayList();
        for (int i = 0; i < 1000000; i++) {
            userDomains.add(new UserDomain(i));
        }
        long start = System.currentTimeMillis();
        userDomains.stream().map(UserDomain::getValue).reduce(Math::min).orElse(0L);
//        userDomains.stream().mapToLong(UserDomain::getValue).reduce(Math::min).orElse(0L);
        System.out.println(System.currentTimeMillis() - start);

        LongSummaryStatistics collect = userDomains.stream().collect(Collectors.summarizingLong(UserDomain::getValue));
        System.out.println(collect);
    }

    @Test
    public void testFileLine() {
        long uniqueWords = 0;
        try (Stream<String> lines =
                     Files.lines(Paths.get("/A.java"), Charset.defaultCharset())) {
            uniqueWords = lines.flatMap(line -> Arrays.stream(line.split(" ")))
                    .distinct()
                    .count();
            System.out.println(uniqueWords);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
