package com.pb.chernjak.hw6;

import java.util.Objects;

public class Dog extends Animal{

    private String frendly;

    public Dog(String name, String food, String location) {
        super(name, food, location);
    }

    public Dog(String name, String food, String location, String frendly) {
        super(name, food, location);
        this.frendly = frendly;
    }

    public String getFrendly() {
        return frendly;
    }

    public void setFrendly(String frendly) {
        this.frendly = frendly;
    }

    @Override
    public String getName() {
        return "Пес " + super.getName();
    }

    @Override
    public void makeNoise() {
        super.makeNoise();
        System.out.println("Гав-Гав");
    }

    @Override
    public void eat() {
        super.eat();
        System.out.println(getName() + " НО очень любит мяско)");
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || this.getClass() != obj.getClass())
            return false;
        Dog dog = (Dog) obj;
        return  getName().equals(getName()) &&
                getFood().equals(dog.getFood()) &&
                getLocation().equals(getLocation()) &&
                getFrendly().equals(dog.getFrendly());
    }

    @Override
    public String toString() {
        return "Животное " + getName() + " : пища - " + getFood() + ", среда обитания - " + getLocation() + ", отношение к хозяину - " + getFrendly();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getFood(), getLocation(), getFrendly());
    }
}
