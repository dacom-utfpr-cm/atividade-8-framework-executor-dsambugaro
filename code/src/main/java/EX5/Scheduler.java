package EX5;
/*
 *
 * @author Danilo Sambugaro created on 13/11/2019 inside the package - EX5
 *
 */

import java.time.LocalTime;
import java.time.temporal.ChronoField;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Scheduler {
    private String time;
    private Runnable task;
    private ScheduledExecutorService executor;

    public Scheduler(String time, Runnable task) {
        this.time = time;
        this.task = task;
        this.executor = Executors.newSingleThreadScheduledExecutor();
    }

    public  void run() {
        long secondsExecute = LocalTime.parse(time).getLong(ChronoField.SECOND_OF_DAY);
        long secondsNow = LocalTime.now().getLong(ChronoField.SECOND_OF_DAY);

        long initialDelay = 0;
        long secondsIn24Hours = 86400;

        if (secondsExecute > secondsNow){
            initialDelay = secondsExecute - secondsNow;
        } else {
            initialDelay = secondsIn24Hours - (secondsNow - secondsExecute);
        }

        // Executa a tarefa uma vez no horário indicado e depois a cada 24 horas
        // Se o horário já tiver passado, executa neste horário no próximo dia
        executor.scheduleWithFixedDelay(task, initialDelay, secondsIn24Hours, TimeUnit.SECONDS);
    }
}
