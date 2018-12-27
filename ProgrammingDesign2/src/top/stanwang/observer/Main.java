package top.stanwang.observer;

public class Main {
    public static void main(String[] args) {
        Observer o = new MyObserver();
        NumberGenerator generator = new RandomNumberGenerator();
        generator.addObserver(o);
        generator.execute();
    }
}
