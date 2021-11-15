package com.pb.chernjak.hw7;

public class Tie extends Clothes implements ManClothes{

    private static final String name = "галстук";

    public Tie(Size size, double cost, String color) {
        super(size, cost, color);
    }

    @Override
    public void dressMan() {
        System.out.println("Наименование : мужской " + name
                + ", размер : " + getSizeInfo()
                + ", стоимость : " + getCost()
                + ", цвет : " + getColor());
    }
}
