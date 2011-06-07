package WallStreet;

import javax.swing.*;
import java.util.ArrayList;

public class WallStreet {

    ArrayList<Investor> _investors;
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
        while(happiness != _investors.size()){
            happiness = 0;
            for (Investor y : _investors){
                if (y.isHappy())happiness++;
                else y.invest();            
            }
          }
        for (Investor a : _investors) {
            a.run();
        }
        while(happiness != _investors.size()){
            happiness = 0;
            for(Investor z : _investors){
                if(z.isHappy()) happiness++;
                else z.sell();
            }
        }
        for(Company b: _market.getCompanies())
            b.adjustPrice();
        for(int i = 0; i < _investors.size(); i++){
            if(_investors.get(i).getMoney() <= 0){
                _investors.get(i).die();
                _investors.remove(i);
            }
        }
    }

    public void addInvestor(Investor j){
        _investors.add(j);
    }
    
    public void addCompany(Company k){
        _market.add(k);
    }
    
    public static void main(String[] arg) {
        WallStreet test = new WallStreet();
    }
}
