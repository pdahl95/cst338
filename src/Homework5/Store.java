package Homework5;
/**
 * Title: Store.java
 * Abstract: The main functional file. The actual store, where it adds customer, add and deletes products, get customer and product information.
 * Make the order.
 * Name: Pernille Dahl
 * Date: 2018-Nov-2
 */

import java.util.ArrayList;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Random;

public class Store {

    String name;
    Scanner input = new Scanner(System.in);
    Random rand = new Random();

    HashMap<Integer, Product> products = new HashMap<>();
    HashMap<Integer, Customer> customers = new HashMap<>();

    ArrayList<Integer> orderHistory = new ArrayList<>();

    public Store(String name) {
        this.name = name;
    }

    /**
     * Function to add costumer, will automatically assign a unique number between 100-300
     */
    public void addCustomer() {
        int customerNumber = rand.nextInt(300-100) + 100;
        String customerName = input.nextLine();

        System.out.println("Customer Number: " + customerNumber);
        System.out.println("Customer Name: " + customerName);

        Customer customer = new Customer(customerName, customerNumber);
        customers.put( customerNumber, customer );
        customer.setCustomerNumber( customerNumber );
        customer.setName( customerName );

        System.out.println("Customer Added - " + customer.getName() + " (# " + customer.getCustomerNumber() + ")");
    }

    /**
     * Function will display every customer added
     */
    public void customerInfo() {
        boolean isEmpty = customers.isEmpty();
        if(!isEmpty){
            for(Customer c : customers.values()){
                System.out.println(c.getName() + " - " + c.getCustomerNumber());
            }
        } else {
            System.out.println("No customer information.");
        }

    }

    /**
     * Function to add a product to the store. Will automatically assign a unique number from 500-700
     */
    public void addProduct() {
        int productNumber = rand.nextInt(700-500) + 500;
        String productName = input.nextLine();
        double price = Double.parseDouble(input.nextLine());

        System.out.println("Product Number: " + productNumber);
        System.out.println("Product Name: " + productName);
        System.out.println("Product Price: " + price);

        Product product = new Product(productName, price, productNumber);
        products.put( productNumber, product);
        product.setProductNumber( productNumber );
        product.setProductName( productName );
        product.setPrice( price );

        System.out.println("Product Added - " + product.getProductName() + ", " + "No: " + product.getProductNumber()
                + ", " + "Price: " + product.getPrice());
    }

    /**
     * Function to delete the product from the online store.
     */
    public void deleteProduct() {
        int productNumber = input.nextInt();
        System.out.println("Product number to delete: " + productNumber);
        if ( !products.containsKey( productNumber ) ) {
            System.out.printf( "Input Error: Product %d doesn't exist.\n", productNumber );
        } else {
            products.remove( productNumber);
            System.out.printf("Product %d deleted. \n", productNumber);
        }

    }

    /**
     * Function to display a specfic product based on the product number, or just display all products in the store.
     */
    public void productInfo() {
        boolean isEmpty = products.isEmpty();
        if(isEmpty){
            System.out.println("No product information.");
        } else {
            System.out.println("Enter product number (or just enter to display all products: ");
            String entryKey = input.nextLine();
            if(entryKey.equals("")){
                for(Product prod : products.values()){
                    System.out.println("No: " + prod.getProductNumber() + " - " + prod.getProductName() + ", Price: " + prod.getPrice());
                }
            } else {
                int productNumber= Integer.parseInt(entryKey);
                if(products.containsKey( productNumber )){
                    System.out.println("No: " + productNumber + " - " + products.get( productNumber ).getProductName() + ", Price: " + products.get( productNumber ).getPrice());

                } else {
                    System.out.println("Product does not exist.");
                    productNumber= Integer.parseInt(entryKey);
                }
            }
        }
    }

    /**
     * Function to make an order, assign random number from 1000-2000, and give a summary of what customer ordered what and the price of the order.
     */
    public void makeOrder() {
        int orderNumber = rand.nextInt(2000-1000) + 1000;
        int customerNumber = Integer.parseInt( input.nextLine() );
        int productNumber;
        double totalPrice = 0;
        System.out.println("Type Customer Number: " + customerNumber);
        if(!customers.containsKey( customerNumber )){
            System.out.printf("Input Error: Customer number %d doesn't exist.\n", customerNumber);
        }
        do{
            System.out.print("Type Product Number (0 to finish): ");
            productNumber = input.nextInt();
            orderHistory.add( productNumber );
        } while(productNumber != 0);

        System.out.println("Order Summary - Order Number: " + orderNumber + ", Customer: " + customers.get( customerNumber ).getName());
        for(int i = 0; i < orderHistory.size()-1; i++){
            System.out.println("\t\t Item " + i +": " + products.get( orderHistory.get( i ) ).getProductName() + ": $" + products.get( orderHistory.get( i ) ).getPrice());
            totalPrice += products.get( orderHistory.get( i ) ).getPrice();
        }
        System.out.println("\t\t Total Price: " + totalPrice);
    }

    @Override
    public String toString(){
        return "";
    }
}
