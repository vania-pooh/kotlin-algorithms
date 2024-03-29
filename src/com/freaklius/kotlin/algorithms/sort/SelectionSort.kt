package com.freaklius.kotlin.algorithms.sort

/**
 * An implementation of selection sort algorithm
 * AveragePerformance = O(n^2)
 */
class SelectionSort : SortAlgorithm {

    override fun sort(arr: Array<Long>): Array<Long> {
        for (unsortedPartFirstIndex in 0..arr.size - 1){
            var minNumberIndex = unsortedPartFirstIndex
            for (unsortedPartCurrentIndex in unsortedPartFirstIndex..arr.size - 1){
                if (arr[unsortedPartCurrentIndex] < arr[minNumberIndex]){
                    minNumberIndex = unsortedPartCurrentIndex
                }
            }
            if (minNumberIndex != unsortedPartFirstIndex){
                swap(arr, unsortedPartFirstIndex, minNumberIndex)
            }
        }
        return arr
    }
    override fun getName(): String {
        return "SelectionSort"
    }
}