package fr.estiam.jeupokemon.models;

import java.util.ArrayList;
import java.util.Scanner;

public class Player {
    public Scanner sc = new Scanner(System.in);

    private String name;
    private int roundWon = 0;
    private int money = 2300;
    private ArrayList<Pokemon> pokemons = new ArrayList<>();
    public void addPokemon(ArrayList<Pokemon> pokemons, Pokemon pokemon){
        pokemons.add(pokemon);
    }

    public String getName() {
        return name;
    }
    public void setName(String s) {
        this.name = s;
    }
    public int getRoundWon() {
        return roundWon;
    }
    public int roundWin(){
        return roundWon ++;
    }
    public int getMoney(){
        return money;
    }
    private ArrayList<Pokemon> chooseList = new ArrayList<>();
    
    
    public void choosePokemon(){
        Pokemon pokemon1 = new Pokemon("Luxray", 364, 372, 282, 317, 282, 262,100, "ELECTRIQUE", "", 500);
        pokemon1.addAtk(new Attack("Coup d'jus", "ELECTRIQUE", "Spécial", 1, 80, 15));
        pokemon1.addAtk(new Attack("Mâchouille", "TENEBRES", "Physique", 1, 80, 15));
        pokemon1.addAtk(new Attack("Crocs éclair", "ELECTRIQUE", "Physique", 0.95, 65, 15));
        pokemon1.addAtk(new Attack("Poing éclair", "ELECTRIQUE", "Physique", 1, 75, 15));
        Pokemon pokemon2 = new Pokemon("Rayquaza", 414,438, 306, 438, 306, 317, 100, "DRAGON", "VOL", 900);
        pokemon2.addAtk(new Attack("Ultralaser", "NORMAL", "Spécial", 0.9, 150, 5));
        pokemon2.addAtk(new Attack("Colère", "DRAGON", "Physique", 1, 120, 10));
        pokemon2.addAtk(new Attack("Dracochoc", "DRAGON", "Physique", 1, 85, 10));
        pokemon2.addAtk(new Attack("Mâchouille", "TENEBRES", "Physique", 1, 80, 15));
        Pokemon pokemon3 = new Pokemon("Torterra", 394, 348, 339, 273, 295, 232, 100, "PLANTE", "SOL", 500);
        pokemon3.addAtk(new Attack("Tempête Verte", "PLANTE", "Spécial", 0.9, 130, 5));
        pokemon3.addAtk(new Attack("Giga-Sangsue", "PLANTE", "Spécial", 1, 75, 10));
        pokemon3.addAtk(new Attack("Séisme", "SOL", "Physique", 1, 100, 10));
        pokemon3.addAtk(new Attack("Tranch'Herbe", "PLANTE", "Physique", 0.95, 55, 25));
        Pokemon pokemon4 = new Pokemon("Kyogre", 404, 328, 306, 438, 416, 306, 100, "EAU", "", 900);
        pokemon4.addAtk(new Attack("Gicledo", "EAU", "Physique", 1, 150, 5));
        pokemon4.addAtk(new Attack("Hydrocanon", "EAU", "Spécial", 0.8, 110, 5));
        pokemon4.addAtk(new Attack("Laser Glace", "GLACE", "Spécial", 1, 90, 10));
        pokemon4.addAtk(new Attack("Plaquage", "NORMAL", "Physique", 1, 85, 15));
        Pokemon pokemon5 = new Pokemon("Sulfura", 384, 328, 306, 383, 295, 306, 100, "FEU", "VOL", 900);
        pokemon5.addAtk(new Attack("Vent Violent", "VOL", "Spécial", 0.7, 110, 10));
        pokemon5.addAtk(new Attack("Lance-Flamme", "FEU", "Spécial", 1, 90, 15));
        pokemon5.addAtk(new Attack("Lame d'Air", "VOL", "Spécial", 0.95, 75, 15));
        pokemon5.addAtk(new Attack("Canicule", "FEU", "Spécial", 0.9, 95, 10));
        Pokemon pokemon6 = new Pokemon("Lucario", 344, 350, 262, 361, 262, 306, 100, "COMBAT", "Acier", 500);
        pokemon6.addAtk(new Attack("Close Combat", "COMBAT", "Physique", 1,120, 5));
        pokemon6.addAtk(new Attack("Vitesse Extrême", "NORMAL", "Physique", 1, 80, 5));
        pokemon6.addAtk(new Attack("Aura Sphère", "COMBAT", "Physique", 1, 80, 20));
        pokemon6.addAtk(new Attack("Dracochoc", "DRAGON", "Physique", 1, 85, 10));
        chooseList.add(pokemon1);
        chooseList.add(pokemon2);
        chooseList.add(pokemon3);
        chooseList.add(pokemon4);
        chooseList.add(pokemon5);
        chooseList.add(pokemon6);
        for (int i= 0 ; i<3 ; i++){ 
            displayPokemons(chooseList);
            System.out.print("Choisissez un Pokémon en entrant le numéro correspondant : ");
            int choice = Integer.parseInt(sc.nextLine());
            if (choice >= 1 && choice <= chooseList.size()){
                if (money>= chooseList.get(choice-1).getPrice()) {
                    Pokemon pokemon = chooseList.get(choice - 1);
                    pokemons.add(pokemon);
                    chooseList.remove(pokemon);
                    money -= pokemon.getPrice();
                    System.out.println("Il vous reste " + getMoney() +'$');
                    System.out.println();
                } else {
                    System.out.println();
                    System.out.println("Vous n'avez pas assez d'argent pour acheter ce Pokémon.");
                    System.out.println();
                    i--;
                }
            } else {
                System.out.println("\nNuméro de pokémon invalide. Veuillez choisir un numéro de pokémon valide\n");
                i--;
            }

        }
    }
    public void displayPokemons(ArrayList<Pokemon> liste){
        for (int i = 0; i < liste.size(); i++) {
            Pokemon pokemon = liste.get(i);
            if (pokemon.getType2().isEmpty()){
                System.out.println((i + 1) + ") " + pokemon.getName() +", Type " + pokemon.getType1() + ", niveau " + pokemon.getLevel() + ", coût " + pokemon.getPrice() + " $");
            } else {
                System.out.println((i + 1) + ") " + pokemon.getName() + ", Types " + pokemon.getType1() + ", " + pokemon.getType2() + ", niveau " + pokemon.getLevel() + ", coût " + pokemon.getPrice() + " $");
            }
        }
        
    }
    public void displayPlayer(Player player) {
        System.out.println(player.getName() + player.getRoundWon() + player.getMoney());
    }

