package com.company;

public class Hero extends Person{
    private int luck;
    private int numberOfTeas;

    public Hero(int health, String name, String tea, int luck, int numberOfTeas) {
        super(health, name, tea);
        this.luck = luck;
        this.numberOfTeas = numberOfTeas;
    }

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
            } else if (heroRandomAttack == 2) {
                switch (round) {
                    case 1: TypeWriter.type("You pull out some mom jokes and MAN did they hurt! They are down on one knee from the pain!");
                    break;
                    case 2: TypeWriter.type("You land some well placed ice cube throws right in their kidneys! ");
                    break;
                    case 3: TypeWriter.type("You threaten to sabotage the team project to miss the client deadline! You thought it would hurt more but it turns out you are not that important to the team anyway..dang..");
                    break;
                    default: break;
                }
            } else {
                TypeWriter.type("You whip your hair back and forth and slap well conditioned hair across your opponents ugly face");
            }
            enemy.setHealth(enemy.getHealth() - 20);
        } else {
            switch (round) {
                case 1: TypeWriter.type("You mistakenly punch yourself in the face! Pathetic!");
                break;
                case 2: TypeWriter.type("You decide to throw a punch but you forget to actually throw it! Leaving yourself wide open for a quick 1-2 slap!");
                break;
                case 3: TypeWriter.type("You throw a punch but this dude has been going to the gym. You feel your wrist fracture when you hit his rock hard stomach..and you make a mental note to rewatch 300 and Magic Mike");
                break;
                default: break;
            }
            hero.setHealth(hero.getHealth() - 10);
            if (hero.getHealth() < 0) {
                hero.setHealth(0);
            }
            TypeWriter.type("You are down to " + hero.getHealth() + " health");
        }
        if (enemy.getHealth() < 0) {
            enemy.setHealth(0);
        }
        if (enemy.getHealth() > 0) {
            TypeWriter.type("Enemy has " + enemy.getHealth() + " health left.");
        } else {
            TypeWriter.type("Enemy has 0 health left and lie in a puddle of bubble tea!");
            TypeWriter.type(" ");
            TypeWriter.type("You win!");
            if (round == 3) {
                TypeWriter.type(" ");
                TypeWriter.type("You are victorious on this day and take a selfie on the ground with all the victims of this battle. You stroll off to work as if you still have a job with your " + numberOfTeas + " Bubble Teas");
                TypeWriter.type(" ");
                TypeWriter.type("Thanks for playing!!!!");
            }
        }
    }

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

    public int getNumberOfTeas() {
        return numberOfTeas;
    }

    public void setNumberOfTeas(int numberOfTeas) {
        this.numberOfTeas = numberOfTeas;
    }
}
