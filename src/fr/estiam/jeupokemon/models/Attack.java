package fr.estiam.jeupokemon.models;

import java.util.ArrayList;

public class Attack {
    private String name;
    public String getName() {
        return name;
    }

    private String type;
    public String getType() {
        return type;
    }

    private String catAtk;

    private double precision;

    private int power;
    private int pp;
    public int getPp() {
        return pp;
    }
    
    public void setPp(int pp) {
        this.pp = pp;
    }
    
    public void displayAttack() {
        System.out.println(this.name + ", " + this.type + ", " + this.catAtk + ", précision : " + this.precision + ", puissance : " + this.power + ", PP : " + this.pp);
    }
    public Attack(String name, String type, String catAtk, double precision, int power, int pp) {
        this.name = name;
        this.type = type;
        this.catAtk = catAtk;
        this.precision = precision;
        this.power = power;
        this.pp = pp;
    }

    public int calculateAtk(Pokemon atk, Pokemon def) {
        int defense = def.getDef();
        int attack = atk.getAtk();
        int level = atk.getLevel();
        double stab = 1;
        double damage;
        String typeAtk1 = atk.getType1();
        String typeAtk2 = atk.getType2();
        
        double multiplier = multiplier(this.type, def);
        if (multiplier == 0){
            System.out.println("Ca n'a aucun effet...");
        } else if (multiplier == 2) {
            System.out.println("C'est très efficace !");
        } else if (multiplier == 4) {
            System.out.println("C'est super efficace !! ");
        } else if (multiplier == 0.5) {
            System.out.println("C'est peu efficace...");
        } else if (multiplier == 0.25) {
            System.out.println("Ce n'est pas très efficace...");
        }
        
        if (this.catAtk.equals("Spécial")) {
            defense = def.getDefSpe();
            attack = atk.getAtkSpe();
        }
        if (this.type.equals(typeAtk1) || this.type.equals(typeAtk2)) {
            stab = 1.5;
        }
        damage = (((level * 0.4 + 2) * attack * this.power) / (defense * 50) + 2) * stab * this.precision * multiplier;
        return (int) damage;
    }
    public boolean ppIsEmpty(){
        if (pp ==0) {
            return true;
        }
        else {
            return false;
        }
    }
    public double multiplier(String s, Pokemon def){
        double multiplier = 1;
        ArrayList<String> strongAgainst = new ArrayList<>();
        ArrayList<String> noEffectAgainst = new ArrayList<>();
        ArrayList<String> weakAgainst = new ArrayList<>();
        
        
        switch (s) {
            case "NORMAL" -> {
                noEffectAgainst.add("SPECTRE");
                weakAgainst.add("ROCHE");
                weakAgainst.add("ACIER");
            }
            case "FEU" -> {
                strongAgainst.add("PLANTE");
                strongAgainst.add("GLACE");
                strongAgainst.add("INSECTE");
                strongAgainst.add("ACIER");
                weakAgainst.add("FEU");
                weakAgainst.add("EAU");
                weakAgainst.add("ROCHE");
                weakAgainst.add("DRAGON");
            }
            case "EAU" -> {
                strongAgainst.add("FEU");
                strongAgainst.add("SOL");
                strongAgainst.add("ROCHE");
                weakAgainst.add("EAU");
                weakAgainst.add("PLANTE");
                weakAgainst.add("DRAGON");
            }
            case "PLANTE" -> {
                strongAgainst.add("EAU");
                strongAgainst.add("SOL");
                strongAgainst.add("ROCHE");
                weakAgainst.add("FEU");
                weakAgainst.add("PLANTE");
                weakAgainst.add("POISON");
                weakAgainst.add("VOL");
                weakAgainst.add("INSECTE");
                weakAgainst.add("DRAGON");
                weakAgainst.add("ACIER");
            }
            case "ELECTRIQUE" -> {
                noEffectAgainst.add("SOL");
                strongAgainst.add("EAU");
                strongAgainst.add("VOL");
                weakAgainst.add("PLANTE");
                weakAgainst.add("ELECTRIQUE");
                weakAgainst.add("DRAGON");
            }
            case "GLACE" -> {
                strongAgainst.add("PLANTE");
                strongAgainst.add("SOL");
                strongAgainst.add("VOL");
                strongAgainst.add("DRAGON");
                weakAgainst.add("FEU");
                weakAgainst.add("EAU");
                weakAgainst.add("GLACE");
                weakAgainst.add("ACIER");
            }
            case "COMBAT" -> {
                noEffectAgainst.add("SPECTRE");
                strongAgainst.add("NORMAL");
                strongAgainst.add("GLACE");
                strongAgainst.add("ROCHE");
                strongAgainst.add("TENEBRES");
                strongAgainst.add("ACIER");
                weakAgainst.add("POISON");
                weakAgainst.add("SOL");
                weakAgainst.add("VOL");
                weakAgainst.add("PSY");
                weakAgainst.add("INSECTE");
            }
            case "POISON" -> {
                noEffectAgainst.add("ACIER");
                strongAgainst.add("PLANTE");
                weakAgainst.add("POISON");
                weakAgainst.add("SOL");
                weakAgainst.add("ROCHE");
                weakAgainst.add("FEU");
                weakAgainst.add("SPECTRE");
            }
            case "SOL" -> {
                noEffectAgainst.add("VOL");
                strongAgainst.add("FEU");
                strongAgainst.add("ELECTRIQUE");
                strongAgainst.add("POISON");
                strongAgainst.add("ROCHE");
                strongAgainst.add("ACIER");
                weakAgainst.add("PLANTE");
                weakAgainst.add("INSECTE");
            }
            case "VOL" -> {
                strongAgainst.add("PLANTE");
                strongAgainst.add("COMBAT");
                strongAgainst.add("INSECTE");
                weakAgainst.add("ELECTRIQUE");
                weakAgainst.add("ROCHE");
                weakAgainst.add("ACIER");
            }
            case "PSY" -> {
                noEffectAgainst.add("TENEBRES");
                strongAgainst.add("COMBAT");
                strongAgainst.add("POISON");
                weakAgainst.add("PSY");
                weakAgainst.add("ACIER");
            }
            case "INSECTE" -> {
                strongAgainst.add("PLANTE");
                strongAgainst.add("PSY");
                strongAgainst.add("TENEBRES");
                weakAgainst.add("FEU");
                weakAgainst.add("COMBAT");
                weakAgainst.add("POISON");
                weakAgainst.add("VOL");
                weakAgainst.add("SPECTRE");
                weakAgainst.add("ACIER");
            }
            case "ROCHE" -> {
                strongAgainst.add("FEU");
                strongAgainst.add("GLACE");
                strongAgainst.add("VOL");
                strongAgainst.add("INSECTE");
                weakAgainst.add("COMBAT");
                weakAgainst.add("SOL");
                weakAgainst.add("ACIER");
            }
            case "SPECTRE" -> {
                noEffectAgainst.add("NORMAL");
                strongAgainst.add("PSY");
                strongAgainst.add("SPECTRE");
                weakAgainst.add("TENEBRES");
                weakAgainst.add("ACIER");
            }
            case "DRAGON" -> {
                strongAgainst.add("DRAGON");
                weakAgainst.add("ACIER");
            }
            case "TENEBRES" -> {
                strongAgainst.add("PSY");
                strongAgainst.add("SPECTRE");
                weakAgainst.add("COMBAT");
                weakAgainst.add("TENEBRES");
                weakAgainst.add("ACIER");
            }
            case "ACIER" -> {
                strongAgainst.add("GLACE");
                strongAgainst.add("ROCHE");
                weakAgainst.add("FEU");
                weakAgainst.add("EAU");
                weakAgainst.add("ACIER");
            }
        }
        if (weakAgainst.contains(def.getType1()) ){
            multiplier = multiplier / 2;
        } else if (noEffectAgainst.contains(def.getType1())){
            multiplier = multiplier * 0;
        }else if (strongAgainst.contains(def.getType1()) ){
            multiplier = multiplier * 2;
        }
        
        if (weakAgainst.contains(def.getType2()) ){
            multiplier = multiplier / 2;
        } else if (noEffectAgainst.contains(def.getType2())){
            multiplier = multiplier * 0;
        }else if (strongAgainst.contains(def.getType2())){
            multiplier = multiplier * 2;
        }
        
        return multiplier;
    }
}
