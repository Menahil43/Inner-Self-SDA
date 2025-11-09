package quiz.app.view;

import quiz.app.controller.ScoreController;
import quiz.app.model.Result;

import javax.swing.*;
import java.awt.*;

/**
 * Beautiful golden-themed score view with colored trait bars and suggestions.
 */
public class ScoreView extends JFrame {

    private final ScoreController controller;
    private final String userName;
    private final Result result;

    public ScoreView(ScoreController controller, String userName, Result result) {
        this.controller = controller;
        this.userName = userName;
        this.result = result;

        setTitle("Your Inner Self - EQ Results");
        setSize(1150, 700);
        setLocation(100, 50);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(null);
        getContentPane().setBackground(new Color(0x4F0D03));

        Color textColor = new Color(239, 164, 60);

        JLabel heading = new JLabel("Thank you " + userName + " for Playing!");
        heading.setBounds(30, 40, 1100, 40);
        heading.setFont(new Font("Mongolian Baiti", Font.BOLD, 30));
        heading.setForeground(textColor);
        heading.setHorizontalAlignment(SwingConstants.CENTER);
        add(heading);

        // Add bars for personality traits
        displayPersonalityScoresWithBars(result.getPersonalityScores());

        JLabel suggestionHeading = new JLabel("Suggestions for Improvement");
        suggestionHeading.setBounds(100, 380, 950, 30);
        suggestionHeading.setFont(new Font("Mongolian Baiti", Font.BOLD, 28));
        suggestionHeading.setForeground(textColor);
        suggestionHeading.setHorizontalAlignment(SwingConstants.CENTER);
        add(suggestionHeading);

        JLabel suggestionLabel = new JLabel(generateImprovementSuggestion(result.getPersonalityScores()));
        suggestionLabel.setBounds(100, 420, 950, 150);
        suggestionLabel.setFont(new Font("Mongolian Baiti", Font.BOLD, 22));
        suggestionLabel.setForeground(textColor);
        suggestionLabel.setHorizontalAlignment(SwingConstants.CENTER);
        suggestionLabel.setVerticalAlignment(SwingConstants.TOP);
        add(suggestionLabel);

        JButton exit = new JButton("EXIT");
        exit.setBounds(500, 600, 150, 40);
        exit.setFont(new Font("Mongolian Baiti", Font.BOLD, 25));
        exit.setBackground(new Color(0xEFA43C));
        exit.setForeground(new Color(0x4F0D03));
        exit.setFocusPainted(false);
        exit.setBorderPainted(false);
        exit.setContentAreaFilled(false);
        exit.setOpaque(true);
        add(exit);

        exit.addActionListener(e -> {
            controller.onExit(userName, result);
            dispose();
        });

        // Add background image (optional)
        try {
            java.net.URL bgUrl = ClassLoader.getSystemResource("back-01.png");
            if (bgUrl != null) {
                ImageIcon i1 = new ImageIcon(bgUrl);
                Image i2 = i1.getImage().getScaledInstance(1150, 700, Image.SCALE_SMOOTH);
                JLabel bg = new JLabel(new ImageIcon(i2));
                bg.setBounds(0, 0, 1150, 700);
                add(bg);
            }
        } catch (Exception ignored) {}

        setVisible(true);
    }

    private void displayPersonalityScoresWithBars(int[] scores) {
        String[] traits = {"Communication", "Empathy", "Adaptability", "Resilience", "Self-Awareness"};
        int y = 100;
        for (int i = 0; i < scores.length; i++) {
            int score = scores[i];

            JLabel traitLabel = new JLabel(traits[i]);
            traitLabel.setBounds(150, y, 200, 30);
            traitLabel.setFont(new Font("Mongolian Baiti", Font.BOLD, 20));
            traitLabel.setForeground(Color.WHITE);
            traitLabel.setHorizontalAlignment(SwingConstants.RIGHT);
            add(traitLabel);

            JPanel barPanel = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    int width = getWidth() / 5;
                    for (int j = 0; j < 5; j++) {
                        g.setColor(j < score ? getColorByScore(score) : new Color(200, 200, 200));
                        g.fillRect(j * width, 0, width, getHeight());
                        g.setColor(Color.BLACK);
                        g.drawRect(j * width, 0, width, getHeight());
                    }
                }
            };
            barPanel.setBounds(400, y + 5, 400, 30);
            barPanel.setOpaque(false);
            add(barPanel);

            y += 60;
        }
    }

    private Color getColorByScore(int score) {
        if (score >= 4) return new Color(76, 175, 80);   // Green
        else if (score >= 3) return new Color(255, 193, 7); // Yellow
        else return new Color(244, 67, 54);              // Red
    }

    private String generateImprovementSuggestion(int[] scores) {
        StringBuilder s = new StringBuilder("<html>");
        String[] traits = {"Communication", "Empathy", "Adaptability", "Resilience", "Self-Awareness"};

        for (int i = 0; i < scores.length; i++) {
            if (scores[i] <= 3) {
                s.append("&#8226; Improve your ").append(traits[i]).append(".<br>");
            }
        }

        if (s.toString().equals("<html>")) {
            s.append("You have a great balance of emotional traits!");
        }

        s.append("</html>");
        return s.toString();
    }
}
