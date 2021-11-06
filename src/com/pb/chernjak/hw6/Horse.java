package com.pb.chernjak.hw6;

import java.util.Objects;

public class Horse extends Animal{

    private String horseMan;

    public Horse(String name, String food, String location, String horseMan) {
        super(name, food, location);
        this.horseMan = horseMan;
    }

    public Horse(String name, String food, String location) {
        super(name, food, location);
    }

    @Override
    public String getName() {
        return "Лошадь " + super.getName();
    }

    @Override
    public void makeNoise() {
        super.makeNoise();
        System.out.println("И-го-го!");
    }

    @Override
    public void eat() {
        System.out.println(getName() + " жует " + getFood());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getFood(), getLocation(), getHorseMan());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (this == null || this.getClass() != obj.getClass())
            return false;
        Horse horse = (Horse) obj;
        return  getName().equals(horse.getName()) &&
                getFood().equals(horse.getFood()) &&
                getLocation().equals(horse.getLocation()) &&
                getHorseMan().equals(getHorseMan());
    }

    public String getHorseMan() {
        return horseMan;
    }

    public void setHorseMan(String horseMan) {
        this.horseMan = horseMan;
    }

    @Override
    public String toString() {
        return "Животное " + getName() + " : пища - " + getFood() + ", среда обитания - " + getLocation() + ", наездник - "
                + getHorseMan();
    }
}
