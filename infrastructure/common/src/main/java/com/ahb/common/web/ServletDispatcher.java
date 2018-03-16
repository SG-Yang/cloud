package com.ahb.common.web;

import com.ahb.common.node.Node;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by aheroboy on 15/3/2018.
 */
public class ServletDispatcher extends HttpServlet {
    private String name;

    private PathResolver resolver;
    private Node node;

    public ServletDispatcher(String name, Node node) {
        this.name = name;
        this.node = node;
    }

    @Override
    public void init() throws ServletException {
        resolver = new CachedPathResolver();
        resolver.init();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Do get!!!!!! " + this.name);
        doPost(req, resp);
    }

    @Override
    protected long getLastModified(HttpServletRequest req) {
        return super.getLastModified(req);
    }

    @Override
    protected void doHead(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        InternalReq internalReq = InternalReqBuilder.newInstance()
                .ofServletRequest(req).build();
        InternalResp internalResp = new InternalResp(resp);
        RequestDistributor distributor = resolver.resolve(internalReq);
        distributor.distribute(internalReq, internalResp);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doOptions(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doTrace(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
