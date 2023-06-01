
//根据给出的数值比例用不同颜色用swing画饼图
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;

public class N03 {
    public static void main(String args[]) {
        new PieChart();
    }
}

class PieChart extends JFrame {
    public PieChart() {
        super("饼图");
        setSize(400, 300);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public void paint(Graphics g) {
        super.paint(g);
        int x = 100, y = 100, w = 200, h = 200;
        int startAngle = 200, arcAngle = 160;
        g.setColor(Color.red);
        g.fillArc(x, y, w, h, startAngle, arcAngle);
        g.setColor(Color.green);
        g.fillArc(x, y, w, h, startAngle + arcAngle, arcAngle);
        g.setColor(Color.blue);
        g.fillArc(x, y, w, h, startAngle + 2 * arcAngle, arcAngle);
    }

}