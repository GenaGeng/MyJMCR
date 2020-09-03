package test;

import test.acc.Account;

/**
 * @author Gena
 * @description
 * @date 2020/3/4 0004
 */
public class TestThreadclass {
    public static int money;

    public static void add() {
        money += 100;
    }

    public static int getMoney() {
        return money;
    }
    public static Account x,y;

    public static void main(String[] args){
        x = new Account(400,700);
        if (x.isLegal()){
            x.countInterest(0.01);
        }
        y = new Account(x);
//        add();
        money += 100;
        getMoney();
    }
}
