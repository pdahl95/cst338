/**
 * Title: OnlineStoreDemo.java
 * Abstract: This program keeps product and order information of 
 * an imaginary online shopping mall.
 * Author: XXXX
 * ID: XXXX
 * Date: MM/DD/YYYY
 */
package lab5;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class OnlineStoreDemo 
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner (System.in);
        OnlineStore csumbOnlineStore = new OnlineStore("CSUMB");
        int option;

        System.out.println("Welcome to CSUMB OnlineStore");
                  
        do
        {
            System.out.println("Select your choice:");
            System.out.println("    1. Add Product");
            System.out.println("    2. Product Info");
            System.out.println("    3. Delete Product");
            System.out.println("    4. Exit");
            System.out.println();
            option = sc.nextInt();
                          
            if (option == 1)        
            {
                csumbOnlineStore.addProduct();
            }
            else if (option == 2)  
            {
                csumbOnlineStore.productInfo();
            }
            else if (option == 3)  
            {
                csumbOnlineStore.deleteProduct();
            }
            else if (option == 4)  
            {
                System.out.println("Bye");
                return;
            }
            else
            {
                System.out.println("Incorrect option");
            }
            System.out.println("\n\n");
        } while (true);
    }
}
