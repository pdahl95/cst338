package Exercise11Sep;

public class MyDate {
    
    private String month;
    private int day;
    private int year;
    
    /*
     * No arg consturctor
     */
    public MyDate() {
        month = "January";
        day = 1;
        year = 2000;
    }
    
    public int getDay() {
        return day;
    } 
    
    public String getMonth() {
        return month;
    }
    
    public int getYear() {
        return year;
    } 
    
    public void setMyDate(String m, int d , int y ) {
        month = m;
        setDay(d);
        year = y;
    }
    
    public void setDay(int day) {
        if (day <=0 || day > 31) {
            System.out.println("Day out of range.");
            System.exit(0); 
        } else {
            this.day = day;
        }
        System.out.println("this="+this);
    }
    
    
     public String toString(){
         return month + " " + day + ", " + year;
     }
}
