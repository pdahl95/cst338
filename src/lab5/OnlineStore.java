// Head comment here
package lab5;
/**
 * Title: OnlineStore.java
 * Abstract: This program have the function to modify and work with the store.
 * For example, the add product function.
 * Author: Pernille Dahl
 * Date: 09/27/2018
 */

import java.util.Scanner;
import java.util.HashMap;

public class OnlineStore {
    String name;
//    Product[] products = new Product[10];
    Order[] orders = new Order[10];

    public OnlineStore(String name) {
        this.name = name;
    }
    Scanner input = new Scanner( System.in );

    HashMap<Integer, Product> products = new HashMap<>();

    public void addProduct() {
        // Develop this method
        // 1. must add the info manually with System.input
        // 2. then use the key to store the rest of the information
        System.out.println("Enter Product Number ");
        int productNumber = input.nextInt();
        System.out.println("Enter Product Name: ");
        String productName = input.next();
        System.out.println("Enter Product Price: ");
        double price = input.nextDouble();

        Product firstProduct = new Product();
        products.put( productNumber, firstProduct );
        firstProduct.productNum = productNumber;
        firstProduct.name = productName;
        firstProduct.unitPrice = price;

        System.out.println("Product Added - " + firstProduct.getName() + ", " + "No: " + firstProduct.getProductNum()
                + ", " + "Price: " + firstProduct.getUnitPrice());

        System.out.println();

    }
    
    public void deleteProduct() {
        // Develop this method
        // ...
    }

    public void productInfo() {
        // Develop this method
        // ...
    }
    public String toString(){
        return  " ";
    }
}
