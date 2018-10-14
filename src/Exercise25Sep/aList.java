package Exercise25Sep;
import java.util.ArrayList;

public class aList {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();

        list.add( "neat" );
        System.out.println( "List Part 1:" );
        System.out.println(list);

        list.add( 0, "nifty" );
        System.out.println( "List Part 2: " );
        System.out.println(list);

        System.out.println( "List access as an array: " );
        System.out.println(list.toArray()[0]);

        list.add("cool");
        list.add( "awesome" );

        for(String s : list){
            System.out.println("Printing: " + s);
        }

    }
}
