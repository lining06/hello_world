package org.lining.javabase.myUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomUtils {


    public static void main(String[] args) {

        List<String> aaa = new ArrayList<>();
        aaa.add("aaa");
        aaa.add("bbb");

        System.out.println(aaa.get(getRandomNum(aaa.size())));
    }

    // 获取size范围内的随机数
    public static int getRandomNum(int size) {
        if (size <= 1) {
            return 0;
        }
        return new Random().nextInt(size);
    }

}
