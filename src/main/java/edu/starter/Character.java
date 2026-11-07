package edu.starter;

import java.util.Scanner;

public class Character{
    private int HP;
    private int resources;
    private boolean defended;
    private String name;
    private int MaxResources;
    
    public Character(String name, int HP, int resources, int MaxResources, boolean defended){
        this.name = name;
        this.HP = HP;
        this.resources = resources;
        this.MaxResources = MaxResources;
        this.defended = defended;
    }

    public int getHP(){
        return HP;
    }

    public int getResources(){
        return resources;
    }

    public boolean takeDamage(int damage){
        if (defended){
            this.HP = Math.max(this.HP - damage / 2, 0);
            return false;
        } else{
            this.HP = Math.max(this.HP - damage, 0);
            return true;
            
        }

    }
    public boolean Attack(Character character, int damage){
        if(character.takeDamage(damage)){
            System.out.println(this.name + " attacked " + character.name + ". " + character.name + "'s HP: " + character.HP);
            return true;
        }else{
            System.out.println(character.name + " defended " + this.name + "'s attack reducing half the damage.");
            return false;
        }
        
        
    }
    
    

    public void Defend() {
        System.out.println(this.name + " is defending the next attack.");
        this.defended = true;
    }

    public boolean Special(Character character, int ResourceCost, int damage){
        if (this.resources >= ResourceCost){
            this.resources -= ResourceCost;
            if(character.takeDamage(damage)){
                System.out.println(this.name + " used a special attack on " + character.name + ". " + character.name + "'s HP: " + character.HP);
            } else{
                System.out.println(character.name + " blocked " + this.name + "'s special attack.");
            }
            return true;
        }else{
            System.out.println(this.name + " does not have enough resources for a special attack.");
            return false;
        }
        
        
    }

    public boolean Recover(int resources){
        if (this.resources == MaxResources){
            System.out.println(this.name + " already have the maximum of " + MaxResources + " resources.");
            return false;
        }else{
            if(this.resources + resources >= MaxResources){
                this.resources = Math.min(this.resources + resources, this.MaxResources);
                System.out.println(this.name + " recovere'd resources to the maximum of " + MaxResources);
            } else{
                this.resources = Math.min(this.resources + resources, this.MaxResources);
                System.out.println(this.name + " recover'd resources");
            }
            return true;
        }

        
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
                    this.Attack(enemy, 10);
                    inputValid = true;
                    break;
                
                case "2":
                    this.Defend();
                    inputValid = true;
                    break;
                
                case "3":
                    inputValid = this.Special(enemy, 3, 15);
                    break;

                
                case "4":
                    inputValid = this.Recover(3);
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
