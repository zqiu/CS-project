package WallStreet;

import java.util.ArrayList;

public class Market {

    ArrayList<Company> _companies;

    public Market() {
        _companies = new ArrayList<Company>();
    }

    public boolean add(Company company){
        int ans = addR(company,0,_companies.size());
        _companies.add(ans, company);
        return true;
    }

    private int addR(Company company, int low, int high){
        int mid = (high + low) / 2;
        if(low >= high){
            return mid;
        }
        else if(_companies.get(mid).getRisk() < company.getRisk()) {
            return addR(company,mid,high);
        }
        else {
            return addR(company, low , mid);
        }
    }


    public ArrayList<Company> getCompanies() {
        return _companies;
    }
}
