package ru.geekbrains.interview.homework2.homework22;

public class MainArray {
    public static void main(String[] args) {
        final int capacity = 1000000;

        MyArray<Integer> arr = new MyArray<>(10);
        arr.add(57);
        arr.add(908);
        arr.add(3);
        arr.add(8);
        arr.add(786);
        arr.add(15);
        System.out.println(arr);

        arr.add(3,67);
        System.out.println(arr);

        arr.remove(8);
        System.out.println(arr);

        long timeBegin = System.nanoTime();
        arr.linearSearch(15);
        System.out.println("Время линейного поиска - " + (System.nanoTime() - timeBegin) + "наносекунд");

        MySortedArray<Integer> sortArr = new MySortedArray<>();
        sortArr.add(57);
        sortArr.add(908);
        sortArr.add(3);
        sortArr.add(8);
        sortArr.add(786);
        sortArr.add(15);
        System.out.println(sortArr);

        sortArr.add(3, 67);
        System.out.println(sortArr);

        sortArr.remove(8);
        System.out.println(sortArr);

        timeBegin = System.nanoTime();
        sortArr.binarySearch(15);
        System.out.println("Время бинарного поиска - " + (System.nanoTime() - timeBegin) + "наносекунд");

        MyArray<Integer> arr1 = new MyArray(capacity);
        for (int i = 0; i < capacity; i++) {
            arr1.add((int)(Math.random()*1000));
        }

        System.out.println(arr1);

        timeBegin = System.currentTimeMillis();
        arr1.sortSelect();

        System.out.println("Время работы сортировки методом выбора - " +
                (System.currentTimeMillis() - timeBegin) + " милисекунд.");
        System.out.println(arr1);

        MyArray<Integer> arr2 = new MyArray(capacity);
        for (int i = 0; i < capacity; i++) {
            arr2.add((int)(Math.random()*100));
        }

        System.out.println(arr2);

        timeBegin = System.currentTimeMillis();
        arr2.sortInsert();

        System.out.println("Время работы сортировки методом вставки - " +
                (System.currentTimeMillis() - timeBegin) + " милисекунд.");
        System.out.println(arr2);

        MyArray<Integer> arr3 = new MyArray(capacity);
        for (int i = 0; i < capacity; i++) {
            arr3.add((int)(Math.random()*100));
        }

        System.out.println(arr3);

        timeBegin = System.currentTimeMillis();
        arr3.sortBubble();

        System.out.println("Время работы сортировки методом пузырька - " +
                (System.currentTimeMillis() - timeBegin) + " милисекунд.");
        System.out.println(arr3);

    }
}
