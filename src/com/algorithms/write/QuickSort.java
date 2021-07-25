package com.algorithms.write;

public class QuickSort {

	public static void main(String[] args) {
		int[] array={5,2,7,6,9};
		quickSort(array,0,array.length-1);
		for(int i=0;i<array.length;i++){
			System.out.print(array[i]);
		}
	}
	
	//左右指针，分割后排序，分割依赖逐步替换，记录index值和key值
	public static void quickSort(int[] array,int left,int right){
		if(left<right){
			int location=patition(array,left,right);
			quickSort(array,left,location);
			quickSort(array,location+1,right);
		}
	}
	
	public static int patition(int[] array,int left,int right){
		int key=array[left];
		while(left<right){
			while(array[left]<key){
				left++;
			}
			while(array[right]>key){
				right--;
			}
			if(left<right){
				int temp=array[left];
				array[left]=array[right];
				array[right]=temp;
			}
		}
		return left;
		
	}

}
