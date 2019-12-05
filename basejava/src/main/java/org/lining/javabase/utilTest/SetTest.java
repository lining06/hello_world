package org.lining.javabase.utilTest;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by lining on 2018/1/25.
 */
public class SetTest {
    public static void main(String args[]){
        Set<Long> applyIdSet = new HashSet();
        applyIdSet.add(123L);
        applyIdSet.add(123L);
        applyIdSet.add(123L);
        applyIdSet.add(123L);
        applyIdSet.add(124L);
        for (Long aLong : applyIdSet) {
            System.out.println(aLong);
        }
    }

}
