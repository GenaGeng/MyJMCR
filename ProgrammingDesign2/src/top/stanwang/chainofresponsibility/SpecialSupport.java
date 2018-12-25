package top.stanwang.chainofresponsibility;

public class SpecialSupport extends Support {
    int number;
    public SpecialSupport(String name,int number) {
        super(name);
        this.number = number;
    }

    @Override
    protected boolean resolve(Trouble trouble) {
        return this.number == trouble.getNumber();
    }
}
