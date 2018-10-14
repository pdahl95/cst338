package Exercise13Sep;

public class CarMade {
    private static int numOfCars = 0;

    public void demoMethod( ) {
        numOfCars++;
    }

    public void outPutCount( )  {
        numOfCars++;
        System.out.println("Number of cars so far = "+ numOfCars);
    }
}
