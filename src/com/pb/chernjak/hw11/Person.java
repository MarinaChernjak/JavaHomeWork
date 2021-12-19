package com.pb.chernjak.hw11;

import java.time.LocalDate;
import java.util.ArrayList;

public class Person implements Comparable<Person>{

    private String name;
    private String address;
    private LocalDate dateOfBirth;
    private ArrayList<String> phones;
    private String modifyTime;

    public Person() {
        this.name = "";
        this.address = "";
        this.dateOfBirth = LocalDate.now();
        this.phones = new ArrayList<>();
        this.modifyTime = "";
    }

    public Person(String name, String address, LocalDate dateOfBirth, ArrayList<String> phones, String modifyTime) {
        this.name = name;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
        this.phones = phones;
        this.modifyTime = modifyTime;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public ArrayList<String> getPhones() {
        return phones;
    }

    public String getModifyTime() {
        return modifyTime;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setPhones(ArrayList<String> phones) {
        this.phones = phones;
    }

    public void setModifyTime(String modifyTime) {
        this.modifyTime = modifyTime;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", phones=" + phones +
                '}';
    }

    @Override
    public int compareTo(Person o) {
        return 0;
    }
}
