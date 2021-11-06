package com.pb.chernjak.hw6;

import java.lang.reflect.Constructor;

public class VetClinic {
    public static void main(String[] args) throws Exception {
        Animal[] animals = new Animal[8];
        animals[0] = new Cat("Васька", "молоко", "милый дом", 3);
        animals[1] = new Dog("Барбос", "сахарная косточка", "будка", "дружеское");
        animals[2] = new Horse("Конек-Горбунок", "сказочное сено", "сказка Пушкина", "Иванушка");
        animals[3] = new Cat("Васька", "молоко", "милый дом", 3);
        animals[4] = new Cat("Маська", "просекко", "Бар \"Овечка Долли\"", 333);
        animals[5] = new Dog("Неповторимый", "лакомство", "Вилла \"Ривьера\"", "выше всяких похвал");
        animals[6] = new Dog("Барбос", "сахарная косточка", "будка", "дружеское");
        animals[7] = new Horse("Конек-Горбунок", "сказочное сено", "сказка Пушкина", "Иванушка");

        System.out.println("На нашей ферме Вас рады приветствовать : ");
        System.out.println("**********************************");
        for (Animal animal : animals) {
            System.out.println(animal.toString());
        }

        Class vet = Class.forName("com.pb.chernjak.hw6.Veterinarian");

        Constructor constr = vet.getConstructor();
        Object obj = constr.newInstance();

        System.out.println("**********************************");
        System.out.println();
        System.out.println("Прием ведет ветеринар Айболит");
        int i = 0;
        if (obj instanceof Veterinarian) {
            for (Animal animal : animals) {
                System.out.println("----------------------------");
                System.out.println(++i + ". На прием пришел : " + animal.getName());
                System.out.println();
                ((Veterinarian) obj).treatAnimal(animal);
            }
        }
        System.out.println("---------------------");
        if (animals[0].equals(animals[3])) {
            System.out.println("Животное " + animals[0].getName() + " является клоном животного " + animals[3].getName());
        }
        else {
            System.out.println("Животное " + animals[0].getName() + " НЕ является клоном животного " + animals[3].getName());
        }
        System.out.println("---------------------");
        if (animals[3].equals(animals[4])) {
            System.out.println("Животное " + animals[3].getName() + " является клоном животного " + animals[4].getName());
        }
        else {
            System.out.println("Животное " + animals[3].getName() + " НЕ является клоном животного " + animals[4].getName());
        }
        System.out.println("---------------------");
        if (animals[2].equals(animals[7])) {
            System.out.println("Животное " + animals[2].getName() + " является клоном животного " + animals[7].getName());
        }
        else {
            System.out.println("Животное " + animals[2].getName() + " НЕ является клоном животного " + animals[7].getName());
        }

    }
}
