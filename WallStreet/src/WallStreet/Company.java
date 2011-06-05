package WallStreet;

public class Company{

    private int _numStock;
    private int _numSold;
    private double _price;
    private int _risk;

    public Company() {
        _numSold = 0;
        _numStock = 30;
        _risk = ((int)(Math.random()*50));
        _price = 50.0;
    }

    public double adjustPrice() {
        if (_risk == 0) {
            _price *= 1.005;
        } else {
            _price += (.15 * _price * ((_numSold / _numStock) - .5))
                    + ((Math.random() * 5 < 2) ? 1 : -1)
                    * Math.random() * .001 * _risk * _price;
        }
        return _price;
    }
    
    public double getPrice(){
        return _price;
    }

    public int getRisk(){
        return _risk;
    }

    public void sell(){
        _numStock--;
        _numSold++;
    }
    public void gain(){
        _numStock++;
        _numSold--;
    }
    
    
    public int getStock(){
        return _numStock;
    }
}