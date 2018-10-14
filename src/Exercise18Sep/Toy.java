package Exercise18Sep;

public class Toy {
    private  String name;
    private int number;

    public Toy(){
        name = "G.I. Joe";
        number = 1;
    }

    public Toy makeCopy(){
        Toy r = new Toy();
        r.name = this.name;
        r.number = this.number;
        return r;
    }

    @Override
    public String toString(){
        return name + " " + number;
    }
    public Toy set(String s, int n){
        name = s;
        number = n;
        return this;
    }
}
