package com.algorithms.write;

public class BubbleSort {

	public static void main(String[] args) {
		int[] array={5,2,7,6,9};
		bubbleSort(array);
		for(int i=0;i<array.length;i++){
			System.out.print(array[i]);
		}

	}
	//最大值往后跑
	public static void bubbleSort(int[] array){
		for(int i=0;i<array.length;i++){
			for(int j=0;j<array.length-1-i;j++){
				if(array[j+1]<array[j]){
					int temp=array[j+1];
					array[j+1]=array[j];
					array[j]=temp;
				}
			}
		}
	}

}
