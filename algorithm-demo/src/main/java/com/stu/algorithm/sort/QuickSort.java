package com.stu.algorithm.sort;

/**
 * 快速排序：同冒泡排序一样，快速排序也属于交换排序，通过元素之间的比较和交换位置来达到排序的目的
 *
 * 不同的是，冒泡排序在每一轮中只把1个元素冒泡到数列的一端，而快速排序则在每一轮挑选一个基准
 * 元素，并让其他比它大的元素移动到数列一边，比它小的元素移动到数列的另一边，从而把数列拆解成
 * 两个部分，这种思路就叫作分治法。
 *
 * 基准元素，英文是pivot，在分治过程中，以基准元素为中心，把其他元素移动到它的左右两边
 * 可以随机选择一个元素作为基准元素，并且让基准元素和数组首元素交换位置，此时基准元素位于第一个元素
 *
 * 选定了基准元素以后，要把其他元素中小于基准元素的都交换到基准元素一边，大于基准元素的都交换到基准元素另一边。
 *
 * @author 86177
 */
public class QuickSort {
}
