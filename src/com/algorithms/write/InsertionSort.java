package com.algorithms.write;

public class InsertionSort {

	public static void main(String[] args) {
		int[] array={5,2,7,6,9};
		insertionSort(array);
		for(int i=0;i<array.length;i++){
			System.out.print(array[i]);
		}
	}
	
	//前面永远是排好序的，从第二个开始单指针往前找位置，找到位置进行替换，找不到往后排
	public static void insertionSort(int[] array){
		for(int i=0;i<array.length-1;i++){
			int index=i+1;
			int key=array[i+1];
			for(int j=i+1;j>0;j--){
				if(array[j-1]>key){
					array[j]=array[j-1];
					index--;
				}
			}
			array[index]=key;
		}
	}

}
