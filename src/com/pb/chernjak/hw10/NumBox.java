package com.pb.chernjak.hw10;

public class NumBox<T extends Number> {

    private T[] numbers;
    private int size;

    public NumBox(int maxsize) {
        this.size = 0;
        this.numbers = (T[]) new Number[maxsize];
    }

    public void add(T num) {
        if (size >= numbers.length) {
             throw new IndexOutOfBoundsException("Достигнуто максимальное количество элементов: " + numbers.length);
        }
        numbers[size++] = num;
    }

    public T get(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Нет элемента с заданным индексом: " + index +
                    ", количество элементов: " + size);
        }
        return numbers[index];
    }

    public int length() {
        return size;
    }

    public double sum() {
        double sum = 0;
        for (int i = 0; i < size; ++i) {
            sum += numbers[i].doubleValue();
        }
        return sum;
    }

    public double average() {
        return sum() / size;
    }

    public T max() {
        double max = Double.MIN_VALUE;
        int maxIndex = 0;
        for (int i = 0; i < size; ++i) {
            if (max < numbers[i].doubleValue()) {
                max = numbers[i].doubleValue();
                maxIndex = i;
            }
        }
        return numbers[maxIndex];
    }
}
