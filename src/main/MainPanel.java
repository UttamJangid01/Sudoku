package main;

import java.awt.Dimension;
import javax.swing.JPanel;

public class MainPanel extends JPanel{
    private final int width, height;
    public Top top;
    private Buttom buttom;
    private Main main;

    public MainPanel(Main main, int width, int height){
        this.main = main;
        this.setLayout(null);
        this.width = width;
        this.height = height;
        this.setPreferredSize(new Dimension(this.width, this.height));
    }

    public void addSubPanels(){
        top = new Top(width, 40);
        top.addImages(5);
        buttom = new Buttom(main, this, width, 500);
        buttom.addFutures();

        top.setBounds(0, 0, width, 40);
        buttom.setBounds(0, 40, width, 500);

        this.add(top);
        this.add(buttom);
    }
}
