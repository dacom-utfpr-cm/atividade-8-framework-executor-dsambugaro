package EX6;
/*
 *
 * @author Danilo Sambugaro created on 13/11/2019 inside the package - EX6
 *
 */

import java.util.Arrays;
import java.util.concurrent.Callable;

public class QuickSortMain implements Callable<int[]> {

    private int input[];
    private int array[];

    public QuickSortMain(int[] input){
        this.input = input;
    }

    public void sort(int[] arr) {

        if (arr == null || arr.length == 0) {
            return;
        }
        array = arr;
        quickSort(0, array.length-1);
    }

    private void quickSort(int left, int right) {

        int i = left;
        int j = right;
        // find pivot number, we will take it as mid
        int pivot = array[left+(right-left)/2];

        while (i <= j) {
            /**
             * In each iteration, we will increment left until we find element greater than pivot
             * We will decrement right until we find element less than pivot
             */
            while (array[i] < pivot) { i++; } while (array[j] > pivot) {
                j--;
            }
            if (i <= j) {
                exchange(i, j);
                //move index to next position on both sides
                i++;
                j--;
            }
        }
        // call quickSort() method recursively
        if (left < j)
            quickSort(left, j);
        if (i < right)
            quickSort(i, right);
    }

    private void exchange(int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    @Override
    public int[] call() throws Exception {
        sort(input);
        return array;
    }
}
