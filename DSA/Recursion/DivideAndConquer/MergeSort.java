package DSA.Recursion.DivideAndConquer;

import java.util.Arrays;

public class MergeSort {
    public static void printArray(int[] arr) {
        for (int i : arr) {
            System.out.print(i+" ");
        }
        System.out.println();
    }

    public static int[] mergeSort(int[] arr) {
        if(arr.length == 1) {
            return arr;
        }
        int mid = arr.length / 2;

        int[] leftHalf = mergeSort(Arrays.copyOfRange(arr, 0, mid));

        int[] rightHalf = mergeSort(Arrays.copyOfRange(arr, mid, arr.length));

        return mergedArray(leftHalf, rightHalf);
    }

    public static int[] mergedArray(int[] first, int[] second) {
        int i = 0, j = 0, k = 0, n = first.length + second.length;
        int[] newArr = new int[n];

        while(i < first.length && j < second.length) {
            if(first[i] <= second[j]) {
                newArr[k++] = first[i++];
            } else {
                newArr[k++] = second[j++];
            }
        }

        while(i < first.length) {
            newArr[k++] = first[i++];
        }

        while(j < second.length) {
            newArr[k++] = second[j++];
        }

        return newArr;
    }
    public static void main(String[] args) {
        int[] arr = {23,54,12,65,34,87,14,99,48};
        System.out.print("Original Array : ");
        printArray(arr);

        int[] newarr = mergeSort(arr);
        System.out.print("Sorted Array : ");
        printArray(newarr);
    }
}
