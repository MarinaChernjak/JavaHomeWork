package com.pb.chernjak.hw7;

public abstract class Clothes {

    private Size size;
    private double cost;
    private String color;

    public Clothes(Size size, double cost, String color) {
        this.size = size;
        this.cost = cost;
        this.color = color;
    }

    public Size getSize() {
        return size;
    }

    public double getCost() {
        return cost;
    }

    public String getColor() {
        return color;
    }

    protected String getSizeInfo() {
        return getSize() + " (" + getSize().getDescription() + ", евро: " + getSize().getEuroSize() + ")";
    }
}
