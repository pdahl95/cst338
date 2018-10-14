package Lab7;

import java.util.ArrayList;
import java.util.ListIterator;

public class Sales {

    private double amount;
    private String itemName;
    private int itemNumber;
    private ArrayList<String> items;
    private ArrayList<Double> price;

    public Sales(double amount, String itemName, int itemNumber, ArrayList<String> items, ArrayList<Double> price) {
        this.amount = amount;
        this.itemName = itemName;
        this.itemNumber = itemNumber;
        this.items = items;
        this.price = price;
    }

    // TODO: 10/5/18 implement some mechanism of authorizing a credit card.
    public boolean authorize(){


        return true;
    }

    public void calcAmount() {
        ListIterator foo = items.listIterator();
        while (foo.hasNext()) {
            amount += price.get(foo.nextIndex());
        }
    }
    public void addItem(String itemName, double price){
        items.add(itemName);
        this.price.add(price);
    }
}


