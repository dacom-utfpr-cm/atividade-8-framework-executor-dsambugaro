package EX1;
/*
 *
 * @author Danilo Sambugaro created on 11/11/2019 inside the package - EX1
 *
 */

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.*;

public class FindMaxValue {

    private Integer[] vet;
    private int qtTasks;
    private int qtThreads;
    private Integer maxValue;
    private ExecutorService executor;
    private List<Future<Integer>> results = new LinkedList<>();
    private List<Integer> lastVet = new LinkedList<>();

    public FindMaxValue(Integer[] vet, int qtTasks, int qtThreads) {
        this.vet = vet;
        this.qtTasks = qtTasks;
        this.qtThreads = qtThreads;
        this.executor = Executors.newFixedThreadPool(qtThreads);
    }

    public void run() {

        int intervalSize = vet.length / qtTasks;

        List<Integer[]> intervals = new LinkedList<Integer[]>();

        for (int i = 0; i < vet.length; i += intervalSize) {
            Integer[] interval = {i, i + intervalSize - 1};
            intervals.add(interval);
        }


        while (!intervals.isEmpty()) {
            if (!intervals.isEmpty()) {

                Integer maxInterval = intervals.get(0)[1];
                if (maxInterval > vet.length) {
                    maxInterval = vet.length;
                }

                SearchTask searchTask = new SearchTask(vet, intervals.get(0)[0], maxInterval);
                Future<Integer> submit = executor.submit(searchTask);
                results.add(submit);
                intervals.remove(0);
            }

        }

        executor.shutdown();
        while (!executor.isTerminated()){}

        for (Future<Integer> r: results) {
            try {
                Integer res = r.get();
                lastVet.add(res);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }

        Integer max = lastVet.get(0);
        for (Integer integer : lastVet) {
            if (integer > max) {
                max = integer;
            }
        }

        maxValue = max;

        System.out.println("Max value: " + maxValue);

    }
}
