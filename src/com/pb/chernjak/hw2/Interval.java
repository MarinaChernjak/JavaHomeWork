package com.pb.chernjak.hw2;

import java.util.Scanner;

public class Interval {
    public static void main(String[] args) {
        int x;
        Scanner scan = new Scanner(System.in);

        System.out.println("Начинаем! Следуйте, пожалуйста, подсказкам!");
        System.out.print("Введите любое целое число : ");
        x = scan.nextInt();
        if ( (x >= 0) && (x <= 14) ) {
            System.out.println("Число " + x + " попадает в промежуток [ 0 - 14 ]");
        } else if ( (x >= 15) && (x <= 35) ) {
            System.out.println("Число " + x + " попадает в промежуток [ 15 - 35 ]");
        } else if ( (x >= 36) && (x <= 50) ) {
            System.out.println("Число " + x + " попадает в промежуток [ 36 - 50 ]");
        } else if ( (x >= 51) && (x <= 100) ) {
            System.out.println("Число " + x + " попадает в промежуток [ 51 - 100 ]");
        } else {
            System.out.println("Число " + x + " не попадает ни в один из указанных промежутков.");
        }
    }
}

