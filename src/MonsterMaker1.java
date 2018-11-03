import java.util.HashMap;

public class MonsterMaker1 {
    public static void main(String[] args){
        HashMap<Integer,Monster> monsters = new HashMap<>();
        for(int i = 4; i > 0; i --){
                   Monster.addMonster(monsters, new CookieMonster("HankMcCoy"+i,"Blue Guy"));
            }


        for (Integer key : monsters.keySet() ){
            System.out.println("=-=-=-=-= Checking Static Methods =-=-=-=-=");
            System.out.println((CookieMonster.bake(monsters.get(key))));
                System.out.println("=-=-=-=-= Checking CookieMonster Methods =-=-=-=-=");
                System.out.println(monsters.get(key).eat("cookie"));
                System.out.println(monsters.get(key).eat("avacado"));
                System.out.println(((CookieMonster) monsters.get(key)).sing(10));
                System.out.println(((CookieMonster) monsters.get(key)).sing(7));
                System.out.println(((CookieMonster) monsters.get(key)).sing(41));
                System.out.println(((CookieMonster) monsters.get(key)).share(monsters.get(key).getName()) );
                System.out.println(((CookieMonster) monsters.get(key)).share("Trogdor") );

            System.out.println("=-=-=-=-= Looping =-=-=-=-=");

        }

        System.out.println("the final count of Monsters: " + Monster.getMonsterCount());

    }

}
