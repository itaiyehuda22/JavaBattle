package edu.starter;

import java.util.Scanner;


/** Creates the player and starts a battle encounter. */

public final class Main {
    /**
     * @pre System.in is open and supplies a player name and subsequent game choices.
     *      Command-line arguments are unused and may be null.
     * @post On normal return, the game has ended after losing the first battle,
     *       or after choosing a reward and completing the second battle.
     */
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Player's name: ");
        String inpName = input.nextLine();
        Character player = new Character(inpName, 100, 5, 10,100, false, 10);

        Character enemy1 = new Character("enemy1", 30, 0, 0, 30, false, 10);
        System.out.println("FIRST BATTLE");
        boolean firstWin = Encounter.newEncouter(player, enemy1);
        if (!firstWin){
            return;
        }
        Reward.ChooseReward(player);
        System.out.println("SECOND BATTLE");
        Character enemy2 = new Character("enemy2", 45, 0, 0, 45, false, 10);

        Encounter.newEncouter(player, enemy2);


    }
}
