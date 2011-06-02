
import java.util.Map;

public class Investor {

    double _money;
    double _oldmoney;
    int _confidence;
    int _stockValChanged;
    //lets the investor access the market
    Market _market;
    //list of the companies pointing to the int amount they have of the stock
    Map<Company, Integer> _stocks;

    public Investor() {
    }

    //find list of all the companies with risk < comfidence.
    public void invest() {

    }

    //sell those stocks with the risk > than confidence
    public void sell() {
    }

    public void resetConfidence() {
        _confidence += (_money + _stockValChanged - _oldmoney) * Math.random()/50;
    }
}
