package com.tianxi.mystudy.rxandroid;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 16/10/14.
 */

public class BeiGuanChaZhe {
    List<Guannchazhe> list = new ArrayList<>();

    public void onChange() {
        for (int i = 0; i < list.size(); i++) {
            list.get(i).change();
        }

    }


    public void add(Guannchazhe guannchazhen) {

        list.add(guannchazhen);

    }


    public void reMove(Guannchazhe guannchazhen) {

        list.remove(guannchazhen);

    }


}
