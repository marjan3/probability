package com.mtanevski.probability;

import java.util.ArrayList;
import java.util.List;

public class FlipACoin {

    public List<Coin> flipCoins(int numberOfCoins){
        List<Coin> coins = new ArrayList<>(numberOfCoins);
        for (int i = 0; i < numberOfCoins; i++) {
            coins.add(next());
        }
        return coins;
    }

    private Coin next(){
        if(Randomizer.nextBoolean()){
            return Coin.HEADS;
        } else {
            return Coin.TAILS;
        }
    }
}
