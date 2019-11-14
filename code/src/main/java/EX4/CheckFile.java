package EX4;
/*
 *
 * @author Danilo Sambugaro created on 13/11/2019 inside the package - EX4
 *
 */

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.attribute.FileTime;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.TimeZone;
import java.util.concurrent.*;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


public class CheckFile {
    private File file;
    private File logFile;
    private String lastModified;
    private ScheduledExecutorService executor;

    public CheckFile(String file, String logFile) {
        this.file = new File(file);
        this.logFile = new File(logFile);
        this.executor = Executors.newSingleThreadScheduledExecutor();
    }

    public  void run() {
        System.out.println("[ INFO ] Starting modified file watcher...");
        executor.scheduleWithFixedDelay(() -> {
            DateFormat format = new SimpleDateFormat("dd MMMM, yyyy hh:mm a z");
            format.setTimeZone(TimeZone.getTimeZone("GMT-3:00"));
            String modifiedTime = null;
            try {
                modifiedTime = format.format(Files.getLastModifiedTime(Paths.get(file.getAbsolutePath())).toMillis());
            } catch (IOException e) {
                e.printStackTrace();
            }

            if (lastModified != null && !lastModified.equals(modifiedTime)) {
                System.out.println("[ INFO ] Modification detected, writing in log file...");
                String log = "File modified at " + modifiedTime + "\n";
                try {
                    BufferedWriter logFileWriter = new BufferedWriter(new FileWriter(logFile.getAbsoluteFile(), true));
                    logFileWriter.append(log);
                    logFileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            lastModified = modifiedTime;
        }, 0, 10, TimeUnit.SECONDS);


    }

}
