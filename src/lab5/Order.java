package lab5;
/**
 * Title: Order.java
 * Abstract: This program keeps product and order information of
 *           an imaginary online shopping mall.
 * Author: XXXX
 * ID: XXXX
 * Date: MM/DD/YYYY
 */

public class Order {
    int orderNum;
    double totalPrice;

    public Order(int orderNum, double totalPrice, Product[] items) {
        this.orderNum = orderNum;
        this.totalPrice = totalPrice;
        this.items = items;
    }

    Product[] items = new Product[10];

    // Constructor ...

    // Other methods ...
}
