package quiz.app.view;

import quiz.app.controller.SessionController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Refactored SessionStarter view (Start screen) — same UI look & feel as your original class.
 */
public class SessionStarterView extends JFrame implements ActionListener {

    private final JTextField text;
    private final JButton nextBtn, backBtn;
    private final SessionController controller;

    public SessionStarterView(SessionController controller) {
        this.controller = controller;

        setTitle("Inner Self - Start");
        setBounds(100, 50, 1150, 700);
        getContentPane().setBackground(new Color(0x4F0D03));
        setLayout(null);

        // Load image safely (skip if not found)
        try {
            java.net.URL imgUrl = ClassLoader.getSystemResource("innerself-01.png");
            if (imgUrl != null) {
                ImageIcon i1 = new ImageIcon(imgUrl);
                Image i = i1.getImage().getScaledInstance(570, 750, Image.SCALE_DEFAULT);
                ImageIcon i2 = new ImageIcon(i);
                JLabel image = new JLabel(i2);
                image.setBounds(550, 0, 600, 750);
                add(image);
            }
        } catch (Exception ignored) {
            // ignore image loading problems for now
        }

        JLabel heading = new JLabel("INNER SELF");
        heading.setBounds(170, 150, 400, 50);
        heading.setFont(new Font("Mongolian Baiti", Font.BOLD, 40));
        heading.setForeground(new Color(0xEFA43C));
        add(heading);

        JLabel nameLabel = new JLabel("Enter Your Name");
        nameLabel.setBounds(200, 220, 300, 30);
        nameLabel.setFont(new Font("Mongolian Baiti", Font.BOLD, 24));
        nameLabel.setForeground(new Color(0xEFA43C));
        add(nameLabel);

        text = new JTextField();
        text.setBounds(130, 280, 300, 25);
        text.setFont(new Font("Times New Roman", Font.BOLD, 18));
        text.addActionListener(this); // Enter key same as pressing next
        add(text);

        nextBtn = new JButton("Next");
        nextBtn.setBounds(150, 340, 120, 25);
        nextBtn.setBackground(new Color(0xEFA43C));
        nextBtn.setForeground(new Color(0x4F0D03));
        nextBtn.setFocusPainted(false);
        nextBtn.addActionListener(this);
        add(nextBtn);

        backBtn = new JButton("Back");
        backBtn.setBounds(290, 340, 120, 25);
        backBtn.setBackground(new Color(0xEFA43C));
        backBtn.setForeground(new Color(0x4F0D03));
        backBtn.setFocusPainted(false);
        backBtn.addActionListener(this);
        add(backBtn);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        if (src == nextBtn || src == text) {
            String name = text.getText().trim();
            if (name.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter your name!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            // Hide this view and tell controller to start test
            setVisible(false);
            controller.startEQTest(name);
            dispose();
        } else if (src == backBtn) {
            controller.exitApp();
        }
    }
}
