package com.ahb.common.web;

import com.ahb.common.Conf;
import com.ahb.common.LifeCycle;
import com.ahb.common.node.NodeImpl;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.ContextHandlerCollection;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.server.session.SessionHandler;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by aheroboy on 15/3/2018.
 */
public class WebEngineImpl implements WebEngine, LifeCycle {
    protected static final Logger LOGGER = LoggerFactory.getLogger(WebEngineImpl.class);
    private int port = 8080;
    private static String WEB_BASE = "infrastructure/api/src/main/resources/public";
    private Thread webEngineThread;
    private Server server;
    private Conf conf;

    public WebEngineImpl(Conf conf){
        this.conf = conf;
    }
    public void start() throws Exception {
        webEngineThread.start();
    }

    @Override
    public void stop() throws Exception {
        webEngineThread.interrupt();
    }

    @Override
    public void init() {
        this.port = conf.getWebPort();
        server = new Server(port);
        ResourceHandler resourceHandler = new ResourceHandler();

        // Add the ResourceHandler to the server.
        resourceHandler.setDirectoriesListed(true);
        resourceHandler.setWelcomeFiles(new String[]{"index.html"});
        resourceHandler.setResourceBase(WEB_BASE);
        System.out.println(resourceHandler.getBaseResource());

        SessionHandler sessionHandler = new SessionHandler();
        SecurityHandler securityHandler = new SecurityHandler();

        ContextHandlerCollection servletContext = new ContextHandlerCollection();
        ServletContextHandler servletContextHandler = ServletHandlerBuilder.newInstance().ofContextPath("/")
                .ofNode(NodeImpl.NodeHolder.INSTANCE.getNode())
                .ofServletName("AHB")
                .ofServletMappingUrl("/ahb/*")
                .build();
        servletContext.setHandlers(new Handler[]{servletContextHandler});

        securityHandler.setHandler(servletContext);
        sessionHandler.setHandler(securityHandler);
        resourceHandler.setHandler(sessionHandler);

        server.setHandler(resourceHandler);
        webEngineThread = new Thread(() -> {
            try {
                server.start();
                LOGGER.info("Web server serve at port " + port);
                server.join();
            } catch (Exception e) {
                server.dumpStdErr();
                throw new RuntimeException(e);
            }
        });
    }

    @Override
    public boolean isRunning() {
        return false;
    }

    @Override
    public boolean isStarted() {
        return false;
    }

    @Override
    public boolean isStarting() {
        return false;
    }

    @Override
    public boolean isStopping() {
        return false;
    }

    @Override
    public boolean isStopped() {
        return false;
    }
}
