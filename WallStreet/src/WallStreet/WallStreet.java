package WallStreet;

import java.util.Arrays;
import javax.swing.*;
import java.util.ArrayList;
import cs1.Keyboard;
import java.awt.*;

public class WallStreet {

    ArrayList<Investor> _investors;
    ArrayList<Investor> _investors2;
    Market _market;
    JFrame frame;
    Human human;
    JPanel panel;
    ArrayList<JButton> buttons;

    public WallStreet() {
        _investors = new ArrayList<Investor>();
        _investors2 = new ArrayList<Investor>();
        _market = new Market();
    }

    public Market getMar(){
        return _market;
    }
    
    private void drawGraphics() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 700);
        human = new Human();
        frame.getContentPane().add(human);
        panel = new JPanel();
        panel.setBackground(Color.CYAN);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        addToPanel();
        frame.getContentPane().add(BorderLayout.EAST,panel);
        frame.setVisible(true);
    }

    public void addToPanel(){
        JButton[] temp = new JButton[10];
        buttons = new ArrayList<JButton>();
        for(int i = 0; i < temp.length; i++){
            temp[i] = new JButton(i + ":" + _investors2.get(i).toString());
        }
        buttons.addAll(Arrays.asList(temp));
        for(int i = 0; i < buttons.size(); i++){
            panel.add(buttons.get(i));
        }
    }

    public void resetPanel(){
        for(int i = 0; i < buttons.size(); i++){
            buttons.get(i).setText(i + ":" + _investors2.get(i).toString());
        }
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
                buttons.remove(i);
            }
        }
        resetPanel();
    }

    public void addInvestor(Investor j) {
        _investors.add(j);
    }

    public void addCompany(Company k) {
        _market.add(k);
    }

    public class Human extends JPanel {

        public void paintComponent(Graphics g) {
            //this is taking too much memory
            /*Image[] images = new Image[_numHumans];
            //change this file path on your computer
            Image img = new ImageIcon("C:\\Users\\English\\Documents\\NetBeansProjects\\CS-project\\WallStreet\\src\\WallStreet\\Human.jpg").getImage();
            img = img.getScaledInstance(frame.getWidth() / _numHumans, frame.getHeight() - 100 / _numHumans * 2, 2);
            for (int i = 0; i < images.length; i++) {
                images[i] = img;
                g.drawImage(images[i], i * frame.getWidth() / _numHumans, 0, this);
            }
            //change this file path on your computer
            Image img2 = new ImageIcon("C:\\Users\\English\\Documents\\NetBeansProjects\\CS-project\\WallStreet\\src\\WallStreet\\WallStreet.jpg").getImage();
            img2 = img2.getScaledInstance(frame.getWidth() / 2, (int) (frame.getHeight() * (_numHumans - 1.0) / (_numHumans) / 2), 1);
            g.drawImage(img2, frame.getWidth() / 4, 3 * frame.getHeight() / _numHumans, this);
             *
             */
            Image img = new ImageIcon("C:\\Users\\English\\Documents\\NetBeansProjects\\CS-project\\WallStreet\\src\\WallStreet\\Human.jpg").getImage();
            //img = img.getScaledInstance(frame.getWidth()/2, frame.getHeight()/2, 1);
            g.drawImage(img, 60, 40, this);
            Image img2 = new ImageIcon("C:\\Users\\English\\Documents\\NetBeansProjects\\CS-project\\WallStreet\\src\\WallStreet\\WallStreet.jpg").getImage();
            //img2 = img2.getScaledInstance(frame.getWidth()/2, frame.getHeight()/2, 1);
            g.drawImage(img2, 50, frame.getHeight()/2, this);
        }
    }

    public void business() {
        _investors2.addAll(_investors);
        drawGraphics();
        while (_investors.size() > 3) {
            go();
            System.out.println("i for investors, c for companies, anything else will initiate another turn");
            String w = Keyboard.readString();
            if (w.equals("i")) {
                for (Investor x : _investors) {
                    System.out.println(x);
                }
            } 
            else if (w.equals("c")) {
                for (Company y : _market.getCompanies()){
                    System.out.println(y);
                }
            }
            else if(w.equals("e"))
            try{
                Thread.sleep(100);
            }catch(Exception e){
            }
        }
    }

    public static void main(String[] arg) {
        WallStreet test = new WallStreet();
        Company a = new Company(); 
        Company b = new Company(); 
        Company c = new Company(); 
        Company d = new Company(); 
        Company e = new Company(); 
        Company f = new Company(); 
        Company g = new Company(); 
        Company h = new Company(); 
        Company i = new Company(); 
        Company j = new Company(); 
        Investor k = new Investor(test.getMar());
        Investor l = new Investor(test.getMar());
        Investor m = new Investor(test.getMar());
        Investor n = new Investor(test.getMar());
        Investor o = new Investor(test.getMar());
        Investor p = new Investor(test.getMar());
        Investor q = new Investor(test.getMar());
        Investor r = new Investor(test.getMar());
        Investor s = new Investor(test.getMar());
        Investor t = new Investor(test.getMar());
        test.addCompany(a);
        test.addCompany(b);
        test.addCompany(c);
        test.addCompany(d);
        test.addCompany(e);
        test.addCompany(f);
        test.addCompany(g);
        test.addCompany(h);
        test.addCompany(i);
        test.addCompany(j);
        test.addInvestor(k);
        test.addInvestor(l);
        test.addInvestor(m);
        test.addInvestor(n);
        test.addInvestor(o);
        test.addInvestor(p);
        test.addInvestor(q);
        test.addInvestor(r);
        test.addInvestor(s);
        test.addInvestor(t);
        test.business();
    }
}