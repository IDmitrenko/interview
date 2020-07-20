package ru.geekbrains.interview.homework2.homework21;

import java.util.Iterator;

public class MainLinkedList {
    public static void main(String[] args) {
        MyLinkedList<String> mll = new MyLinkedList<>();

        mll.insertFirst("Maria");
        mll.insertFirst("Ivan");
        mll.insertFirst("Petya");
        mll.insertFirst("Sasha");

        System.out.println(mll.getFirst());
        System.out.println(mll.removeFirst());
        System.out.println(mll.removeFirst());
        System.out.println(mll.getFirst());
        System.out.println(mll);
        System.out.println(mll.remove("Maria"));
        mll.insert(99,"Fedor");
        System.out.println(mll);

        mll.insert(1, "Alex");
        for (String s : mll ) {
            System.out.print(s+"; ");
        }

        System.out.println();
        Iterator<String> iterator = mll.iterator();
        while(iterator.hasNext()){
            if (iterator.next() == "Fedor") {
                iterator.remove();
            }
        }
        System.out.println(mll);
    }
}
