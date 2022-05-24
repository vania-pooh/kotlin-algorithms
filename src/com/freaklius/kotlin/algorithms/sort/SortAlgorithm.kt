package com.freaklius.kotlin.algorithms.sort

/**
 * An abstract sort algorithm class (a base class for all sort algorithms)
 */
interface SortAlgorithm {
    /**
     * Sorts numbers using specified algorithm
     */
    fun sort(arr: Array<Long>) : Array<Long>

    /**
     * Returns algorithm name
     */
    fun getName() : String
}