package fr.estiam.jeupokemon.models;

import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    public Scanner sc = new Scanner(System.in);
    ArrayList<Player> players = new ArrayList<>();
    int round = 1;
    
    Player player1 = new Player();
    Player player2 = new Player();
    Attack attack1;
    Attack attack2;
    public void start() {
        System.out.print("Quel est le nom du joueur 1 ? ");
        player1.setName(sc.nextLine());
        System.out.print("Quel est le nom du joueur 2 ? ");
        player2.setName(sc.nextLine());
        players.add(player1);
        players.add(player2);
        System.out.println("\n" + player1.getName() + " choisit ses Pokémons");
        player1.choosePokemon();
        System.out.println(player2.getName() + " choisit ses Pokémons\n");
        player2.choosePokemon();
        System.out.println("Pokémons de " + player1.getName());
        player1.displayPokemons();
        System.out.println();
        System.out.println("Pokémons de " + player2.getName());
        player2.displayPokemons();
        
        while (player1.getRoundWon() != 2 && player2.getRoundWon() != 2) {
            Pokemon p1 = player1.getPokemon(round - 1);
            Pokemon p2 = player2.getPokemon(round - 1);
            System.out.println();
            System.out.println("------Debut du round " + round + "------");
            while (!p1.isKo() && !p2.isKo()) {
                System.out.printf(" ----" + p1.getName() + " vs " + p2.getName() + "----\n");
                if (p1.isKo() || p2.isKo()) {
                    break;
                }
                System.out.println();
                attack1 = player1.chooseAttack(p1);
                System.out.println();
                attack2 = player2.chooseAttack(p2);
                if (p1.getSpeed() >= p2.getSpeed() && !p1.isKo() && !p2.isKo()) {
                    player1.attack(p1, p2, attack1);
                    System.out.println();
                    if (!p2.isKo()) {
                        player2.attack(p2, p1, attack2);
                    } else {
                        break;
                    }
                } else {
                    player2.attack(p2, p1, attack2);
                    System.out.println();
                    if (!p1.isKo()) {
                        player1.attack(p1, p2, attack1);
                    } else {
                        break;
                    }
                }
                
            }
            if (p1.isKo()) {
                System.out.println(p1.getName() + " de " + player1.getName() + " n'est plus capable de se battre. " + player2.getName() + " remporte le round !");
                round++;
                player2.roundWin();
            } else if (p2.isKo()) {
                System.out.println(p2.getName() + " de " + player2.getName() + " n'est plus capable de se battre. " + player1.getName() + " remporte le round !");
                round++;
                player1.roundWin();
            }
        }
        System.out.println("\n/!\\------FIN DU MATCH------/!\\\n");
        if (player2.getRoundWon() == 2) {
            System.out.println(player2.getName() + " remporte le match par " + player1.getRoundWon() + '-' + player2.getRoundWon() + '!');
        } else {
            System.out.println(player1.getName() + " remporte le match par " + player1.getRoundWon() + '-' + player2.getRoundWon() + '!');
        }
    }
}

