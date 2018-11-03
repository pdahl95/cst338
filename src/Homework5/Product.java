package Homework5;
/**
 * Title: Product.java
 * Abstract: Product file to access and get the name of the product, the price and the id attach to each product.
 * Name: Pernille Dahl
 * Date: 2018-Nov-2
 */

public class Product {

    private String productName;
    private double price;
    private int productNumber; // should assign a unique random number between 500-700

    public Product(String productName, double price, int productNumber) {
        this.productName = productName;
        this.price = price;
        this.productNumber = productNumber;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getProductNumber() {
        return productNumber;
    }

    public void setProductNumber(int productNumber) {
        this.productNumber = productNumber;
    }

}
