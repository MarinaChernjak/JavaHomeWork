package com.pb.chernjak.hw6;

import java.util.Objects;

public class Cat extends Animal{

    private int countBreakToysNY;

    public int getCountBreakToysNY() {
        return countBreakToysNY;
    }

    public void setCountBreakToysNY(int countBreakToysNY) {
        this.countBreakToysNY = countBreakToysNY;
    }

    public Cat(String name, String food, String location, int countBreakToysNY) {
        super(name, food, location);
        this.countBreakToysNY = countBreakToysNY;
    }

    public Cat(String name, String food, String location) {
        super(name, food, location);
    }

    @Override
    public void eat() {
        System.out.println(getName() + " очень любит " + getFood());
    }

    @Override
    public String getName() {
        return "Кот " + super.getName();
    }

    @Override
    public void makeNoise() {
        super.makeNoise();
        System.out.println("Мяу-мяу ... мурррр...");
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getFood(), getLocation(), getCountBreakToysNY());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (this == null || this.getClass() != obj.getClass())
            return false;
        Cat cat = (Cat) obj;
        return getName().equals(cat.getName()) &&
               getLocation().equals(cat.getLocation()) &&
               getFood().equals(cat.getFood()) &&
               getCountBreakToysNY() == cat.getCountBreakToysNY();
    }

    @Override
    public String toString() {
        return "Животное " + getName() + " : пища - " + getFood() + ", среда обитания - " + getLocation() + ", количество разбитых игрушек на Новый Год - " +
                getCountBreakToysNY();
    }
}
