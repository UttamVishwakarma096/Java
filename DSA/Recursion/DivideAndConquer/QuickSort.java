package DSA.Recursion.DivideAndConquer;

public class QuickSort {
    public static void printArray(int[] arr) {
        for (int i : arr) {
            System.out.print(i+" ");
        }
        System.out.println();
    }

    public static void quickSort(int[] arr, int low, int high) {
        if(low >= high) {
            return;
        }
    
        int start = low, end = high;
        // Taking mid of the array as a pivot
        int pivot = arr[start + (end - start) / 2];

        while(start <= end) {
            while(arr[start] < pivot) {
                start++;
            }
            while(arr[end] > pivot) {
                end--;
            }
            if(start <= end) {
                int x = arr[start];
                arr[start] = arr[end];
                arr[end] = x;

                start++;
                end--;
            }
        }
        //Left half of the array
        quickSort(arr, low, end);
        //Right half of the array
        quickSort(arr, start, high);
    }    
    public static void main(String[] args) {
        int[] arr = {6, 3, 9, 5, 2, 8, 4, 12, 7};

        System.out.print("Original Array : ");
        printArray(arr);

        quickSort(arr, 0, arr.length - 1);

        System.out.print("Sorted Array : ");
        printArray(arr);
    }
}
