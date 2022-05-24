package com.freaklius.kotlin.algorithms.sort

/**
 * Counting sort algorithm implementation.
 * Input array should consist of integers only in the range 0..k, i.e. this sort algorithm works
 * only for bounded array. In this method we determine k using max() method - in reality we should pass it directly.
 * Average performance = O(n)
 */
class CountingSort : SortAlgorithm {

    override fun sort(arr: Array<Long>): Array<Long> {
        val countsArray = Array<Int>(maximum(arr), { i -> 0})
        //Determining counts of every integer in input array
        for (i in 0..arr.size - 1){
            val countsArrayIndex = arr[i].toInt() - 1 //Counts array is indexed by the values from the input array
            countsArray[countsArrayIndex] = countsArray[countsArrayIndex] + 1
        }
        //Determining counts of integers smaller than current input array integer
        for (j in 1..countsArray.size - 1){
            countsArray[j] = countsArray[j] + countsArray[j - 1]
        }
        //Preparing sorted output array
        val outputArray = Array<Long>(arr.size, { i -> 0})
        var k = arr.size - 1
        while(k >= 0){
            val countsArrayIndex = arr[k].toInt() - 1
            outputArray[countsArray[countsArrayIndex] - 1] = arr[k]
            countsArray[countsArrayIndex]-- //Two equal input array elements should be placed in adjacent but different cells
            k--
        }
        return outputArray
    }

    override fun getName(): String {
        return "CountingSort"
    }
}