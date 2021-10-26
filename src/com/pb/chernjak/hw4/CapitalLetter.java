package com.pb.chernjak.hw4;

import java.util.Scanner;

public class CapitalLetter {

    public static String toCapitalLetters(String input) {
        String[] words = input.split(" ");
        StringBuffer outputStr = new StringBuffer();
        for (int i = 0; i < words.length; ++i) {
            String word = words[i];
            word = Character.toUpperCase(word.charAt(0)) + word.substring(1);
            outputStr.append(word).append(" ");
        }
        return outputStr.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите предложение : ");
        String inputStr = scanner.nextLine();
        System.out.println("Предложение, полученное после перевода в верхний регистр первых букв : ");
        System.out.println(toCapitalLetters(inputStr));
    }
}
