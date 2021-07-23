package com.algorithms.sort;

/**
 * @Description : TODO
 * @Author : 黄信俊
 * @Date : 7/22/21 3:13 PM
 * @Version : 1.0
 **/
public class BubbleSort {

    public static int[] bubbleSort(int[] array) {
        if (array.length == 0)
            return array;
        for (int i = 0; i < array.length; i++)
            for (int j = 0; j < array.length - 1 - i; j++)
                if (array[j + 1] < array[j]) {
                    int temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                }
        return array;
    }

    public static void main(String[]args){
        int[]array={5,2,6,7,9};
        array=bubbleSort2(array);
        for(int i=0;i<array.length;i++){
            System.out.println(array[i]);
        }
    }

    public static int[] bubbleSort2(int[] array){
        if(array==null||array.length==0) return array;
        //循环
        for(int i=0;i<array.length;i++){
            //对比替换
            for(int j=0;j<array.length-1-i;j++){
                if(array[j+1]<array[j]){
                    int temp=array[j+1];
                    array[j+1]=array[j];
                    array[j]=temp;
                }
            }
        }
        return array;
    }
}
