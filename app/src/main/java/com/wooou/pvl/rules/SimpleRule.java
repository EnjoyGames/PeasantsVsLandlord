package com.wooou.pvl.rules;

import android.support.annotation.NonNull;

import com.wooou.pvl.card.CardInfo;

/**
 * Created by lenovo on 2018/6/22.
 */

public class SimpleRule implements Comparable<SimpleRule>,Rule {

    private CardInfo cardInfo;

    public SimpleRule(CardInfo cardInfo) {
        this.cardInfo = cardInfo;
    }

    public CardInfo getCardInfo() {
        return cardInfo;
    }

    @Override
    public int compareTo(@NonNull SimpleRule o) {
        return this.cardInfo.getDecker().getValue() - o.getCardInfo().getDecker().getValue();
    }
}
