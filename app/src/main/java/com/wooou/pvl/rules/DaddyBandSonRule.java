package com.wooou.pvl.rules;

import android.support.annotation.NonNull;

import com.wooou.pvl.card.CardInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * 三不带
 * 三带一
 * 三带二
 * 四带一
 * 四带二
 * Created by lenovo on 2018/6/22.
 */

public class DaddyBandSonRule implements Rule, Comparable<DaddyBandSonRule> {

    private List<CardInfo> mDaddy = new ArrayList<>();
    private List<CardInfo> ALL = new ArrayList<>();

    public DaddyBandSonRule(List<CardInfo> mDaddy, List<CardInfo> ALL) {
        this.mDaddy = mDaddy;
        this.ALL = ALL;
    }

    @Override
    public int compareTo(@NonNull DaddyBandSonRule o) {
        return mDaddy.get(0).getDecker().getValue() - o.getmDaddy().get(0).getDecker().getValue();
    }

}
