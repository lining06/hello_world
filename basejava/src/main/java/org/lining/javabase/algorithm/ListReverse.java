/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package org.lining.javabase.algorithm;


import com.alibaba.fastjson.JSON;

/**
 * @author lining
 * @version $Id: ListReverse.java, v 0.1 2019-11-18 3:42 PM lining Exp $
 *
 * 链表反转实现
 */
public class ListReverse {

    public static class Node{
        public int value;
        public Node next;

        public Node(int value){
            this.value = value;
        }
    }

    //递归法
    public Node reverse(Node curNode){
        if (curNode == null | curNode.next == null){
            return curNode;
        }
        //拿到最后一个节点
        Node nextNode = reverse(curNode.next);
        curNode.next = null;
        return nextNode;
    }

    //遍历法


    public static void main(String[] args) {
        //确定第一个
//        Node node =  new Node(1);
//        node.next = new Node(2);
//        node.next.next = new Node(3);
//        node.next.next.next = new Node(4);
//
//        System.out.println(JSON.toJSONString(node));
//
        Node node = generate(10);
        System.out.println(JSON.toJSON(node));
    }

    //设置正向链表
    public static Node putNode(Node node){
        Node tmpNode = new Node(1);
        if(node == null){
            node = tmpNode;
        }else {
            tmpNode = new Node(node.value + 1);
        }

        node.next = putNode(node);

        if (node.value < 3){
            return tmpNode;
        }

        return node;
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