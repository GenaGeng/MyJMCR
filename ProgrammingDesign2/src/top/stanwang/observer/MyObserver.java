package top.stanwang.observer;

public class MyObserver implements Observer{

    @Override
    public void update(NumberGenerator generator) {
        int number = generator.getNumber();
        System.out.println("啊啊啊我被更新了"+number);
    }
}
