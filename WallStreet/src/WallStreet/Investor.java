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

    public Investor(Market mar){
        _money = 5000.0;
        _oldmoney = 0;
        _confidence = 43 + (int)(16*Math.random());
        _stockVal = 0;
        _stockValChanged = 0;
        _market = mar;
        _stocks = new TreeMap<Company, Integer>();
    }
    
    //find list of all the companies with risk < comfidence.
    
    public void changeStockVal(){
        double old = _stockVal;
        _stockVal = 0; 
        for(Company x: _stocks.keySet()){
            _stockVal = x.getPrice() * _stocks.get(x);
        }
        _stockValChanged = _stockVal - old;
         
    }
    
    
    public double getStockChange(){
        return _stockValChanged;
    }

    public double getStockVal(){
        return _stockVal;
    }
    
    public double getPort(){
        return _money + _stockVal;
    }

    public void invest(){//The code is a little messy here.  Will clean up later
        _oldmoney = _money; //assuming this goes first.
        ArrayList<Company> comp = _market.getCompanies();
        for(int i = 0; i < comp.size(); i++){
            if((comp.get(i).getRisk() < _confidence) 
                && comp.get(i).getPrice() < _money){
                if(_stocks.containsKey(comp.get(i))){
                    _stocks.put(comp.get(i), (_stocks.get(comp.get(i)) + 1));
                }
                else _stocks.put(comp.get(i), 1);
            }
               comp.get(i).sell();
               _money -= comp.get(i).getPrice();
               break;
        }
    }

    //sell those stocks with the risk > than confidence
    public void sell() {
        for(Company x: _market.getCompanies()){
            if(x.getRisk() > _confidence || x.getStock() < 3){
                if(_stocks.get(x) == 1) _stocks.remove(x);
                else _stocks.put(x, _stocks.get(x) - 1);
                _money += x.getPrice();
                x.gain();
                break;
            }
        }
    }
        
    public void resetConfidence() {
        _confidence += (_money + _stockValChanged - _oldmoney) * Math.random()/50;
    }
    
    public double getMoney(){
        return _money;
    }
    
    public int getConfidence(){
        return _confidence;
    }
}
