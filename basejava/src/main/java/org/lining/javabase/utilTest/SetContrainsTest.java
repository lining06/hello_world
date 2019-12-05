package org.lining.javabase.utilTest;

import java.util.*;

/**
 * Created by lining on 2018/6/16.
 */
public class SetContrainsTest {


    public static void main(String[] args) {

        Long testLong = 1999L;
        if (testLong == 1999){
            System.out.println("good");
        }

        Map<Long, String> testMap = new HashMap<>();
        testMap.put(0L, "good");

        Set keys = testMap.keySet();
        if (keys.size() == 1 && keys.contains(0L)){
            //keys.size() == 1 && key == 0 ,表示无标品
            System.out.println("yes");
            return;
        }
        System.out.println("no");

    }
}