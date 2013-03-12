package com.freaklius.kotlin.algorithms.sort

import java.util.ArrayList

/**
 * This class launches all specified sort algorithms and compares their performance
 */
public class SortLauncher{

    /**
     * Launches sort algorithms
     */
    public fun launch() {
//        val arr: Array<Long> = randomNumericArray(10, 100);
        val arr: Array<Long> = array(79.toLong(), 11.toLong(), 35.toLong(), 76.toLong(), 9.toLong(), 90.toLong(), 37.toLong(), 33.toLong(), 19.toLong(), 58.toLong());
        for (algorithm in getAlgorithmsList()){
            measureAlgorithm(arr.copyOf(), algorithm);
        }
    }

    /**
     * Executes and measures a single algorithm
     */
    private fun measureAlgorithm(arr: Array<Long>, algorithm: SortAlgorithm){
        println("--------------------------------------");
        println("Algorithm name: " + algorithm.getName());
        println("Initial array: " + arrayToString(arr));

        val startTime : Long = System.nanoTime();
        val sortedArr = algorithm.sort(arr);
        val endTime : Long = System.nanoTime();

        println("Sorted array: " + arrayToString(sortedArr));
        println("Is array sorted in ascending order: " + isSortedAsc(sortedArr));
        val avgTimePerElement : Double = ((endTime - startTime).toDouble() / arr.size.toDouble());
        println("Average time per element, ns: " + avgTimePerElement);
    }

    /**
     * Returns a list of algorithms to be tested
     */
    private fun getAlgorithmsList() : Array<SortAlgorithm>{
        return array(
                BubbleSort(),
                SelectionSort(),
                InsertionSort(),
                CombSort(),
                MergeSort(),
                HeapSort(),
                BogoSort()
        );
    }
}

/**
 * Entry point function
 */
fun main(args: Array<String>) {
    SortLauncher().launch();
}
