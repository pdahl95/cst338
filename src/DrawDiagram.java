/**
 * Title: DrawDiagram.java
 * Abstract: This is a program were we ask the user for an input, the length of the diagram. .
 * Then the program prints out a sqaure as well as a triangle.
 * Author: [Pernille Dahl]
 * ID: [CST 338]
 * Date: [Sep 6 2018]
 */
import java.util.Scanner;
public class DrawDiagram {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a length: ");
        int length = input.nextInt();

        input.close();

        for(int r = 0; r < length; r++){
            for(int c = 0; c < length; c++){
                System.out.print(" *");
            }
            System.out.println(" ");
        }

        System.out.println(" ");

        for(int r = 0; r <= length; r++){
            for(int i = 1; i <= (length - r); i++){
                System.out.print(" ");
                System.out.print(" ");
            }
            for(int c = 0; c <= r; c++){
                System.out.print("*");
                System.out.print(" ");
            }
            System.out.println(" ");
        }
    }
}
