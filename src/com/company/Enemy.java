package com.company;

public class Enemy extends Person{
    private int ugliness;
    private int rage;

    public Enemy(int health, String name, String tea, int ugliness, int rage) {
        super(health, name, tea);
        this.ugliness = ugliness;
        this.rage = rage;
    }

    public void enemyAttack (Hero hero, Enemy enemy, int round) throws InterruptedException {
        TypeWriter.type(enemy.getName() + " Attacks!");
        int enemyDamageRandom = (int) (Math.random() * (10) + 1);
        if (enemyDamageRandom < enemy.getRage() && enemyDamageRandom != 1) {
            switch (round) {
                case 1: TypeWriter.type("He grabs another person in line over their head and throws them on top of you!! A rare and painful move!");
                        hero.setHealth(hero.getHealth() - 30);
                        break;
                case 2: TypeWriter.type("Signature move! He moves with lightning speed and the next thing you know, he is drinking from your straw!! You feel your life force DRAINING!");
                        enemy.setHealth(enemy.getHealth() + 10);
                        if (enemy.getHealth() > 100) {
                            enemy.setHealth(100);
                        }
                        TypeWriter.type("Enemy regains health and is now at " + enemy.getHealth() + " health");
                        hero.setHealth(hero.getHealth() - 30);
                        break;
                case 3: TypeWriter.type("Signature move! 2 handed punch right in the sternum sending you flying through the store window!");
                        hero.setHealth(hero.getHealth() - 30);
                        break;
                default: break;
            }
        } else if (enemyDamageRandom > 1) {
            int enemyRandomAttack = (int) (Math.random() * (3) + 1);
            if (enemyRandomAttack == 1) {
                switch (round) {
                    case 1: TypeWriter.type("Somebody has been watching the Karate Kid! You take a crane kick to the FACE!");
                    break;
                    case 2: TypeWriter.type("He grabs an Innocent's bubble tea and pours it slowly on the ground! Who would do such a thing!! You scream inaudibly and shed a tear for your fallen comrade");
                    break;
                    case 3: TypeWriter.type("He pulls out your paycheck and rips it up! Your going to have to live off the free fruit supplied at work at this rate..");
                    break;
                }
            } else if (enemyRandomAttack == 2) {
                switch (round) {
                    case 1: TypeWriter.type("'What's that?' and points at your chest. OH NO, you fell for it! Finger smashes your nose when you look down! What a loser!");
                    break;
                    case 2: TypeWriter.type("He says " + hero.getTea() + " Bubble Tea sucks! How could he! You start to question all your life choices.. you will definitely talk about this moment in your weekly therapy session.");
                    break;
                    case 3: TypeWriter.type("He jedi force grabs you by throat! The force is strong with this one");
                    break;
                }
            } else {
                TypeWriter.type("Classic hair pull! He knows how to get you where it hurts!");
            }
            hero.setHealth(hero.getHealth() - 20);
        } else {
            if (round == 1 || round == 2){
                TypeWriter.type("He goes in for a flying kick and completely misses! Flies through the window of the Bubble Tea Shop and takes an Innocent out with them");
            } else if (round == 3){
                TypeWriter.type("What bad luck! Pulls a hammy before he can attack and winces in pain!");
            }
            enemy.setHealth(enemy.getHealth() - 10);
            if (enemy.getHealth() < 0) {
                enemy.setHealth(0);
            }
            TypeWriter.type("He is one tough badger but he has " + enemy.getHealth() + " health left now.");
        }
        if (hero.getHealth() < 0) {
            hero.setHealth(0);
        }
        TypeWriter.type("You now have " + hero.getHealth() + " health.");
    }

    public void enemyHeal( Enemy enemy, int round ) throws InterruptedException {
        TypeWriter.type(enemy.getName() + " Heals...Boring but effective");
        if (round == 3) {
            enemy.setHealth(enemy.getHealth() + 25);
        } else {
            enemy.setHealth(enemy.getHealth() + 20);
        }
        if (enemy.getHealth() > 100) {
            enemy.setHealth(100);
        }
        TypeWriter.type("Enemy now has " + enemy.getHealth() + " health.");
    }

    public int getUgliness() {
        return ugliness;
    }

    public void setUgliness(int ugliness) {
        this.ugliness = ugliness;
    }

    public int getRage() {
        return rage;
    }

    public void setRage(int rage) {
        this.rage = rage;
    }
}
