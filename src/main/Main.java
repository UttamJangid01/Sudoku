package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Main {
    private JFrame window;
    private Sound sound;

    public Main() {
        sound = new Sound();
        window = new JFrame();
        window.setSize(540, 540);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLocationRelativeTo(null);
        window.setResizable(false);

        MainPanel mainPanel = new MainPanel(this, window.getWidth(), window.getHeight());
        mainPanel.addSubPanels();
        window.add(mainPanel);

        window.pack();
        window.setVisible(true);
    }

    public void glassPane(String status) {
        // Create a transparent panel as glasspane
        JPanel glass = new JPanel(new BorderLayout());
        JLabel label;

        if (status.equals("win")) {
            label = new JLabel("You Win");
            label.setForeground(Color.green);
            sound.playSound("win.wav");
        } else {
            label = new JLabel("Game Over");
            label.setForeground(Color.red);
            sound.playSound("gameOver.wav");
        }

        label.setFont(new Font("", Font.BOLD, 50));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setVerticalAlignment(SwingConstants.CENTER);

        glass.add(label, BorderLayout.CENTER);
        glass.setOpaque(false); // transparent
        glass.addMouseListener(new java.awt.event.MouseAdapter() {}); // consume mouse events
        glass.addKeyListener(new java.awt.event.KeyAdapter() {}); // consume key events

        window.setGlassPane(glass);
        glass.setVisible(true); // activate glasspane → blocks all events
    }

    public static void main(String[] args) {
        new Main();
    }
}
