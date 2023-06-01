import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Stack;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class N01 {
    public static void main(String[] args) {
        cal cl = new cal();
        cl.setVisible(true);
        cl.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
class cal extends JFrame implements ActionListener{
    private JPanel p1,p2,p3;
    private JTextArea show;
    private String[] box2 = { "7", "8", "9", "/", "4", "5", "6", "*", "1", "2", "3", "-", "0", ".", "=", "+" };
    private JButton[] numButtons = new JButton[box2.length];
    public cal(){
        p1 = new JPanel();
        p2 = new JPanel();
        p3 = new JPanel();
        show = new JTextArea();
        p1.setSize(600, 100);
        init();
    }

    private void init() {
        this.setTitle("calc");
        this.setBounds(300, 300, 320, 300);
        this.setLayout(new BorderLayout());
        this.add(p1, BorderLayout.NORTH);
        this.add(p2, BorderLayout.CENTER);
        this.add(p3, BorderLayout.EAST);
        JButton clearButton = new JButton("clear");
        clearButton.setPreferredSize(new Dimension(40, 200));
        clearButton.addActionListener(this);
        p3.add(clearButton);
        show.setPreferredSize(new Dimension(300, 50));
        p1.add(show);
        p2.setLayout(new GridLayout(4, 4));
        for (int i = 0; i < box2.length; i++) {
            if ((box2[i]=="1")||(box2[i]=="2")||(box2[i]=="3")||(box2[i]=="4")||(box2[i]=="5")||(box2[i]=="6")||(box2[i]=="7")||(box2[i]=="8")||(box2[i]=="9")||(box2[i]=="0")||(box2[i]==".")){
                numButtons[i] = new JButton(box2[i]);
            } else {
                numButtons[i] = new JButton(" "+box2[i] + " ");
            }
            p2.add(numButtons[i]);
        }
        for (int i = 0; i < numButtons.length; i++) {
            numButtons[i].addActionListener(this);
        }
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        System.out.print(command);
        if (command.equals(" = ")) {
            show.setText(show.getText() + command);
            String[] box3 = show.getText().split(" ");
            Stack<String> stack = new Stack<String>();
            for (int i = 0; i < box3.length; i++) {
                if (box3[i].equals("*") || box3[i].equals("/")) {
                    double a = Double.parseDouble(stack.pop());
                    double b = Double.parseDouble(box3[i + 1]);
                    if (box3[i].equals("*")) {
                        stack.push(String.valueOf(a * b));
                    } else {
                        stack.push(String.valueOf(a / b));
                    }
                    i++;
                } else {
                    stack.push(box3[i]);
                }
            }
            double result = Double.parseDouble(stack.get(0));
            for (int i = 1; i < stack.size(); i++) {
                if (stack.get(i).equals("+")) {
                    result += Double.parseDouble(stack.get(i + 1));
                } else if (stack.get(i).equals("-")) {
                    result -= Double.parseDouble(stack.get(i + 1));
                }
            }

            if (show.getText().contains(".")) {
                show.setText(show.getText() + result);
            } else {
                show.setText(show.getText() + (int) result);
            }
        } else if (command.equals("clear")) {
            show.setText("");
        } else {
            show.setText(show.getText() + command);
            if (show.getText().length() % 40 == 0 && show.getText().length() >= 40) {
                show.setText(show.getText() + "\n ");
            }
        }
    }
}