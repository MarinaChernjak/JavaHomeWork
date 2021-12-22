package com.pb.chernjak.hw11;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.BufferedWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {

    private static final String PHONEBOOK_FILE_PATH = "files/phonebook.json";

    static class NameTester implements Predicate<Person> {
        private final String name;
        public NameTester(String name) {
            this.name = name;
        }
        @Override
        public boolean test(Person person) {
            return name.equals(person.getName());
        }
    }

    public static int FindContact(List<Person> persons, String name) {
        for (int i = 0; i < persons.size(); i++) {
            if (name.equals(persons.get(i).getName())) {
                return i;
            }
        }
        return -1;
    }

    public static ArrayList<String> ScanPhones(Scanner scan) {
        ArrayList<String> phones = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            String scanPhone = scan.next();
            if (scanPhone.equals("0")) {
                return phones;
            }
            phones.add(scanPhone);
        }
        return phones;
    }

    static class PersonNameComparator implements Comparator<Person> {
        @Override
        public int compare(Person a, Person b) {
            return a.getName().compareTo(b.getName());
        }
    }

    public static void main(String[] args) throws JsonProcessingException {

        List<Person> persons = new ArrayList<>();
        Scanner scan = new Scanner(System.in);
        boolean flag = true;

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

        JavaTimeModule module = new JavaTimeModule();
        objectMapper.registerModule(module);

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
        System.out.println(" 6 - вывести все элементы");
        System.out.println(" 0 - завершить работу с телефонной книгой");
        String scanName;
        String scanAddress;
        String scanPhone;
        LocalDate scanDateOfBirth;
        String scanModifyTime;

        while (flag) {
            int option;
            System.out.print("Введите цифру, соответствующую нужной опции : ");
            try {
                option = scan.nextInt();
            } catch (Exception e) {
                System.out.println("Ошибка ввода нужной опции! Введите число от 0 до 5");
                scan.next();
                continue;
            }

            switch (option) {
                case 1:
                    System.out.println("Введите данные нового элемента:");
                    System.out.print("ФИО : ");
                    scanName = scan.next();

                    System.out.print("Адрес : ");
                    scanAddress = scan.next();

                    System.out.print("Дата рождения в формате год-месяц-день : ");
                    try {
                        scanDateOfBirth = LocalDate.parse(scan.next());
                    } catch (DateTimeParseException e) {
                        System.out.println("Ошибка ввода даты рождения : " + e.getMessage());
                        continue;
                    }

                    System.out.println("Введите номера телефонов (не более 5). Если номеров больше нет, введите 0:");
                    ArrayList<String> phones = ScanPhones(scan);

                    scanModifyTime = LocalDateTime.now().toString();

                    persons.add(new Person(scanName, scanAddress, scanDateOfBirth, phones, scanModifyTime));
                    break;

                case 2:
                    System.out.print("Введите ФИО элемента, который нужно удалить: ");
                    scanName = scan.next();
                    persons.removeIf(new NameTester(scanName));
                    break;

                case 3: {
                    System.out.println("Введите ФИО, чтобы найти контакт: ");
                    scanName = scan.next();
                    //Поиск с помощью StreamAPI
                    persons.stream()
                            .filter(new NameTester(scanName))
                            .forEach(System.out::println);
                    //Линейный посик в цикле
//                    int i = FindContact(persons, scanName);
//                    if (i < 0) {
//                        System.out.println("Контакт с указанным именем не найден.");
//                    } else {
//                        System.out.println(persons.get(i).toString());
//                    }

                    break;
                }

                case 4:
                    int parameter;
                    while (true) {
                        System.out.println("Выберите критерий сортировки:");
                        System.out.println("1 - сортировка по имени");
                        System.out.println("2 - сортировка по дате рождения");
                        try {
                            parameter = scan.nextInt();
                            if (parameter < 1 || parameter > 2) {
                                System.out.println("Ошибка ввода нужного параметра для сортировки! Введите число 1 или 2");
                                continue;
                            }
                            break;
                        } catch (Exception e) {
                            System.out.println("Ошибка ввода нужного параметра для сортировки! Введите число 1 или 2");
                            scan.next();
                        }
                    }
                    switch (parameter) {
                        case 1:
                            System.out.println("Контакты были отсортированы по ФИО: ");
                            //сортировка с помощью Comparator
//                            persons.sort(new PersonNameComparator());
                            //сортировка с помощью лямбда
//                            persons.sort(Comparator.comparing(p -> p.getName()));
                            //сортировка с помощью StreamAPI
                            persons = persons.stream()
                                    .sorted(Comparator.comparing(Person::getName))
                                    .collect(Collectors.toList());
                            break;
                        case 2:
                            System.out.println("Контакты были отсортированы по дате рождения: ");
                            //Сортировка с помощью Comparator
//                            persons.sort(new Comparator<Person>() {
//                                @Override
//                                public int compare(Person o1, Person o2) {
//                                    return o1.getDateOfBirth().compareTo(o2.getDateOfBirth());
//                                }
//                            });
                            //Сортировка с помощью лямбды
//                          persons.sort(Comparator.comparing(p -> p.getDateOfBirth()));
                            //Сортировка с помощью StreamAPI
                            persons = persons.stream()
                                    .sorted((o1, o2) -> o1.getDateOfBirth().compareTo(o2.getDateOfBirth()))
                                    .collect(Collectors.toList());

                            break;
                        default:
                            System.out.println("Нет возможности отсортировать по выбранному критерию.");
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
                        System.out.print("Дата рождения в формате год/месяц/день : ");
                        persons.get(i).setDateOfBirth(LocalDate.parse(scan.next()));
                        System.out.println("Введите номера телефонов (не более 5). Если номеров больше нет, введите 0 :");
                        persons.get(i).setPhones(ScanPhones(scan));
                        persons.get(i).setModifyTime(LocalDateTime.now().toString());
                    }
                    break;
                }
                case 6:
                    System.out.println("Список элементов телефонной книги:");
                    persons.stream()
                            .forEach(System.out::println);
                    break;
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
  