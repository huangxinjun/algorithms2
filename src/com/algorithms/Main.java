package com.algorithms;

import com.algorithms.write2.*;

public class Main {

    public static void main(String[] args) {
        int[] array={5,2,7,6,9};
        SortAlgorithms.heapSort(array);
        for(int i=0;i<array.length;i++){
            System.out.print(array[i]);
        }
    }
}
