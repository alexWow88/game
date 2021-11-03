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

        Hero hero = new Hero(100, name, tea, luck);

        // Setting the story of the Game

        TypeWriter.type(hero.getName() + ", the " + hero.getTea() + " Bubble Tea maniac, continues his Bubble Tea Adventures..");
        int numberOfTeas = (int) (Math.random() * (5 + 1) + 5);

        Enemy enemy1 = new Enemy(100, "Sound as a Pound, Andy", "Mango Tapioca", 3, 4);

        Enemy enemy2 = new Enemy(100, "Wham Blam Sam", "What is he Thinking OREO FLAVOUR", 5, 3);

        Enemy enemy3 = new Enemy(100, "I'm Your Boss, Ollie, B****", "Best Flavour Imaginable", 6, 6);

        TypeWriter.type("You are late for work but feeling good because you just picked up " + numberOfTeas + " Bubble teas at BubbleTeas4Life");
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
                    int heroDamageRandom = (int) (Math.random() * (10) + 1);
                    if (heroDamageRandom < hero.getLuck() && heroDamageRandom != 1) {
                        TypeWriter.type("You throw a tapioca pearl right into their eye! That must have HURT to get hit by a small wet squishy sweet! You are feeling it today! Luck on your side!");
                        enemy1.setHealth(enemy1.getHealth() - 30);
                    } else if (heroDamageRandom > 1) {
                        int heroRandomAttack = (int) (Math.random() * (3) + 1);
                        if (heroRandomAttack == 1) {
                            TypeWriter.type("You shove the straw up your their nose! Savage!!!");
                        } else if (heroRandomAttack == 2) {
                            TypeWriter.type("You pull out some mom jokes and MAN did they hurt! They are down on one knee from the pain!");
                        } else {
                            TypeWriter.type("You whip your hair back and forth and slap well conditioned hair across your opponents ugly face");
                        }
                        enemy1.setHealth(enemy1.getHealth() - 20);
                    } else {
                        TypeWriter.type("You mistakenly punch yourself in the face! Pathetic!");
                        hero.setHealth(hero.getHealth() - 10);
                        TypeWriter.type("You are down to " + hero.getHealth() + "health");
                    }
                    if (enemy1.getHealth() < 0) {
                        enemy1.setHealth(0);
                    }
                    if (enemy1.getHealth() > 0) {
                        TypeWriter.type("Enemy has " + enemy1.getHealth() + " health left.");
                    } else {
                        TypeWriter.type("Enemy has 0 health left and lie in a puddle of bubble tea!");
                        TypeWriter.type(" ");
                        TypeWriter.type("You win!");
                    }
                    int uglinessDamageRandom = (int) (Math.random() * (10) + 1);
                    if (enemy1.getUgliness() > uglinessDamageRandom) {
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
                // Hero Heal Option
                if (choice == 2) {
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
                if (enemy1.getHealth() != 0) {
                    int enemyRandomMove = (int) (Math.random() * (2) + 1);
                    // Enemy Attack Option
                    if (enemyRandomMove == 1) {
                        TypeWriter.type(enemy1.getName() + " Attacks!");
                        int enemyDamageRandom = (int) (Math.random() * (10) + 1);
                        if (enemyDamageRandom < enemy1.getRage() && enemyDamageRandom != 1) {
                            TypeWriter.type("He grabs another person in line over their head and throws them on top of you!! A rare and painful move!");
                            hero.setHealth(hero.getHealth() - 30);
                        } else if (enemyDamageRandom > 1) {
                            int enemyRandomAttack = (int) (Math.random() * (3) + 1);
                            if (enemyRandomAttack == 1) {
                                TypeWriter.type("Somebody has been watching the Karate Kid! You take a crane kick to the FACE!");
                            } else if (enemyRandomAttack == 2) {
                                TypeWriter.type("'What's that?' and points at your chest. OH NO, you fell for it! Finger smashes your nose when you look down! What a loser!");
                            } else {
                                TypeWriter.type("Classic hair pull! He knows how to get you where it hurts!");
                            }
                            hero.setHealth(hero.getHealth() - 20);
                        } else {
                            TypeWriter.type("He goes in for a flying kick and completely misses! Flies through the window of the Bubble Tea Shop and takes an Innocent out with them");
                            enemy1.setHealth(enemy1.getHealth() - 10);
                            if (enemy1.getHealth() < 0) {
                                enemy1.setHealth(0);
                            }
                            TypeWriter.type("He is one tough badger but he has " + enemy1.getHealth() + " health left now.");
                        }
                        if (hero.getHealth() < 0) {
                            hero.setHealth(0);
                        }
                        TypeWriter.type("You now have " + hero.getHealth() + " health.");
                    }
                    // Enemy Heal Option
                    if (enemyRandomMove == 2) {
                        TypeWriter.type(enemy1.getName() + " Heals...Boring but effective");
                        enemy1.setHealth(enemy1.getHealth() + 20);
                        if (enemy1.getHealth() > 100) {
                            enemy1.setHealth(100);
                        }
                        TypeWriter.type("Enemy now has " + enemy1.getHealth() + " health.");
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
                    int heroDamageRandom = (int) (Math.random() * (10) + 1);
                    if (heroDamageRandom < hero.getLuck() && heroDamageRandom != 1) {
                        TypeWriter.type("You hold up a mirror and reflect his ugliness back at him and he gets an EYE FULL! So rare to pull that move off! Mega Lucky!");
                        enemy2.setHealth(enemy2.getHealth() - 30);
                    } else if (heroDamageRandom > 1) {
                        int heroRandomAttack = (int) (Math.random() * (3) + 1);
                        if (heroRandomAttack == 1) {
                            TypeWriter.type("You toss your tea up in the air! Your opponent jumps up to catch it and you slap the Bejesus out of him and safely catch your delicious beverage! You would have thought he would have remembered your signature move (you do this a lot)");
                        } else if (heroRandomAttack == 2) {
                            TypeWriter.type("You land some well placed ice cube throws right in their kidneys! ");
                        } else {
                            TypeWriter.type("You whip your hair back and forth and slap well conditioned hair across your opponents ugly face");
                        }
                        enemy2.setHealth(enemy2.getHealth() - 20);
                    } else {
                        TypeWriter.type("You decide to throw a punch but you forget to actually throw it! Leaving yourself wide open for a quick 1-2 slap!");
                        hero.setHealth(hero.getHealth() - 10);
                        if (hero.getHealth() < 0) {
                            hero.setHealth(0);
                        }
                        TypeWriter.type("You are down to " + hero.getHealth() + " health");
                    }
                    if (enemy2.getHealth() < 0) {
                        enemy2.setHealth(0);
                    }
                    if (enemy2.getHealth() > 0) {
                        TypeWriter.type("Enemy has " + enemy2.getHealth() + " health left.");
                    } else {
                        TypeWriter.type("Enemy has 0 health left and lie in a puddle of bubble tea!");
                        TypeWriter.type(" ");
                        TypeWriter.type("You win!");
                    }
                    int uglinessDamageRandom = (int) (Math.random() * (10) + 1);
                    if (enemy2.getUgliness() > uglinessDamageRandom) {
                        hero.setHealth(hero.getHealth() - 5);
                        if (hero.getHealth() < 0) {
                            hero.setHealth(0);
                        }
                        TypeWriter.type("You forget to shield your eyes and sustain damage from the ugliness of your opponent.. You have " + hero.getHealth() + " health left.");
                        if (hero.getHealth() == 0) {
                            TypeWriter.type("You just couldn't handle all the ugly and get knocked out!");
                        }
                    }
                }
                // Hero Heal Option
                if (choice == 2) {
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
                if (enemy2.getHealth() != 0) {
                    int enemyRandomMove = (int) (Math.random() * (2) + 1);
                    // Enemy Attack Option
                    if (enemyRandomMove == 1) {
                        TypeWriter.type(enemy2.getName() + " Attacks!");
                        int enemyDamageRandom = (int) (Math.random() * (10) + 1);
                        if (enemyDamageRandom < enemy2.getRage() && enemyDamageRandom != 1) {
                            TypeWriter.type("Signature move! He moves with lightning speed and the next thing you know, he is drinking from your straw!! You feel your life force DRAINING!");
                            enemy2.setHealth(enemy2.getHealth() + 10);
                            if (enemy2.getHealth() > 100) {
                                enemy2.setHealth(100);
                            }
                            TypeWriter.type("Enemy regains health and is now at " + enemy2.getHealth() + " health");
                            hero.setHealth(hero.getHealth() - 30);
                        } else if (enemyDamageRandom > 1) {
                            int enemyRandomAttack = (int) (Math.random() * (3) + 1);
                            if (enemyRandomAttack == 1) {
                                TypeWriter.type("He grabs an Innocent's bubble tea and pours it slowly on the ground! Who would do such a thing!! You scream inaudibly and shed a tear for your fallen comrade");
                            } else if (enemyRandomAttack == 2) {
                                TypeWriter.type("He says " + hero.getTea() + " Bubble Tea sucks! How could he! You start to question all your life choices.. you will definitely talk about this moment in your weekly therapy session.");
                            } else {
                                TypeWriter.type("Classic hair pull! He knows how to get you where it hurts!");
                            }
                            hero.setHealth(hero.getHealth() - 20);
                        } else {
                            TypeWriter.type("He goes in for a flying kick and completely misses! Flies through the window of the Bubble Tea Shop and takes an Innocent out with them");
                            enemy2.setHealth(enemy2.getHealth() - 10);
                            if (enemy2.getHealth() < 0) {
                                enemy2.setHealth(0);
                            }
                            TypeWriter.type("He is one tough badger but he has " + enemy2.getHealth() + " health left now.");
                        }
                        if (hero.getHealth() < 0) {
                            hero.setHealth(0);
                        }
                        TypeWriter.type("You now have " + hero.getHealth() + " health.");
                    }
                    // Enemy Heal Option
                    if (enemyRandomMove == 2) {
                        TypeWriter.type(enemy2.getName() + " Heals...Boring but effective");
                        enemy2.setHealth(enemy2.getHealth() + 20);
                        if (enemy2.getHealth() > 100) {
                            enemy2.setHealth(100);
                        }
                        TypeWriter.type("Enemy now has " + enemy2.getHealth() + " health.");
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
                        int heroDamageRandom = (int) (Math.random() * (10) + 1);
                        if (heroDamageRandom < hero.getLuck() && heroDamageRandom != 1) {
                            if (numberOfTeas > 0) {
                                TypeWriter.type("Oh no you didn't!! You throw one of your " + numberOfTeas + "and clock him right in the face! Massive damage!!");
                                numberOfTeas -= 1;
                                enemy3.setHealth(enemy3.getHealth() - 30);
                            } else {
                                TypeWriter.type("Oh no!! You try to throw another tea at him but you are out! You KNEW you should have bought more!");
                            }
                        } else if (heroDamageRandom > 1) {
                            int heroRandomAttack = (int) (Math.random() * (3) + 1);
                            if (heroRandomAttack == 1) {
                                TypeWriter.type("You charge the man and CLOTHES LINE him! Lands flat on his back on the hard pavement.");
                            } else if (heroRandomAttack == 2) {
                                TypeWriter.type("You threaten to sabotage the team project to miss the client deadline! You thought it would hurt more but it turns out you are not that important to the team anyway..dang..");
                            } else {
                                TypeWriter.type("You whip your hair back and forth and slap well conditioned hair across your opponents ugly face");
                            }
                            enemy3.setHealth(enemy3.getHealth() - 20);
                        } else {
                            TypeWriter.type("You throw a punch but this dude has been going to the gym. You feel your wrist fracture when you hit his rock hard stomach..and you make a mental note to rewatch 300 and Magic Mike");
                            hero.setHealth(hero.getHealth() - 10);
                            if (hero.getHealth() < 0) {
                                hero.setHealth(0);
                            }
                            TypeWriter.type("You are down to " + hero.getHealth() + "health");
                        }
                        if (enemy3.getHealth() < 0) {
                            enemy3.setHealth(0);
                        }
                        if (enemy3.getHealth() > 0) {
                            TypeWriter.type("Enemy has " + enemy3.getHealth() + " health left.");
                        } else {
                            TypeWriter.type("Enemy has 0 health left and lie in a puddle of bubble tea!");
                            TypeWriter.type(" ");
                            TypeWriter.type("You win!");
                            TypeWriter.type(" ");
                            TypeWriter.type("You are victorious on this day and take a selfie on the ground with all the victims of this battle. You stroll off to work as if you still have a job with your " + numberOfTeas + " Bubble Teas");
                            TypeWriter.type(" ");
                            TypeWriter.type("Thanks for playing!!!!");
                        }
                        int uglinessDamageRandom = (int) (Math.random() * (10) + 1);
                        if (enemy3.getUgliness() > uglinessDamageRandom) {
                            hero.setHealth(hero.getHealth() - 5);
                            if (hero.getHealth() < 0) {
                                hero.setHealth(0);
                            }
                            TypeWriter.type("You forget to shield your eyes and sustain damage from the ugliness of your opponent.. You have " + hero.getHealth() + " health left.");
                            if (hero.getHealth() == 0) {
                                TypeWriter.type("You just couldn't handle all the ugly and get knocked out!");
                            }
                        }
                    }
                    // Hero Heal Option
                    if (choice == 2) {
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
                    if (enemy3.getHealth() != 0) {
                        int enemyRandomMove = (int) (Math.random() * (2) + 1);
                        // Enemy Attack Option
                        if (enemyRandomMove == 1) {
                            TypeWriter.type(enemy3.getName() + " Attacks!");
                            int enemyDamageRandom = (int) (Math.random() * (10) + 1);
                            if (enemyDamageRandom < enemy3.getRage() && enemyDamageRandom != 1) {
                                TypeWriter.type("Signature move! 2 handed punch right in the sternum sending you flying through the store window!");
                                hero.setHealth(hero.getHealth() - 30);
                            } else if (enemyDamageRandom > 1) {
                                int enemyRandomAttack = (int) (Math.random() * (3) + 1);
                                if (enemyRandomAttack == 1) {
                                    TypeWriter.type("He pulls out your paycheck and rips it up! Your going to have to live off the free fruit supplied at work at this rate..");
                                } else if (enemyRandomAttack == 2) {
                                    TypeWriter.type("He jedi force grabs you by throat! The force is strong with this one");
                                } else {
                                    TypeWriter.type("Does a complete back flip while KICKING you in the CHIN!");
                                }
                                hero.setHealth(hero.getHealth() - 20);
                            } else {
                                TypeWriter.type("What bad luck! Pulls a hammy before he can attack and winces in pain!");
                                enemy3.setHealth(enemy3.getHealth() - 10);
                                if (enemy3.getHealth() < 0) {
                                    enemy3.setHealth(0);
                                }
                                TypeWriter.type("He is one tough badger but he has " + enemy3.getHealth() + " health left now.");
                            }
                            if (hero.getHealth() < 0) {
                                hero.setHealth(0);
                            }
                            TypeWriter.type("You now have " + hero.getHealth() + " health.");
                        }
                        // Enemy Heal Option
                        if (enemyRandomMove == 2) {
                            TypeWriter.type(enemy3.getName() + " Heals...Boring but effective");
                            enemy3.setHealth(enemy3.getHealth() + 25);
                            if (enemy3.getHealth() > 100) {
                                enemy3.setHealth(100);
                            }
                            TypeWriter.type("Enemy now has " + enemy3.getHealth() + " health.");
                        }
                        if (hero.getHealth() == 0) {
                            TypeWriter.type("You lose!");
                        }
                    }
                }
            }
        }
    }