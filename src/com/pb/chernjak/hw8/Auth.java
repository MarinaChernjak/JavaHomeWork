package com.pb.chernjak.hw8;

public class Auth {

    private String login;
    private String password;

    public void signUp(String login, String password, String confirmPassword)
            throws WrongLoginException, WrongPasswordException {
        if (!login.matches("[a-zA-Z0-9]{5,20}")) {
            throw new WrongLoginException("Login должен содержать от 5 до 20 символов: латинские буквы или цифры");
        }
        if (!password.matches("[a-zA-Z0-9_]{5,}")) {
            throw new WrongPasswordException("Password должен содержать от 5 символов: латинские буквы, цифры или символ подчеркивания");
        }
        if (!password.equals(confirmPassword)) {
            throw new WrongPasswordException("Password не совпадает с ConfirmPassword");
        }
        this.login = login;
        this.password = password;
    }

    public void signIn(String login, String password)
            throws WrongLoginException, WrongPasswordException {
        if (!this.login.equals(login)) {
            throw new WrongLoginException();
        }
        if (!this.password.equals(password)) {
            throw new WrongPasswordException();
        }
    }
}
