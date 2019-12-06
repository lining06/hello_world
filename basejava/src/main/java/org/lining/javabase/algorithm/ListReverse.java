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

    public static void main(String[] args) {
        //确定第一个
        Node node = Node.generate(10);
        System.out.println(JSON.toJSON(node));
    }

    //遍历法
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

}