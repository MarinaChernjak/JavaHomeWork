package com.pb.chernjak.hw4;

import java.util.Arrays;
import java.util.Scanner;

public class Anagram {

    public static String sortChars(String input){
        char[] chars = input.toCharArray();
        Arrays.sort(chars);
        String sortChars = new String(chars);
        return sortChars;
    }

    public static String removePunktuation(String input){
        String outputStr = input.replaceAll("\\p{Punct}|\\s", "");
        return outputStr;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Игра \"Анаграмма\". Следуйте подсказкам на экране(ввод возможен кириллицей или латиницей).");
        System.out.println("Введите первую строку : ");
        String input1 = scanner.nextLine();
        System.out.println("Введите вторую строку : ");
        String input2 = scanner.nextLine();
        String sort1 = sortChars(removePunktuation(input1.toLowerCase()));
        String sort2 = sortChars(removePunktuation(input2.toLowerCase()));
        if (sort1.equals(sort2)) {
            System.out.println("Введенные выражения являются Анаграммой");
        } else {
            System.out.println("Введенные выражения НЕ являются Анаграммой");
        }
    }
}
