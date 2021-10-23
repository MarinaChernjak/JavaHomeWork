package com.pb.chernjak.hw3;

import java.util.Scanner;

public class Array {
    public static void main(String[] args) {
        int[] array = new int[10];
        Scanner element = new Scanner(System.in);

        for (int i = 0; i < array.length; ++i) {
            System.out.print("Введите " + (i + 1) + "-й элемент массива : ");
            array[i] = element.nextInt();
        }
        System.out.println("Введенный массив : ");
        for (int i = 0; i < array.length; ++i) {
            System.out.print(array[i] + "\t");
        }

        int sum = 0;
        int countPos = 0;
        for (int i = 0; i < array.length; ++i) {
            sum += array[i];
            if (array[i] > 0) {
                countPos++;
            }
        }
        System.out.print("\nСумма всех элементов массива : " + sum);
        System.out.print("\nКоличество положительных элементов массива : " + countPos);

        //Пузырьковая сортировка
        int tmp;
        for (int i = array.length - 1; i > 0; i=i-1) {
            for (int j = 0; j < i; j++) {
                if (array[j] > array[j+1]) {
                    tmp = array[j+1];
                    array[j+1] = array[j];
                    array[j] = tmp;
                }
            }
        }
        System.out.println("\nОтсортированный массив от меньшего к большему : ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "\t");
        }
    }
}

