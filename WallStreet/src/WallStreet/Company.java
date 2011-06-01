
public class Company {

    int _numStock;
    int _numSold;
    double _price;
    int _risk;

    public Company() {
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
}