    public Attack chooseAttack(Pokemon pokemon) {
        while (true) {
            System.out.println("Au tour de " + getName());
            pokemon.displayAttacks();
            System.out.print("Choisissez votre attaque pour " + pokemon.getName() + " : ");
            int choice = Integer.parseInt(sc.nextLine());
            System.out.println();
            if (choice >= 1 && choice <= pokemon.getAttacks().size()) {
                Attack att = pokemon.getAttacks().get(choice - 1);
                if (att.getPp() > 0) {
                    return att;
                } else {
                    System.out.println("Cette attaque n'est plus utilisable veuillez utiliser une autre attaque. ");
                }
            } else {
                System.out.println("Choix invalide. Veuillez choisir un numéro d'attaque valide.");
            }
        }
    }

    public void displayPokemons() {
        for (Pokemon pokemon : pokemons) {
            if (pokemon.getType2().isEmpty()) {
                System.out.println(pokemon.getName() + ", type " + pokemon.getType1() + ", niveau " + pokemon.getLevel());
            } else {
                System.out.println(pokemon.getName() + ", types " + pokemon.getType1() + " et " + pokemon.getType2() + ", niveau " + pokemon.getLevel());
                
            }
        }
    }

    public Pokemon getPokemon(int numero) {
        return pokemons.get(numero);
    }
    
    public void attack(Pokemon atk, Pokemon def, Attack chosenAttack) {
        System.out.println(atk.getName() + " attaque " + chosenAttack.getName() + " !");
        int damage = chosenAttack.calculateAtk(atk, def);
        def.getDammaged(damage);
        chosenAttack.setPp(chosenAttack.getPp()-1);
        System.out.println(def.getName() + " perd " + damage + " PV.");
        System.out.println("PV de " + def.getName() + " : " + def.getHp());
    }


}
