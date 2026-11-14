package edu.starter;

import java.util.Scanner;

public class Encounter {
    /**
     * @pre Both characters HP > 0; player != null && enemy != null && player != enemy.
     * @post player.HP == 0 || enemy.HP == 0
    **/
    static boolean newEncouter(Character player, Character enemy) {

        boolean playerKnocked = false;
        boolean enemyKnocked = false;
        while (!playerKnocked && !enemyKnocked) {
            enemyKnocked = player.Action(enemy, 0);
            if (enemyKnocked) {
                break;
            } else {
                playerKnocked = enemy.Action(player, 1);
            }
        }

        if (enemyKnocked) {
            System.out.println("You have won the battle with " + player.getHP() + " HP and " + player.getResources() + " resources left");
            return true;
        } else {
            System.out.println("You have lost the battle");
            return false;
        }
    }


}
