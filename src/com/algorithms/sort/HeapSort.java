package com.algorithms.sort;

import java.util.Arrays;

/**
 * @Description : TODO
 * @Author : 黄信俊
 * @Date : 7/22/21 3:14 PM
 * @Version : 1.0
 **/
public class HeapSort {

    public static void main(String []args){
        int []arr = {5,2,7,6,9};
//        System.out.println("排序前："+ Arrays.toString(arr));
        sort(arr);
//        System.out.println("排序后："+Arrays.toString(arr));
    }

    public static void sort(int []arr){
        //1.构建大顶堆
        for(int i=arr.length/2-1;i>=0;i--){
            //从第一个非叶子结点从下至上，从右至左调整结构
            adjustHeap(arr,i,arr.length);
        }
        //2.调整堆结构+交换堆顶元素与末尾元素
        for(int j=arr.length-1;j>0;j--){
            swap(arr,0,j);//将堆顶元素与末尾元素进行交换
            adjustHeap(arr,0,j);//重新对堆进行调整
        }

    }

    /**
     * 调整大顶堆（仅是调整过程，建立在大顶堆已构建的基础上）
     * @param arr
     * @param i
     * @param length
     */
    public static void adjustHeap(int []arr,int i,int length){
        int temp = arr[i];//先取出当前元素i
//        System.out.println("i="+i);
        int k=i*2+1;
        while(k<length){//从i结点的左子结点开始，也就是2i+1处开始
            if(k+1<length && arr[k]<arr[k+1]){//如果左子结点小于右子结点，k指向右子结点
                k++;
            }
            if(arr[k] >temp){//如果子节点大于父节点，将子节点值赋给父节点（不用进行交换）
                arr[i] = arr[k];
                i = k;
                k=i*2+1;
            }else{
                break;
            }
//            for (int y = 0; y < arr.length; ++y) {
//                System.out.printf("%d ", arr[y]);
//            }
//            System.out.println("i="+i+"---"+"temp="+temp);
        }
        arr[i] = temp;//将temp值放到最终的位置
//        for (int y = 0; y < arr.length; ++y) {
//            System.out.printf("%d ", arr[y]);
//        }
//        System.out.println();
    }

    /**
     * 交换元素
     * @param arr
     * @param a
     * @param b
     */
    public static void swap(int []arr,int a ,int b){
        int temp=arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }


//    public static void main(String[] args) {
//        int[]array={5,2,7,6,9};
//        heapSort(array);
//        for (int i = 0; i < array.length; ++i) {
//            System.out.printf("%d ", array[i]);
//        }
//    }
//
//    /**
//     * 创建堆，
//     * @param arr 待排序列
//     */
//    private static void heapSort(int[] arr) {
//        //创建堆
//        for (int i = (arr.length - 1) / 2; i >= 0; i--) {
//            //从第一个非叶子结点从下至上，从右至左调整结构
//            adjustHeap(arr, i, arr.length);
//        }
//
//        //调整堆结构+交换堆顶元素与末尾元素
//        for (int i = arr.length - 1; i > 0; i--) {
//            //将堆顶元素与末尾元素进行交换
//            int temp = arr[i];
//            arr[i] = arr[0];
//            arr[0] = temp;
//
//            //重新对堆进行调整
//            adjustHeap(arr, 0, i);
//        }
//    }
//
//    /**
//     * 调整堆
//     * @param arr 待排序列
//     * @param parent 父节点
//     * @param length 待排序列尾元素索引
//     */
//    private static void adjustHeap(int[] arr, int parent, int length) {
//        //将temp作为父节点
//        int temp = arr[parent];
//        //左孩子
//        int lChild = 2 * parent + 1;
//
//        while (lChild < length) {
//            //右孩子
//            int rChild = lChild + 1;
//            // 如果有右孩子结点，并且右孩子结点的值大于左孩子结点，则选取右孩子结点
//            if (rChild < length && arr[lChild] < arr[rChild]) {
//                lChild++;
//            }
//
//            // 如果父结点的值已经大于孩子结点的值，则直接结束
//            if (temp >= arr[lChild]) {
//                break;
//            }
//
//            // 把孩子结点的值赋给父结点
//            arr[parent] = arr[lChild];
//
//            //选取孩子结点的左孩子结点,继续向下筛选
//            parent = lChild;
//            lChild = 2 * lChild + 1;
//        }
//        arr[parent] = temp;
//    }
}
