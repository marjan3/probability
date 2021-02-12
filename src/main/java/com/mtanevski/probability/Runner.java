package com.mtanevski.probability;

public class Runner {

    public void run(Runnable runnable, int times){
        for (int i = 1; i <= times; i++) {
            runnable.run();
        }

        System.out.println("Ran " + times + " times.");
    }
}
