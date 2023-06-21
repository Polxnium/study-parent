package com.stu.algorithm.binaryTree;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author wangyixing
 * @Description 两数之和
 */
public class Demo2 {
    public int[] twoSum(int[] nums, int target) {
        int size = nums.length;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < size; i++) {
            Integer key = target - nums[i];
            if (map.containsKey(key)) {
                return new int[] {map.get(key), i};
            }
            map.put(nums[i], i);
        }
        //返回空数组
        return new int[0];
    }
}
