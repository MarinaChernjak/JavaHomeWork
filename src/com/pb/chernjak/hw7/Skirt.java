package com.pb.chernjak.hw7;

public class Skirt extends Clothes implements WomenClothes {

    private static final String name = "юбка";

    public Skirt(Size size, double cost, String color) {
        super(size, cost, color);
    }

    @Override
    public void dressWomen() {
        System.out.println("Наименование : женская " + name
                + ", размер : " + getSizeInfo()
                + ", стоимость : " + getCost()
                + ", цвет : " + getColor());
    }

}
