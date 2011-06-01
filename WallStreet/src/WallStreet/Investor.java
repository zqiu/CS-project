
import java.util.Map;

public class Investor {

    double _money;
    int _confidence;
    //lets the investor access the market
    Market _market;
    //list of the companies pointing to the int amount they have of the stock
    Map<Company, Integer> _stocks;

    public Investor() {
    }

    public void invest() {
    }

    public void sell() {
    }

    public void resetConfidence() {
    }
}
