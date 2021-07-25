package com.algorithms.write;

public class selectionSort {

	public static void main(String[] args) {
		int[] array={5,2,7,6,9};
		selectionSort(array);
		for(int i=0;i<array.length;i++){
			System.out.print(array[i]);
		}
	}
	
	//最小值从第一个开始排，单指针找到最小值索引，然后进行替换
	public static void selectionSort(int[] array){
		for(int i=0;i<array.length;i++){
			int minIndex=i;
			for(int j=i;j<array.length;j++){
				if(array[j]<array[minIndex]){
					minIndex=j;
				}
			}
			int temp=array[i];
			array[i]=array[minIndex];
			array[minIndex]=temp;
		}
	}

}
