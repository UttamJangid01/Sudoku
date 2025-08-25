package main;

import java.awt.Font;
import java.awt.BorderLayout;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Dimension;
import javax.swing.SwingConstants;
import javax.swing.JPanel;

public class Top extends JPanel {
    private JLabel label;
    private JPanel panel;
    private ImageIcon icon;
    private Image image;

    public Top(int width, int height) {
        this.setLayout(new BorderLayout());
        this.setPreferredSize(new Dimension(width, height));
        
        panel = new JPanel();

        java.net.URL url = getClass().getResource("res/Image/heart.png");
        if(url != null){
            icon = new ImageIcon(url);
            image = icon.getImage().getScaledInstance(35, 35, Image.SCALE_SMOOTH);
        }
        
        label = new JLabel("Sudoku", SwingConstants.CENTER);
        label.setVerticalAlignment(SwingConstants.CENTER);
        label.setFont(new Font("", Font.BOLD, 35));
        
        this.add(label, BorderLayout.WEST);
        this.add(panel, BorderLayout.EAST);
    }

    public void addImages(int n) {
        panel.removeAll();
        for (int i = 0; i < n; i++) {
            JLabel label = new JLabel(new ImageIcon(image));
            panel.add(label);
        }
        panel.revalidate();
        panel.repaint();
    }
}
