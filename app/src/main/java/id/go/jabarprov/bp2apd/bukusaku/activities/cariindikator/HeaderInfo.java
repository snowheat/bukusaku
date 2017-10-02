package id.go.jabarprov.bp2apd.bukusaku.activities.cariindikator;

import java.util.ArrayList;

/**
 * Created by insan on 4/16/2017.
 */

public class HeaderInfo {

    private String name;
    private ArrayList<DetailInfo> productList = new ArrayList<DetailInfo>();

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public ArrayList<DetailInfo> getProductList() {
        return productList;
    }
    public void setProductList(ArrayList<DetailInfo> productList) {
        this.productList = productList;
    }

}
