package quiz.app.model;

public class QuestionBank {
    private final Question[] questions;

    public QuestionBank() {
        questions = new Question[]{
                new Question("How do you build and maintain trust in your relationships?",
                        new String[]{
                                "By being honest and transparent in my communication",
                                "By consistently following through on promises",
                                "By showing empathy and understanding",
                                "By respecting boundaries and perspectives"},
                        new String[]{"Communication", "Responsibility", "Empathy", "Respect"}),

                new Question("When faced with a conflict, what is your typical response?",
                        new String[]{
                                "I calmly discuss to understand both sides",
                                "I avoid it and wait for things to cool down",
                                "I try to compromise quickly",
                                "I get upset but later apologize"},
                        new String[]{"Self-Awareness", "Resilience", "Adaptability", "Empathy"}),

                new Question("How do you usually react to sudden changes?",
                        new String[]{
                                "I embrace them as opportunities",
                                "I feel anxious but adapt",
                                "I resist them at first",
                                "I ignore until necessary"},
                        new String[]{"Adaptability", "Resilience", "Self-Awareness", "Adaptability"}),

                new Question("How often do you reflect on your emotions?",
                        new String[]{
                                "Regularly, to understand patterns",
                                "Only when something big happens",
                                "Rarely, I move on quickly",
                                "I find it difficult to reflect"},
                        new String[]{"Self-Awareness", "Resilience", "Adaptability", "Self-Awareness"}),

                new Question("When someone shares their problem, how do you respond?",
                        new String[]{
                                "Listen actively and show empathy",
                                "Offer practical advice immediately",
                                "Relate with my own experiences",
                                "Change the topic to lighten the mood"},
                        new String[]{"Empathy", "Responsibility", "Communication", "Adaptability"}),

                new Question("When stressed, how do you calm yourself?",
                        new String[]{
                                "Take deep breaths and think positively",
                                "Talk to a trusted friend",
                                "Distract myself with activities",
                                "Ignore and push through"},
                        new String[]{"Resilience", "Empathy", "Adaptability", "Self-Awareness"}),

                new Question("How do you ensure clear communication?",
                        new String[]{
                                "By being an active listener",
                                "By keeping my tone respectful",
                                "By confirming understanding",
                                "By avoiding assumptions"},
                        new String[]{"Communication", "Respect", "Responsibility", "Empathy"}),

                new Question("When criticized, you usually...",
                        new String[]{
                                "Listen and improve",
                                "Defend yourself instantly",
                                "Ignore and move on",
                                "Feel hurt for a while"},
                        new String[]{"Self-Awareness", "Communication", "Adaptability", "Resilience"}),

                new Question("How do you motivate yourself during tough times?",
                        new String[]{
                                "Remind myself of past achievements",
                                "Seek inspiration from others",
                                "Focus on small wins",
                                "Push myself harder"},
                        new String[]{"Resilience", "Empathy", "Adaptability", "Responsibility"}),

                new Question("What do you do when a team member feels down?",
                        new String[]{
                                "Encourage them with kind words",
                                "Offer help with their workload",
                                "Give them space",
                                "Try to cheer them up with humor"},
                        new String[]{"Empathy", "Responsibility", "Respect", "Adaptability"})
        };
    }

    public Question[] getQuestions() {
        return questions;
    }
}
