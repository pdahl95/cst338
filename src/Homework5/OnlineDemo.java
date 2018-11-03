package Homework5;
/**
 * Title: OnlineDemo.java
 * Abstract: Demo to run the Online Store Program.
 * Name: Pernille Dahl
 * Date: 2018-Nov-2
 */

import java.util.Scanner;

public class OnlineDemo {
    public static void main(String[] args)  {

        Scanner sc = new Scanner (System.in);
        Store csumbOnlineStore = new Store("CSUMB");
        int option;
        System.out.println("Welcome to CSUMB Online Store");

        do{
            System.out.println("Select your choice:");
            System.out.println("\t 1. Add Customer");
            System.out.println("\t 2. Customer Info");
            System.out.println("\t 3. Add Product");
            System.out.println("\t 4. Delete Product");
            System.out.println("\t 5. Product Info");
            System.out.println("\t 6. Make Order");
            System.out.println("\t 7. Exit");
            System.out.println();

            while(!sc.hasNextInt()){
                System.out.println("Invalid Input! Please enter a number between 1 - 7!");
                sc.next();
            }
            option = sc.nextInt();

            if (option == 1){
                csumbOnlineStore.addCustomer();
            } else if(option == 2){
                csumbOnlineStore.customerInfo();
            }else if(option == 3){
                csumbOnlineStore.addProduct();
            }else if(option == 4){
                csumbOnlineStore.deleteProduct();
            }else if(option == 5){
                csumbOnlineStore.productInfo();
            }else if(option == 6){
                csumbOnlineStore.makeOrder();
            }else if (option == 7){
                System.out.println("Bye");
                return;
            }
            else {
                System.out.println("Error! The option does not exist!");
            }

            System.out.println("\n");
        } while (true);

    }
}
