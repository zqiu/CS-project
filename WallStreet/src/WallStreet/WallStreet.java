package WallStreet;

import javax.swing.*;
import java.awt.*;

public class WallStreet {

    Investor[] _investors;
    Market _market;
    JFrame frame;
    Human human;

    public WallStreet() {
        drawGraphics();
    }

    private void drawGraphics(){
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        human = new Human(10);

        frame.getContentPane().add(human);
        frame.setVisible(true);
    }

    public void go() {
    }

    public String toString() {
        return "complete this";
    }

    public class Human extends JPanel {

        int _numHumans;

        public Human(int numHumans){
            super();
            _numHumans = numHumans;
        }

        public void paintComponent(Graphics g) {
            Image[] images = new Image[_numHumans];
            Image img = new ImageIcon("C:\\Users\\English\\Documents\\NetBeansProjects\\CS-project\\WallStreet\\src\\WallStreet\\Human.jpg").getImage();
            img = img.getScaledInstance(frame.getWidth()/_numHumans, frame.getHeight()/_numHumans, 2);
            for(int i = 0; i < images.length; i++){
                images[i] = img;
                g.drawImage(images[i], i * frame.getWidth() / _numHumans , 0, this);
            }
            Image img2 = new ImageIcon("C:\\Users\\English\\Documents\\NetBeansProjects\\CS-project\\WallStreet\\src\\WallStreet\\WallStreet.jpg").getImage();
            img2 = img2.getScaledInstance(frame.getWidth(), (int)(frame.getHeight() * (_numHumans - 1.0)/(_numHumans)), 1);
            g.drawImage(img2, 0, frame.getHeight()/_numHumans, this);
        }
    }

    public static void main(String[] arg) {
        WallStreet test = new WallStreet();
    }
}
