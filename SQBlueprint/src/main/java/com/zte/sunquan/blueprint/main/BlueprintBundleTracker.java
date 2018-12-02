package com.zte.sunquan.blueprint.main;

import org.apache.aries.blueprint.NamespaceHandler;
import org.apache.aries.blueprint.services.BlueprintExtenderService;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.BundleEvent;
import org.osgi.framework.FrameworkUtil;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;
import org.osgi.framework.SynchronousBundleListener;
import org.osgi.service.blueprint.container.EventConstants;
import org.osgi.service.event.Event;
import org.osgi.service.event.EventHandler;
import org.osgi.util.tracker.BundleTrackerCustomizer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collections;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;

/**
 * Created by 10184538 on 2017/11/7.
 */
public class BlueprintBundleTracker implements BundleActivator, BundleTrackerCustomizer<Bundle>, EventHandler,
        SynchronousBundleListener {
    private static final Logger LOG = LoggerFactory.getLogger(BlueprintBundleTracker.class);
    private static final String BLUEPRINT_FILE_PATH = "org/opendaylight/blueprint/";
    private static final String BLUEPRINT_FLE_PATTERN = "*.xml";
    private ServiceRegistration<?> namespaceReg;
    private ServiceRegistration<?> eventHandlerReg;

    @Override
    public Bundle addingBundle(Bundle bundle, BundleEvent event) {
        return null;
    }

    @Override
    public void modifiedBundle(Bundle bundle, BundleEvent event, Bundle object) {

    }

    @Override
    public void removedBundle(Bundle bundle, BundleEvent event, Bundle object) {

    }

    @Override
    public void bundleChanged(BundleEvent event) {

    }

    @Override
    public void handleEvent(Event event) {
        System.out.println("Got bluepirnt event:" + event.getTopic());

        if (EventConstants.TOPIC_CREATED.equals(event.getTopic())) {
            Object property = event.getProperty(EventConstants.BUNDLE);
            System.out.println("Blueprint container for bundle " + property + " was successfully created");

        } else if (EventConstants.TOPIC_FAILURE.equals(event.getTopic())) {
            Object property = event.getProperty(EventConstants.BUNDLE);
            System.out.println("Blueprint container for bundle " + property + " was not created");
            //如果是失败由于依赖找不到超时 重启bundle
            if (event.getProperty(EventConstants.DEPENDENCIES) != null) {
                Bundle bundle = (Bundle) event.getProperty(EventConstants.BUNDLE);
                List<Object> paths = findBlueprintPaths(bundle);
                if (!paths.isEmpty()) {
                    System.out.println("Blueprint container for bundle " + bundle + " timed out waiting for dependencies - restarting it");
                    BlueprintExtenderService blueprintExtenderService = get(BlueprintExtenderService.class);
                    blueprintExtenderService.destroyContainer(bundle,blueprintExtenderService.getContainer(bundle));
                    blueprintExtenderService.createContainer(bundle, paths);
//                    restartService.restartContainer(bundle, paths);
                }
            }
        }

    }

    @Override
    public void start(BundleContext context) throws Exception {
        LOG.info("SQBlueprint bundle starting...");
        registerNamespaceHandler(context);
        registerBlueprintEventHandler(context);
    }

    private void registerNamespaceHandler(BundleContext context) {
        Dictionary<String, Object> sqNamespaceProperty = new Hashtable<>();
        sqNamespaceProperty.put("osgi.service.blueprint.namespace",
                SQNamespaceHandler.NAMESPACE_1_0_0);
        namespaceReg = context.registerService(NamespaceHandler.class.getName(),
                new SQNamespaceHandler(), sqNamespaceProperty);
    }

    private void registerBlueprintEventHandler(BundleContext context) {
        Dictionary<String, Object> props = new Hashtable<>();
        props.put(org.osgi.service.event.EventConstants.EVENT_TOPIC,
                new String[]{EventConstants.TOPIC_CREATED, EventConstants.TOPIC_FAILURE});
        eventHandlerReg = context.registerService(EventHandler.class.getName(), this, props);
    }
    static List<Object> findBlueprintPaths(Bundle bundle) {
        Enumeration<?> rntries = bundle.findEntries(BLUEPRINT_FILE_PATH, BLUEPRINT_FLE_PATTERN, false);
        if (rntries == null) {
            return Collections.emptyList();
        } else {
            return Collections.list((Enumeration)rntries);
        }
    }
    public static <T> T get(Class<T> serviceClass) {
        Bundle bundle = FrameworkUtil.getBundle(serviceClass);
        BundleContext bc = null;
        if (bundle != null && (bc = bundle.getBundleContext()) != null) {
            ServiceReference<T> reference = bc.getServiceReference(serviceClass);
            if (reference != null) {
                T impl = bc.getService(reference);
                if (impl != null) {
                    return impl;
                }
            }
        }
        throw new RuntimeException("Service " + serviceClass.getName() + " not found");
    }

    @Override
    public void stop(BundleContext context) throws Exception {
        System.out.println("SQBlueprint bundle stop...");
    }
}
