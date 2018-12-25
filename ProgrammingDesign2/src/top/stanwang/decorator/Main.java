package top.stanwang.decorator;

public class Main {
    public static void main(String[] args) {
//        Display b1 = new StringDisplay("HelloWorld");
//        Display b2 = new SideBorder(b1, '#');
//        Display b3 = new FullBorder(b2);
//        b1.show();
//        b2.show();
//        b3.show();
//        Display b4 =
//                new SideBorder(
//                        new FullBorder(
//                                new FullBorder(
//                                        new SideBorder(
//                                                new FullBorder(
//                                                        new StringDisplay("你好，世界。")
//                                                )
//                                                , '*')
//                                )
//                        ), '/');
//        b4.show();

        Display b5 =
                new FullBorder(
                        new UpDownBorder(
                                new SideBorder(
                                        new UpDownBorder(
                                                new SideBorder(
                                                        new StringDisplay("Hello world.")
                                                        ,'*'
                                                )
                                                ,'='
                                        )
                                        ,'|'
                                )
                                , '/'
                        )
                );
        b5.show();

        MultiStringDisplay md = new MultiStringDisplay();
        md.add("1230");
        md.add("22");
        Display b6 = new UpDownBorder(md,'-');
        b6.show();
    }
}
