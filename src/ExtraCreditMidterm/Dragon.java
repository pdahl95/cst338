package ExtraCreditMidterm;

/**
 * Pernille Dahl
 * Midterm 1 Extra Credit Other File
 * Dragon.Java
 * 10/26/2018
 */
public class Dragon extends Monster {

    public Dragon(){
        this("trogdor", "wingely");
    }

    public Dragon(String name, String type){
        super(name);
        setMonsterType( type );
    }

    public static String burninate(Monster monster, double v) {
        if(monster instanceof Dragon){
            return monster.name + " burninates " + v + " peasants";
        }
        return  monster.name + " eats " + v + " cookies";
    }

    public String flap(int flaps){
        if(flaps % 2 == 0 || flaps < 20){
            return getName() + " flaps its tiny wings " + flaps + " times";
        }
        return getName() + " can't even";
    }

    public String trample(String thing){
        if(thing.contains( "cottage" )){
            return "the " + thing + " is trampled by " + getName();
        }
        return "the " + thing + " resists " +  getName();
    }

    @Override
    public String eat(String food){
        if(food.equals( "peasant" )){
            return "burna-licious";
        }
        return "Dragon don't eat " + food;
    }
}
