/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package org.lining.javabase.algorithm.leetcode;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author lining
 * @version $Id: ThreeSum.java, v 0.1 2019-12-11 4:43 PM lining Exp $
 */
public class ThreeSum {

    public static void main(String[] args) {
        System.out.println(JSON.toJSONString(threeSum(new int[]{0,3,0,1,1,-1,-5,-5,3,-3,-3,0})));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        Set<Integer> set = new HashSet();
        for(int i=0;i<nums.length;i++){
            set.add(nums[i]);
        }
        Object[] numsNew = (Object[])set.toArray();

        List<List<Integer>> results = new ArrayList();
        for(int i=0;i<numsNew.length;i++){
            for(int j=i+1;j<numsNew.length;j++){
                for(int k=j+1;k<numsNew.length;k++){
                    if((Integer)numsNew[i] + (Integer)numsNew[j] + (Integer)numsNew[k] == 0){
                        List<Integer> list = new ArrayList();
                        list.add((Integer)numsNew[i]);
                        list.add((Integer)numsNew[j]);
                        list.add((Integer)numsNew[k]);
                        results.add(list);
                    }
                }
            }
        }
        for(int i=0;i<results.size();i++){
            Set setI = new HashSet();
            setI.add(results.get(i).get(0));
            setI.add(results.get(i).get(1));
            setI.add(results.get(i).get(2));

            for(int j=i+1;j<results.size();j++){
                Set setJ = new HashSet();
                setJ.add(results.get(j).get(0));
                setJ.add(results.get(j).get(1));
                setJ.add(results.get(j).get(2));
                for (int i1 = 0; i1 < setJ.size(); i1++) {
                    for (Object o : setI) {
                        
                    }
                }
                if(setJ.size() == setI.size() &&
                        setJ.contains(results.get(i).get(0)) &&
                        setJ.contains(results.get(i).get(1))&&
                        setJ.contains(results.get(i).get(2))){
                    results.remove(j);
                    if (j> i){
                        j--;
                    }
                }
            }
        }
        return results;
    }

}