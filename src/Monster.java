import java.util.HashMap;

public abstract class Monster {

    protected static String name;
    protected String monsterType;
    private static int monsterCount;

    public Monster(){
        this.name = "Trogdor";
    }

    public Monster(String name) {
        this.name = name;
        addMonster();
    }

    public static String getName() {
        return name;
    }
    public static void setMonsterCount(int monsterCount) {
        Monster.monsterCount = monsterCount;
    }
    public String getMonsterType() {
        return monsterType;
    }

    public static void addMonster(HashMap<Integer,Monster> monsters, CookieMonster blue_guy) {
        monsters.put( monsters.size()+1,blue_guy );
    }

    public static String getMonsterCount() {
        return String.valueOf( monsterCount+1);
    }

    public abstract String eat(String cookie);

    private void addMonster(){
        monsterCount += 1;
    }

}
