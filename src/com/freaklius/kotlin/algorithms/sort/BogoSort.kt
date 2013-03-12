package com.freaklius.kotlin.algorithms

/**
 * An implementation of the most stupid sort algorithm =P
 * AveragePerformance = O(n*n!) -> Infinity
 */
public class BogoSort : SortAlgorithm{

    public override fun sort(arr: Array<Long>) : Array<Long>{
        while(!isSortedAsc(arr)){
            shuffleArray(arr);
        }
        return arr;
    }

    public override fun getName(): String {
        return "BogoSort";
    }
}
