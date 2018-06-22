package com.wooou.pvl.rules;

import android.support.annotation.NonNull;

import com.wooou.pvl.card.CardInfo;

/**
 * Created by lenovo on 2018/6/22.
 */

public class PairRule implements Comparable<PairRule>, Rule {

    private CardInfo ACardInfo;
    private CardInfo BCardInfo;

    public PairRule(CardInfo ACardInfo, CardInfo BCardInfo) {
        if (ACardInfo.getDecker() != BCardInfo.getDecker()) {

        }
        this.ACardInfo = ACardInfo;
        this.BCardInfo = BCardInfo;
    }


    @Override
    public int compareTo(@NonNull PairRule o) {
        return ACardInfo.getDecker().getValue() - o.getACardInfo().getDecker().getValue();
    }

    public CardInfo getACardInfo() {
        return ACardInfo;
    }

    public void setACardInfo(CardInfo ACardInfo) {
        this.ACardInfo = ACardInfo;
    }

    public CardInfo getBCardInfo() {
        return BCardInfo;
    }

    public void setBCardInfo(CardInfo BCardInfo) {
        this.BCardInfo = BCardInfo;
    }
}
