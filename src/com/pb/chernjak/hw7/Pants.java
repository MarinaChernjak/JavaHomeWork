package com.pb.chernjak.hw7;

public class Pants extends Clothes implements ManClothes, WomenClothes {

    private static final String name = "штаны";

    public Pants(Size size, double cost, String color) {
        super(size, cost, color);
    }

    @Override
    public void dressMan() {
        System.out.println("Наименование : мужские " + name
                            + ", размер : " + getSizeInfo()
                            + ", цвет : " + getColor());
    }

    @Override
    public void dressWomen() {
        System.out.println("Наименование : женские " + name
                + ", размер : " + getSizeInfo()
                + ", цвет : " + getColor());
    }
}
