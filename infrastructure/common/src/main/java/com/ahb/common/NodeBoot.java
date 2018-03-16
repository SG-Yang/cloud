package com.ahb.common;

import com.ahb.common.node.Node;
import com.ahb.common.node.NodeImpl;

/**
 * Created by aheroboy on 9/3/2018.
 */
public class NodeBoot {
    public static void main(String xargs[]) throws Exception {
        int port = 9090;
        if (xargs.length > 0) {
            port = Integer.parseInt(xargs[0]);
        }
        Node node = NodeImpl.newInstance();
        node.getConf().setPort(port);
        node.start();
    }
}
