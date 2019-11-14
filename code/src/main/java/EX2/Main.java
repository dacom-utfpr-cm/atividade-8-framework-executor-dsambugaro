package EX2;
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
        Integer[][] mat = new Integer[5][10];

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 10; j++) {
                mat[i][j] = i + j;
            }
        }

        SumMat sumMat = new SumMat(mat, 4);

        sumMat.run();
    }

}

