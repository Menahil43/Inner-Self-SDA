package quiz.app.model;

public class Question {
    private final String text;
    private final String[] options;
    private final String[] traits;

    public Question(String text, String[] options, String[] traits) {
        this.text = text;
        this.options = options;
        this.traits = traits;
    }

    public String getText() { return text; }
    public String[] getOptions() { return options; }
    public String[] getTraits() { return traits; }
}
