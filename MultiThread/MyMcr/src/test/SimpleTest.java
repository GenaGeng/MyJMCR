package test;

import scheduler.Scheduler;

public class SimpleTest {

    public static int money;

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                money+=100;
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                money-=100;
            }
        });
        t1.start();
        t2.start();

        t1.join();
        t2.join();
        System.out.println(money);
    }

}
