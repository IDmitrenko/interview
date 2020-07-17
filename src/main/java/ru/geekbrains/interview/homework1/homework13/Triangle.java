package ru.geekbrains.interview.homework1.homework13;

public class Triangle extends Figure {

    private int height, footing;

    public Triangle(int height, int footing) {
        this.height = height;
        this.footing = footing;
    }

    @Override
    public double area() {
        return height*footing/2;
    }

    @Override
    public void printArea() {
        System.out.println("Площадь треугольника = " + area());
    }
}
