package com.freaklius.kotlin.algorithms.sort

/**
 * Bubble sort algorithm
 * AveragePerformance = O(n^2)
 */
class BubbleSort : SortAlgorithm{

    override fun sort(arr: Array<Long>): Array<Long> {
        var swappedElements : Boolean
        do {
            swappedElements = false
            for (i in 0..arr.size - 2){
                if (arr[i] > arr[i + 1]){
                    swap(arr, i, i + 1)
                    swappedElements = true
                }
            }
        } while (swappedElements)
        return arr
    }

    override fun getName(): String {
        return "BubbleSort"
    }
}