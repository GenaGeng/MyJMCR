package top.stanwang.facade;

import top.stanwang.facade.pagemaker.PageMaker;

public class Main {
    public static void main(String[] args) {
        PageMaker.makeWelcomePage("hyuki@hyuki.com","welcome.html");
    }
}

//15.1 将Database和 HTMLWriter类的访问修饰符号设置为protected
//15.2 见PageMaker类
