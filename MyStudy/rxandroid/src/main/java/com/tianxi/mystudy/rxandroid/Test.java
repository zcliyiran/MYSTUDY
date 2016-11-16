package com.tianxi.mystudy.rxandroid;

/**
 * Created by admin on 16/10/17.
 */

public class Test {

    public static void main(String[] args) {
        BeiGuanChaZhe beiGuanChaZhe=new BeiGuanChaZhe();
        G1 g1=new G1();
        G2 g2=new G2();
        G3 g3=new G3();

        beiGuanChaZhe.add(g1);
        beiGuanChaZhe.add(g2);
        beiGuanChaZhe.add(g3);
        beiGuanChaZhe.onChange();

        switch ("sdwds"){
            case "1":
            break;
            case "2":
                break;
            case "3":
                break;
            case "4":
                break;
        }
//        Exception
    }
}
