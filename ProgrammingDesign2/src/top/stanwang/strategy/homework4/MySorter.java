package top.stanwang.strategy.homework4;

public class MySorter implements Sorter {
    @Override
    public void sort(Comparable[] data) {
        boolean exchange = false;
        for (int i = 0; i < data.length; i++) {
            for (int j = data.length-1; j > 0;j--){
                if (data[j].compareTo(data[j - 1]) < 0) {
                    Comparable temp = data[j];
                    data[j] = data[j - 1];
                    data[j - 1] = temp;
                    exchange = true;
                }
            }
            if(!exchange){
                return;
            } else {
                exchange = false;
            }
        }
    }
}
