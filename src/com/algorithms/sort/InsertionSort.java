package com.algorithms.sort;

/**
 * @Description : TODO
 * @Author : 黄信俊
 * @Date : 7/22/21 3:14 PM
 * @Version : 1.0
 **/
public class InsertionSort {

    public static int[] insertionSort(int[] array) {
        if (array.length == 0)
            return array;
        int current;
        //循环
        for (int i = 0; i < array.length - 1; i++) {
            current = array[i + 1];
            int preIndex = i;
            //对比找前面比它小的值
            while (preIndex >= 0 && current < array[preIndex]) {
                array[preIndex + 1] = array[preIndex];
                preIndex--;
            }
            array[preIndex + 1] = current;
        }
        return array;
    }

    public static void main(String[]args){
        int[]array={5,2,6,7,9};
        array=insertionSort2(array);
        for(int i=0;i<array.length;i++){
            System.out.println(array[i]);
        }
    }

    public static int[] insertionSort2(int[]array){

        //循环
        for(int i=0;i<array.length-1;i++){
            int current=array[i+1];
            int preIndex=i;
            //对比找到索引位置插入
            for(int j=i;j>=0;j--){
                if(current<array[preIndex]){
                    array[preIndex+1]=array[preIndex];
                    preIndex--;
                }
            }
            array[preIndex+1]=current;
        }
        return array;
    }

}
