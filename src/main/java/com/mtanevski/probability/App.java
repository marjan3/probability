package com.mtanevski.probability;

import java.util.ArrayList;
import java.util.List;

import static com.mtanevski.probability.Coin.HEADS;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        System.out.println( "Hello World!" );
        final Runner runner = new Runner();
        List<List<Coin>> outcome = new ArrayList<>();
        List<List<Coin>> totalOutcome = new ArrayList<>();
        runner.run(() -> {
            List<Coin> coins = new FlipACoin().flipCoins(6);
            totalOutcome.add(coins);
            long headsCount = coins.stream().filter(HEADS::equals).count();
            if(headsCount == 3){
                outcome.add(coins);
            }
        }, 1_000_000);
        System.out.println("Final probability: " + outcome.size() + "/" + totalOutcome.size());

    }
}
