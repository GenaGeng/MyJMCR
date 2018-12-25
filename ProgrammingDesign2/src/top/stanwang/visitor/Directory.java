package top.stanwang.visitor;

import java.util.ArrayList;
import java.util.Iterator;

public class Directory extends Entry{

    private ArrayList<Entry> dir = new ArrayList<>();
    private String name;

    public Directory(String name){
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getSize() {
        int size = 0;
        Iterator it = iterator();
        while (it.hasNext()){
            size += ((Entry) it.next()).getSize();
        }
        return size;
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }

    @Override
    public Entry add(Entry entry) {
        dir.add(entry);
        return this;
    }

    @Override
    public Iterator iterator() {
        return dir.iterator();
    }
}
