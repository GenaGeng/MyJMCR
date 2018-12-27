package top.stanwang.singleton;

public class Triple {

    private int id;
    private Triple(int id){
        this.id = id;
    }
    private static Triple[] instances= {new Triple(0),new Triple(1),new Triple(2)};
    public static Triple getInstance(int id){
        return instances[id];
    }

}


