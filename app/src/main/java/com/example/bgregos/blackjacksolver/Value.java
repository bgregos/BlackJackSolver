package com.example.bgregos.blackjacksolver;

public class Value
{

    private int val;

    public Value(int val)
    {
        this.val = val;
    }

    public int getVal()
    {
        if (val > 10)
            return 10;
        return val;
    }

    public String toString(){
        String value;
        int val = this.val;
        switch (val) {
            case 1:  value = "A";
                     break;
            case 2:  value = "2";
                     break;
            case 3:  value = "3";
                     break;
            case 4:  value = "4";
                     break;
            case 5:  value = "5";
                     break;
            case 6:  value = "6";
                     break;
            case 7:  value = "7";
                     break;
            case 8:  value = "8";
                     break;
            case 9:  value = "9";
                     break;
            case 10: value = "10";
                     break;
            case 11: value = "J";
                     break;
            case 12: value = "Q";
                     break;
            case 13: value = "K";
                    break;
            default: value = "0";
                     break;
                     
        }
        return value;
    }
}
