package com.zte.sunquan.ext.blueprint.content;

import java.util.Dictionary;
import java.util.Hashtable;

import org.apache.aries.blueprint.NamespaceHandler;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.blueprint.container.EventConstants;
import org.osgi.service.event.Event;
import org.osgi.service.event.EventHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * ContentPrintActivator class
 *
 * @author 10184538
 * @date 2019/2/23
 */
public class ContentPrintActivator implements BundleActivator, EventHandler {
    private static final Logger LOG = LoggerFactory.getLogger(ContentPrintActivator.class);
    private ServiceRegistration<?> namespaceReg;
    private ServiceRegistration<?> eventHandlerReg;

    @Override
    public void start(BundleContext context) throws Exception {
        LOG.info("Content-print start...");
        registerNameSpaceHandler(context);
        registerBlueprintEventHandler(context);
    }

    @Override
    public void stop(BundleContext context) throws Exception {
        LOG.info("Content-print stop...");
    }


    @Override
    public void handleEvent(Event event) {
        if (EventConstants.TOPIC_CREATED.equals(event.getTopic())) {
            Object property = event.getProperty(EventConstants.BUNDLE);
            LOG.info("Blueprint container for bundle {} was successfully created.", property);
        } else if (EventConstants.TOPIC_FAILURE.equals(event.getTopic())) {
            Object property = event.getProperty(EventConstants.BUNDLE);
            LOG.info("Blueprint container for bundle {} was not created.", property);
        }
    }

    private void registerNameSpaceHandler(BundleContext context) {
        Dictionary<String, Object> namespaceProperty = new Hashtable<>();
        namespaceProperty.put("osgi.service.blueprint.namespace",
                ContentPrintNameSpaceHandler.NAMESPACE_1_0_0);
        namespaceReg = context.registerService(NamespaceHandler.class.getName(),
                new ContentPrintNameSpaceHandler(), namespaceProperty);
    }

    private void registerBlueprintEventHandler(BundleContext context) {
        Dictionary<String, Object> props = new Hashtable<>();
        props.put(org.osgi.service.event.EventConstants.EVENT_TOPIC,
                new String[]{EventConstants.TOPIC_CREATED, EventConstants.TOPIC_FAILURE});
        eventHandlerReg = context.registerService(EventHandler.class.getName(), this, props);
    }

}
