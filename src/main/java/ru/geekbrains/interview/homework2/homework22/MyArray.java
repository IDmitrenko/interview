package ru.geekbrains.interview.homework2.homework22;

public class MyArray<T extends Comparable> {
    private T[] array;
    private final int DEFAULT_CAPACITY = 10;
    private final int CAPACITY_MAX = 2000000000;
    private int cardinality = 0;
    private int capacity;

    public MyArray(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Количество элементов массива должно находиться в пределах " +
                    "0<количество<" + CAPACITY_MAX + ". Задано " + capacity);
        } else {
            array = (T[]) new Comparable[capacity];
            this.capacity = capacity;
        }
    }

    public MyArray() {
        array = (T[]) new Comparable[DEFAULT_CAPACITY];
        this.capacity = DEFAULT_CAPACITY;
    }

    public void add(T item) {
        if (cardinality < capacity) {
            array[cardinality] = item;
            cardinality++;
        } else {
            throw new ArrayIndexOutOfBoundsException("Нет свободных элементов в массиве для добавления данных!");
        }
    }

    public void add(int index, T item) {
        if (index > capacity || index > cardinality) {
            index = cardinality;
        }
        if (index < 0)
            index = 0;
        if (cardinality < capacity) {
            for (int i = cardinality; i > index; i--) {
                array[i] = array[i - 1];
            }
            array[index] = item;
            cardinality++;
        } else {
            throw new ArrayIndexOutOfBoundsException("Нет свободных элементов в массиве для добавления данных!");
        }
    }

    public boolean remove(T item) {
        int i = 0;
        while (i < cardinality && !array[i].equals(item)) {
            i++;
        }
        if (i == cardinality)
            return false;
        for (int j = i; j < cardinality -1 ; j++) {
            array[j] = array[j + 1];
        }
        cardinality--;
        array[cardinality] = null;
        return true;
    }

    public boolean linearSearch(T item) {
        for (int i = 0; i < cardinality; i++) {
            if (array[i].equals(item)) {
                return true;
            }
        }
        return false;
    }

    public int getCardinality() {
        return cardinality;
    }

    public T get(int index) {
        return array[index];
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < cardinality; i++) {
            sb.append(array[i] + " ");
        }
        return sb.toString();
    }

    private void change(int index1, int index2) {
        T temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    private boolean less(T item1, T item2) {
        return item1.compareTo(item2) < 0;
    }

    public void sortSelect() {
        int marker;
        for (int i = 0; i < cardinality; i++) {
            marker = i;
            for (int j = i + 1; j < cardinality; j++) {
                if (less(array[j], array[marker])) {
                    marker = j;
                }
            }
            change(i, marker);
        }
    }

    public void sortInsert() {
        T temp;
        int j;
        for (int i = 1; i < cardinality; i++) {
            j = i;
            temp = array[i];
            while (j > 0 && less(temp, array[j - 1])) {
                array[j] = array[j - 1];
                j--;
            }
            array[j] = temp;
        }
    }

    public void sortBubble() {
        boolean isChange;
        for (int i = cardinality - 1; i > 0 ; i--) {
            isChange = false;
            for (int j = 0; j < i; j++) {
                if (less(array[j + 1], array[j])) {
                    change(j + 1, j);
                    isChange = true;
                }
            }
            if (!isChange) {
                break;
            }
        }
    }

}
