package Lab2;
/*
 * Title: Lab2.java
 * Abstract: calculate mean and standard deviation of file of numbers. 
 * Name: Pernille Dahl
 * Date: 2018-Sept-13
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Lab2 {

    public static void main(String[] args) throws FileNotFoundException {

        double mean, stddev;
        double sum = 0;
        int count=0; 
        Scanner infile = null;
        String filename = null;
        File file = null;
        Scanner keyboard = new Scanner(System.in);
        boolean foundFile = false;

        // task #1 goes here to calculate count and mean.
        while (!foundFile){ // if there is not file
            try {
                System.out.print("Enter file name: ");
                filename = keyboard.nextLine();
                file = new File(filename);
                infile = new Scanner(file);
                foundFile = true;

            } catch (FileNotFoundException e){
                System.out.println("File not found.");

            }
        }
            while (infile.hasNext()){
                String currentValue = "";
                try{
                    currentValue = infile.next();
                    double currentDoubleValue = Double.valueOf(currentValue);
                    sum += currentDoubleValue;
                    count++;
                } catch (NumberFormatException e){
                    System.out.println("Bad Input: " + currentValue);
                }
            }

        infile.close();
        mean = sum/count;

        // task #2 goes here to calculate stddev
        double accumulator = 0;
        infile = new Scanner(file);
        while (infile.hasNext()){
            String currentValue;
            try{
                currentValue = infile.next();
                double currentDoubleValue = Double.valueOf(currentValue);
                accumulator += Math.pow(currentDoubleValue - mean, 2);
            } catch (NumberFormatException e){
//                System.out.println("Bad Input: " + currentValue);
            }
        }
        infile.close();

         stddev = Math.sqrt(accumulator/count);
         System.out.printf("Mean= %.3f Stddev= %.3f %n", mean, stddev);

        System.out.println("good bye.");

    }
}
