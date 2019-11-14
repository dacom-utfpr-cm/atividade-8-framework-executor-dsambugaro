package EX6;
/*
 *
 * @author Danilo Sambugaro created on 13/11/2019 inside the package - EX6
 *
 */

import java.util.concurrent.Callable;

public class MergeSortMain implements Callable<int[]> {

    private int[] arr;

    public MergeSortMain(int[] arr) {
        this.arr = arr;
    }


    // Recursive algorithm for merge sort
    public void mergeSort(int start, int end) {
        int mid = (start + end) / 2;
        if (start < end) {
            // Sort left half
            mergeSort(start, mid);
            // Sort right half
            mergeSort(mid + 1, end);
            // Merge left and right half
            merge(start, mid, end);
        }

    }


    private void merge(int start, int mid, int end) {
        // Initializing temp array and index
        int[] tempArray = new int[arr.length];
        int tempArrayIndex = start;

//        System.out.print("Before Merging:  ");
//        printArray(arr,start,end);

        int startIndex = start;
        int midIndex = mid + 1;

        // It will iterate until smaller list reaches to the end
        while (startIndex <= mid && midIndex <= end) {
            if (arr[startIndex] < arr[midIndex]) {
                tempArray[tempArrayIndex++] = arr[startIndex++];
            } else {
                tempArray[tempArrayIndex++] = arr[midIndex++];
            }
        }

        // Copy remaining elements
        while (startIndex <= mid) {
            tempArray[tempArrayIndex++] = arr[startIndex++];
        }
        while (midIndex <= end) {
            tempArray[tempArrayIndex++] = arr[midIndex++];
        }

        // Copy tempArray to actual array after sorting
        for (int i = start; i <= end; i++) {
            arr[i] = tempArray[i];
        }

//        System.out.print("After merging:   ");
//        printArray(tempArray,start,end);
//        System.out.println();
    }

    public void printArray(int arr[], int start, int end) {
        for (int i = start; i <= end; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    @Override
    public int[] call() throws Exception {
        mergeSort(0, arr.length - 1);
        return arr;
    }
}
