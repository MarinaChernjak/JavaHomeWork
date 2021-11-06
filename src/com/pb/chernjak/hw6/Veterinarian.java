package com.pb.chernjak.hw6;

public class Veterinarian {

    public void treatAnimal(Animal animal) {
        animal.eat();
        animal.sleep();
        animal.makeNoise();
        System.out.println(animal.getName() + " питается : " + animal.getFood());
        System.out.println(animal.getName() + " проживает в локации : " + animal.getLocation());
    }
}

