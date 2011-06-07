package WallStreet;

import javax.swing.*;

import java.util.ArrayList;

import java.awt.*;


import java.awt.*;

public class WallStreet {

    ArrayList<Investor> _investors;
    Market _market;
    JFrame frame;
    Human human;

    public WallStreet() {
        drawGraphics();
    }

    private void drawGraphics() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        human = new Human(10);

        frame.getContentPane().add(human);
        frame.setVisible(true);
        _market = new Market();
        _investors = new ArrayList<Investor>();

    }

    public void shuffle() {
        Investor temp;
        int y;
        for (int i = 0; i < _investors.size(); i++) {
            y = (int) (Math.random() * 10);
            temp = _investors.get(i);
            _investors.set(i, _investors.get(y));
            _investors.set(y, temp);
        }
    }

    public void go() {
        shuffle();
        int happiness = 0;
        for (Investor x : _investors) {
            x.run();
        }
        while (happiness != _investors.size()) {
            happiness = 0;
            for (Investor y : _investors) {
                if (y.isHappy()) {
                    happiness++;
                } else {
                    y.invest();
                }
            }
        }
        for (Investor a : _investors) {
            a.run();
        }
        while (happiness != _investors.size()) {
            happiness = 0;
            for (Investor z : _investors) {
                if (z.isHappy()) {
                    happiness++;
                } else {
                    z.sell();
                }
            }
        }
        for (Company b : _market.getCompanies()) {
            b.adjustPrice();
        }
        for (int i = 0; i < _investors.size(); i++) {
            if (_investors.get(i).getMoney() <= 0) {
                _investors.get(i).die();
                _investors.remove(i);
            }
        }
    }
    

    public void addInvestor(Investor j) {
        _investors.add(j);
    }

    public void addCompany(Company k) {
        _market.add(k);
    }

    public class Human extends JPanel {

        int _numHumans;

        public Human(int numHumans) {
            super();
            _numHumans = numHumans;
        }

        public void paintComponent(Graphics g) {
            Image[] images = new Image[_numHumans];
            //change this file path on your computer
            Image img = new ImageIcon("C:\\Users\\English\\Documents\\NetBeansProjects\\CS-project\\WallStreet\\src\\WallStreet\\Human.jpg").getImage();
            img = img.getScaledInstance(frame.getWidth() / _numHumans, frame.getHeight() / _numHumans * 2, 2);
            for (int i = 0; i < images.length; i++) {
                images[i] = img;
                g.drawImage(images[i], i * frame.getWidth() / _numHumans, 0, this);
            }
            //change this file path on your computer
            Image img2 = new ImageIcon("C:\\Users\\English\\Documents\\NetBeansProjects\\CS-project\\WallStreet\\src\\WallStreet\\WallStreet.jpg").getImage();
            img2 = img2.getScaledInstance(frame.getWidth() / 2, (int) (frame.getHeight() * (_numHumans - 1.0) / (_numHumans) / 2), 1);
            g.drawImage(img2, frame.getWidth() / 4, 3 * frame.getHeight() / _numHumans, this);
        }
    }
    
    
    public static void main(String[] arg) {
        WallStreet test = new WallStreet();
    }
}
