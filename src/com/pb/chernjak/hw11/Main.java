package com.pb.chernjak.hw11;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.core.type.TypeReference;

import java.io.BufferedWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
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

    static int FindContact(List<Person> persons, String name) {
        for (int i = 0; i < persons.size(); i++) {
            if (name.equals(persons.get(i).getName())) {
                return i;
            }
        }
        return -1;
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
        System.out.println(" 5 - редактирование элемента");
        System.out.println(" 0 - завершить работу с телефонной книгой");
        String scanName;
        String scanAddress;
        String scanPhone;
        String scanDateOfBirth;
        String scanModifyTime;

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
                    System.out.print("Дата рождения в формате год/месяц/день : ");
                    scanDateOfBirth = scan.next();
                    scanModifyTime = LocalDateTime.now().toString();
                    persons.add(new Person(scanName, scanAddress, scanDateOfBirth, scanPhone, scanModifyTime));
                    break;
                case 2:
                    System.out.print("Введите ФИО элемента, который нужно удалить: ");
                    scanName = scan.next();
                    persons.removeIf(new NameTester(scanName));
                    break;
                case 3: {
                    System.out.println("Введите ФИО, чтобы найти контакт: ");
                    scanName = scan.next();
                    int i = FindContact(persons, scanName);
                    if (i < 0) {
                        System.out.println("Контакт с указанным именем не найден.");
                    } else {
                        System.out.println(persons.get(i).toString());
                    }
                    break;
                }
                case 4:
                    System.out.println("Выберите критерий сортировки:");
                    System.out.println("1 - сортировка по имени");
                    System.out.println("2 - сортировка по дате рождения");
                    int parametr = scan.nextInt();
                    switch (parametr) {
                        case 1:
                            System.out.println("Контакты были отсортированы по ФИО: ");
                            persons.sort(Comparator.comparing(p -> p.getName()));
                            break;
                        case 2:
                            System.out.println("Контакты были отсортированы по дате рождения: ");
                            persons.sort(Comparator.comparing(p -> p.getDateOfBirth()));
                            break;
                        default:
                            break;
                    }
                    break;
                case 5: {
                    System.out.println("Введите элемент, который нужно отредактировать (ФИО) : ");
                    scanName = scan.next();
                    int i = FindContact(persons, scanName);
                    if (i < 0) {
                        System.out.println("Контакт с указанным именем не найден.");
                    } else {
                        System.out.println("Введите новые данные редактируемого элемента :");
                        System.out.print("ФИО : ");
                        persons.get(i).setName(scan.next());
                        System.out.print("Адрес : ");
                        persons.get(i).setAddress(scan.next());
                        System.out.print("Телефон : ");
                        persons.get(i).setPhones(scan.next());
                        System.out.print("Дата рождения в формате год/месяц/день : ");
                        persons.get(i).setDateOfBirth(scan.next());
                        persons.get(i).setModifyTime(LocalDateTime.now().toString());
                    }
                    break;
                }
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
  