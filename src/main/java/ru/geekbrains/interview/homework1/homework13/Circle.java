package ru.geekbrains.interview.homework1.homework13;

public class Circle extends Figure {

    private int radius;

    public Circle(int radius) {
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI*radius*radius;
    }

    @Override
    public void printArea() {
        System.out.println("Площадь круга = " + area());
    }
}
