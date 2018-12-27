package top.stanwang.strategy.homework4;

public class Main {
    public static void main(String[] args) {
        Sorter sorter = new MySorter();
        Character a []= {'t','h','a','g','h'};
        new SortAndPrint(a,sorter).excute();
    }
}
