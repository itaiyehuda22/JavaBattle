package edu.starter;

import java.util.Scanner;

import javax.print.DocFlavor.STRING;

import edu.starter.Main;

/** Student-owned game entry point; replace this message with your own implementation. */

public final class Main {


    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Player's name: ");
        String inpName = input.nextLine();
        Character player = createCharectar(inpName, 100, 5, 10);
        Character enemy = createCharectar("Enemy", 30, 0, 0);

        String battleOutcome = "";
        while (player.HP > 0 && enemy.HP > 0){
            boolean enemyKnocked = player.Action(enemy, 0);
            if (enemyKnocked){
                battleOutcome = "You have won the battle with " + player.HP + " health and " + player.resources + " resources left congrats!";
                break;
            }else{
                boolean PlayerKnocked = enemy.Action(player, 1);
                if (PlayerKnocked) {
                    battleOutcome = "You have lost the battle game over!";
                }
            }
        }
        System.out.println(battleOutcome);


    }
    
    static Character createCharectar(String name, int startingHP, int resources, int MaxResources){
        Character character = new Character();
        character.name = name;
        character.HP = startingHP;
        character.startingHP = startingHP;
        character.resources = resources;
        character.MaxResources = MaxResources;
        return character;
    }

}




class Character{
    int HP = 100;
    int startingHP = 100;
    int resources = 5;
    boolean defended = false;
    String name = "";
    int MaxResources = 10;

    public boolean Attack(Character character, int damage){
        if (!character.defended){
            character.HP -= damage;
            return true;
        }else{
            character.HP -= damage/2;
            return false;
        }


    }

    public void Defend() {
        this.defended = true;
    }

    public boolean Special(Character character, int ResourceCost, int damage){

    
        this.resources -= ResourceCost;
        return Attack(character, damage);
        
    }

    public void Recover(int resources){
        this.resources = Math.min(this.resources + resources, this.MaxResources);
        
    }



    public boolean Action( Character enemy, int action){

        boolean inputValid = false;
        String input;
        while(!inputValid){
            if( action >= 1 && action <= 4){
                input = Integer.toString(action);
            } else{
                System.out.println("HP: " + this.HP + " Resources: " + this.resources + " Enemey HP: " + enemy.HP);
                System.out.println("Choose your action:");
                System.out.println("1) Attack");
                System.out.println("2) Defend");
                System.out.println("3) Special");
                System.out.println("4) Recover resources");
                Scanner scanner = new Scanner(System.in);
                input = scanner.nextLine();
            }
            switch (input){

                case "1":
                    boolean AttackSucceded = this.Attack(enemy, 10);
                    if (AttackSucceded){
                        System.out.println(this.name + " attacked " + enemy.name + ". " + enemy.name + "'s HP: " + enemy.HP);

                    } else {System.out.println(enemy.name + " defended " + this.name + "'s attack reducing half the damage.");}
                    inputValid = true;
                    break;
                
                case "2":
                    System.out.println(this.name + " is defending the next attack.");
                    this.defended = true;
                    inputValid = true;
                    break;
                
                case "3":
                    if (this.resources >= 3){
                        boolean SpecialSucceded = this.Special(enemy,3, 15);
                        if (SpecialSucceded){
                            System.out.println(this.name + " used a special attack on " + enemy.name + ". " + enemy.name + "'s HP: " + enemy.HP);
                            inputValid = true;
                        } else {System.out.println(enemy.name + " blocked " + this.name + "'s special attack."); inputValid = true;}
                    } else{
                        System.out.println(this.name + " does not have enough resources for a special attack.");
                    }
                    break;

                
                case "4":
                    this.Recover(3);
                    System.out.println("OrangeDragon recover'd resources");
                    inputValid = true;
                    break;
                default:
                    System.out.println("Invalid action must be a number 1 - 4");
                }

        }
        enemy.defended = false;
        boolean knocked = enemy.HP <= 0;
        return knocked;

    }
}
