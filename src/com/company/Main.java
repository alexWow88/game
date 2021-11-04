package com.company;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        // Player inputs
        Scanner myScanner = new Scanner(System.in);

        System.out.println(" ");
        System.out.println(" ");
        System.out.println("___________________________________________________________________________________________________________________________ ");
        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" ");
        System.out.println("        8888888     88     88  8888888     8888888     88         888888888      8888888888  888888888      888");
        System.out.println("        88     88   88     88  88     88   88     88   88         88                 88      88            88 88");
        System.out.println("        88    88    88     88  88    88    88    88    88         88                 88      88           88   88");
        System.out.println("        88888888    88     88  88888888    88888888    88         88888              88      88888       88     88");
        System.out.println("        88     88   88     88  88     88   88     88   88         88                 88      88          888888888");
        System.out.println("        88      88  88     88  88      88  88      88  88         88                 88      88          88     88");
        System.out.println("        88     88   88     88  88     88   88     88   88         88                 88      88          88     88");
        System.out.println("        88888888      88888    88888888    88888888    888888888  888888888          88      888888888   88     88");
        System.out.println("                                                                                          //");
        System.out.println("            888   8888   8     8  88888  88  8  88888  8   8  888    88888         _______||_______  ");
        System.out.println("           8   8  8   8  8     8  8      8 8 8    8    8   8  8  8   8             <______||______>");
        System.out.println("           8   8  8   8   8   8   888    8 8 8    8    8   8  8  8   888           |      ||      |");
        System.out.println("           88888  8   8   8   8   8      8  88    8    8   8  888    8             |``````||``````|");
        System.out.println("           8   8  8   8    8 8    8      8  88    8    8   8  8  8   8              | o   ||  o  |");
        System.out.println("           8   8  8888      8     88888  8   8    8     888   8   8  88888          | o o  o o o |");
        System.out.println("                                                                                     |  o o o o |");
        System.out.println("                                                                                     `__________`");
        System.out.println(" ");
        System.out.println("___________________________________________________________________________________________________________________________ ");
        System.out.println(" ");
        System.out.println(" ");

        System.out.println("Enter your name: ");
        String name = myScanner.next();
        System.out.println("Are you feeling lucky today? Type a number between 1-10 with 10 being the most lucky (game is easier the luckier you are!): ");
        int luck = myScanner.nextInt();
        System.out.println("Bubble tea you are thirsty for: ");
        String tea = myScanner.next();

        int numberOfTeas = (int) (Math.random() * (5 + 1) + 5);

        Hero hero = new Hero(100, name, tea, luck, numberOfTeas);

        // Setting the story of the Game

        TypeWriter.type(hero.getName() + ", the " + hero.getTea() + " Bubble Tea maniac, continues his Bubble Tea Adventures..");

        Enemy enemy1 = new Enemy(100, "Sound as a Pound, Andy", "Mango Tapioca", 3, 4);

        Enemy enemy2 = new Enemy(100, "Wham Blam Sam", "What is he Thinking OREO FLAVOUR", 5, 3);

        Enemy enemy3 = new Enemy(100, "I'm Your Boss, Ollie, B****", "Best Flavour Imaginable", 6, 6);

        TypeWriter.type("You are late for work but feeling good because you just picked up " + hero.getNumberOfTeas() + " Bubble teas at BubbleTeas4Life");
        TypeWriter.type("You run out of the bubble tea shop and realise something is very wrong....");
        TypeWriter.type("3 angry dudes are standing in front of you blocking your way...");
        TypeWriter.type("The last thing you remember is that you were 4th in line behind these guys....");
        TypeWriter.type("...and you see their bloody faces and start to recall...");
        TypeWriter.type("You only remember snippets because you are a Bubble tea junkie and you blacked out the moment you entered the shop.");
        TypeWriter.type("You sometimes get this way over the excitement of your first bubble tea of the day...");
        TypeWriter.type("You remember the face punching and kicking and banshee screaming you did to get to the front of the line...and then pure joy over getting your " + numberOfTeas + " teas");
        TypeWriter.type(" ");
        TypeWriter.type("Was is worth it???........ Absolutely! But now you have to kick their butts to get to work... just another #bubbleTeaMorning...");
        TypeWriter.type(" ");

        TypeWriter.type("Fight's On!!!!");
        TypeWriter.type("...");
        TypeWriter.type("Your first opponent steps up... It's " + enemy1.getName() + " the " + enemy1.getTea() + " Bubble Tea Lover..and they look MAD!");

        // Round 1 (Opponent 1)

        for (int i = 0; i < 100; i++) {
            if (hero.getHealth() != 0 && enemy1.getHealth() != 0) {
                TypeWriter.type("Options: Enter 1 for ATTACK (does between 0-30 damage)   or   Enter 2 for HEAL (Replenish 20-30 life force by drinking some delicious tea");
                int choice = myScanner.nextInt();
                // Hero Attack Option
                if (choice == 1) {
                    hero.heroAttack(hero, enemy1, 1);
                    hero.sustainUglinessDamageCheck(hero, enemy1, 1);
                }
                // Hero Heal Option
                if (choice == 2) {
                    hero.heroHeal(hero, 1);
                }
                if (enemy1.getHealth() != 0) {
                    int enemyRandomMove = (int) (Math.random() * (2) + 1);
                    // Enemy Attack Option
                    if (enemyRandomMove == 1) {
                        enemy1.enemyAttack(hero, enemy1, 1);
                    }
                    // Enemy Heal Option
                    if (enemyRandomMove == 2) {
                        enemy1.enemyHeal(enemy1, 1);
                    }
                    if (hero.getHealth() == 0) {
                        TypeWriter.type("You lose!");
                    }
                }
            }
        }

        // Round 2 (Opponent 2)

        TypeWriter.type("Your second opponent steps up... It's " + enemy2.getName() + " the " + enemy2.getTea() + " Bubble Tea Lover..this guy looks toughhhhhh!!");
        TypeWriter.type(" ");

        for (int i = 0; i < 100; i++) {
            if (hero.getHealth() != 0 && enemy2.getHealth() != 0) {
                TypeWriter.type("Options: Enter 1 for ATTACK (does between 0-30 damage)   or   Enter 2 for HEAL (Replenish 20-30 life force by drinking some delicious tea");
                int choice = myScanner.nextInt();
                // Hero Attack Option
                if (choice == 1) {
                    hero.heroAttack(hero, enemy2, 2);
                    hero.sustainUglinessDamageCheck(hero, enemy2, 2);
                }
                // Hero Heal Option
                if (choice == 2) {
                    hero.heroHeal(hero, 2);
                }
                if (enemy2.getHealth() != 0) {
                    int enemyRandomMove = (int) (Math.random() * (2) + 1);
                    // Enemy Attack Option
                    if (enemyRandomMove == 1) {
                        enemy2.enemyAttack(hero, enemy2, 2);
                    }
                    // Enemy Heal Option
                    if (enemyRandomMove == 2) {
                        enemy2.enemyHeal(enemy2, 2);
                    }
                    if (hero.getHealth() == 0) {
                        TypeWriter.type("You lose!");
                    }
                }
            }
        }

        // Round 3 (Opponent 3)

            TypeWriter.type("Your final opponent steps up and OMG it's " + enemy3.getName() + " the " + enemy3.getTea() + " Bubble Tea Lover...looks like there won't be any point to go into work after this...");
            TypeWriter.type("...FINAL BOSS...");

            for (int i = 0; i < 100; i++) {
                if (hero.getHealth() != 0 && enemy3.getHealth() != 0) {
                    TypeWriter.type("Options: Enter 1 for ATTACK (does between 0-30 damage)   or   Enter 2 for HEAL (Replenish 20-30 life force by drinking some delicious tea");
                    int choice = myScanner.nextInt();
                    // Hero Attack Option
                    if (choice == 1) {
                        hero.heroAttack(hero, enemy3, 3);
                        hero.sustainUglinessDamageCheck(hero, enemy3, 3);
                    }
                    // Hero Heal Option
                    if (choice == 2) {
                        hero.heroHeal(hero, 3);
                    }
                    if (enemy3.getHealth() != 0) {
                        int enemyRandomMove = (int) (Math.random() * (2) + 1);
                        // Enemy Attack Option
                        if (enemyRandomMove == 1) {
                            enemy3.enemyAttack(hero, enemy3, 3);
                        }
                        // Enemy Heal Option
                        if (enemyRandomMove == 2) {
                            enemy3.enemyHeal(enemy3, 3);
                        }
                        if (hero.getHealth() == 0) {
                            TypeWriter.type("You lose!");
                        }
                    }
                }
            }
        }
    }