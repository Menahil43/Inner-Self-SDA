package quiz.app.controller;

import quiz.app.model.QuestionBank;
import quiz.app.model.Result;
import quiz.app.view.EQTestView;

/**
 * Handles the logic for the EQ Test:
 *  - Loads questions from the model
 *  - Updates scores
 *  - Sends results to ScoreController
 */
public class EQTestController {

    private final QuestionBank questionBank;
    private final Result result;

    public EQTestController() {
        this.questionBank = new QuestionBank();
        this.result = new Result();
    }

    /** Called from SessionController when the test begins */
    public void startTest(String userName) {
        new EQTestView(this, userName, questionBank.getQuestions());
    }

    /** Called by EQTestView whenever the user selects an answer */
    public void updateScore(String trait) {
        result.updatePersonalityScore(trait);
    }

    /** Called by EQTestView when all questions are finished */
    public void finishTest(String userName) {
        new ScoreController().showScore(userName, result);
    }
}
