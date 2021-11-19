package com.pb.chernjak.hw8;

import java.util.Scanner;

public class OnlineShop {

    public static void main(String[] args) {
        Auth user = new Auth();
        Scanner scanner = new Scanner(System.in);
        boolean registered = false;

        System.out.println("Зарегистрируйтесь, пожалуйста!");
        while (!registered) {
            System.out.println("Login (может содержать от 5 до 20 символов: латинские буквы и цифры) : ");
            String login = scanner.nextLine();
            System.out.println("Password (может содержать от 5 символов: латинские буквы, цифры, символ подчеркивания) : ");
            String password = scanner.nextLine();
            System.out.println("Подтвердите ввод пароля : ");
            String confirmPassword = scanner.nextLine();
            try {
                user.signUp(login, password, confirmPassword);
                registered = true;
            } catch (WrongLoginException e) {
                System.out.println("Неверный Login: " + e.getMessage());
                System.out.println("Повторите регистрацию");
            } catch (WrongPasswordException e) {
                System.out.println("Неверный Password: " + e.getMessage());
                System.out.println("Повторите регистрацию");
            }
        }
        System.out.println("Вы успешно зарегистрированы!\n");

        System.out.println("Войдите на сайт.");
        int i = 3;
        while (i > 0) {
            System.out.println("Введите Login : ");
            String login = scanner.nextLine();
            System.out.println("Введите Password : ");
            String password = scanner.nextLine();
            try {
                user.signIn(login, password);
                break;
            } catch (Exception e) {
                System.out.println("Данные введены не верно. Повторите попытку входа!");
            }
            i--;
        }
        if (i == 0) {
            System.out.println("Вы использовали попытки входа, повторите попытку через 3 часа!");
        } else
            System.out.println("Вы успешно вошли на сайт!");
    }
}
