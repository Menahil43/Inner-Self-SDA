package quiz.app.model;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

/**
 * Handles file saving of EQ test results.
 */
public class FileStorage {

    public void saveResultToFile(String userName, int[] scores) {
        try (FileWriter writer = new FileWriter("EQ_Results.txt", true)) {
            writer.write("User: " + userName + "\n");
            writer.write("Date: " + LocalDateTime.now() + "\n");
            String[] traits = {"Communication", "Empathy", "Adaptability", "Resilience", "Self-Awareness"};
            for (int i = 0; i < scores.length; i++) {
                writer.write(traits[i] + ": " + scores[i] + "\n");
            }
            writer.write("-------------------------------------------\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
