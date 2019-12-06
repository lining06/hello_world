/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package org.lining.javabase.algorithm;

/**
 * @author lining
 * @version $Id: Node.java, v 0.1 2019-12-06 11:47 AM lining Exp $
 */

public class Node {

    public int value;
    public Node next;

    public Node(int value){
        this.value = value;
    }

    public static Node generate(int n) {
        Node firstNode = null;
        Node preNode = null;
        for (int i = 0; i < n; i++) {
            Node curNode = new Node(i);
            if (i == 0) {
                firstNode = curNode;
            }
            if (preNode != null) {
                preNode.next = curNode;
            }
            preNode = curNode;
        }

        return firstNode;
    }

}