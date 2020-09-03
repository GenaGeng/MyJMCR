package test;

/**
 * @author Gena
 * @description
 * @date 2020/3/12 0012
 */
public class SimpleCounter {
    public static double money;
    public static double saving = 100;
    public static double interest;

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                interest = 0.3;
            }

        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                interest = 0.2;
                money = saving * (1 + interest);
            }
        });
        t1.start();
        t2.start();

//        t1.join();
//        t2.join();
//        System.out.println(money);
    }
}
