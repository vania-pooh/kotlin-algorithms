package com.freaklius.kotlin.algorithms.sort

import java.util.LinkedList

/**
 * Bucket sort algorithm
 * Average performance = O(n)
 */
public class BucketSort : SortAlgorithm {

    public override fun sort(arr: Array<Long>): Array<Long> {
        //Number of buckets can depend on input array size
        var numberOfBuckets = if (arr.size > 100) Math.floor(arr.size / 10.0).toInt() else 10;
        var outputArray = arr;
        var sortArray = Array<LinkedList<Long>>(numberOfBuckets, {i -> LinkedList()}); //We need to store digits in range 0..9
        var maxArrayValue = maximum(arr);
        for (i in 0..arr.size - 1){
            var value = arr[i];
            var valueIndex = Math.floor((numberOfBuckets * (value / maxArrayValue)).toDouble()).toInt(); // It's a number in range 0..9
            if (valueIndex == arr.size){
                valueIndex = arr.size - 1; //Maximum values go to the last bucket
            }
            sortArray[valueIndex].add(value);
        }
        var outputArrayIndex = 0;
        for (list in sortArray){
            if (list.size() > 0){
                var arrayFromList = Array<Long>(list.size(), {i -> list.get(i)});
                for (value in InsertionSort().sort(arrayFromList)){
                    outputArray[outputArrayIndex] = value;
                    outputArrayIndex++;
                }
            }
        }
        return outputArray;
    }

    public override fun getName(): String {
        return "BucketSort";
    }
}