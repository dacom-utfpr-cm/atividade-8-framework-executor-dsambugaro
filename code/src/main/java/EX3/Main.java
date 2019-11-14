package EX3;
/*
 * Faça um programa concorrente para multiplicar duas matrizes.
 *
 * @author Danilo Sambugaro created on 12/11/2019 inside the package - EX3
 *
 */

public class Main {
    public static void main(String[] args) {

        Integer[][] mat_a = new Integer[][]{
                { 1, 2, 3 },
                { 4, 5, 6 }
        };

        Integer[][] mat_b = new Integer[][]{
                { 7, 8 },
                { 9, 10 },
                { 11, 12 },
        };

        MultiMat multiMat = new MultiMat(mat_a, mat_b);

        multiMat.run();


    }
}
