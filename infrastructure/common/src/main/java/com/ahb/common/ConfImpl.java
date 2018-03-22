package com.ahb.common;

import com.ahb.common.node.Node;
import org.apache.commons.lang3.StringUtils;

import java.util.Optional;

/**
 * Created by aheroboy on 9/3/2018.
 */
public class ConfImpl implements Conf {
    private String ip;
    private int port;
    private Node node;
    private int webPort;

    public ConfImpl() {
        this(Node.CENTOER_NODE_IP, Node.CENTOER_NODE_PORT);
    }

    public ConfImpl(int port) {
        this(Node.CENTOER_NODE_IP, port);
    }

    public ConfImpl(String ip, int port) {
        this.ip = Optional.ofNullable(ip).orElse(Node.CENTOER_NODE_IP);
        this.port = port;
        String webPort = System.getProperty("WebPort");
        if(StringUtils.isNotBlank(webPort)){
            this.webPort = Integer.valueOf(webPort);
        }
    }

    @Override
    public boolean getServerType() {
        String serverType = System.getProperty("serverType");
        return Boolean.valueOf(StringUtils.isBlank(serverType) ? Boolean.FALSE : Boolean.valueOf(serverType));
    }

    @Override
    public void setIp(String ip) {
        this.ip = ip;
    }

    @Override
    public void setPort(int port) {
        this.port = port;
    }

    @Override
    public boolean isCenterNode() {
        return Node.CENTOER_NODE_IP.equalsIgnoreCase(this.ip) && Node.CENTOER_NODE_PORT == this.port;
    }

    public Node getNode() {
        return this.node;
    }

    public void setNode(Node node) {
        this.node = node;
    }

    @Override
    public String getIp() {
        return ip;
    }

    @Override
    public int getPort() {
        return port;
    }

    public int getWebPort() {
        return webPort;
    }

    public void setWebPort(int webPort) {
        this.webPort = webPort;
    }
}
