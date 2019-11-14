package EX1;
/*
 *
 * Faça um programa que localize o maior valor em um vetor. Divida o programa em tarefas que localizam o maior valor
 * em um segmento do vetor. O programa deve possibilitar especificar o número de tarefas e o número de threads para
 * resolver o problema.
 *
 * @author Danilo Sambugaro created on 11/11/2019 inside the package - EX1
 *
 */

public class Main {

    public static void main(String[] args) {
        Integer[] vet = new Integer[1001];

        for (int i = 0; i < 1001; i++) {
            vet[i] = i;
        }

        FindMaxValue findMaxValue = new FindMaxValue(vet, 4, 4);

        findMaxValue.run();
    }

}

