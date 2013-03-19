package com.freaklius.kotlin.algorithms.sort

import java.util.LinkedList

/**
 * Radix sort algorithm
 * Assumption: all sorted values has the same number of digits.
 * Average performance = O(n + k), where k is a number of digits
 */
public class RadixSort : SortAlgorithm {

    public override fun sort(arr: Array<Long>): Array<Long> {
        //The main idea is to sort input array by each digit using any sort algorithm
        var outputArray = arr;
        for (digitNumber in 0..getMaximumDigitsCount(arr) - 1){
            outputArray = sortArrayBySingleDigit(outputArray, digitNumber);
        }
        return outputArray;
    }

    /**
     * Sorts input array by specified digit using counting sort algorithm. In fact this is a bucket sort
     * where each of 10 buckets correspond to one of 10 possible decimal system digit values (from 0 to 9).
     * @param arr
     * @param digitNumber
     */
    private fun sortArrayBySingleDigit(arr: Array<Long>, digitNumber: Int) : Array<Long>{
        var outputArray = arr;
        var mappingArray = Array<LinkedList<Long>>(10, {i -> LinkedList()}); //We need to store digits in range 0..9
        for (i in 0..arr.size - 1){
            var number = arr[i];
            var digit = digitAt(number, digitNumber); // It's a number in range 0..9
            mappingArray[digit].add(number);
        }
        var outputArrayIndex = 0;
        for (list in mappingArray){
            if (list.size() > 0){
                for (value in list){
                    outputArray[outputArrayIndex] = value;
                    outputArrayIndex++;
                }
            }
        }
        return outputArray;
    }

    /**
     * Returns digit positioned at specified position number starting from the right end.
     * I.e. digitAt(123, 1) = 3; digitAt(123, 2) = 2 and so on.
     * @param number
     * @param digitNumber zero-based digit number
     */
    private fun digitAt(number: Long, digitNumber: Int) : Int{
        var numberString = number.toString();
        return if (digitNumber <= numberString.length() - 1)
            numberString.charAt(numberString.length() - digitNumber - 1).toString().toInt() //Char.toInt() is a char code
            else 0;
    }

    /**
     * Returns maximum digits count assuming that input array is in decimal
     */
    private fun getMaximumDigitsCount(arr: Array<Long>) : Int{
        return maximum(arr).toString().length();
    }

    public override fun getName(): String {
        return "RadixSort";
    }
}