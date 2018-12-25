package top.stanwang.decorator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MultiStringDisplay extends Display {

    List<String> list = new ArrayList<>();

    public void add(String str){
        list.add(str);
    }
    @Override
    public int getColumns() {
        Collections.sort(list, (o1, o2) -> o1.getBytes().length - o2.getBytes().length);
        return list.get(list.size()-1).getBytes().length;
    }

    @Override
    public int getRows() {
        return list.size();
    }

    @Override
    public String getRowText(int row) {
        return list.get(row);
    }
}
