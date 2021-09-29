package com.company;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Player inputs
        Scanner myScanner = new Scanner(System.in);

        System.out.println("Enter your name: ");
        String name = myScanner.next();
        System.out.println("Are you feeling lucky today? Type a number between 1-10 with 10 being the most lucky (game is easier the luckier you are!: ");
        int luck = myScanner.nextInt();
        System.out.println("Bubble tea you are thirsty for: ");
        String tea = myScanner.next();

        Hero hero = new Hero(100, name, tea, luck);

        // Setting the story of the Game
        System.out.println(" ");
        System.out.println(hero.name + ", the " + hero.tea + " Bubble Tea maniac, continues his Bubble Tea Adventures..");
        System.out.println(" ");
        int numberOfTeas = (int) (Math.random() * (5 + 1) + 5);

        Enemy enemy1 = new Enemy(100, "Sound as a Pound, Andy", "Mango Tapioca", 7, 10);

        Enemy enemy2 = new Enemy(100, "Sam Blam Blam", "What is he Thinking OREA FLAVOUR", 0, 5 );

        Enemy enemy3 = new Enemy(100, "I'm Your Boss, Ollie, B****", "The best flavour imagineable", 0, 10 );

        System.out.println("You are late for work but feeling good because you just picked up " + numberOfTeas + " Bubble teas at BubbleTeas4Life");
        System.out.println("You run out of the bubble tea shop and realise something is very wrong....");
        System.out.println("3 angry dudes are standing in front of you blocking your way...");
        System.out.println("The last thing you remember is that you were 4th in line behind these guys....");
        System.out.println("...and you see their bloody faces and start to recall...");
        System.out.println("You only remember snippets because you are a Bubble tea junkie and you blacked out the moment you entered the shop.");
        System.out.println("You sometimes get this way over the excitement of your first bubble tea of the day...");
        System.out.println("You remember the face punching and kicking and banshee screaming you did to get to the front of the line...and then pure joy over getting your " + numberOfTeas + "teas");
        System.out.println(" ");
        System.out.println("Was is worth it???........ Absolutely! But now you have to kick their butts to get to work... just another #bubbleTeaMorning...");
        System.out.println(" ");

        System.out.println(" ");
        System.out.println("Fight's On!!!!");
        System.out.println(" ");
        System.out.println("...");
        System.out.println(" ");
        System.out.println("Your first opponent steps up... It's " + enemy1.name + " the " + enemy1.tea + " Bubble Tea Lover..and they look MAD!");
        System.out.println(" ");

        // Round 1 (Opponent 1)

        for (int i = 0; i < 100; i++) {
            if (hero.health != 0 && enemy1.health != 0) {
                System.out.println("Options: Enter 1 for ATTACK (does between 20-30 damage)   or   Enter 2 for HEAL (Replenish 20-30 life force by drinking some delicious tea");
                int choice = myScanner.nextInt();
                // Hero Attack Option
                if (choice == 1) {
                    int heroDamageRandom = (int) (Math.random() * (10) + 1);
                    if (heroDamageRandom < hero.luck && heroDamageRandom != 1) {
                        System.out.println("You throw a tapioca pearl right into their eye! That must have HURT to get hit by a small wet squishy sweet! You are feeling it today! Luck on your side!");
                        enemy1.health = enemy1.health - 30;
                    } else if (heroDamageRandom > 1) {
                        int heroRandomAttack = (int) (Math.random() * (3) + 1);
                        if (heroRandomAttack == 1) {
                            System.out.println("You shove the straw up your their nose! Savage!!!");
                        } else if (heroRandomAttack == 2) {
                            System.out.println("You pull out some mom jokes and MAN did they hurt! They are down on one knee from the pain!");
                        } else {
                            System.out.println("You whip your hair back and forth and slap well conditioned hair across your opponents ugly face");
                        }
                        enemy1.health = enemy1.health - 20;
                    } else {
                        System.out.println("You mistakenly punch yourself in the face! Pathetic!");
                        hero.health = hero.health -10;
                    }
                    if (enemy1.health < 0) {
                        enemy1.health = 0;
                    }
                    if (enemy1.health > 0) {
                        System.out.println("Enemy has " + enemy1.health + " health left.");
                    } else {
                        System.out.println("Enemy has 0 health left and lie in a puddle of bubble tea!");
                        System.out.println("You win!");
                    }
                    int uglinessDamageRandom = (int) (Math.random() * (10) + 1);
                    if (enemy1.ugliness > uglinessDamageRandom) {
                        hero.health = hero.health - 5;
                        System.out.println("You forget to shield your eyes and sustain damage from the ugliness of your opponent.. You have " + hero.health + " health left.");
                    }
                }
                // Hero Heal Option
                if (choice == 2) {
                    int heroHealRandom = (int) (Math.random() * (10) + 20);
                    hero.health = hero.health + heroHealRandom;
                    if (hero.health > 100) {
                        hero.health = 100;
                    }
                    if (heroHealRandom >= 26) {
                        System.out.println("You take a sip of tea and have all the luck! You sucked up a Tapioka pearl and are feeling recharged! You have " + hero.health + " now.");
                    } else {
                        System.out.println("You take this chance to take a sip of tea but NO TAPIOKA CAME UP THE STRAW...minimal heal.. You have " + hero.health + " now.");
                    }
                }
                if (enemy1.health != 0) {
                    int enemyRandomMove = (int) (Math.random() * (2) + 1);
                    // Enemy Attack Option
                    if (enemyRandomMove == 1) {
                        System.out.println(enemy1.name + " Attacks!");
                        hero.health = hero.health - 10;
                        if (hero.health < 0) {
                            hero.health = 0;
                        }
                        System.out.println("You now have " + hero.health + " health.");
                    }
                    // Enemy Heal Option
                    if (enemyRandomMove == 2) {
                        System.out.println(enemy1.name + " Heals...");
                        enemy1.health = enemy1.health + 10;
                        if (enemy1.health > 100) {
                            enemy1.health = 100;
                        }
                        System.out.println("Enemy now has " + enemy1.health + " health.");
                    }
                    if (hero.health == 0) {
                        System.out.println("You lose!");
                    }
                }
            }
        }


    }
}
