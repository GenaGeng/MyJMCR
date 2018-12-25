package top.stanwang.visitor;

import top.stanwang.iterator.Iterator;

public class ListVisitor extends Visitor {

    private String currenntdir = "";
    @Override
    public void visit(File file) {
        System.out.println(currenntdir + "/" + file);
    }

    @Override
    public void visit(Directory directory) {
        System.out.println(currenntdir+"/"+directory);
        String saveDir = currenntdir;
        currenntdir = currenntdir + "/" + directory.getName();
        java.util.Iterator it = directory.iterator();
        while (it.hasNext()){
            Entry entry = (Entry)it.next();
            entry.accept(this);
        }
        currenntdir = saveDir;
    }
}
