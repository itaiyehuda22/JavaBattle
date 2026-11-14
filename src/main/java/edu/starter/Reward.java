package edu.starter;

import java.util.Scanner;

public enum Reward {
    HEAL, UPGRADE_ATTACK;

    /**
     * @pre character has valid fields
     * @post Either HP increases by up to 25, capped at MaxHP or attackDamage increases by 2.
     */
    static void ChooseReward(Character character){
        System.out.println("Choose your reward for winning the battle");
        Scanner scanner = new Scanner(System.in);
        System.out.println("1) Recover 25 HP to the maximum of " + character.getMaxHP());
        System.err.println("2) Upgrade attack damage by 2");
        
        boolean inputValid = false;

        while (!inputValid){
            String input = scanner.nextLine();
            Reward selectedReward = switch(input){
                case "1" -> Reward.HEAL;
                case "2" -> Reward.UPGRADE_ATTACK;
                default -> null;
            };

            if (selectedReward == null){
                System.out.println("Invalid option please choose again:");

            } else{
                inputValid = true;
                switch (selectedReward) {
                    case HEAL:
                        character.restoreHP(25);
                        break;
                    case UPGRADE_ATTACK:
                        character.ChangeAttackDamage(character.getAttackDamage() + 2);
                        break;
                    
                    default:
                        break;
                }
            }
            
            
        }

    }

}
