package EX3;
/*
 *
 * @author Danilo Sambugaro created on 12/11/2019 inside the package - EX3
 *
 */

import java.util.concurrent.*;

public class MultiMat {
    private Integer[][] mat_a;
    private Integer[][] mat_b;
    private Integer[][] mat_result;
    private ExecutorService executor;

    public MultiMat(Integer[][] mat_a, Integer[][] mat_b) {
        this.mat_a = mat_a;
        this.mat_b = mat_b;
        this.mat_result = new Integer[mat_a.length][mat_b[0].length];
        this.executor = Executors.newFixedThreadPool(4);

        for (int i = 0; i < mat_a.length; i++) {
            for (int j = 0; j < mat_b[0].length; j++) {
                this.mat_result[i][j] = 0;
            }
        }

    }


    public void run() {

        // Linhas de uma matrix e colunas de outra
        for (int i = 0; i < mat_a.length; i++) {
            for (int j = 0; j < mat_b[0].length; j++) {
                MultiMatTask multiMatTask = new MultiMatTask(mat_a, mat_b, mat_result,i, j, mat_b.length);
                executor.submit(multiMatTask);
            }
        }

        executor.shutdown();
        while (!executor.isTerminated()) {
        }


        for (int i = 0; i < mat_a.length; i++) {
            for (int j = 0; j < mat_b[0].length; j++) {
                System.out.println(mat_result[i][j]);
            }
        }

    }

}

