package com.company;

public class Hero extends Person{
    private int luck;

    public Hero(int health, String name, String tea, int luck) {
        super(health, name, tea);
        this.luck = luck;
    }

//    public void setHealth(int health) {
        // do your checks to see if goes below zero?
//    }

//    public void heroAttack () {
//        int heroDamageRandom = (int) (Math.random() * (10) + 1);
//        if (heroDamageRandom < hero.getLuck() && heroDamageRandom != 1) {
//            TypeWriter.type("You throw a tapioca pearl right into their eye! That must have HURT to get hit by a small wet squishy sweet! You are feeling it today! Luck on your side!");
//            enemy1.setHealth(enemy1.getHealth() - 30);
//        } else if (heroDamageRandom > 1) {
//            int heroRandomAttack = (int) (Math.random() * (3) + 1);
//            if (heroRandomAttack == 1) {
//                TypeWriter.type("You shove the straw up your their nose! Savage!!!");
//            } else if (heroRandomAttack == 2) {
//                TypeWriter.type("You pull out some mom jokes and MAN did they hurt! They are down on one knee from the pain!");
//            } else {
//                TypeWriter.type("You whip your hair back and forth and slap well conditioned hair across your opponents ugly face");
//            }
//            enemy1.setHealth(enemy1.getHealth() - 20);
//        } else {
//            TypeWriter.type("You mistakenly punch yourself in the face! Pathetic!");
//            hero.setHealth(hero.getHealth() - 10);
//            TypeWriter.type("You are down to " + hero.getHealth() + "health");
//        }
//        if (enemy1.getHealth() < 0) {
//            enemy1.setHealth(0);
//        }
//        if (enemy1.getHealth() > 0) {
//            TypeWriter.type("Enemy has " + enemy1.getHealth() + " health left.");
//        } else {
//            TypeWriter.type("Enemy has 0 health left and lie in a puddle of bubble tea!");
//            TypeWriter.type(" ");
//            TypeWriter.type("You win!");
//        }
//        int uglinessDamageRandom = (int) (Math.random() * (10) + 1);
//        if (enemy1.getUgliness() > uglinessDamageRandom) {
//            hero.setHealth(hero.getHealth()-5);
//            if (hero.getHealth() < 0) {
//                hero.setHealth(0);
//            }
//            TypeWriter.type("You forget to shield your eyes and sustain damage from the ugliness of your opponent.. You have " + hero.getHealth() + " health left.");
//            if (hero.getHealth() == 0) {
//                TypeWriter.type("You just couldn't handle all the ugly and get knocked out!");
//            }
//
//        }
//    }

    public void heroHeal (Hero hero , int round) throws InterruptedException {
        int heroHealRandom = (int) (Math.random() * (10) + 20);
        hero.setHealth(hero.getHealth() + heroHealRandom);
        if (hero.getHealth() > 100) {
            hero.setHealth(100);
        }
        if (heroHealRandom >= 26) {
            TypeWriter.type("You take a sip of tea and have all the luck! You sucked up a Tapioca pearl and are feeling recharged! You have " + hero.getHealth() + " now.");
        } else {
            TypeWriter.type("You take this chance to take a sip of tea but NO TAPIOCA CAME UP THE STRAW...minimal heal.. You have " + hero.getHealth() + " now.");
        }
    }

    public void sustainUglinessDamageCheck (Hero hero, Enemy enemy, int round) throws InterruptedException {
        int uglinessDamageRandom = (int) (Math.random() * (10) + 1);
        if (enemy.getUgliness() > uglinessDamageRandom) {
            hero.setHealth(hero.getHealth()-5);
            if (hero.getHealth() < 0) {
                hero.setHealth(0);
            }
            TypeWriter.type("You forget to shield your eyes and sustain damage from the ugliness of your opponent.. You have " + hero.getHealth() + " health left.");
            if (hero.getHealth() == 0) {
                TypeWriter.type("You just couldn't handle all the ugly and get knocked out!");
            }

        }
    }

    public int getLuck() {
        return luck;
    }

    public void setLuck(int luck) {
        this.luck = luck;
    }
}
