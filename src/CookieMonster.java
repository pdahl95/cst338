public class CookieMonster extends Monster{
    public CookieMonster() {
        name = "cookie";
        monsterType = "Cookie Monster";

    }

    public CookieMonster(String s1, String s2){
        name = s1;
        monsterType = s2;
    }

    public String sing(int mins){
        if(mins % 2 == 1 && mins < 15){
            return "cookie sings C IS FOR COOKIE!! for " + mins +  " minutes";
        }
        return "cookie says it is not time for singing. Maybe in " + mins + " minutes";
    }
    public static String bake(Monster m){
        CookieMonster c = new CookieMonster();
        if(!m.monsterType.equals(c.monsterType)){
            return getName() + " bakes cookies in an oven";
        }
        return getName() + " uses flame breath to bake a cake";
    }
    public String share(String name){
        if(this.getName().equalsIgnoreCase( name )){
            return this.getName() + " does not share any cookies =-(";
        }
        return this.getName() + " shares cookies with " + name;
    }
    @Override
    public String eat(String food){
        if(food.equals( "cookie" )){
            return "OM NOM NOM!";
        }
        return "C is for cookie not, " + food;
    }

}
