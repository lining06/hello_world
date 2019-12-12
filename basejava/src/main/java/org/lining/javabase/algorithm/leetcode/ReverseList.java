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
 * 思想讲解见：
 * 迭代：https://blog.csdn.net/qq_36791466/article/details/88766450
 * 递归：https://blog.csdn.net/Wu_ye123/article/details/88729736
 */
public class ReverseList {

    public static void main(String[] args) {

        Node node = Node.generate(3);

        Node reverseNode = reverseNew(node);

        System.out.println(JSON.toJSON(reverseNode));
    }

    //迭代
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

    //递归法
    private static Node reverseNew(Node node) {

        if (node.next == null){
            return node;
        }
        //拿到最后一个对象
        Node last = reverseNew(node.next);
        node.next.next = node;
        node.next = null;
        return last;
    }


}