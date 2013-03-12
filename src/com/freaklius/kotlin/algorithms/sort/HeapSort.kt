package com.freaklius.kotlin.algorithms.sort

/**
 * Heap sort algorithm
 * AveragePerformance = O(n*lg(n))
 */
public class HeapSort : SortAlgorithm {
    /**
     * Stores size of the heap to be used
     */
    private var heapSize = 0;

    public override fun sort(arr: Array<Long>): Array<Long> {
        buildMaxHeap(arr);
        var i: Int = arr.size - 1;
        while (i >= 1){
            swap(arr, i, 0);
            heapSize--;
            maxHeapify(arr, 0);
            i--;
        }
        return arr;
    }

    /**
     * Builds a max-heap data structure from the input array (the original array is replaced) using maxHeapify method
     * @param arr
     */
    private fun buildMaxHeap(arr: Array<Long>){
        heapSize = arr.size;
        var i: Int = Math.floor(arr.size / 2.0).toInt();
        while (i >= 0){
            maxHeapify(arr, i);
            i--;
        }
    }

    /**
     * Restores MaxHeap property starting from the array's ith element and going down
     * @param arr
     * @param i heap index where we need to check the property; we implicitly assume that child heaps conform to the
     * MaxHeap property
     */
    private fun maxHeapify(arr: Array<Long>, i: Int){
        var leftElementIndex = left(i);
        var rightElementIndex = right(i);
        var largestElementIndex : Int = i;

        if ( (leftElementIndex <= heapSize - 1) && (arr[leftElementIndex] > arr[i]) ){
            largestElementIndex = leftElementIndex;
        }

        if ( (rightElementIndex <= heapSize - 1) && (arr[rightElementIndex] > arr[largestElementIndex]) ){
            largestElementIndex = rightElementIndex;
        }

        if (largestElementIndex != i){
            swap(arr, i, largestElementIndex);
            maxHeapify(arr, largestElementIndex);
        }
    }

    /**
     * Returns the index of the array element corresponding to the left element of the ith element in the heap
     * @param i an element to get the left element
     */
    private fun left(i: Int) : Int{
        return 2 * i + 1;
    }

    /**
     * Returns the index of the array element corresponding to the right element of the ith element in the heap
     * @param i an element to get the left element
     */
    private fun right(i: Int) : Int{
        return 2 * i + 2;
    }

    public override fun getName(): String {
        return "HeapSort";
    }
}