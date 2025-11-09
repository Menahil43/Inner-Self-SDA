package quiz.app.view;

import quiz.app.controller.EQTestController;
import quiz.app.model.Question;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EQTestView extends JFrame implements ActionListener {
    private final EQTestController controller;
    private final Question[] questions;
    private int index = 0;
    private final JLabel questionLabel;
    private final JRadioButton[] options = new JRadioButton[4];
    private final ButtonGroup group;
    private final JButton nextBtn;
    private final String userName;

    public EQTestView(EQTestController controller, String userName, Question[] questions) {
        this.controller = controller;
        this.userName = userName;
        this.questions = questions;

        setTitle("EQ Test - Inner Self");
        setSize(1000, 650);
        setLocation(150, 80);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        getContentPane().setBackground(new Color(0x4F0D03));

        // ******** IMAGE ADDING ********
        ImageIcon img = new ImageIcon(getClass().getResource("/eq-01.png"));
        Image scaled = img.getImage().getScaledInstance(1150, 300, Image.SCALE_SMOOTH);
        JLabel imgLabel = new JLabel(new ImageIcon(scaled));
        imgLabel.setBounds(0, 0, 1150, 300);
        add(imgLabel);


        // ******** TITLE LABEL ********
        JLabel title = new JLabel("INNER SELF EQ TEST");
        title.setFont(new Font("Mongolian Baiti", Font.BOLD, 30));
        title.setForeground(new Color(0xEFA43C));
        title.setBounds(300, 240, 400, 40);
        add(title);

        // ******** QUESTION LABEL ********
        questionLabel = new JLabel();
        questionLabel.setBounds(100, 290, 800, 50);
        questionLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
        questionLabel.setForeground(new Color(0xEFA43C));
        add(questionLabel);

        // ******** OPTIONS ********
        group = new ButtonGroup();
        for (int i = 0; i < 4; i++) {
            options[i] = new JRadioButton();
            options[i].setBounds(120, 350 + i * 40, 700, 30);
            options[i].setBackground(new Color(0x4F0D03));
            options[i].setForeground(new Color(0xEFA43C));
            options[i].setFont(new Font("Times New Roman", Font.PLAIN, 18));
            group.add(options[i]);
            add(options[i]);
        }

        // ******** NEXT BUTTON ********
        nextBtn = new JButton("Next");
        nextBtn.setBounds(400, 520, 150, 35);
        nextBtn.setBackground(new Color(0xEFA43C));
        nextBtn.setForeground(new Color(0x4F0D03));
        nextBtn.setFocusPainted(false);
        nextBtn.addActionListener(this);
        add(nextBtn);

        loadQuestion();
        setVisible(true);
    }

    private void loadQuestion() {
        group.clearSelection();
        Question q = questions[index];
        questionLabel.setText((index + 1) + ". " + q.getText());
        for (int i = 0; i < 4; i++) {
            options[i].setText(q.getOptions()[i]);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (group.getSelection() == null) {
            JOptionPane.showMessageDialog(this, "Please select an answer!");
            return;
        }

        Question q = questions[index];
        for (int i = 0; i < 4; i++) {
            if (options[i].isSelected()) {
                controller.updateScore(q.getTraits()[i]);
            }
        }

        index++;
        if (index < questions.length) {
            loadQuestion();
        } else {
            setVisible(false);
            controller.finishTest(userName);
            dispose();
        }
    }
}
