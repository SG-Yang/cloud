package com.ahb.common.web;

import com.ahb.common.node.Node;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by aheroboy on 15/3/2018.
 */
public class DispatchServlet extends HttpServlet {
    protected static final Logger LOGGER = LoggerFactory.getLogger(DispatchServlet.class);
    private String name;
    private Node node;

    public DispatchServlet(String name, Node node) {
        this.name = name;
        this.node = node;
    }

    @Override
    public void init() throws ServletException {
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
        LOGGER.info(String.format("Receiving request to %s with data:\n%s",req.getRequestURL(),internalReq));
        node.distribute(internalReq, new InternalResp(resp));
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
