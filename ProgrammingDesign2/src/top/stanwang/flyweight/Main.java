package top.stanwang.flyweight;

public class Main {
    public static void main(String[] args) {
        memory();
        BigString bs = new BigString("01011101110101");
        memory();
        memory();
        BigString bs1 = new BigString("01011101110101",false);
        memory();
    }

    private static void memory(){
        Runtime.getRuntime().gc();
        long used = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        System.out.println("Ê¹ÓÃÄÚ´æ"+used);
    }
}
