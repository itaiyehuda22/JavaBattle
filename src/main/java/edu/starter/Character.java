package edu.starter;

import java.util.Scanner;

/**
 * A battle character. Contracts assume a character created with valid constructor inputs.
 * In postconditions, old(x) means x before the call and result means the return value.
 * Postconditions describe normal completion; fields not mentioned remain unchanged.
 */
public class Character{
    private int HP;
    private int resources;
    private boolean defended;
    private String name;
    private int MaxResources;
    private  int attackDamage;
    private int MaxHP;
    
    /**
     * @pre name != null; MaxHP > 0; 0 <= HP <= MaxHP;
     *      MaxResources >= 0; 0 <= resources <= MaxResources; attackDamage > 0.
     * @post Each varibale equals to it's constructor argument.
     */
    public Character(String name, int HP, int resources, int MaxResources, int MaxHP, boolean defended, int attackDamage){
        this.name = name;
        this.HP = HP;
        this.MaxHP = MaxHP;
        this.resources = resources;
        this.MaxResources = MaxResources;
        this.defended = defended;
        this.attackDamage = attackDamage;
    }


    public int getHP(){
        return HP;
    }

    public int getMaxHP() {
        return MaxHP;
    }


    public int getAttackDamage() {
        return attackDamage;
    }

    public int getMaxResources() {
        return MaxResources;
    }

    public String getName() {
        return name;
    }


    public int getResources(){
        return resources;
    }

    /**
     * @pre damage > 0.
     * @post HP >= 0
     */
    boolean takeDamage(int damage){
        if (this.defended){
            this.HP = Math.max(this.HP - damage / 2, 0);
            return false;
        } else{
            this.HP = Math.max(this.HP - damage, 0);
            return true;
            
        }

    }

    /**
     * @pre health > 0; HP + health must not overflow an int.
     * @post HP <= MaxHP.
     */
    void restoreHP(int health){
        this.HP = Math.min(this.HP + health, MaxHP);
        System.out.println(this.name + " Restored " + health + " HP");
    }

    /**
     * @pre character != null; damage > 0; character has valid states;
     * @post character.HP >= 0.
     */
    boolean Attack(Character character, int damage){
        if(character.takeDamage(damage)){
            System.out.println(this.name + " attacked " + character.name + ". " + character.name + "'s HP: " + character.HP);
            return true;
        }else{
            System.out.println(character.name + " defended " + this.name + "'s attack reducing half the damage.");
            return false;
        }
        
        
    }

    /**
     * @pre newDamage > 0.
     * @post attackDamage == newDamage.
     */
    void ChangeAttackDamage(int newDamage){
        this.attackDamage = newDamage;
        System.out.println("Changed " + this.name + " attack's damage to " + newDamage);
    }
    
    /**
     * @post defended == false.
     */
    void removeDefence(){
        this.defended = false;
    }

    /**
     * @post defended == true.
     */
    void Defend() {
        System.out.println(this.name + " is defending the next attack.");
        this.defended = true;
    }

    /**
     * @pre character != null; character has valid states; damage > 0; ResourceCost > 0.
     * @post resources >= 0 && character.HP >= 0
     */
    boolean Special(Character character, int ResourceCost, int damage){
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

    /**
     * @pre resources > 0; this.resources + resources must not overflow an int.
     * @post this.resources == min(old(this.resources) + resources, MaxResources).
     * @post result == (old(this.resources) < MaxResources).
     */
    boolean Recover(int resources){
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



    /**
     * @pre enemy != null; enemy != this; both characters have valid fields and HP > 0.
     * @pre For action == 3, this.resources >= 3; for action == 4, this.resources < MaxResources. Otherwise you will not get a second choice of action.
     *
     * @post enemy.defended == false && result == enemy.HP <= 0. all characters field are valid
     */
    boolean Action( Character enemy, int action){

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
                    this.Attack(enemy, this.attackDamage);
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
