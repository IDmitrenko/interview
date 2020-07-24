package ru.geekbrains.interview.homework3.homework31;

public class PingPong {

    private final static String PING = "Ping";
    private final static String PONG = "Pong";
    private static volatile String current = PING;

    public static void main(String[] args) {
        new Thread(PingPong::printPing).start();
        new Thread(PingPong::printPong).start();
    }

    private synchronized static void printPing() {
        for (int i = 0; i < 10; i++) {
            try {
                while (current != PING) {
                    PingPong.class.wait();
                }
                Thread.sleep(100);
                System.out.println(PING);
                current = PONG;
                PingPong.class.notify();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }

    private synchronized static void printPong() {
        for (int i = 0; i < 10; i++) {
            try {
                while (current != PONG) {
                    PingPong.class.wait();
                }
                Thread.sleep(100);
                System.out.println(PONG);
                current = PING;
                PingPong.class.notify();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }

}
