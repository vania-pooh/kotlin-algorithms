package com.freaklius.kotlin.algorithms

/**
 * An implementation of CombSort algorithm
 * AveragePerformance = O(n^2/p)
 */
public class CombSort : SortAlgorithm {

    public override fun sort(arr: Array<Long>): Array<Long> {
        var gap : Int = arr.size;
        val DIVISOR = 1.3; //Divisor to be used when decreasing gap
        var swappedElements : Boolean;
        do {
            gap = Math.floor((gap / DIVISOR).toDouble()).toInt();
            if (gap < 1){
                gap = 1;
            }
            swappedElements = false;
            var i : Int = 0;
            do {
                if (arr[i] > arr[i + gap]){
                    swap(arr, i, i + gap);
                    swappedElements = true;
                }
                i++;
            } while (i + gap < arr.size);
        } while ( (gap != 1) && swappedElements);
        return arr;
    }

    public override fun getName(): String {
        return "CombSort";
    }
}