package WallStreet;

import javax.swing.*;
import java.awt.*;

public class WallStreet {

    Investor[] _investors;
    Market _market;
    JFrame frame;
    Human human;

    public WallStreet() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        human = new Human();
        frame.getContentPane().add(human);
        frame.setSize(500, 500);
        frame.setVisible(true);
    }

    public void go() {
    }

    public String toString() {
        return "complete this";
    }

    public class Human extends JPanel {

        public void paintComponent(Graphics g) {
            Image img = new ImageIcon("C:\\Users\\English\\Documents\\NetBeansProjects\\CS-project\\WallStreet\\src\\WallStreet\\Human.jpg").getImage();
            Image img2 = img.getScaledInstance(100, 100, 2);
            img = img2;
            g.drawImage(img, 0, 0, this);
            g.drawImage(img2, 0, 100, this);
        }
    }

    public static void main(String[] arg) {
        WallStreet test = new WallStreet();
    }
}
