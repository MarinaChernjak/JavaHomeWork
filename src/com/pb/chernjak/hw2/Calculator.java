package com.pb.chernjak.hw2;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        int operand1, operand2;
        float result;
        String sign;
        Scanner scan = new Scanner(System.in);

        System.out.println("Приветствую! Следуйте, пожалуста, подсказкам.");
        System.out.print("Введите 1-й операнд (целое число) : ");
        operand1 = scan.nextInt();
        System.out.print("Введите 2-й операнд (целое число) : ");
        operand2 = scan.nextInt();
        System.out.print("Введите операцию (+, -, * , /) : ");
        sign = scan.next();

        switch (sign) {
            case ("+"):
                result = operand1 + operand2;
                System.out.print("Результат выполнения операции : " + operand1 + " + " + operand2 + " = " + result);
                break;
            case ("-"):
                result = operand1 - operand2;
                System.out.print("Результат выполнения операции : " + operand1 + " - " + operand2 + " = " + result);
                break;
            case ("*"):
                result = operand1 * operand2;
                System.out.print("Результат выполнения операции : " + operand1 + " * " + operand2 + " = " + result);
                break;
            case ("/"):
                if (operand2 == 0) {
                    System.out.println("Деление на 0 заперщено! Пожалуйста, поменяйте 2-й операнд");
                } else {
                    result = (float)operand1 / operand2;
                    System.out.print("Результат выполнения операции : " + operand1 + " / " + operand2 + " = " + result);
                    break;
                }


        }
    }
}
