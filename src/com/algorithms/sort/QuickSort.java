package com.algorithms.sort;

/**
 * @Description : TODO
 * @Author : 黄信俊
 * @Date : 7/22/21 3:14 PM
 * @Version : 1.0
 **/
public class QuickSort {

//    /**
//     * 快速排序方法
//     * @param array
//     * @param start
//     * @param end
//     * @return
//     */
//    public static int[] QuickSort(int[] array, int start, int end) {
//        if (array.length < 1 || start < 0 || end >= array.length || start > end) return null;
//        int smallIndex = partition(array, start, end);
//        if (smallIndex > start)
//            QuickSort(array, start, smallIndex - 1);
//        if (smallIndex < end)
//            QuickSort(array, smallIndex + 1, end);
//        return array;
//    }
//    /**
//     * 快速排序算法——partition
//     * @param array
//     * @param start
//     * @param end
//     * @return
//     */
//    public static int partition(int[] array, int start, int end) {
//        int pivot = (int) (start + Math.random() * (end - start + 1));
//        int smallIndex = start - 1;
//        swap(array, pivot, end);
//        for (int i = start; i <= end; i++)
//            if (array[i] <= array[end]) {
//                smallIndex++;
//                if (i > smallIndex)
//                    swap(array, i, smallIndex);
//            }
//        return smallIndex;
//    }
//
//    /**
//     * 交换数组内两个元素
//     * @param array
//     * @param i
//     * @param j
//     */
//    public static void swap(int[] array, int i, int j) {
//        int temp = array[i];
//        array[i] = array[j];
//        array[j] = temp;
//    }

    //左右指针，分割后排序，分割依赖逐步替换，记录index值和key值
    public static void main(String[] args) {
        int[]array={5,2,7,6,9};
        quickSort(array, 0, array.length - 1);
//        for (int i = 0; i < array.length; ++i) {
//            System.out.printf("%d ", array[i]);
//        }
    }

    public static void quickSort(int[] array, int left, int high) {
        if(left<high){
            //切割->排序
            int j=Partition(array,left,high);
            quickSort(array, left, j);
            quickSort(array, j + 1, high);
        }
    }

    public static int Partition(int[] array, int left, int high) {
        int i = left, j = high;
        int key = array[left];
        while (i < j) {
            while (array[i] < key){
                i++;
            }
            while (array[j] > key){
                j--;
            }
            if (i < j) {
                int t = array[i];
                array[i] = array[j];
                array[j] = t;
            }
        }
        return i;
    }
}
