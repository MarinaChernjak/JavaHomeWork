package com.pb.chernjak.hw7;

public class Tshirt extends Clothes implements ManClothes, WomenClothes{

    private static final String name = "футболка";

    public Tshirt(Size size, double cost, String color) {
        super(size, cost, color);
    }

    @Override
    public void dressMan() {
        System.out.println("Наименование : мужская " + name 
                + ", размер : " + getSizeInfo()
                + ", стоимость : " + getCost() 
                + ", цвет : " + getColor());
    }
    
    @Override
    public void dressWomen() {
        System.out.println("Наименование : женская " + name
                + ", размер : " + getSizeInfo()
                + ", стоимость : " + getCost()
                + ", цвет : " + getColor());
    }
}
