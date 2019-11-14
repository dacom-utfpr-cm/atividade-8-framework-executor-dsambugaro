package EX2;
/*
 *
 * @author Danilo Sambugaro created on 11/11/2019 inside the package - EX1
 *
 */

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SumMat {

    private Integer[][] vet;
    private int qtThreads;
    private Integer sumresult;
    private ExecutorService executor;
    private List<Future<Integer>> results = new LinkedList<>();

    public SumMat(Integer[][] vet, int qtThreads) {
        this.vet = vet;
        this.qtThreads = qtThreads;
        this.executor = Executors.newFixedThreadPool(qtThreads);
    }

    public void run() {


        for (int i = 0; i < vet.length; i++) {
            SumTask sumTask = new SumTask(vet[0]);
            Future<Integer> submit = executor.submit(sumTask);
            results.add(submit);
        }

        executor.shutdown();
        while (!executor.isTerminated()) {
        }

        Integer sumFinal = 0;
        for (Future<Integer> r : results) {
            try {
                Integer res = r.get();
                sumFinal += res;
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }

        sumresult = sumFinal;

        System.out.println("Sum: " + sumresult);

    }
}
