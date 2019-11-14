package EX2;
/*
 * Thread que imprime os números primos em um determidado intervalo
 *
 * @author Danilo Sambugaro created on 01/09/2019 inside the package - EX3
 *
 */

import java.util.concurrent.Callable;

public class SumTask implements Callable<Integer> {

    private Integer[] vet;
    private int sum;

    public SumTask(Integer[] vet) {
        this.vet = vet;
    }

    @Override
    public Integer call() throws Exception {

        for (int i = 0; i < vet.length; i++) {
            sum += vet[i];
        }

        return sum;
    }
}
