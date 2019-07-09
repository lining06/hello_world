package org.lining.test.utilTest;

/**
 * Created by lining on 2019/2/18.
 * 检验String的存储原理
 */
public class TestString {

    public static void main(String[] args) {
        String a = "aaa";//存在数据区
        String b = "aaa";//存在数据区
        String c = new String("aaa");//存在堆中

        //打印内存地址
        System.out.println(System.identityHashCode(a));
        System.out.println(System.identityHashCode(b));
        System.out.println(System.identityHashCode(c));


        System.out.println("凯文傻不傻");

        if(b.equals(a)){
            System.out.println("凯文不傻");
        }
    }
}
