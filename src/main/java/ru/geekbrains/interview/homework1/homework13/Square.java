package ru.geekbrains.interview.homework1.homework13;

public class Square extends Figure {

    private int side;

    public Square(int side) {
        this.side = side;
    }

    @Override
    public double area() {
        return side*side;
    }

    @Override
    public void printArea() {
        System.out.println("Площадь квадрата = " + area());
    }
}
