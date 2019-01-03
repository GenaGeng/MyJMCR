package top.stanwang.flyweight;

public class BigString {
    private BigChar chars[];
    public BigString(String string){
        BigCharFactory factory = BigCharFactory.getInstance();
        chars = new BigChar[string.length()];
        for (int i = 0;i < string.length(); i++){
            chars[i] = factory.getBigChar(string.charAt(i));
        }
    }

    public BigString(String string,boolean shared){
        chars = new BigChar[string.length()];
        if (shared){
            BigCharFactory factory = BigCharFactory.getInstance();
            for (int i = 0;i < string.length(); i++){
                chars[i] = factory.getBigChar(string.charAt(i));
            }
        } else {
            for (int i = 0; i < string.length(); i++) {
                chars[i] = new BigChar(string.charAt(i));
            }
        }
    }
    public void print(){
        for (BigChar aChar : chars) {
            aChar.print();
        }
    }
}
