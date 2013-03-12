package com.freaklius.kotlin.algorithms.sort

/**
 * An implementation of merge sort procedure
 * AveragePerformance = O(n*lg(n)), where lg(n) is a logarithm of n for base 2
 */
public class MergeSort : SortAlgorithm {

    public override fun sort(arr: Array<Long>): Array<Long> {
        sortArrayPiece(arr, 0, arr.size - 1);
        return arr;
    }

    /**
     * Sorts a piece of input array using recursive calls of itself
     * @param arr
     * @param fromIndex
     * @param toIndex
     */
    private fun sortArrayPiece(arr: Array<Long>, startIndex: Int, endIndex: Int){
        var pieceSize = endIndex - startIndex + 1;
        if (pieceSize == 1){
            return; //Single element piece case
        }
        var middleElementIndex = Math.floor((startIndex + endIndex) / 2.0).toInt();
        sortArrayPiece(arr, startIndex, middleElementIndex);
        sortArrayPiece(arr, middleElementIndex + 1, endIndex);
        merge(arr, startIndex, middleElementIndex, endIndex);
    }

    /**
     * Merges two subarrays of initial array arr: [startIndex; middleIndex] and [middleIndex + 1; endIndex]
     * in ascending order.
     * @param arr
     * @param startIndex
     * @param middleIndex
     * @param endIndex
     */
    private fun merge(arr: Array<Long>, startIndex: Int, middleIndex: Int, endIndex: Int){
        var leftArray = arr.copyOfRange(startIndex, middleIndex + 1); //Left bound is exclusive, right - inclusive
        var rightArray = arr.copyOfRange(middleIndex + 1, endIndex + 1);
        var i = 0;
        var j = 0;
        for (k in startIndex..endIndex){
            if ( (i <= leftArray.size - 1) && ( (j >= rightArray.size) || (leftArray[i] <= rightArray[j]) ) ){
                arr[k] = leftArray[i];
                i++;
            }else {
                arr[k] = rightArray[j];
                j++;
            }
        }
    }

    public override fun getName(): String {
        return "MergeSort";
    }
}