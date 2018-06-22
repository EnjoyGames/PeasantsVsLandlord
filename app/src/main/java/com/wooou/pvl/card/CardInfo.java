package com.wooou.pvl.card;

import android.support.annotation.NonNull;

/**
 * Created by lenovo on 2018/6/22.
 */

public class CardInfo implements Comparable<CardInfo> {
    private Decker decker;

    public CardInfo(Decker decker) {
        this.decker = decker;
    }


    @Override
    public int compareTo(@NonNull CardInfo o) {
        return decker.getValue() - o.getDecker().getValue();
    }

    public Decker getDecker() {
        return decker;
    }

    public void setDecker(Decker decker) {
        this.decker = decker;
    }
}
