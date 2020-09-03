package test.acc;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * @author Gena
 * @description
 * @date 2020/1/15
 */
public class AccountTest extends TestCase {
    Account x, y;
    Thread t1 = new Thread(){
        @Override
        public void run(){
            if (x.isLegal()) {
                t2.start();y = new Account(x);
            }
        }
    };
    Thread t2 = new Thread(){
        @Override
        public void run(){
            x.countInterest(0.01);
        }
    };
    @Test
    public void testCase(){
        x = new Account(400,700);
        t1.start();
    }
}