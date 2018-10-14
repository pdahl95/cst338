package Lab7;
/**
 * Author: Drew A. Clinkenbeard
 * Date: 8 - Oct - 2018 Don't leave things until the end folks
 * Purpose: A silly class to demonstrate JUnit
 * Add this to a file named Demo.java in either Intellij or Eclipse
 */

public class Demo {
    private int mustBePositive;
    private String cantBeNull;
    private boolean shouldBeTrue;

    public Demo(int m, String c, boolean s){
        this.mustBePositive = m;
        this.cantBeNull = c;
        this.shouldBeTrue =s;
    }

    public int getMustBePositive() {
        return mustBePositive;
    }

    public void setMustBePositive(int mustBePositive) {
        this.mustBePositive = mustBePositive;
    }

    public String getCantBeNull() {
        return cantBeNull;
    }

    public void setCantBeNull(String cantBeNull) {
        this.cantBeNull = cantBeNull;
    }

    public boolean isShouldBeTrue() {
        return shouldBeTrue;
    }

    public void setShouldBeTrue(boolean shouldBeTrue) {
        this.shouldBeTrue = shouldBeTrue;
    }
}



