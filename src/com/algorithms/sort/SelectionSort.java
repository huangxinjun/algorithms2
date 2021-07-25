package com.algorithms.sort;

/**
 * @Description : TODO
 * @Author : 黄信俊
 * @Date : 7/22/21 3:13 PM
 * @Version : 1.0
 **/
public class SelectionSort {

    public static int[] selectionSort(int[] array) {
        if (array.length == 0)
            return array;
        for (int i = 0; i < array.length; i++) {
            int minIndex = i;
            for (int j = i; j < array.length; j++) {
                if (array[j] < array[minIndex]) //找到最小的数
                    minIndex = j; //将最小数的索引保存
            }
            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
        return array;
    }

    public static void main(String[]args){
        int[]array={5,2,6,7,9};
        array=selectionSort2(array);
        for(int i=0;i<array.length;i++){
            System.out.println(array[i]);
        }
    }

    public static int[] selectionSort2(int[] array){
        //循环
        for(int i=0;i<array.length;i++){
            int minIndex = i;
            //对比找最小值索引
            for(int j=i;j<array.length;j++){
                if(array[j]<array[minIndex]){
                    minIndex=j;
                }
            }
            //替换
            int temp=array[minIndex];
            array[minIndex]=array[i];
            array[i]=temp;
        }
        return array;
    }

}
