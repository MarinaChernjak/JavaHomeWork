package com.pb.chernjak.hw11;

public class Person implements Comparable<Person>{

    private String name;
    private String address;
    private String dateOfBirth;
    private String phones;
    private String modifyTime;

    public Person() {
        this.name = "";
        this.address = "";
        this.dateOfBirth = "";
        this.phones = "";
        this.modifyTime = "";
    }

    public Person(String name, String address, String dateOfBirth, String phones, String modifyTime) {
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

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getPhones() {
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

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setPhones(String phones) {
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
