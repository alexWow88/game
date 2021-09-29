package com.company;

public class Person {
    public int health = 100;
    public String name;
    public String tea;

    public Person(int health, String name, String tea) {
        this.health = health;
        this.name = name;
        this.tea = tea;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTea() {
        return tea;
    }

    public void setTea(String tea) {
        this.tea = tea;
    }
}
