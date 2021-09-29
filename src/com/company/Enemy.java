package com.company;

public class Enemy extends Person{
    public int ugliness;
    public int rage;

    public Enemy(int health, String name, String tea, int ugliness, int rage) {
        super(health, name, tea);
        this.ugliness = ugliness;
        this.rage = rage;
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
