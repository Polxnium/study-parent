package com.stu.algorithm.sort;

/**
 * 快速排序：同冒泡排序一样，快速排序也属于交换排序，通过元素之间的比较和交换位置来达到排序的目的
 *
 * 不同的是，冒泡排序在每一轮中只把1个元素冒泡到数列的一端，而快速排序则在每一轮挑选一个基准
 * 元素，并让其他比它大的元素移动到数列一边，比它小的元素移动到数列的另一边，从而把数列拆解成
 * 两个部分，这种思路就叫作分治法。
 *
 * 基准元素，英文是pivot，在分治过程中，以基准元素为中心，把其他元素移动到它的左右两边
 * 0. 可以随机选择一个元素作为基准元素，并且让基准元素和数组首元素交换位置，此时基准元素位于第一个元素
 *
 * 比基准元素小的放到左侧，比基准元素大的放到右侧。
 *
 * 元素的交换：
 * 一、双边循环法
 * 1. 两个指针left和right，指向数列的最左和最右两个元素
 * 2. 从right开始，该元素和基准元素做比较。如果>=pivot，则指针向左移动；如果<pivot，则指针不动；
 * 3. 从left开始，该元素和基准元素做比较。如果<=pivot，则指针向右移动；如果>pivot，则指针不动；
 * 4. right和left指针交换值
 *
 * @author 86177
 */
public class QuickSort {

    public static void main(String[] args) {

    }

    /**
     * 双边循环法
     * @param array
     * @return
     */
    public static int partition(int[] array) {
        int pivot = array[0];
        return 0;
    }
}
