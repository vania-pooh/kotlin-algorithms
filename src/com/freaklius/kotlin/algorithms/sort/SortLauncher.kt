package com.freaklius.kotlin.algorithms.sort


/**
 * This class launches all specified sort algorithms and compares their performance
 */
class SortLauncher{

    /**
     * Launches sort algorithms
     */
     fun launch() {
        val arr: Array<Long> = randomNumericArray(10, 100)
        for (algorithm in getAlgorithmsList()){
            measureAlgorithm(arr.clone(), algorithm)
        }
    }

    /**
     * Executes and measures a single algorithm
     */
    private fun measureAlgorithm(arr: Array<Long>, algorithm: SortAlgorithm){

        println("--------------------------------------")
        println("Algorithm name: " + algorithm.getName())
        println("Initial array: " + arrayToString(arr))

        val startTime : Long = System.nanoTime()
        val sortedArr = algorithm.sort(arr)
        val endTime : Long = System.nanoTime()

        println("Sorted array: " + arrayToString(sortedArr))
        println("Is array sorted in ascending order: " + isSortedAsc(sortedArr))

        val avgTimePerElement : Double = ((endTime - startTime).toDouble() / arr.size.toDouble())
        val runTime : Double = (endTime - startTime).toDouble()
        println("Average time per element, ns: " + avgTimePerElement)
        println("Total Array run time, ns: " + runTime)
    }

    /**
     * Returns a list of algorithms to be tested
     */
    private fun getAlgorithmsList() : Array<SortAlgorithm>{
        return arrayOf(
                BubbleSort(),
                SelectionSort(),
                InsertionSort(),
                CombSort(),
                MergeSort(),
                HeapSort(),
                QuickSort(),
                CountingSort(),
               RadixSort(),
                BucketSort(),
                BogoSort()
        )
    }
}

/**
 * Entry point function
 */
fun main(args: Array<String>) {
    SortLauncher().launch()

}
