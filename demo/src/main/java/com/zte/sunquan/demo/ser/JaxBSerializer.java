package com.zte.sunquan.demo.ser;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.transform.dom.DOMResult;

/**
 * Created by 10184538 on 2018/3/13.
 */
public class JaxBSerializer {

    private JaxBSerializer() {

    }

    public static JaxBSerializer getInstance() {
        return Singleton.INSTANCE.getInstance();
    }

    private enum Singleton {
        INSTANCE;
        private JaxBSerializer singleton;

        Singleton() {
            singleton = new JaxBSerializer();
        }

        public JaxBSerializer getInstance() {
            return singleton;
        }
    }

    private static final JAXBContext JAXB_CONTEXT;

    static {
        try {
            JAXB_CONTEXT = JAXBContext.newInstance(NetconfState.class);
        } catch (JAXBException e) {
            throw new ExceptionInInitializerError(e);
        } catch (Exception e) {
            throw e;
        }

    }

    public Element toXml(final NetconfState monitoringModel) {
        final DOMResult res;
        try {
            final Marshaller marshaller = JAXB_CONTEXT.createMarshaller();

            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            res = new DOMResult();
            marshaller.marshal(monitoringModel, res);
        } catch (final JAXBException e) {
            throw new RuntimeException("Unable to serialize netconf state " + monitoringModel, e);
        }
        return ((Document) res.getNode()).getDocumentElement();
    }

    public static void main(String[] args) {
        NetconfState state=new NetconfState();
    }
}
