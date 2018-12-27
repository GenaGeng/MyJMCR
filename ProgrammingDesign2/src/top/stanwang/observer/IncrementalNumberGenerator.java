package top.stanwang.observer;

public class IncrementalNumberGenerator extends NumberGenerator {
    int start;
    int end;
    int step;
    int number;
    public IncrementalNumberGenerator(int start,int end,int step){
        this.start = start;
        this.end = end;
        this.step = step;
        number = start;
    }


    @Override
    public int getNumber() {
        return number;
    }

    @Override
    public void execute() {
        while (number < end){
            number += step;
            notifyObservers();
        }
    }
}
