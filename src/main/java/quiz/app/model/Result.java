package quiz.app.model;

import java.io.Serializable;

/**
 * Holds EQ test results and handles saving to file.
 */
public class Result implements Serializable {

    private final int[] personalityScores;

    public Result() {
        this.personalityScores = new int[5]; // 5 traits
    }

    /**
     * Update a specific personality trait's score.
     */
    public void updatePersonalityScore(String trait) {
        switch (trait.toLowerCase()) {
            case "communication" -> personalityScores[0]++;
            case "empathy" -> personalityScores[1]++;
            case "adaptability" -> personalityScores[2]++;
            case "resilience" -> personalityScores[3]++;
            case "self-awareness" -> personalityScores[4]++;
        }
    }

    /**
     * Return the personality scores array.
     */
    public int[] getPersonalityScores() {
        return personalityScores;
    }

    /**
     * Save results to a text file (using FileStorage helper).
     */
    public void saveToFile(String userName) {
        FileStorage storage = new FileStorage();
        storage.saveResultToFile(userName, personalityScores);
    }
}
