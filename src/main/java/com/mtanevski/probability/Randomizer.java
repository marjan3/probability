package com.mtanevski.probability;

import java.util.Random;

public class Randomizer {

    private static final Random random = new Random();

    public static boolean nextBoolean(){
        return random.nextBoolean();
    }


}
