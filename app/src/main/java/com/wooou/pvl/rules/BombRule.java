package com.wooou.pvl.rules;

import android.support.annotation.NonNull;

import com.wooou.pvl.card.CardInfo;

import java.util.List;

/**
 * 炸弹类型
 * Created by lenovo on 2018/6/22.
 */

public class BombRule implements Comparable<BombRule>, Rule {

    private List<CardInfo> data;

    public BombRule(List<CardInfo> data) {
        this.data = data;
    }

    @Override
    public int compareTo(@NonNull BombRule o) {
        return 0;
    }
}
