package com.pb.chernjak.hw7;

public class Atelier {

    static void dressMan(Clothes[] clothes) {
        System.out.println("Мужская одежда:");
        for (Clothes cloth : clothes) {
            if (cloth instanceof ManClothes) {
                ((ManClothes) cloth).dressMan();
            }
        }
    }

    static void dressWomen(Clothes[] clothes) {
        System.out.println("Женская одежда:");
        for (Clothes cloth : clothes) {
            if (cloth instanceof WomenClothes) {
                ((WomenClothes) cloth).dressWomen();
            }
        }
    }

    public static void main(String[] args) {

        Tshirt tshirt = new Tshirt(Size.XS, 100, "красный");
        Skirt skirt = new Skirt(Size.S, 150, "белый");
        Pants pants = new Pants(Size.L, 200, "черный");
        Tie tie = new Tie(Size.XXS, 25, "синий");

        Clothes[] clothes = new Clothes[] { tshirt, skirt, pants, tie };

        dressMan(clothes);
        dressWomen(clothes);
    }
}
