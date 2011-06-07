package WallStreet;

import java.util.Map;
import java.util.TreeMap;
import java.util.ArrayList;

public class Investor {

    double _money;
    double _oldmoney;
    int _confidence;
    double _stockVal;
    double _stockValChanged;
    //lets the investor access the market
    Market _market;
    //list of the companies pointing to the int amount they have of the stock
    Map<Company, Integer> _stocks;
    //reports true if investor does not want to buy more stocks;
    boolean _happy;

    public Investor(Market mar) {
        _money = 5000.0;
        _oldmoney = 0;
        _confidence = 43 + (int) (16 * Math.random());
        _stockVal = 0;
        _stockValChanged = 0;
        _market = mar;
        _stocks = new TreeMap<Company, Integer>();
    }

    //find list of all the companies with risk < comfidence.
    public void changeStockVal() {
        double old = _stockVal;
        _stockVal = 0;
        for (Company x : _stocks.keySet()) {
            _stockVal += x.getPrice() * _stocks.get(x);
        }
        _stockValChanged = _stockVal - old;

    }

    public double getStockChange() {
        return _stockValChanged;
    }

    public double getStockVal() {
        return _stockVal;
    }

    public double getPort() {
        return _money + _stockVal;
    }

    public void invest(){
        _oldmoney = _money; //assuming this goes first.
        for (Company y : _market.getCompanies()) {
            if (y.getRisk() < _confidence && y.numLeft() > 0 && y.getPrice() < _money) {
                if (_stocks.containsKey(y)) {
                    _stocks.put(y, (_stocks.get(y) + 1));
                } 
                else {
                    _stocks.put(y, 1);
                }
                y.sell();
                _money -= y.getPrice();
                break;
            } 
            else _happy = true;
        }
    }
    //sell those stocks with the risk > than confidence

    public void sell() {
        for (Company x : _market.getCompanies()) {
            if (x.getRisk() > _confidence || x.numLeft() < 3){
                if (_stocks.get(x) == 1){
                    _stocks.remove(x);
                } 
                else{
                    _stocks.put(x, _stocks.get(x) - 1);
                }
                _money += x.getPrice();
                x.gain();
                break;
            } 
            else _happy = true;   
        }
    }

    public void resetConfidence() {
        _confidence += (_money + _stockValChanged - _oldmoney) * Math.random() / 50;
    }

    public double getMoney() {
        return _money;
    }

    public int getConfidence() {
        return _confidence;
    }

    public String toString() {
        String ans = "";
        ans = "Money: " + _money + "  |Portfolio: " + getPort()
                + "  |Confidence: " + _confidence;
        return ans;
    }

    //carries out what an investor would do each turn, in order, before invest.
    public boolean isHappy() {
        return _happy;
    }

    public void resetHappy() {
        _happy = false;
    }

    public void run() {
        resetHappy();
        changeStockVal();
        resetConfidence();
    }

    public void die(){
        for(Company x: _stocks.keySet()){
            for(int i = 0; i < _stocks.get(x); i++){
                x.gain();
            }
        }
    }

}
 