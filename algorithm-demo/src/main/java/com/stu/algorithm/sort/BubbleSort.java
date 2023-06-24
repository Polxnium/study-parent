package com.stu.algorithm.sort;

/**
 * 冒泡排序
 * @author 86177
 */
public class BubbleSort {
    public static void main(String[] args) {
        //int[] array = new int[] {9, 6, 8, 1, 7, 4, 0, 5, 2, 3};
        //BubbleSort.sort(array);
        int[] array = new int[] {1, 7, 4, 0, 5, 2, 3, 8, 9};
        BubbleSort.sortPlus(array);
        for (int i : array) {
            System.out.println(i);
        }
    }

    public static void sort(int[] array) {
        int length = array.length;
        for (int x = 0; x < length - 1; x++) {
            for (int y = 0; y < length - 1; y++) {
                if (array[y] > array[y+1]) {
                    int temp = array[y+1];
                    array[y+1] = array[y];
                    array[y] = temp;
                }
            }
        }
    }

    public static void sortPlus(int[] array) {
        int length = array.length;
        for (int x = 0; x < length - 1; x++) {
            boolean sorted = true;
            for (int y = 0; y < length - 1; y++) {
                if (array[y] > array[y+1]) {
                    sorted = false;
                    int temp = array[y+1];
                    array[y+1] = array[y];
                    array[y] = temp;
                }
            }
            if (sorted) {
                break;
            }
        }
    }
}
