package EX1;
/*
 * Thread que imprime os números primos em um determidado intervalo
 *
 * @author Danilo Sambugaro created on 01/09/2019 inside the package - EX3
 *
 */

import java.util.concurrent.Callable;

public class SearchTask implements Callable<Integer> {

    private Integer[] vet;
    private int minNum;
    private int maxNum;
    private int maxValue;
    private boolean founded;

    public SearchTask(Integer[] vet, int min, int max) {
        this.vet = vet;
        this.minNum = min;
        this.maxNum = max;
        this.maxValue = this.vet[0];
    }

    @Override
    public Integer call() throws Exception {

        for (int i = minNum; i < maxNum; i++) {
            if (vet[i] >= maxValue) {
                maxValue = vet[i];
            }
        }

        return maxValue;
    }
}
