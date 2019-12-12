/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package org.lining.javabase.algorithm.leetcode;

import com.alibaba.fastjson.JSON;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lining
 * @version $Id: FindTwoNumSum.java, v 0.1 2019-12-05 11:03 AM lining Exp $
 */
public class FindTwoNumSum {

    public static void main(String[] args) {

        LocalDateTime before = LocalDateTime.now();
        System.out.println(JSON.toJSONString(twoSum2(new int[]{2,11,15,7,312,314,314,4314,43124,143124,43124,43124,431,431, 8}, 19)));
        System.out.println(Duration.between(before, LocalDateTime.now()).toMillis());
        List a = new ArrayList();
    }

    /**
     * 寻找两数之和
     给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
     你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。

     示例:
     给定 nums = [2, 7, 11, 15], target = 9
     因为 nums[0] + nums[1] = 2 + 7 = 9
     所以返回 [0, 1]
     链接：https://leetcode-cn.com/problems/two-sum/solution/liang-shu-zhi-he-by-leetcode-2/
     */
    //方法一：暴力法很简单，遍历每个元素 xx
    // 时间复杂度：O(n^2)， 空间复杂度：O(1)
    public static int[] twoSum(int[] nums, int target) {
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i] + nums[j] == target){
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    //方法二：两遍哈希表 (通过以空间换取速度的方式，我们可以将查找时间从 O(n)O(n) 降低到 O(1)O(1)。哈希表正是为此目的而构建的)
    // 时间复杂度：O(n),空间复杂度：O(n)
    public static int[] twoSum1(int[] nums, int target){
        Map<Integer, Integer> map = new HashMap();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i], i);
        }

        for(int i=0;i<nums.length;i++){
            int value = target - nums[i];
            if(map.containsKey(value) && map.get(value) != i){
                return new int[]{i, map.get(value)};
            }
        }
        return null;
    }

    //方法三：一遍哈希表 (在进行迭代并将元素插入到表中的同时，我们还会回过头来检查表中是否已经存在当前元素所对应的目标元素)
    //时间复杂度：最多O(n), 空间复杂度：最多O(n)
    public static int[] twoSum2(int[] nums, int target){
        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0;i<nums.length;i++){

            int value = target - nums[i];
            if(map.containsKey(value)){
                return new int[]{map.get(value), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }
}