package Lab7;
import java.util.ListIterator;

public abstract class CCPayment implements Payment {
    public boolean authorize(){
        return false;
    }
    public void calcAmount(ListIterator<Item> items){
        double ret = 0;
//        while(items.hasNext()){
//            ret += items.next() - ;
//        }
    }

//    public void calcAmount() {
//        ListIterator foo = items.listIterator();
//        while (foo.hasNext()) {
//            amount += price.get(foo.nextIndex());
//        }
//    }

}
