package com.wooou.pvl.card;

/**
 * Created by lenovo on 2018/6/22.
 */

public enum Decker {
    THREE(3),FOUR(4),FIVE(5),SIX(6),SEVEN(7),EIGHT(8),NINE(9),TEN(10),J(11),Q(12),K(13),A(14),
    TWO(100),
    boss(1000),BOSS(2000);
    private int value;

    Decker(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
