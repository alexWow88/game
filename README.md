![alt text](./assets/images/bubble-tea.PNG) 
# Bubble Tea Adventure Game
A whacky text-based battle game where you play as a crazed Bubble Tea junky who constantly gets into fights at the Bubble Tea shop. You just can't handle your Bubble Tea!

## General Info 
I made this during week 7 of my software development course at _nology. 
This project was used to showcase knowledge of Classes and extending off a Class as well as accessing/changing properties via Getters and Setters. This game is purely text-based and played from the Terminal.

## Technologies used
* Java

## Steps of the game:
* Pick your name
* Pick how lucky you feel that day (luckier will make the game easier as you are more likely to do a Critical Hit on attack)
* Pick your favorite Bubble Tea (will be mentioned in game at various times)
* Round 1: Turn-based battle with Opponent 1. Attack or Heal.
* Round 2: Battle with Opponent 2.
* Round 3: Battle with your Boss, the Final Boss.
* If you defeat all 3 opponents before they take you down to 0 health, you win the game!

## Under the Hood
After deciding on how the game will work, I settled on 3 classes. "Person" is the first class and both the "Hero" and "Enemy" class extend from the "Person" class as both will share the same properties. Hero will have an additional property of "luck" which will be used to make the game easier/harder. Enemy has properties of "ugliness" which will determine if you take damage during your turn, and "rage" which if a higher number will make it more likely for the enemy to land a Critical Hit (works exactly the same as "luck" for the Hero). See below snippets of code from each class.
Now that I have my classes and have generated Getters and Setters to access the Hero and Enemy properties, I started to code the story and rounds of the game.

````javascript
public class Person {
    private int health = 100;
    private String name;
    private String tea;

    public Person(int health, String name, String tea) {
        this.health = health;
        this.name = name;
        this.tea = tea;
    } 

...

public class Hero extends Person{
    private int luck;

    public Hero(int health, String name, String tea, int luck) {
        super(health, name, tea);
        this.luck = luck;
    }

    ...

public class Enemy extends Person{
    private int ugliness;
    private int rage;

    public Enemy(int health, String name, String tea, int ugliness, int rage) {
        super(health, name, tea);
        this.ugliness = ugliness;
        this.rage = rage;
    }
````
To make the game more enjoyable, you cannot just immediately start battling opponents without some backstory. I start with lines upon lines of just setting the scene and taking the Hero player details. As I did not want all of the story text to be printed at once to the screen and wanted it to print at the same speed as the player could read the story, a 4th class called TypeWriter was created to print each character in the lines of text with a delay between each character. See below.

````javascript
public class TypeWriter {

    public static void type(String message) throws InterruptedException {
        // slowly print text
       for (char c: message.toCharArray()
             ) {
            System.out.print(c);
            Thread.sleep(10);
        }
        try
        {
            System.in.read();
        }
        catch(Exception e)
        {}
    }
}
````

At this point, the 3 enemies are initialized, the hero has been created, and it is time to start the battling. There are 3 rounds with a Hero turn and an Enemy turn. The Hero can Attack or Heal. Random number generators are compared to the luck, ugliness, and rage properties to determine if a Critical Hit is landed or if you take damage.
To keep the code as DRY as possible, methods for heroAttack(), heroHeal(), enemyAttack(), and enemyHeal() are added to classes Hero and Enemy.

Below is the code for the first round... and a snippet of code from the heroAttack method which uses a switch case to call the attacks of the correct opponent.
````javascript
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

...

public void heroAttack (Hero hero, Enemy enemy, int round) throws InterruptedException {
        int heroDamageRandom = (int) (Math.random() * (10) + 1);
        if (heroDamageRandom < hero.getLuck() && heroDamageRandom != 1) {
            if (round == 1) {
                TypeWriter.type("You throw a tapioca pearl right into their eye! That must have HURT to get hit by a small wet squishy sweet! You are feeling it today! Luck on your side!");
                enemy.setHealth(enemy.getHealth() - 30);
            } else if (round == 2) {
                TypeWriter.type("You hold up a mirror and reflect his ugliness back at him and he gets an EYE FULL! So rare to pull that move off! Mega Lucky!");
                enemy.setHealth(enemy.getHealth() - 30);
            } else if (round == 3 && hero.getNumberOfTeas() > 0) {
                TypeWriter.type("Oh no you didn't!! You throw one of your " + hero.getNumberOfTeas() + " Bubble Teas and clock him right in the face! Massive damage!!");
                hero.setNumberOfTeas(hero.getNumberOfTeas() - 1);
                enemy.setHealth(enemy.getHealth() - 30);
            } else {
                TypeWriter.type("Oh no!! You try to throw another tea at him but you are out! You KNEW you should have bought more!");
            }
        } else if (heroDamageRandom > 1) {
            int heroRandomAttack = (int) (Math.random() * (3) + 1);

            if (heroRandomAttack == 1) {
                switch (round) {
                    case 1: TypeWriter.type("You shove the straw up your their nose! Savage!!!");
                    break;
                    case 2: TypeWriter.type("You toss your tea up in the air! Your opponent jumps up to catch it and you slap the Bejesus out of him and safely catch your delicious beverage! You would have thought he would have remembered your signature move (you do this a lot)");
                    break;
                    case 3: TypeWriter.type("You charge the man and CLOTHES LINE him! Lands flat on his back on the hard pavement.");
                    break;
                    default: break;
                } 

...
````

## Download the code and play! Much of this game is an inside joke between myself and my coworkers and I found it very enjoyable to say the least :) 
