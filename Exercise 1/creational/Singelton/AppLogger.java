package Singelton;
import java.time.LocalDateTime;

public class AppLogger {
   private static AppLogger instance;

    private AppLogger()
    {
        System.out.println("Logger created at " + LocalDateTime.now());
    }

    public static synchronized AppLogger getInstance() {
        if (instance == null) {
            instance = new AppLogger();
        }
        return instance;
    }

    public void info(String msg) {
        log("INFO", msg);
    }

    public void warn(String msg) {
        log("WARN", msg);
    }

    public void error(String msg) {
        log("ERROR", msg);
    }

    private void log(String level, String msg) {
        System.out.printf("[%s] %s - %s%n", level, LocalDateTime.now(), msg);
    }
} 

