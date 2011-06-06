package WallStreet;

import javax.swing.*;

public class WallStreet {

    Investor[] _investors;
    Market _market;
    JFrame frame;
    Human human;

    public WallStreet() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JButton button = new JButton("clicked");
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

    public static void main(String[] arg) {
        WallStreet test = new WallStreet();
    }
}
