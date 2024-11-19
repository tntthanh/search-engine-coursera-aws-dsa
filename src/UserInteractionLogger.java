
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class UserInteractionLogger {

    private static final String LOG_FILE = "src/resources/data/user_interactions.log";

    // Method to log search interactions
    public void logSearch(String searchTerm) {
        log("Search for: " + searchTerm);
    }

    // Method to log sorting interactions
    public void logSort(String sortCriteria) {
        log("Sorted by: " + sortCriteria);
    }

    // Method to log viewing all books
    public void logViewAllBooks() {
        log("Viewed all books");
    }

    // Generic method to log messages with a timestamp
    public void log(String message) {
        // TODO 17: Open the log file in append mode
        try (FileWriter writer = new FileWriter(LOG_FILE, true)) {
            // TODO 18: Construct the log entry with timestamp
            String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS"));
            writer.write(timestamp + " - " + message + System.lineSeparator());
        } catch (IOException e) {
            // TODO 19: Handle exceptions during file writing
            System.err.println("An error occurred while logging: " + e.getMessage());
        }
    }

}
