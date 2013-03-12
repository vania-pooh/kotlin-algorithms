package com.freaklius.kotlin.algorithms

/**
 * An implementation of insertion sort algorithm
 * AveragePerformance = O(n^2)
 */
public class InsertionSort : SortAlgorithm{

    public override fun sort(arr: Array<Long>) : Array<Long>{
        for (j in 1..arr.size - 1){
            var i = j - 1;
            val processedValue = arr[j];
            while ( (i >= 0) && (arr[i] > processedValue) ){
                arr[i + 1] = arr[i];
                i--;
            }
            arr[i + 1] = processedValue;
        }
        return arr;
    }


    public override fun getName(): String {
        return "InsertionSort";
    }
}
