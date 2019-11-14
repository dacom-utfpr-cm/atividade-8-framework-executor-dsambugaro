package EX6;
/*
 *
 * @author Danilo Sambugaro created on 13/11/2019 inside the package - EX6
 *
 */

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SortingRun {

    private int[] input;
    private int[] result;
    private List<Callable<int[]>> callabes = new LinkedList<>();
    private ExecutorService executor;


    public SortingRun(int[] input) {
        this.input = input;
        this.executor = Executors.newFixedThreadPool(3);
    }

    public int[] run(){

        QuickSortMain quickSort = new QuickSortMain(input);
        MergeSortMain mergeSort = new MergeSortMain(input);
        HeapSortMain heapSort = new HeapSortMain(input);

        callabes.add(quickSort);
        callabes.add(mergeSort);
        callabes.add(heapSort);

        try {
            this.result = executor.invokeAny(callabes);
        } catch (InterruptedException e) {

        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        executor.shutdown();

        return this.result;
    }
}
