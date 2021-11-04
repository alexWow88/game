package com.company;

public class Enemy extends Person{
    private int ugliness;
    private int rage;

    public Enemy(int health, String name, String tea, int ugliness, int rage) {
        super(health, name, tea);
        this.ugliness = ugliness;
        this.rage = rage;
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
