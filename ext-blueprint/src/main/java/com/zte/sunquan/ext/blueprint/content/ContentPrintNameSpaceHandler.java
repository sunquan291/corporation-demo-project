package com.zte.sunquan.ext.blueprint.content;

import java.net.URL;
import java.util.Collections;
import java.util.Set;

import org.apache.aries.blueprint.NamespaceHandler;
import org.apache.aries.blueprint.ParserContext;
import org.apache.aries.blueprint.mutable.MutableBeanMetadata;
import org.apache.aries.blueprint.mutable.MutableValueMetadata;
import org.osgi.service.blueprint.reflect.BeanMetadata;
import org.osgi.service.blueprint.reflect.ComponentMetadata;
import org.osgi.service.blueprint.reflect.Metadata;
import org.osgi.service.blueprint.reflect.ReferenceMetadata;
import org.osgi.service.blueprint.reflect.ValueMetadata;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

/**
 * ContentPrintNameSpaceHandler class
 *
 * @author 10184538
 * @date 2019/2/23
 */
public class ContentPrintNameSpaceHandler implements NamespaceHandler {
    private static final Logger LOG = LoggerFactory.getLogger(ContentPrintNameSpaceHandler.class);
    public static final String NAMESPACE_1_0_0 = "http://blog.csdn.net/sunquan291/xmlns/blueprint/v1.0.0";

    @Override
    public URL getSchemaLocation(String namespace) {
        if (NAMESPACE_1_0_0.equals(namespace)) {
            return getClass().getResource("/sq-blueprint-ext-1.0.0.xsd");
        }
        return null;
    }

    @Override
    public Set<Class> getManagedClasses() {
        return Collections.emptySet();
    }

    @Override
    public Metadata parse(Element element, ParserContext context) {
        if (nodeNameEquals(element, "content-print")) {
            MutableBeanMetadata metadata = context.createMetadata(MutableBeanMetadata.class);
            metadata.setId(context.generateId());
            metadata.setScope(BeanMetadata.SCOPE_SINGLETON);
            metadata.setActivation(ReferenceMetadata.ACTIVATION_EAGER);
            metadata.setRuntimeClass(ContentPrintServiceBean.class);
            metadata.setInitMethod("init");
            metadata.addProperty("value", createValue(context, element.getAttribute("value")));
            return metadata;
        }
        return null;
    }


    @Override
    public ComponentMetadata decorate(Node node, ComponentMetadata componentMetadata, ParserContext context) {
        if (componentMetadata == null) {
            MutableBeanMetadata metadata = context.createMetadata(MutableBeanMetadata.class);
            metadata.setId("123456");
            return metadata;
        }
        return componentMetadata;
    }

    private static boolean nodeNameEquals(final Node node, final String name) {
        return name.equals(node.getNodeName()) || name.equals(node.getLocalName());
    }

    private static ValueMetadata createValue(final ParserContext context, final String value) {
        MutableValueMetadata metadata = context.createMetadata(MutableValueMetadata.class);
        metadata.setStringValue(value);
        return metadata;
    }
}
