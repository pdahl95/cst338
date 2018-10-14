package Exercise13Sep;

public class CarMadeDemo {
    public static void main(String[] args)   {
        int i;
        CarMade object1 = new CarMade( );
        for (i = 1; i <= 5 ; i++) {
            object1.demoMethod( );
        }
        object1.outPutCount( );

        CarMade object2 = new CarMade( );
        for (i = 1; i <= 5 ; i++) {
            object2.demoMethod( );
            object2.outPutCount( );
        }
    }
}
