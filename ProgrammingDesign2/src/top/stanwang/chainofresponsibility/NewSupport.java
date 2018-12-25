package top.stanwang.chainofresponsibility;

import java.util.ArrayList;
import java.util.List;

public abstract class NewSupport {
    private String name;
    private List<Support> next;
    public NewSupport(String name){
        this.name = name;
        next  = new ArrayList<>();
    }
    public Support addNext(Support next){
        this.next.add(next);
        return next;
    }
    public final void support(Trouble trouble){
        if (resolve(trouble)){
            done(trouble);
        } else if (!next.isEmpty()){
            for (Support i : next){
                if (i.resolve(trouble)){
                    i.done(trouble);
                    break;
                } else {
                    fail(trouble);
                }
            }
        } else {
            fail(trouble);
        }
    }

    protected abstract boolean resolve(Trouble trouble);
    protected void done(Trouble trouble){
        System.out.println(trouble + " is resolved by " + this + ".");
    }
    protected void fail(Trouble trouble){
        System.out.println(trouble + " can't be resolved.");
    }
    @Override
    public String toString() {
        return "[ " + name + " ]";
    }
}
