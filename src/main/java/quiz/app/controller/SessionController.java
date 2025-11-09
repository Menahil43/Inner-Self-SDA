package quiz.app.controller;

import quiz.app.view.SessionStarterView;

public class SessionController {
    /**
     * Show the initial session starter view (where user enters name).
     */
    public void startSession() {
        new SessionStarterView(this);
    }
    /**
     * Called from the view when user wants to start the EQ test.
     * @param userName name entered by the user
     */
    public void startEQTest(String userName) {
        // Delegate to EQTestController to handle test start
        new EQTestController().startTest(userName);
    }
    /**
     * Exit the application.
     */
    public void exitApp() {
        System.exit(0);
    }
}
