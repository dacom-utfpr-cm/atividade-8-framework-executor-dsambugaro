package EX4;
/*
 *
 * Faça um programa que periodicamente monitore mudanças em um
 * conjunto de arquivos especificados. Se ocorreram mudanças, o programa
 * deve registrá-las em um arquivo de log.
 *
 * @author Danilo Sambugaro created on 13/11/2019 inside the package - EX4
 *
 */

import java.io.File;
import java.util.concurrent.ExecutionException;

public class Main {
    public static void main(String[] args) {
        String file = "src/main/resources/wathedFile.txt";
        String logFile = "src/main/resources/log.txt";

        CheckFile checkFile = new CheckFile(file, logFile);

        checkFile.run();

    }
}
