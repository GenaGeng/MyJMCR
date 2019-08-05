public class HelloWorld {

    public static void main(String[] args){
        A a =  new A();
        a.println("1+2=",String.valueOf(a.add(1,2)));
    }

    static class A{
        int add(int a,int b){
            return a+b;
        }

        void println(String ... args){
            for (String a:args){
                System.out.print(a);
            }
            System.out.println();
        }
    }

}
