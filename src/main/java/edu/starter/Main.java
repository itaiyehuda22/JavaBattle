package edu.starter;

import java.util.Scanner;


/** Creates the player and starts a battle encounter. */

public final class Main {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Player's name: ");
        String inpName = input.nextLine();
        Character player = new Character(inpName, 100, 5, 10, false);
        Character enemy1 = new Character("enemy1", 30, 0, 0, false);
        System.out.println("FIRST BATTLE");
        boolean firstWin = Encounter.newEncouter(player, enemy1);
        if (!firstWin){
            return;
        }
        System.out.println("SECOND BATTLE");
        Character enemy2 = new Character("enemy2", 45, 0, 0, false);

        Encounter.newEncouter(player, enemy2);


    }
}
