package ExtraCreditMidterm;

import java.util.HashMap;

public abstract class Monster {

    protected String name;
    protected String monsterType;
    private static int monsterCount;

    public Monster(){
        this("Trogdor");
    }

    public Monster(String name) {
        this.name = name;
        addMonster();
    }

    public String getName() {
        return name;
    }

    public static void setMonsterCount(int monsterCount) {
        Monster.monsterCount = monsterCount;
    }

    public String getMonsterType() {
        return monsterType;
    }
    public void setMonsterType(String monsterType) {
        this.monsterType = monsterType;
    }

    public static void addMonster(HashMap<Integer, Monster> monsters, Monster m) {
        monsters.put(monsterCount + 1, m );
    }

    public static int getMonsterCount() {
        return monsterCount;
    }

    public abstract String eat(String cookie);

    private void addMonster(){
        setMonsterCount(getMonsterCount() + 1);
    }

}
