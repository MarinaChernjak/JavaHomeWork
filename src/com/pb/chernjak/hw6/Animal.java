package com.pb.chernjak.hw6;

public abstract class Animal {
    private String name;
    private String food;
    private String location;

    public Animal(String name, String food, String location) {
        this.name = name;
        this.food = food;
        this.location = location;
    }

    public String getFood() {
        return food;
    }

    public String getLocation() {
        return location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void makeNoise() {
        System.out.print(getName() + " издаeт звуки : ");
    }

    public void sleep() {
        System.out.println(getName() + " спит в локации : " + location);
    }

    public void eat() {
        System.out.println(getName() + " питается : " + food);
    }
}
