/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package org.lining.javabase.algorithm.leetcode;

import com.alibaba.fastjson.JSON;
import org.lining.javabase.algorithm.Node;

/**
 * @author lining
 * @version $Id: ReverseList.java, v 0.1 2019-12-06 11:46 AM lining Exp $
 *
 * 思想讲解见：https://blog.csdn.net/qq_36791466/article/details/88766450
 */
public class ReverseList {

    public static void main(String[] args) {

        Node node = Node.generate(5);

        Node reverseNode = reverse(node);

        System.out.println(JSON.toJSON(reverseNode));
    }

    private static Node reverse(Node node) {

        Node pre = null;
        Node next = null;

        while (node != null){

            next = node.next;
            node.next = pre;
            pre = node;
            node = next;
        }

        return pre;
    }

}