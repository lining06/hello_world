/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package org.lining.javabase.algorithm.leetcode;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lining
 * @version $Id: ThreeSum.java, v 0.1 2019-12-11 4:43 PM lining Exp $
 */
public class ThreeSum {

    public static void main(String[] args) {
        System.out.println(JSON.toJSONString(threeSum(new int[]{0,3,0,1,1,-1,-5,-5,3,-3,-3,0})));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> results = new ArrayList();
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                for(int k=j+1;k<nums.length;k++){
                    if(nums[i] + nums[j] + nums[k] == 0){
                        List<Integer> list = new ArrayList();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        results.add(list);
                    }
                }
            }
        }
        for(int i=0;i<results.size();i++){
            int a = results.get(i).get(0);
            int b = results.get(i).get(1);
            int c = results.get(i).get(2);

            for(int j=i+1;j<results.size();j++){
                if(results.get(j).contains(a) &&
                        results.get(j).contains(b)&&
                        results.get(j).contains(c)){
                    results.remove(j);
                    j--;
                }
            }


        }
        return results;
    }

}