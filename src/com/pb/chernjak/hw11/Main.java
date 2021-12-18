package com.pb.chernjak.hw11;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.core.type.TypeReference;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.nio.CharBuffer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Predicate;

public class Main {

    private static final String PHONEBOOK_FILE_PATH = "files/phonebook.json";

    static class NameTester implements Predicate<Person> {
        private String name;
        public NameTester(String name) {
            this.name = name;
        }
        @Override
        public boolean test(Person person) {
            return name.equals(person.getName());
        }
    }

    public static void main(String[] args) throws JsonProcessingException {

        List<Person> persons = new ArrayList<>();
        Scanner scan = new Scanner(System.in);
        boolean flag = true;

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

        Path phoneBookPath = Paths.get(PHONEBOOK_FILE_PATH);
        try {
            persons = objectMapper.readValue(phoneBookPath.toFile(), new TypeReference<List<Person>>() {});
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("В Телефонной книге доступны средующие опции:");
        System.out.println(" 1 - добавление элемента");
        System.out.println(" 2 - удаление элемента");
        System.out.println(" 3 - поиск элемента");
        System.out.println(" 4 - сортировка элементов");
        System.out.println(" 0 - завершить работу с телефонной книгой");
        String scanName;
        String scanAddress;
        String scanPhone;
        String scanDateOfBirth;
        while (flag) {
            System.out.print("Введите цифру, соответствующую нужной опции : ");
            int option = scan.nextInt();

            switch (option) {
                case 1:
                    System.out.println("Введите данные нового элемента:");
                    System.out.print("ФИО : ");
                    scanName = scan.next();
                    System.out.print("Адрес : ");
                    scanAddress = scan.next();
                    System.out.print("Телефон : ");
                    scanPhone = scan.next();
                    System.out.print("Дата рождения : ");
                    scanDateOfBirth = scan.next();
                    persons.add(new Person(scanName, scanAddress, scanDateOfBirth, scanPhone, ""));
                    break;
                case 2:
                    System.out.print("Введите ФИО элемента, который нужно удалить: ");
                    scanName = scan.next();
                    persons.removeIf(new NameTester(scanName));
                    break;
                case 3:
                    System.out.println("Введите ФИО, чтобы найти контакт: ");
                    scanName = scan.next();
                    for (int i=0; i < persons.size(); i++) {
                        if (scanName.equals(persons.get(i).getName())) {
                            String json = objectMapper.writeValueAsString(persons);
                            System.out.println(json);
                            continue;
                        }
                    }
                    break;
                case 4:
                    System.out.println("Контакты были отсортированы по ФИО: ");
                    persons.sort(Comparator.comparing(p -> p.getName()));
                case 0:
                    flag = false;
                    System.out.println("Завершение работы");
                    break;
                default:
                    System.out.println("Введите цифры от 1 до 5, если хотите работать с Телефонной книгой");
            }
        }

        String json = objectMapper.writeValueAsString(persons);
        System.out.println(json);

        try (BufferedWriter writer = Files.newBufferedWriter(phoneBookPath)) {
            writer.write(json);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
  