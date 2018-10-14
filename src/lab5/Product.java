package lab5;
/**
 * Title: Product.java
 * Abstract: This file contain the class Product which is define with getters and
 * setters to modify and get the information needed.
 * Author: XXXX
 * ID: XXXX
 * Date: MM/DD/YYYY
 */
public class Product {
    int productNum;
    String name;
    double unitPrice;

    // getters
    public int getProductNum() {
        return productNum;
    }

    public String getName() {
        return name;
    }

    public double getUnitPrice() {
        return unitPrice;
    }


    // setters
    public void setProductNum(int productNum) {
        this.productNum = productNum;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }


}
