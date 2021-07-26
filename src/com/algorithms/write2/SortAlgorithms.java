package com.algorithms.write2;

/**
 * @Description : TODO
 * @Author : 黄信俊
 * @Date : 7/26/21 11:20 AM
 * @Version : 1.0
 **/
public class SortAlgorithms {

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

    public static void selectionSort(int[] array){
        for(int i=0;i<array.length-1;i++){
            int minIndex=i;
            for(int j=i;j<array.length-1;j++){
                if(array[j]<array[minIndex]){
                    minIndex=j;
                }
            }
            int temp=array[i];
            array[i]=array[minIndex];
            array[minIndex]=temp;
        }
    }

    public static void insertionSort(int[] array){
        for(int i=1;i<array.length;i++){
            int key=array[i];
            int index=i;
            for(int j=i;j>0;j--){
                if(array[j-1]>array[i]){
                    array[i]=array[j-1];
                    index=j-1;
                }
            }
            array[index]=key;
        }
    }

    public static void quickSort(int[] array,int left,int right){
        if(left>=right) return;
        int location=patition(array,left,right);
        quickSort(array,left,location);
        quickSort(array,location+1,right);
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
                int temp=array[right];
                array[right]=array[left];
                array[left]=temp;
            }
        }
        return left;
    }

    public static void mergeSort(int[] array,int left,int right){
        if(left<right){
            int mid=(left+right)/2;
            mergeSort(array,left,mid);
            mergeSort(array,mid+1,right);
            merge(array,left,mid,right);
        }
    }

    public static void merge(int[] array,int left,int mid, int right){
        int[] mergeList=new int[array.length];
        int mleft=left;
        int index=left;
        int rleft=mid+1;
        while(left<=mid&&rleft<=right){
            if(array[left]<array[rleft]){
                mergeList[index++]=array[left++];
            }else{
                mergeList[index++]=array[rleft++];
            }
        }
        while(left<=mid){
            mergeList[index++]=array[left++];
        }
        while(rleft<=right){
            mergeList[index++]=array[rleft++];
        }

        while(mleft<index){
            array[mleft]=mergeList[mleft];
            mleft++;
        }
    }

    public static void heapSort(int[] array){

        for(int i=array.length/2-1;i>=0;i--){
            bulidHeap(array,i,array.length);
        }

        for(int i=array.length-1;i>0;i--){
            int temp=array[i];
            array[i]=array[0];
            array[0]=temp;
            bulidHeap(array,0,i);
        }
    }

    public static void bulidHeap(int[] array,int index,int right){
        int key=array[index];
        int left=2*index+1;
        while(left<right){
            if(left+1<right&&array[left]<array[left+1]){
                left++;//指向右节点
            }
            if(array[left]>array[index]){
                array[index]=array[left];
                index=left;
                left=2*left+1;
            }else{
                break;
            }
        }
        array[index]=key;
    }

}
