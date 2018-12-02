package com.zte.sunquan.blueprint.main;

import org.apache.aries.blueprint.NamespaceHandler;
import org.apache.aries.blueprint.ParserContext;
import org.apache.aries.blueprint.mutable.MutableBeanMetadata;
import org.apache.aries.blueprint.mutable.MutableRefMetadata;
import org.apache.aries.blueprint.mutable.MutableValueMetadata;
import org.osgi.service.blueprint.reflect.BeanMetadata;
import org.osgi.service.blueprint.reflect.ComponentMetadata;
import org.osgi.service.blueprint.reflect.Metadata;
import org.osgi.service.blueprint.reflect.RefMetadata;
import org.osgi.service.blueprint.reflect.ReferenceMetadata;
import org.osgi.service.blueprint.reflect.ValueMetadata;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Attr;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import javax.xml.bind.DatatypeConverter;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by 10184538 on 2017/11/7.
 */
public class SQNamespaceHandler implements NamespaceHandler {
    private static final Logger LOG = LoggerFactory.getLogger(SQNamespaceHandler.class);
    public static final String NAMESPACE_1_0_0 = "http://opendaylight.org/xmlns/blueprint/v1.0.0";

    @Override
    public URL getSchemaLocation(String namespace) {
        if (NAMESPACE_1_0_0.equals(namespace)) {
            URL url = getClass().getResource("/opendaylight-blueprint-ext-1.0.0.xsd");
            System.out.println("schema loaction url:" + url);
            return url;
        }
        return null;
    }

    @Override
    public Set<Class> getManagedClasses() {
        return Collections.emptySet();
    }

    private static RefMetadata createRef(final ParserContext context, final String id) {
        MutableRefMetadata metadata = context.createMetadata(MutableRefMetadata.class);
        metadata.setComponentId(id);
        return metadata;
    }

    private static ValueMetadata createValue(final ParserContext context, final String value) {
        MutableValueMetadata metadata = context.createMetadata(MutableValueMetadata.class);
        metadata.setStringValue(value);
        return metadata;
    }

    @Override
    public Metadata parse(Element element, ParserContext context) {
        System.out.println("start to parse element: " + element);
        System.out.println(element);
        if (nodeNameEquals(element, "rpc-implementation")) {
            System.out.println("result:" + element.getAttribute("ref"));

        } else if (nodeNameEquals(element, "sq-print")) {
            System.out.println("result:" + element.getAttribute("value"));
            MutableBeanMetadata metadata = context.createMetadata(MutableBeanMetadata.class);
            metadata.setId(context.generateId());
            metadata.setScope(BeanMetadata.SCOPE_SINGLETON);
            metadata.setActivation(ReferenceMetadata.ACTIVATION_EAGER);
            metadata.setRuntimeClass(SQPrintServiceBean.class);
            metadata.setInitMethod("init");
            metadata.addProperty("value", createValue(context, element.getAttribute("value")));
            //            metadata.addProperty("printService", createRef(context, "com.zte.sdn.oscp.yang.gen.v1.ip.device.rev20170324.SQPrintService"));
            return metadata;

        }
        MutableBeanMetadata metadata = context.createMetadata(MutableBeanMetadata.class);
        metadata.setId(context.generateId());
        metadata.setScope(BeanMetadata.SCOPE_SINGLETON);
        metadata.setActivation(ReferenceMetadata.ACTIVATION_EAGER);
        metadata.setRuntimeClass(RpcImplementationBean.class);
        metadata.setInitMethod("init");
        metadata.setDestroyMethod("destroy");
//        metadata.addProperty("bundle", createRef(context, "blueprintBundle"));
//        metadata.addProperty("rpcRegistry", createRef(context, RPC_REGISTRY_NAME));
//        metadata.addProperty("implementation", createRef(context, element.getAttribute(REF_ATTR)));

//        if (element.hasAttribute(INTERFACE)) {
//            metadata.addProperty("interfaceName", createValue(context, element.getAttribute(INTERFACE)));
//        }

        LOG.debug("parseRpcImplementation returning {}", metadata);
        return metadata;
    }

    @Override
    public ComponentMetadata decorate(Node node, ComponentMetadata componentMetadata, ParserContext context) {
        System.out.println("decorate....");
        if (node instanceof Attr) {
            Attr attr = (Attr) node;
            System.out.println("Attribute:" + attr.getName() + ":" + attr.getValue());
        }
        //一定要返回
        if (componentMetadata == null) {
            MutableBeanMetadata metadata = context.createMetadata(MutableBeanMetadata.class);
            metadata.setId("123");
            return metadata;
        }
        return componentMetadata;
    }

    private static boolean nodeNameEquals(final Node node, final String name) {
        return name.equals(node.getNodeName()) || name.equals(node.getLocalName());
    }

    private static MessageDigest md = null;
    private static ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    private static ReentrantReadWriteLock.WriteLock writeLock;

    static {
        writeLock = lock.writeLock();
    }

    public static String getSHA256(String password) {
        byte[] bytes = null;
        try {
            bytes = password.getBytes("utf-8");
            if (md == null) {
                writeLock.lock();
                if (md == null) {
                    md = MessageDigest.getInstance("SHA-256");
                }
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } finally {
            writeLock.unlock();
        }
        byte[] out = null;
        if (bytes != null) {
            try {
                writeLock.lock();
                md.update(bytes);
                out = md.digest();
            } finally {
                writeLock.unlock();
            }
        }
        return DatatypeConverter.printBase64Binary(out);
    }

    public static void main(String[] args) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        String password = "admin";
        String salt = "FYINFOWXDLIL";

        byte data[] = password.getBytes();
        byte SALT[] = salt.getBytes();

        byte[] temp = new byte[data.length + SALT.length];
        System.arraycopy(data, 0, temp, 0, data.length);
        System.arraycopy(SALT, 0, temp, data.length, SALT.length);

        String encStr = password + salt;
        byte[] bytes = encStr.getBytes();

        md.update(bytes);
        byte[] by = md.digest();

        String s = DatatypeConverter.printBase64Binary(by);
        System.out.println(s);

        System.out.println(getSHA256(password + salt));
    }
}
