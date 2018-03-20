package com.ahb.common.web;

import com.ahb.common.node.Node;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

/**
 * Created by aheroboy on 16/3/2018.
 */
public class ServletHandlerBuilder {

    private String contextPath;
    private String servletName;
    private String servletMappingUrl;
    private Node node;

    public static ServletHandlerBuilder newInstance() {
        return new ServletHandlerBuilder();
    }

    public ServletHandlerBuilder ofServletName(String servletName) {
        this.servletName = servletName;
        return this;
    }

    public ServletHandlerBuilder ofServletMappingUrl(String url) {
        this.servletMappingUrl = url;
        return this;
    }

    public ServletHandlerBuilder ofContextPath(String contextPath) {
        this.contextPath = contextPath;
        return this;
    }

    public ServletHandlerBuilder ofNode(Node node) {
        this.node = node;
        return this;
    }

    public ServletContextHandler build() {
        ServletContextHandler handler = new ServletContextHandler();
        handler.setContextPath(contextPath);
        handler.addServlet(new ServletHolder(new DispatchServlet(servletName, node)), servletMappingUrl);
        return handler;
    }
}
