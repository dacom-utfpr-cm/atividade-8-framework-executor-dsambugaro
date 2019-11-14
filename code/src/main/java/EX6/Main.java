package EX6;
/*
 * ça um programa que execute três algoritmos de ordenação para um conjunto de valores e exiba o resultado apenas
 * do algoritmo que finalizar primeiro (use invokeAny ).
 *
 * Fonte dos algoritmos de ordenação: https://java2blog.com/sorting-algorithms-java/
 *
 * @author Danilo Sambugaro created on 13/11/2019 inside the package - EX6
 *
 */

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] input = {33,21,45,64,55,34,11,8,3,5,1};

        System.out.println(Arrays.toString(input));

        SortingRun sortingRun = new SortingRun(input);

        sortingRun.run();

        System.out.println(Arrays.toString(input));

    }
}
