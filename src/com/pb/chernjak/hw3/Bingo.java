package com.pb.chernjak.hw3;

import java.util.Scanner;

public class Bingo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int attempt = 0;

        System.out.println("Приветствую! В игре было загадано целое число в диапазоне от 0 до 100.");
        System.out.println("Попробуйте угадать загаданное число. Если захотите выйти, введите exit\n");

        int random = (int)(Math.random()*101);
//        System.out.println(random);

        int inputNum;
        do {
            attempt++;
            System.out.print("Попытка № " + attempt + " : ");

            String x = scanner.next();
            if (x.equals("exit")) {
                System.out.println("Вы не захотели продолжать игру! Game Over");
                return;
            }

            inputNum = Integer.parseInt(x);
            if (inputNum < random) {
                System.out.println("Введенное число меньше загаданного");
            } else if (inputNum > random) {
                System.out.println("Введенное число больше загаданного");
            }
        }
        while (inputNum != random);
        System.out.println("Bingo !!! Число " + random + " угадано с " + attempt + "-й попытки!");
    }
}
