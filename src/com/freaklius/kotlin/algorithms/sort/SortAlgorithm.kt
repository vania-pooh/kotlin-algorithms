package com.freaklius.kotlin.algorithms

/**
 * An abstract sort algorithm class (a base class for all sort algorithms)
 */
public trait SortAlgorithm {
    /**
     * Sorts numbers using specified algorithm
     */
    public fun sort(arr: Array<Long>) : Array<Long>;

    /**
     * Returns algorithm name
     */
    public fun getName() : String;
}