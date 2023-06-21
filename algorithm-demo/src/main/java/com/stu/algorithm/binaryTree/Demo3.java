package com.stu.algorithm.binaryTree;

/**
 * @Author wangyixing
 * @Description 两数组的两数相加
 */
public class Demo3 {
    public static int removeElement(int[] nums, int val) {
        int n = nums.length;
        int left = 0;
        for (int right = 0; right < n; right++) {
            if (nums[right] != val) {
                nums[left] = nums[right];
                left++;
            }
        }
        return left;
    }

    /**
     * 双指针法，并返回移除元素后数组的新长度
     * @param nums
     * @param val
     * @return
     */
    public static int removeElement__(int[] nums, int val) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            if (nums[left] == val) {
                nums[left] = nums[right - 1];
                right--;
            } else {
                left++;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {3,2,3,3};
        int size = removeElement(nums, 3);
        System.out.println(size);
    }
}
