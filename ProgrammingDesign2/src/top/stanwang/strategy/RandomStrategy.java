package top.stanwang.strategy;

import java.util.Random;

public class RandomStrategy implements Strategy {
    Random random;

    @Override
    public Hand nextHand() {
        return Hand.getHand(random.nextInt(3));
    }

    @Override
    public void study(boolean win) {

    }
}
