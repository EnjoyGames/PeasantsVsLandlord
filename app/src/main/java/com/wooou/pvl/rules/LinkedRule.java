package com.wooou.pvl.rules;

import android.support.annotation.NonNull;

import com.wooou.pvl.card.CardInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2018/6/22.
 */

public class LinkedRule implements Comparable<LinkedRule>, Rule {

    private List<CardInfo> cardInfoLinkedList = new ArrayList<>();

    public LinkedRule(List<CardInfo> cardInfoLinkedList) {
        this.cardInfoLinkedList = cardInfoLinkedList;
    }

    @Override
    public int compareTo(@NonNull LinkedRule o) {
        return 0;
    }
}
