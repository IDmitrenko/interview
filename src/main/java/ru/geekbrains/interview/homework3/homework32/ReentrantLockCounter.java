package ru.geekbrains.interview.homework3.homework32;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockCounter implements Runnable {
    private int counter;
    private final ReentrantLock reLock = new ReentrantLock(true);

    public void incrementCounter() {
        reLock.lock();
        try {
            counter++;
            System.out.println(Thread.currentThread().getName() + ": " + counter);
        } finally {
            reLock.unlock();
        }
    }

    public int getCounter() {
        return counter;
    }

    @Override
    public void run() {
        while (counter < 100) {
            incrementCounter();
            Thread.yield();
        }
    }

    public static void main(String[] args) {
        ReentrantLockCounter reentrantLockCounter = new ReentrantLockCounter();
        Thread thread1 = new Thread(reentrantLockCounter);
        Thread thread2 = new Thread(reentrantLockCounter);
        Thread thread3 = new Thread(reentrantLockCounter);

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
