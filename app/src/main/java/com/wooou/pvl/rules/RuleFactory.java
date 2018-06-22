package com.wooou.pvl.rules;

import com.wooou.pvl.card.CardInfo;
import com.wooou.pvl.card.Decker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lenovo on 2018/6/22.
 */

public final class RuleFactory {


    public static Rule init(List<CardInfo> input) {
        Collections.sort(input);

        Map<Decker, List<CardInfo>> temp = new HashMap<>();
        int maxSize = 0;
        int equalsSize = 0;
        Decker maxSizeDecker = null;

        for (CardInfo item : input) {
            List<CardInfo> list = temp.get(item.getDecker());
            if (list == null) {
                list = new ArrayList<>();
            }
            list.add(item);
            if (maxSize < list.size()) {
                maxSize = list.size();
                maxSizeDecker = item.getDecker();
            }
        }

        if (maxSize == 4) {
            if (temp.size() == 1) {
                return new BombRule(input);
            } else if (temp.size() == 2 || temp.size() == 3) {
                return new DaddyBandSonRule(temp.get(maxSizeDecker), input);
            } else {
                return new NoneRule();
            }
        } else if (maxSize == 3) {
            if (temp.size() == 1 || temp.size() == 2) {//三不带,三带一,三带二
                return new DaddyBandSonRule(temp.get(maxSizeDecker), input);
            } else {
                //还有飞机的情况
                return new NoneRule();
            }
        } else if (maxSize == 1) {
            return new SimpleRule();
        }


        if (input.size() == 1) {
            return new SimpleRule(input.get(0));
        } else if (input.size() == 2) {
            int a = input.get(0).getDecker().getValue();
            int b = input.get(1).getDecker().getValue();
            if (a == b) {
                return new PairRule(input.get(0), input.get(1));
            } else if (a + b == Decker.boss.getValue() + Decker.BOSS.getValue()) {
                return new BombRule(input.get(0), input.get(1));
            } else {
                return new NoneRule();
            }
        } else if (input.size() == 2) {
            int a = input.get(0).getDecker().getValue();
            int b = input.get(1).getDecker().getValue();
            if (a == b) {
                return new PairRule(input.get(0), input.get(1));
            } else if (a + b == Decker.boss.getValue() + Decker.BOSS.getValue()) {
                return new BombRule(input.get(0), input.get(1));
            } else {
                return new NoneRule();
            }
        } else if (input.size() == 3) {
            int a = input.get(0).getDecker().getValue();
            int b = input.get(1).getDecker().getValue();
            int c = input.get(2).getDecker().getValue();
            if (a == b && b == c) {
                return new PairRule(input.get(0), input.get(1));
            } else {
                return new NoneRule();
            }
        } else if (input.size() == 4) {
            int a = input.get(0).getDecker().getValue();
            int b = input.get(1).getDecker().getValue();
            int c = input.get(2).getDecker().getValue();
            int d = input.get(3).getDecker().getValue();
            if (a == b && b == c && c == d) {
                return new BombRule(input.get(0), input.get(1), input.get(2), input.get(3));
            } else if (a == b && b == c) {
                return new DaddyBandSonRule(input.subList(0, 3), input.subList(3, 4));
            } else if (b == c && c == d) {
                return new DaddyBandSonRule(input.subList(1, 4), input.subList(0, 1));
            } else {
                return new NoneRule();
            }
        } else if (input.size() > 4) {
            //5张(34567)
            int a = input.get(0).getDecker().getValue();
            int z = input.get(input.size() - 1).getDecker().getValue();
            if (z - a == input.size() - 1) {
                //连张
                return new LinkedRule(input);
            }

        } else {
            return new NoneRule();
        }
    }
}
