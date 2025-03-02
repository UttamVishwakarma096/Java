package DSA.Recursion.DivideAndConquer;

import java.util.Scanner;

public class BinarySearch {
    public static void printArray(int[] arr) {
        for (int i : arr) {
            System.out.print(i+" ");
        }
        System.out.println();
    }
    public static int binarySearch(int[] arr, int target, int start, int end) {
        int mid = start + (end - start) / 2;

        while(start <= end) {
            if(arr[mid] == target) {
                return mid;
            }
            if(arr[mid] < target) {
                return binarySearch(arr, target, mid + 1, end);
            } else {
                return binarySearch(arr, target, start, mid - 1);
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        try (Scanner scan = new Scanner(System.in)) {
            int[] arr = {2,6,13,24,34,55,67,73,95,100};
            printArray(arr);

            System.out.print("Enter target : ");
            int target = scan.nextInt();
            
            int result = binarySearch(arr, target, 0, arr.length - 1);
            System.out.println("Index of target : "+result);
        }
    }
}
