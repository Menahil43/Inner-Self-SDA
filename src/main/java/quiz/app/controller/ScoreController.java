package quiz.app.controller;

import quiz.app.model.Result;
import quiz.app.view.ScoreView;

/**
 * Controller for displaying and handling the score screen.
 */
public class ScoreController {

    /**
     * Show the ScoreView with the given result and user name.
     */
    public void showScore(String userName, Result result) {
        new ScoreView(this, userName, result);
    }

    /**
     * Called when user presses the EXIT button.
     * Saves result and returns to start screen.
     */
    public void onExit(String userName, Result result) {
        // Save to file using model's storage system
        result.saveToFile(userName);
        // Return to session starter
        new SessionController().startSession();
    }
}
