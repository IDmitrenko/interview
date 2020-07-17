package ru.geekbrains.interview.homework1.homework12;

public class Lorry extends Car implements Moveable, Stopable {

    @Override
    public void move() {
        System.out.println("Car is moving");
    }

    @Override
    public void stop() {
        System.out.println("Car is stop");
    }

    @Override
    public void open() {
        System.out.println("Car is open");
    }
}
