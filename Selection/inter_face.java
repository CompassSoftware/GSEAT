/** inter_face.java
 *
 * Selection team
 *
 * @author Yuanboz
 *
 * Version 1.0
 */

import javax.swing.*;
import java.awt.*;

public class inter_face {

    private JFrame f;
    private JPanel p;
    private JButton b1;
    private JLabel lab;

    public inter_face() {

        gui();

    }

    public void gui() {

        f= new JFrame("GSEAT");
        f.setVisible(true);
        f.setSize(600,400);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        p = new JPanel();
        p.setBackground(Color.YELLOW);

        b1 = new JButton("test");
        lab = new JLabel("This is test label");

        p.add(b1);
        p.add(lab);

        f.add(p);

    }

    public static void main(String[] args) {

        new inter_face();

    }
}
