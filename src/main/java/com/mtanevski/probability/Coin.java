package com.mtanevski.probability;

public enum Coin {
    HEADS("H"), TAILS("T");

    private final String mark;

    Coin(String mark){
        this.mark = mark;
    }

    @Override
    public String toString() {
        return mark;
    }
}
