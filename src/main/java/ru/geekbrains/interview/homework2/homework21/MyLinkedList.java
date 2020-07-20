package ru.geekbrains.interview.homework2.homework21;

import java.util.Iterator;

public class MyLinkedList<T> implements Iterable<T> {
    private Node first;   // ссылка на первый элемент
    private int size = 0; // размер списка

    public MyLinkedList() {
        this.first = null;
    }

    public Iterator<T> iterator() {
        return new Iter();
    }

    private class Iter implements Iterator<T> {
        Node current = new Node(null, first);   // узел указывающий на первый элемент

        @Override
        public boolean hasNext() {
            return current.getNext() != null;
        }

        @Override
        public T next() {
            current = current.getNext();
            return (T) current.getValue();
        }

        @Override
        public void remove() {
            MyLinkedList.this.remove((T) current.getValue());
        }
    }

    private class Node<T> {
        private T value;
        private Node next;  // ссылка на следующий элемент

        public Node(T value, Node next) {
            this.value = value;
            this.next = next;
        }

        public Node(T value) {
            this.value = value;
        }

        public T getValue() {
            return value;
        }

        public Node getNext() {
            return next;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        @Override
        public String toString() {
            return value.toString();
        }
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return size;
    }

    public T getFirst() {        // значение первого элемента
        return (T) first.getValue();
    }

    public void insertFirst(T item) {   // вставить на место первого
        Node newNode = new Node(item);
        newNode.setNext(first);
        first = newNode;
        size++;
    }

    public T removeFirst() {          // получить первый с удалением
        if (isEmpty()) {
            return null;
        }
        Node oldFirst = first;
        first = first.getNext();
        size--;
        return (T) oldFirst.getValue();
    }

    public int indexOf(T item) {   // получить индекс элемента по значению
        Node current = first;   // текущий элемент
        int index = 0;          // индекс текущего элемента
        while (current != null) {
            if (item.equals(current.getValue())) {
                return index;
            }
            current = current.getNext();
            index++;
        }
        return -1;
    }

    public boolean contains(T item) {  // проверить наличие элемента по значению
        return indexOf(item) > -1;
    }

    public void insert(int index, T item) {  // вставить элемент по индексу
        if (index <= 0) {
            insertFirst(item);
            return;
        }
        Node current = first;
        int i = 0;
        if (index > size) {
            index = size;
        }
        while (i < index -1) {  // ищем предыдущий элемент
            current = current.getNext();
            i++;
        }
        Node newNode = new Node(item);
        newNode.setNext(current.getNext()); // новый ссылается на следующий за текущим
        current.setNext(newNode);      // текущий ссылается на новый
        size++;
    }

    public boolean remove(T item) {  // удалить элемент по значению
        if (isEmpty()) {
            return false;
        }
        if (first.getValue().equals(item)) { // проверка на первый
            removeFirst();
            return true;
        }
        Node current = first;
        while (current.getNext() != null &&
                !current.getNext().getValue().equals(item)) {
// проверка на конец списка и поиск элемента предыдущего удаляемому
            current = current.getNext();
        }
        if (current.getNext() == null) {
            return false;   // выход по концу списка
        }
        current.setNext(current.getNext().getNext());
// в предыдущий элемент занесли ссылку на следующий от удаляемого
        size--;
        return true;
    }

    @Override
    public String toString() {
        Node current = first;
        StringBuilder sb = new StringBuilder();
        while (current != null) {
            sb.append(current.getValue() + " ");
            current = current.getNext();
        }
        return sb.toString();
    }
}
