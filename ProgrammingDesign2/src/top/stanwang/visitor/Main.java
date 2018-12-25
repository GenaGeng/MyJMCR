package top.stanwang.visitor;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        try {
            System.out.println("Making root entries...");
            Directory rootDir = new Directory("root");
            Directory bindir = new Directory("bin");
            Directory tmpdir = new Directory("tmp");
            Directory usrdir = new Directory("usr");
            rootDir.add(bindir);
            rootDir.add(tmpdir);
            rootDir.add(usrdir);
            bindir.add(new File("vi",10000));
            bindir.add(new File("latex",20000));
            rootDir.accept(new ListVisitor());

            Directory yuki = new Directory("yuki");
            Directory hanako = new Directory("hanako");
            Directory tomura = new Directory("tomura");
            yuki.add(new File("diary.html",1234));
            yuki.add(new File("Composite.java",2222));
            hanako.add(new File("memo.tex",7974));
            hanako.add(new File("index.html",44));
            tomura.add(new File("game.dox",11));
            tomura.add(new File("junk.mail",665));
            rootDir.add(yuki);
            rootDir.add(hanako);
            rootDir.add(tomura);

            System.out.println("HTML files are:");
            FileFindVisitor ffv= new FileFindVisitor(".html");
            rootDir.accept(ffv);
            Iterator<File> it = ffv.getFoundedFiles();
            while (it.hasNext()) {
                System.out.println(it.next());
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
