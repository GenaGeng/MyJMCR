package top.stanwang.visitor;

import com.sun.glass.ui.Size;

import java.util.Iterator;

public class SizeVisitor extends Visitor{

    int size;
    SizeVisitor(){
        size = 0;
    }

    @Override
    public void visit(File file) {
        size+=file.getSize();
    }

    @Override
    public void visit(Directory directory) {
        Iterator it= directory.iterator();
        while (it.hasNext()){
            Entry e = (Entry)it.next();
            e.accept(this);
        }
    }
}
