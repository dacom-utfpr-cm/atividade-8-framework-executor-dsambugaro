package EX5;
/*
 * Faça um programa que possibilite agendar uma tarefa para ser executada em um horário especı́fico.
 *
 * @author Danilo Sambugaro created on 13/11/2019 inside the package - EX5
 *
 */

import java.text.ParseException;
import java.util.Date;

public class Main {
    public static void main(String[] args) throws ParseException {

        Runnable task = () -> System.out.println("Hello, it's me! A schedule task!");

        Scheduler scheduler = new Scheduler("22:00:00", task);
        scheduler.run();
    }
}
