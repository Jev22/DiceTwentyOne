package com.company;

import java.util.Random;

public class Die {
    //Vi laver en klasse bestående af antal sider og en value.
    private final int Antal_Sider = 6;
    private int value;


    //Med en constructor der kalder en roll metode, der tildeler terningen en værdi.
    Die() {
        roll();
    }

    public void roll() {
        Random randomValue = new Random();

        value = randomValue.nextInt(Antal_Sider) + 1;
    }

    //med getValue kan vi returnere værdien af terningen
    public int getValue() {
        return value;
    }
}
