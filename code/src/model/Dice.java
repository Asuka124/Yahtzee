package model;

public class Dice {
	
    private int value;

    public void roll() {
        value = (int)(Math.random() * 5) + 1;
    }

    public int getValue() {
        return value;
    }
}
