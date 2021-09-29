package com.company;

public class Hero extends Person{
    public int luck;

    public Hero(int health, String name, String tea, int luck) {
        super(health, name, tea);
        this.luck = luck;
    }

//    public void heroAttack () {
//        System.out.println("You whip your hair back and forth and slap well conditioned hair across your opponents ugly face");
//        enemy1.health = enemy1.health - 20;
//        if (enemy1.health < 0) {
//            enemy1.health = 0;
//        }
//        if (enemy1.health > 0) {
//            System.out.println("Enemy has " + enemy1.health + " left.");
//        } else {
//            System.out.println("You win!");
//        }
//    }

    public int getLuck() {
        return luck;
    }

    public void setLuck(int luck) {
        this.luck = luck;
    }
}
