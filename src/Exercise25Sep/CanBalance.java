package Exercise25Sep;
public class CanBalance {

    /*
     *  canBalance returns true whenever the front and back of an array have the same total value.
     *  For example {1,1,1,3} would return true because 1+1+1 == 3
     *  {1,1,1,4} would be false. {5,0,5} is true. {2,0,0,3} is false.
     *  Come up with an algorithm that will return the correct response for the following examples.
     *
     */

    public static void main(String[] args) {

        boolean r;
        r = canBalance(new int[] {1, 1, 1, 2, 1});
        System.out.println("canBalance( [1, 1, 1, 2, 1] ) should be true. You returned "+r);

        r = canBalance(new int[] {2, 1, 1, 2, 1 });
        System.out.println("canBalance( [2, 1, 1, 2, 1]) should be false.  You returned "+r);

        r = canBalance(new int[] {10, 10});
        System.out.println("canBalance( [10,10]) should be true. You returned "+r);

        r = canBalance(new int[] {10, 0, 1, -1, 10} );
        System.out.println("canBalance([10, 0, 1, -1, 10]) should be true. You returned "+r);

        r = canBalance(new int[] { 1});
        System.out.println(" should be false. You returned "+r);

        r = canBalance(new int[] {1, 1, 1, 2, 1});
        System.out.println("canBalance([1, 1, 1, 2, 1])  should be true. You returned "+r);

    }

    public static boolean canBalance(int[] nums) {
        // write your solution here.
      int first = 0;
      int second = 0;

      for(int i = 0; i < nums.length; i++){
          second += nums[i];
      }
      for(int i = 0; i <= nums.length - 2; i++){
          first += nums[i];
          second -= nums[i];

          if(first == second){
              return true;
          }
      }

        return false; //this is here so to make the 'no return' error go away.
    }

}
