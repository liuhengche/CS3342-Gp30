import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class SystemLog {
    private static SystemLog instance;
    private static final String LOG_FILE = "system_log.txt"; // Log file path
    private final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

    private SystemLog() {
    }

    public static SystemLog getInstance() {
        if (instance == null) {
            synchronized (SystemLog.class) {
                if (instance == null) {
                    instance = new SystemLog();
                }
            }
        }
        return instance;
    }

    public void log(String level, String message) {
        LocalDateTime now = LocalDateTime.now();
        String formattedMessage = dtf.format(now) + " [" + level + "] " + message;
        System.out.println(formattedMessage); // Print to console
        writeToFile(formattedMessage); // Write to file
    }

    private void writeToFile(String message) {
        try (PrintWriter out = new PrintWriter(new FileWriter(LOG_FILE, true))) {
            out.println(message);
        } catch (IOException e) {
            System.err.println("Error writing to log file: " + e.getMessage());
        }
    }

    // Example usage methods for different log levels
    public void info(String message) {
        log("INFO", message);
    }

    public void warning(String message) {
        log("WARNING", message);
    }

    public void error(String message) {
        log("ERROR", message);
    }
}
