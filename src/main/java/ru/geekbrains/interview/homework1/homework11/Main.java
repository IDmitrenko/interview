package ru.geekbrains.interview.homework1.homework11;

public class Main {
    public static void main(String[] args) {
        Person person = Person.builder()
                .firstName("Igor")
                .lastName("Dmitrenko")
                .middleName("Dias")
                .address("Moscow")
                .age(55)
                .country("Russia")
                .gender("M")
                .phone("112233")
                .build();

        System.out.println(person);
    }
}
