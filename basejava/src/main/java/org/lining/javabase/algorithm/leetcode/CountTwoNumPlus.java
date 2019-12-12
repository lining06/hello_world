/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package org.lining.javabase.algorithm.leetcode;

import com.alibaba.fastjson.JSON;
import org.lining.javabase.algorithm.Node;

/**
 * @author lining
 * @version $Id: CountTwoNumPlus.java, v 0.1 2019-12-05 2:18 PM lining Exp $
 */
public class CountTwoNumPlus {

    public static void main(String[] args) {
        CountTwoNumPlus countTwoNumPlus = new CountTwoNumPlus();
        Node node = new Node(1);
        node.next = new Node(2);
        node.next.next = new Node(3);
        Node node2 = new Node(7);
        node2.next = new Node(6);
        node2.next.next = new Node(7);
        System.out.println(JSON.toJSON(node));
        System.out.println(JSON.toJSON(node2));
        System.out.println(JSON.toJSON(countTwoNumPlus.countTwoMine(node, node2)));
    }
    /**
     * 两数相加
     给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
     如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
     您可以假设除了数字 0 之外，这两个数都不会以 0 开头。

     示例：
     输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
     输出：7 -> 0 -> 8
     原因：342 + 465 = 807
     */

    //时间复杂度：O(max(m, n)) 空间复杂度：O(max(m, n)) 新列表的长度最多为 max(m,n) + 1
    public Node countTwo(Node first, Node second){

        Node result = new Node(0);
        Node currentResult = result;
        Node firstCurrent = first;
        Node secondCurrent= second;
        //进位
        int out = 0;

        while (firstCurrent != null || secondCurrent != null){
            int firstCurrentValue = (firstCurrent == null ? 0 : firstCurrent.value);
            int secondCurrentValue = (secondCurrent == null ? 0 : secondCurrent.value);
            int currentSum =  firstCurrentValue + secondCurrentValue + out;
            out = currentSum / 10;

            currentResult.next = new Node(currentSum % 10);
            firstCurrent = (firstCurrent == null ? null : firstCurrent.next);
            secondCurrent = (secondCurrent == null ? null : secondCurrent.next);

            currentResult = currentResult.next;
            //最后一位，>0则最大位为1
            if (out > 0){
                currentResult.next = new Node(out);
            }
        }

        return result.next;
    }

    //我的练习
    public Node countTwoMine(Node l1, Node l2){

        Node lastOne = new Node(0);
        Node result = lastOne;
        int outNum = 0;

        while(l1 != null || l2 != null){

            int first = (l1 == null) ? 0 : l1.value;
            int second = (l2 == null) ? 0 : l2.value;
            int sum = first + second + outNum;
            int num = sum % 10;
            outNum = sum / 10;

            Node tmp = new Node(num);
            lastOne.next = tmp;
            lastOne = lastOne.next;
            l1 = (l1 == null) ? null : l1.next;
            l2 = (l2 == null) ? null : l2.next;
        }
        if(outNum > 0){
            lastOne.next = new Node(1);
        }

        return result.next;
    }
}