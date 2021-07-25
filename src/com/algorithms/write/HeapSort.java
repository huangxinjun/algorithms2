package com.algorithms.write;

public class HeapSort {

	public static void main(String[] args) {
		int[] array={5,2,7,6,9};
		heapSort(array);
//		for(int i=0;i<array.length;i++){
//			System.out.print(array[i]);
//		}
	}
	
	
	public static void heapSort(int[] array){
		//构造大顶堆,先找到第一个非叶子节点，逐步向上推出大顶堆的值，然后小值逐步往下比沉下去就行
		for(int i=array.length/2-1;i>=0;i--){
			buileHeap(array,i,array.length);
		}
		//替换顶堆与末尾的值，重新生成堆，只要替换后顶部的值逐步往下比沉下去就行
		for(int i=array.length-1;i>0;i--){
			int temp=array[i];
			array[i]=array[0];
			array[0]=temp;
			for(int j=0;j<array.length;j++){
				System.out.print(array[j]);
			}
			System.out.println(i);
			buileHeap(array,0,i);
		}
	}
	
	public static void buileHeap(int[] array,int index,int right){
		
		int key=array[index];
		int left=2*index+1;
		while(left<right){
			if((left+1)<right&&array[left]<array[left+1]){
				left++;
			}
			if(key<array[left]){
				array[index]=array[left];
				index=left;
				left=2*index+1;
			}else{
				break;
			}
		}
		array[index]=key;
	}

}
