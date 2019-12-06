package view;

import model.*;

import java.util.Scanner;

public class View {
	
    private Scanner scanner = new Scanner(System.in);
    private String []type = Type.type;

    public int getInt() {
        return scanner.nextInt();
    }

    public String getString() {
        return scanner.next();
    }

    public void displayStart() {
        System.out.println("^.^ **** Welcome to YAHTZEE **** ^.^");
        System.out.println("1. New game");
        System.out.println("2. Load game");
    }

    public void displayPlay() {
        System.out.println("----------------------------");
        System.out.println("1. Roll");
        System.out.println("2. Show compact list");
        System.out.println("3. Show full list");
        System.out.println("0. Exit");
    }

    public void displayDiceNumber(Player player) {
        System.out.print("Current Dice: ");
        for(Dice dice: player.getDiceList())
            System.out.print(dice.getValue() + " ");
        System.out.println();
    }

    public void displayRoll(Game game) {
        System.out.println("type 'r' to roll");
        if(getString().toLowerCase().equals("r")) {
            game.start();
            displayDiceNumber(game.getPlayer());
            System.out.println("Input 'y' to roll again, or input 'n' to stop");
            if (getString().toLowerCase().equals("y")) {
                game.start();
                displayDiceNumber(game.getPlayer());
                System.out.print("Input 'y' to roll again, or input 'n' to stop (The last chance)");
                if (getString().toLowerCase().equals("y")) {
                    game.start();
                    displayDiceNumber(game.getPlayer());
                    displayChooseType(game);
                } else {
                    displayChooseType(game);
                }
            } else{
                displayChooseType(game);
            }
        }
    }

    public void displayChooseType(Game game) {
        for(int i =0; i < Type.type.length; i++ )
            System.out.print(i+1 + ": " + type[i] + " ");
        System.out.println("");
        System.out.print("Please choose a type: ");
        game.chooseType(getInt());
    }

    public void displayFullScore(Player player) {
        System.out.println(player.getTime() + "\n" + player.getName());
        int i = 0;
        for(int n : player.getScores()) {
            System.out.println(type[i] + ": " + n);
            i++;
        }
        System.out.println("Upper Bonus: " + player.getUpperBonus());
        System.out.println("Total Score: " + player.getTotalScore());
        System.out.println("");
    }

    public void displayFullScoreComputer(Iterable<Computer> computers) {
        for(Computer computer : computers) {
            System.out.println(computer.getName());
            int i = 0;
            for(int n : computer.getScores()) {
                System.out.println(type[i] + ": " + n);
                i++;
            }
            System.out.println("Upper Bonus: " + computer.getUpperBonus());
            System.out.println("Total Score: " + computer.getTotalScore() + "\n");
        }
    }

    public void displayCompactList(Player player, Iterable<Computer> computerPlayers) {
        System.out.println("Time: " + player.getTime());
        System.out.println("Name: " + player.getName() + " " + "Total Score: " + player.getTotalScore());
        for(Computer computerPlayer: computerPlayers)
            System.out.println(computerPlayer.getName() + " " + "Total Score: " + computerPlayer.getTotalScore());
    }
    
    public void displayInputName() {
        System.out.println("Please input name: ");
    }

    public void displaySelectNumber() {
        System.out.println("Please select number of players");
    }

}
