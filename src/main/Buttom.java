package main;

import java.awt.Dimension;
import java.awt.Color;
import java.awt.Font;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.util.List;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.BorderFactory;
import javax.swing.SwingConstants;
import javax.swing.JPopupMenu;
import javax.swing.JMenuItem;

public class Buttom extends JPanel {
    private int lives = 5;
    private Data data;
    private Sound sound;
    private Font font;
    private JPopupMenu popupMenu;
    public List<List<JLabel>> sudoku;

    public Buttom(Main main, MainPanel mainPanel, int width, int height) {
        data = new Data();
        sound = new Sound();
        sudoku = new ArrayList<>();
        popupMenu = new JPopupMenu();
        popupMenu.setLayout(new java.awt.FlowLayout(FlowLayout.LEFT));

        for (int i = 1; i <= 9; i++) {
            JMenuItem item = new JMenuItem("" + i);
            int number = i;
            item.addActionListener(e -> {
                JLabel sourceLabel = (JLabel) popupMenu.getInvoker();

                int row = (int) sourceLabel.getClientProperty("row");
                int col = (int) sourceLabel.getClientProperty("col");

                if (data.getSolveSudoku(row, col) == number) {
                    data.setFillSudoku(row, col, number);
                    sourceLabel.setText(String.valueOf(number));

                    if (data.checkUserWin())
                        main.glassPane("win");
                    else
                        sound.playSound("correct.wav");
                } else {
                    lives--;
                    mainPanel.top.addImages(lives);

                    if (lives <= 0)
                        main.glassPane("over");
                    else
                        sound.playSound("wrong.wav");
                }
            });

            popupMenu.add(item);
        }

        font = new Font("", Font.BOLD, 16);
        this.setLayout(new GridLayout(9, 9));
        this.setPreferredSize(new Dimension(width, height));
    }

    public void addFutures() {
        int number;
        for (int row = 0; row < 9; row++) {
            List<JLabel> rowSudoku = new ArrayList<>();
            for (int col = 0; col < 9; col++, number++) {
                JLabel label = new JLabel("", SwingConstants.CENTER);
                label.setVerticalAlignment(SwingConstants.CENTER);

                // metadata
                label.putClientProperty("row", row);
                label.putClientProperty("col", col);

                label.setFont(font);
                label.setOpaque(true);

                number = data.getFillSudoku(row, col);

                if (number != 0) {
                    label.setText("" + number);
                    label.setBackground(Color.lightGray);
                } else {
                    addListener(label);
                }

                if ((row == 2 && col == 2) || (row == 2 && col == 5) || (row == 5 && col == 2)
                        || (row == 5 && col == 5))
                    label.setBorder(BorderFactory.createMatteBorder(1, 1, 5, 5, Color.black));
                else if (row == 2 || row == 5)
                    label.setBorder(BorderFactory.createMatteBorder(1, 1, 5, 1, Color.black));
                else if (col == 2 || col == 5)
                    label.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 5, Color.black));
                else
                    label.setBorder(BorderFactory.createLineBorder(Color.black));

                rowSudoku.add(label);
            }
            sudoku.add(rowSudoku);
        }

        addSudokuOnPanel();
    }

    private void addListener(JLabel label) {
        label.addMouseListener(new MouseAdapter() {
            Color originalColor = label.getBackground();

            @Override
            public void mouseEntered(MouseEvent e) {
                showPopup(e);
                label.setBackground(new java.awt.Color(215, 215, 215));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                label.setBackground(originalColor);
            }

            private void showPopup(MouseEvent e) {
                popupMenu.show(e.getComponent(), e.getX(), e.getY());
            }
        });
    }

    private void addSudokuOnPanel() {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                this.add(sudoku.get(row).get(col));
            }
        }
    }
}
