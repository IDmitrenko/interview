package ru.geekbrains.interview.homework3.homework32;

import java.util.concurrent.atomic.AtomicInteger;

public class ThreadSafeCounter {

       AtomicInteger value = new AtomicInteger(0);

       public ThreadSafeCounter(AtomicInteger value) {
              this.value = value;
       }

       public void increment() {
              value.incrementAndGet();
       }

       public void decrement() {
              value.decrementAndGet();
       }

       public AtomicInteger getValue() {
              return value;
       }
}