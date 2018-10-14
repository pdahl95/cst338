package Exercise18Sep;

import java.util.Hashtable;
import java.util.Scanner;
/**
 * Roman numerals 
 *    I  1 
 *    V  5
 *    X  10
 *    L  50
 *    C  100
 *    D  500
 *    M  1000
 * 
 *    Numbers are written in decreasing value
 *    Example:    XII is 12, not IIX or IXI
 *    
 *    But there are  special rules:
 *    I can come before V or X  IV = 4,  IX = 9
 *    X can come before L or C  XL = 40, XC = 90
 *    C can come before D or M  CD = 400 CM = 900
 */
public class Roman {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

        Hashtable<Character, Integer> ht = new Hashtable<>();
        ht.put('i', 1);
        ht.put('x', 10);
        ht.put('c', 100);
        ht.put('m', 1000);
        ht.put('v', 5);
        ht.put('l', 50);
        ht.put('d', 500);

		while (true) {
			System.out.print("Enter Roman Number or q for quit. ");
			String x = in.nextLine();
			if (x.equals("q"))
				return;

			// your code goes here.
            int intNum = 0;
            int prev = 0;
            for(int i = x.length(); i > 0; i--){



            }
            System.out.println(intNum);
		}

        }
}