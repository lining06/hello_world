/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package org.lining.javabase.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * @author lining
 * @version $Id: LambdaTest.java, v 0.1 2019-11-29 4:41 PM lining Exp $
 */
public class LambdaTest {

    final int ddd = 1;

    public static void main(String args[]){
        //函数式接口的实现两种写法

        //1、lambda写法
        TestInterface c = (Integer x) -> { System.out.println(x);};
        c.accept(123);

        //2、匿名内部类写法
        TestInterface a = new TestInterface(){
            @Override
            public void accept(Integer t){
                System.out.println(t);
            }
        };
        a.accept(456);

        //线程lambda写法
        new Thread(
                () -> {
                    System.out.println("good");
                }
        ).start();


        //lambda foreach用法
        //Old way:
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        for(Integer n: list) {
//            System.out.println(n);
        }

        //New way:
//        list.forEach(n -> System.out.println(n));


        //or we can use :: double colon operator in Java 8
//        list.forEach(System.out::println);

        //lambda map用法
//        list.stream().map(x -> 2 * x).map(x -> 3 * x).forEach(System.out::println);

        int sum = list.stream().map(x -> 2 * x).reduce((x,y) -> x + y).get();
        System.out.println(sum);


        /**
         *  Java8 中reduce的基本使用
         *  1、初识 reduce 的基本 api
         */
        Stream<Integer> stream = Arrays.stream(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8});

        //求集合元素只和
        Integer result = stream.reduce(0, Integer::sum);
        System.out.println(result);

        stream = Arrays.stream(new Integer[]{1, 2, 3, 4, 5, 6, 7});

        //求和
        stream.reduce((i, j) -> i + j).ifPresent(System.out::println);


        stream = Arrays.stream(new Integer[]{1, 2, 3, 4, 5, 6, 7});
        //求最大值
        stream.reduce(Integer::max).ifPresent(System.out::println);

        stream = Arrays.stream(new Integer[]{1, 2, 3, 4, 5, 6, 7});
        //求最小值
        stream.reduce(Integer::min).ifPresent(System.out::println);

        stream = Arrays.stream(new Integer[]{1, 2, 3, 4, 5, 6, 7});
        //做逻辑
        stream.reduce((i, j) -> i > j ? j : i).ifPresent(System.out::println);

        stream = Arrays.stream(new Integer[]{1, 2, 3, 4, 5, 6, 7});

        //求逻辑求乘机
        int result2 = stream.filter(i -> i % 2 == 0).reduce(1, (i, j) -> i * j);
        Optional.of(result2).ifPresent(System.out::println);



    }


}