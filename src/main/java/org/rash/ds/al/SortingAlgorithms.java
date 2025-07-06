/**
 *
 */
package org.rash.ds.al;

import java.util.Arrays;

/**
 * @author Ammi
 */

/*
 * Need to take some consideration when implementing sorting algorithms
 *
 * 1) Stable algorithm: which means same elements will lose their original
 * position after sorting
 *
 * 2) In-Place algorithm: Instead of using temporary variable or temporary
 * collections, algorithm has to use its own space
 *
 * 3) Adaptive algorithm: A sorting algorithm is said to be adaptive, if it
 * takes advantage of already 'sorted' elements in the list that is to be
 * sorted.
 */
public class SortingAlgorithms {

    public static int[] bubbleSort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            int flag = 0;
            for (int j = 0; j < a.length - i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    swap(a, j, j + 1);
                    flag = 1;
                }
            }
            if (flag == 0) {
                break;
            }
        }
        return a;
    }

    public static int[] insertionSort(int[] a) {
        for (int i = 1; i < a.length; i++) {
            for (int j = i; j > 0; j--) {
                if (a[j] < a[j - 1]) {
                    swap(a, j, j - 1);
                } else {
                    break;
                }
            }
        }
        return a;
    }

    public static int[] selectionSort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] > a[j]) {
                    swap(a, i, j);
                }
            }
        }
        return a;
    }

    public static void quickSort(int[] a, int lowerIndex, int higherIndex) {

        int i = lowerIndex;
        int j = higherIndex;
        int pivot = a[lowerIndex + (higherIndex - lowerIndex) / 2];

        while (i <= j) {
            while (a[i] < pivot) {
                i++;
            }
            while (a[j] > pivot) {
                j--;
            }
            if (i <= j) {
                swap(a, i, j);
                i++;
                j--;
            }
        }

        if (lowerIndex < j)
            quickSort(a, lowerIndex, j);

        if (i < higherIndex)
            quickSort(a, i, higherIndex);

    }

    public static void mergeSort(int[] a, int lowerIndex, int higherIndex) {

        if (lowerIndex < higherIndex) {
            int middleIndex = (lowerIndex + higherIndex) / 2;
            mergeSort(a, lowerIndex, middleIndex);
            mergeSort(a, middleIndex + 1, higherIndex);

            mergeParts(a, lowerIndex, middleIndex, higherIndex);
        }
    }

    private static void mergeParts(int[] array, int lowerIndex, int middleIndex, int higherIndex) {

        int[] tempMergArr = Arrays.copyOf(array, array.length);

        int i = lowerIndex;
        int j = middleIndex + 1;
        int k = lowerIndex;
        while (i <= middleIndex && j <= higherIndex) {
            if (tempMergArr[i] <= tempMergArr[j]) {
                array[k] = tempMergArr[i];
                i++;
            } else {
                array[k] = tempMergArr[j];
                j++;
            }
            k++;
        }
        while (i <= middleIndex) {
            array[k] = tempMergArr[i];
            k++;
            i++;
        }

    }


    private static void swap(int a[], int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        int[] a = new int[]{14, 35, 42, 35, 10, 19, 27, 44};

        System.out.println(Arrays.toString(a));

        SortingAlgorithms.mergeSort(a, 0, a.length - 1);

        System.out.println(Arrays.toString(a));
    }

}
