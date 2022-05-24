package com.freaklius.kotlin.algorithms.sort

/**
 * An implementation of the most stupid sort algorithm =P
 * AveragePerformance = O(n*n!) -> Infinity
 */
class BogoSort : SortAlgorithm{

    override fun sort(arr: Array<Long>) : Array<Long>{
        while(!isSortedAsc(arr)){
            shuffleArray(arr)
        }
        return arr
    }

    override fun getName(): String {
        return "BogoSort"
    }
}
