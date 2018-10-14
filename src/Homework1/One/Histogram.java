/**
 * Title: Histogram.java
 * Abstract: This is a program that displays a list of distinct characters in an input file and the occurrence of each character.
 * The program reads an input file name from a user.
 * After that, the program reads characters in the file and display a list of distinct characters and their occurrences.
 * Finally, the program draws a vertical bar for the occurrences.
 *
 * Side Note:
 * - Unfortunally I was not able to solve the problem completely.
 * I try to make the Histogram to look as much alike as the Homework example,
 * but I was really struggling with the drawing of stars vertically and keeping them connected to the characters.
 * Also, evertime I entered the input file I had to do this: "/Users/pernilledahl/Desktop/cst338/src/Homework1/One/t1.txt"
 *
 * ID: [CST 338]
 * Date: [Sep 6 2018]
 */
package Homework1.One;

import java.io.FileNotFoundException;
import java.util.*;
import java.io.File;

public class Histogram {

    static int[] map = new int[11];
    static int counter = 0;
    static int max = 0;

    // function to print out the table fo the "map"
    private static void printMap(int[] map) {
        System.out.println("Char\tOccurrence");
        for (int i = 0; i < map.length; i++) {
            if(map[i]>0)
                System.out.println(" " + (char)(i+65) + "\t\t\t" + map[i]);
        }
    }
    // function to get the max value of the height occurrence
    private static int getMax(int[] arr) throws Exception {
        if(arr.length == 0 ) throw new Exception("arr is empty");
        int max = arr[0];
        for (int i : arr) {
            if(i > max) max = i;
        }
        return max;
    }


    public static void main(String[] args) {

        List<Integer> list = new ArrayList<Integer>();

        Scanner input = new Scanner(System.in);
        String line;

        try {

            System.out.print("Enter the filename: ");

            File file = new File(input.nextLine());
            input = new Scanner(file);

            // code to read and map the file into correct char and occurrence
            while (input.hasNextLine()) {
                line = input.nextLine();
                for (int i = 0; i < line.length(); i++) {
                    map[line.charAt(i) - 65]++;
                }
            }
            // printing the table
            printMap(map);

            // getting the max height of the vertical bar
            int height = getMax(map);

            /**  printing the vertical bar **/
            for (int r = 0; r < 12; r++) {
                System.out.print("=");
            }
            System.out.print(" Vertical Bar ");
            for (int r = 0; r < 12; r++) {
                System.out.print("=");
            }
            System.out.println(" ");

            // Code snippet to draw out the stars (not complete 100% to HW Example)
            for (int a = 0; a < list.size(); a++){
                 map[(list.get(a)-1) / height]++;
            }

            for (int count = 0; count < height; count++){
                if(map[count] > 0){
                    System.out.print("| " + (count*1+1) + (count == 1 ? " ": " ") + "| \t");
                }

                for(int h = 0; h < map[count]; h++)
                    System.out.print("* ");

                System.out.println();
            }

            for (int i = 0; i < 38; i++) {
                System.out.print("=");
            }
            // printing the characters from A to K in alphabetical order
            System.out.println(" ");
            for (int r = 0; r < 2; r++) {
                for (int c = r + 1; c < 2; c++) {
                    System.out.print("| " + "No" + " |");
                    for (char alphabet = 'A'; alphabet <= 'K'; alphabet++) {
                        // TODO: remove and add at the end the character who has occurance in file here
                        System.out.print(" " + alphabet + " ");
                    }
                }
            }
            // printing out the last line of the histogram
            System.out.println();
            for (int i = 0; i < 38; i++) {
                System.out.print("=");
            }
            /**  End of the vertical bar **/

        } catch (FileNotFoundException e) {
            e.printStackTrace();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            input.close();
        }
    }
}
