package com.stu.algorithm.binaryTree;

/**
 * @Author wangyixing
 * @Description
 */
public class Demo4 {

    public static void main(String[] args) {
        int[] nums1 = new int[] {1,2,3,0,0,0};
        int[] nums2 = new int[] {2,5,6};
        int m = 3;
        int n = 3;
        merge(nums1, m, nums2, n);
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] sorted = new int[m + n];
        int p1 = 0;
        int p2 = 0;
        int count = 0;
        while (p1 < m || p2 < n) {
            int val = 0;
            if (p1 == m) {
                val = nums2[p2++];
            } else if (p2 == n) {
                val = nums1[p1++];
            } else if (nums1[p1] < nums2[p2]) {
                val = nums1[p1++];
            } else {
                val = nums2[p2++];
            }
            sorted[count++] = val;
        }
        for (int i = 0; i < (m + n); i++) {
            nums1[i] = sorted[i];
        }
    }
}
