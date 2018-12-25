package top.stanwang.visitor;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FileFindVisitor extends Visitor {

    private String pattern;
    private List<File> list = new ArrayList<>();

    public FileFindVisitor(String pattern) {
        this.pattern = pattern;
    }

    @Override
    public void visit(File file) {

    }

    private boolean isMatched(String re) {
        if (re.length() < pattern.length()) {
            return false;
        }
        int length = pattern.length();
        return re.substring(re.length() - length).equals(pattern);
    }

    @Override
    public void visit(Directory directory) {
        Iterator it = directory.iterator();
        while (it.hasNext()) {
            Entry obj = (Entry) it.next();
            if (obj instanceof File) {
                File file = (File) obj;
                if (isMatched(file.getName())) {
                    list.add(file);
                }
            }
            obj.accept(this);
        }
    }

    Iterator<File> getFoundedFiles() {
        return list.iterator();
    }
}
