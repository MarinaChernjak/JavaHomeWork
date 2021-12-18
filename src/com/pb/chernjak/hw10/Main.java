package com.pb.chernjak.hw10;

public class Main {

    public static void main(String[] args) {
        System.out.println("Массив с элементами типа Integer:");
        NumBox<Integer> box1 = new NumBox<>(5);
        try {
            box1.add(-5);
            box1.add(0);
            box1.add(3);
            box1.add(7);
            box1.add(9);
            box1.add(101);
            System.out.println("Текущее количество элементов: " + box1.length());
            System.out.println("Сумма всех элементов: " + box1.sum());
            System.out.println("Среднее арифметическое элементов: " + box1.average());
            System.out.println("Максимальный элемент: " + box1.max());

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println();
        System.out.println("Массив с элементами типа Float:");
        System.out.println("------------------------------");
        NumBox<Float> box2 = new NumBox<>(3);
        box2.add(1.2f);
        box2.add(0f);
        box2.add(-5f);
        System.out.println("Текущее количество элементов: " + box2.length());
        System.out.println("Сумма всех элементов: " + box2.sum());
        System.out.println("Среднее арифметическое элементов: " + box2.average());
        System.out.println("Максимальный элемент: " + box2.max());
    }
}
