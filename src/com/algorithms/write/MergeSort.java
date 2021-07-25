package com.algorithms.write;

public class MergeSort {

	public static void main(String[] args) {
		int[] array={5,2,7,6,9};
		mergeSort(array,0,array.length-1);
		for(int i=0;i<array.length;i++){
			System.out.print(array[i]);
		}
	}
	
	//先分割，后合并，双数组组合需要先装一遍，后装剩下的
	public static void mergeSort(int[] array,int left,int right){
		System.out.println(left+"-"+right);
		if(left>=right) return;
		int mid=(left+right)/2;
		mergeSort(array,left,mid);
		mergeSort(array,mid+1,right);
		merge(array,left,mid,right);
	}
	
	public static void merge(int[] array,int left,int mid,int right){
		
		int[] mergeList=new int[array.length];
		int index=left;
		int qs=left;
		int rindex=mid+1;
		while(left<=mid&&rindex<=right){
			if(array[left]>array[rindex]){
				mergeList[index++]=array[rindex];
				rindex++;
			}else{
				mergeList[index++]=array[left];
				left++;
			}
		}
		while(left<=mid){
			mergeList[index++]=array[left];
			left++;
		}
		while(rindex<=right){
			mergeList[index++]=array[rindex];
			rindex++;
		}
		 //数组合并
        while (qs <= right) {
            array[qs] = mergeList[qs];
            qs++;
        }
	}
	
	

}
