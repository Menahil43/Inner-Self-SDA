package quiz.app;

import quiz.app.controller.SessionController;

public class Main {
    public static void main(String[] args) {
        // Start the application
        javax.swing.SwingUtilities.invokeLater(() -> new SessionController().startSession());
    }
}
