package com.algorithms.sort;

import java.util.Arrays;

/**
 * @Description : TODO
 * @Author : 黄信俊
 * @Date : 7/22/21 3:14 PM
 * @Version : 1.0
 **/
public class MergeSort {

//    /**
//     * 归并排序
//     *
//     * @param array
//     * @return
//     */
//    public static int[] MergeSort(int[] array) {
//        if (array.length < 2) return array;
//        int mid = array.length / 2;
//        int[] left = Arrays.copyOfRange(array, 0, mid);
//        int[] right = Arrays.copyOfRange(array, mid, array.length);
//        return merge(MergeSort(left), MergeSort(right));
//    }
//    /**
//     * 归并排序——将两段排序好的数组结合成一个排序数组
//     *
//     * @param left
//     * @param right
//     * @return
//     */
//    public static int[] merge(int[] left, int[] right) {
//        int[] result = new int[left.length + right.length];
//        for (int index = 0, i = 0, j = 0; index < result.length; index++) {
//            if (i >= left.length)
//                result[index] = right[j++];
//            else if (j >= right.length)
//                result[index] = left[i++];
//            else if (left[i] > right[j])
//                result[index] = right[j++];
//            else
//                result[index] = left[i++];
//        }
//        return result;
//    }

    public static void main(String[] args) {
        int[]array={5,2,7,6,9};
        mergeSort(array,0,array.length-1);
        for (int i = 0; i < array.length; ++i) {
            System.out.printf("%d ", array[i]);
        }
    }

    public static void mergeSort(int[] array, int left, int right){
        if(left>=right)return ;
        int mid=(left+right)/2;
        //分割
        mergeSort(array,left,mid);
        mergeSort(array,mid+1,right);
        //组合
        merge(array,left,mid,right);

    }

    public static void merge(int[] array, int left, int mid, int right){
        int[] mergeList=new int[array.length];
        int rl=mid+1;
        int index=left;
        int qs=left;
        //比较两个小数组相应下标位置的数组大小，小的先放进新数组
        while(left<=mid&&rl<=right){
            if(array[left]<=array[rl]){
                mergeList[index++]=array[left++];
            }else{
                mergeList[index++]=array[rl++];
            }
        }
        //如果左边还有数据需要拷贝，把左边数组剩下的拷贝到新数组
        while(left<=mid){
            mergeList[index++]=array[left++];
        }
        //如果右边还有数据需要拷贝，把右边数组剩下的拷贝到新数组
        while(rl<=right){
            mergeList[index++]=array[rl++];
        }

        //数组合并
        while (qs <= right) {
            array[qs] = mergeList[qs];
            qs++;
        }
    }
}
