package com.zte.sunquan.demo.jetty;

import org.eclipse.jetty.security.HashLoginService;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.ContextHandlerCollection;
import org.eclipse.jetty.webapp.WebAppContext;
import org.junit.After;
import org.junit.Before;

/**
 * Created by 10184538 on 2017/11/6.
 */
public class SecuredHelloHandler2 {
    protected Server alfrescoServer = null;


    protected String[] getConnectorNames() {
        return new String[]{"Alfresco"};
    }

    protected String[] getConnectorClasses() {
        return new String[]{"org.apache.manifoldcf.crawler.connectors.alfresco.AlfrescoRepositoryConnector"};
    }

    protected String[] getOutputNames() {
        return new String[]{"Null Output"};
    }

    protected String[] getOutputClasses() {
        return new String[]{"org.apache.manifoldcf.agents.output.nullconnector.NullConnector"};
    }

    // Setup/teardown

    @Before
    public void setUpAlfresco()
            throws Exception {
        alfrescoServer = new Server(9090);
        alfrescoServer.setStopAtShutdown(true);

        String alfrescoServerWarPath = "../../connectors/alfresco/alfresco-war/alfresco.war";

        if (System.getProperty("alfrescoServerWarPath") != null)
            alfrescoServerWarPath = System.getProperty("alfrescoServerWarPath");

        //Initialize Alfresco Server bindings
        ContextHandlerCollection contexts = new ContextHandlerCollection();
        alfrescoServer.setHandler(contexts);

        WebAppContext alfrescoServerApi = new WebAppContext(alfrescoServerWarPath, "/alfresco");
        alfrescoServerApi.setParentLoaderPriority(false);
        HashLoginService dummyLoginService = new HashLoginService("TEST-SECURITY-REALM");
        alfrescoServerApi.getSecurityHandler().setLoginService(dummyLoginService);
        contexts.addHandler(alfrescoServerApi);


        HelloHandler hh = new HelloHandler();

        // chain the hello handler into the security handler
        alfrescoServer.setHandler(hh);

        // Start things up!
        alfrescoServer.start();

        // The use of server.join() the will make the current thread join and
        // wait until the server is done executing.
        // See
        // http://docs.oracle.com/javase/7/docs/api/java/lang/Thread.html#join()
        alfrescoServer.join();

//        Class h2DataSource = Thread.currentThread().getContextClassLoader().loadClass("org.h2.jdbcx.JdbcDataSource");
//        Object o = h2DataSource.newInstance();
//        String jdbcUrl = "jdbc:h2:.alf_data_jetty/h2_data/alf_jetty";
//        String jdbcUsername = "alfresco";
//        String jdbcPassword = "alfresco";
//        String jdbcJndiName = "jdbc/dataSource";
//        h2DataSource.getMethod("setURL", new Class[] {String.class}).invoke(o, new Object[] {jdbcUrl});
//        h2DataSource.getMethod("setUser", new Class[] {String.class}).invoke(o, new Object[] {jdbcUsername});
//        h2DataSource.getMethod("setPassword", new Class[] {String.class}).invoke(o, new Object[] {jdbcPassword});
//
//        Resource jdbcResource = new Resource(jdbcJndiName, o);
//
//        alfrescoServer.start();
//        boolean entered = false;
//
//        while(alfrescoServer.isStarted()
//                && alfrescoServerApi.isStarted()
//                && !entered){
//            entered = true;
//            Thread.sleep(5000);
//        }
    }

    @After
    public void cleanUpAlfresco()
            throws Exception {
    }
}
