import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class N02 {
    public static void main(String args[]) {
        p win = new p();
        win.setVisible(true);
        win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class p extends JFrame {
    private JPanel p1, p2, p3, p4, p5;
    private JButton[] blackButtons = new JButton[72];
    private JButton[] whiteButtons = new JButton[72];
    private JLabel label;
    public p() {
        p1 = new JPanel();
        p2 = new JPanel();
        p3 = new JPanel();
        p4 = new JPanel();
        p5 = new JPanel();
        init();
    }

    private void init() {
        this.setTitle("p");
        this.setBounds(300, 300, 300, 320);
        this.setLayout(new BorderLayout());

        label = new JLabel("北方");
        p1.setLayout(new FlowLayout());
        p1.setPreferredSize(new Dimension(300, 30));
        p1.add(label);
        this.add(p1, BorderLayout.NORTH);

        label = new JLabel("<html>东<br>方",JLabel.CENTER);
        p2.setLayout(new BorderLayout());
        p2.setPreferredSize(new Dimension(30, 240));
        p2.add(label, BorderLayout.CENTER);        
        this.add(p2, BorderLayout.EAST);

        p3.setLayout(new GridLayout(12, 12,0,0));
        Color black = new Color(0, 0, 0);
        for (int i = 0; i < 72; i++) {
            blackButtons[i] = new JButton();
            blackButtons[i].setPreferredSize(new Dimension(24, 24));
            blackButtons[i].setBackground(black);
            blackButtons[i].setOpaque(true);
            blackButtons[i].setBorderPainted(false);
        }
        Color white = new Color(255, 255, 255);
        for (int i = 0; i < 72; i++) {
            whiteButtons[i] = new JButton();
            whiteButtons[i].setPreferredSize(new Dimension(24, 24));
            whiteButtons[i].setBackground(white);
            whiteButtons[i].setOpaque(true);
            whiteButtons[i].setBorderPainted(false);

        }
        int index1 = 0;
        int index2 = 0;
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if (j % 2 == 0) {
                    p3.add(blackButtons[index1]);
                    index1++;
                } else {
                    p3.add(whiteButtons[index2]);
                    index2++;
                }
            }
            for (int j = 0; j < 6; j++) {
                if (j % 2 == 0) {
                    p3.add(whiteButtons[index2]);
                    index2++;
                } else {
                    p3.add(blackButtons[index1]);
                    index1++;
                } 
            }
        }
        this.add(p3, BorderLayout.CENTER);

        label = new JLabel("<html>西<br>方",JLabel.CENTER);
        p4.setLayout(new BorderLayout());
        p4.setPreferredSize(new Dimension(30, 240));
        p4.add(label, BorderLayout.CENTER);        
        this.add(p4, BorderLayout.WEST);

        label = new JLabel("南方");
        p5.add(label);
        p5.setPreferredSize(new Dimension(300, 30));
        p5.setLayout(new FlowLayout());
        this.add(p5, BorderLayout.SOUTH);


    }
}