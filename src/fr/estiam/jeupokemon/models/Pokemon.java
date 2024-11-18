package fr.estiam.jeupokemon.models;

import java.util.ArrayList;

public class Pokemon {
    
    private String name;
    
    public String getName() {
        return name;
    }
    
    private int hp;
    
    public int getHp() {
        return hp;
    }
    
    public void setHp(int hp) {
        this.hp = hp;
        if (this.hp < 0) {
            this.hp = 0;
        }
    }
    
    private int atk;
    
    public int getAtk() {
        return atk;
    }
    
    private int def;
    
    public int getDef() {
        return def;
    }
    
    private int atkSpe;
    
    public int getAtkSpe() {
        return atkSpe;
    }
    
    private int defSpe;
    
    public int getDefSpe() {
        return defSpe;
    }
    
    private int speed;
    
    public int getSpeed() {
        return speed;
    }
    
    private int level;
    
    public int getLevel() {
        return level;
    }
    
    private String type1;
    private String type2;
    
    public String getType1() {
        return type1;
    }
    
    public String getType2() {
        return type2;
    }
    
    
    private int price;
    
    public int getPrice() {
        return price;
    }
    
    private ArrayList<Attack> attacks = new ArrayList<>();
    
    public ArrayList<Attack> getAttacks() {
        return attacks;
    }
    
    public void displayAttacks() {
        for (int i = 0; i < attacks.size(); i++) {
            Attack attack = attacks.get(i);
            System.out.println((i + 1) + ") " + attack.getName() + ", Type : " + attack.getType() + ", PP : " + attack.getPp());
        }
    }
    
    public boolean isKo() {
        if (hp <= 0) {
            return true;
        } else {
            return false;
        }
    }
    
    public void display(Pokemon pokemon) {
        System.out.println(getName() + getLevel() + getType1() + getType2() + getHp());
    }
    
    public void addAtk(Attack atk) {
        attacks.add(atk);
    }
    
    public Pokemon(String name, int hp, int atk, int def, int atkSpe, int defSpe, int speed, int level, String type1, String type2, int price) {
        this.name = name;
        this.hp = hp;
        this.atk = atk;
        this.def = def;
        this.atkSpe = atkSpe;
        this.defSpe = defSpe;
        this.speed = speed;
        this.level = level;
        this.type1 = type1;
        this.type2 = type2;
        this.price = price;
    }
    
    
    public int getDammaged(int dammage) {
        setHp(hp - dammage);
        return hp;
    }
}