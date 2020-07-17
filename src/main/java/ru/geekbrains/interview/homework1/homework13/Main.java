package ru.geekbrains.interview.homework1.homework13;

public class Main {
    public static void main(String[] args) {
        Figure[] figure = new Figure[3];
        figure[0] = new Circle(4);
        figure[1] = new Square(5);
        figure[2] = new Triangle(3, 4);
        for (int i = 0; i < figure.length; i++) {
            figure[i].printArea();
        }
    }
}
