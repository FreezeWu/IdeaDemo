package com.wkc.work.Day02_CollectionAndGeneric;

import java.util.*;

/**
 * @program: WKC
 * @description: Fight against landlords
 * @author: Freeze Wu
 * @create: 2019-04-04 10:28
 **/


//按照斗地主的规则，完成洗牌发牌的动作。
//
//具体规则：
//
//使用54张牌打乱顺序,三个玩家参与游戏，三人交替摸牌，每人17张牌，最后三张留作底牌。

public class DouDiZhu {
    //定义花色
//    private String diamond = "♦";
//    private String plum = "♣";
//    private String heart = "♥";
//    private String spade = "♠";

    private static String[] suit = {"♦", "♣", "♥", "♠"};
    private static String[] royal = {"J", "Q", "K", "A"};

    //大小王
    private static String litterJoker = "小王";
    private static String bigJoker = "大王";

    public static void main(String[] args) {
        ArrayList<String> poker = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            for (int j = 1; j <= 13; j++) {
                if(j == 1){
                    poker.add(suit[i] + royal[3]);
                    continue;
                }
                else if(j == 11){
                    poker.add(suit[i] + royal[0]);
                    continue;
                }
                else if(j == 12){
                    poker.add(suit[i] + royal[1]);
                    continue;
                }
                else if(j == 13){
                    poker.add(suit[i] + royal[2]);
                    continue;
                }
                else {
                    poker.add(suit[i] + j);
                }
            }

        }
        poker.add(litterJoker);
        poker.add(bigJoker);

        //随机打乱扑克牌
        Collections.shuffle(poker);

        System.out.println(poker);

        ArrayList<String> player1 = new ArrayList<>();
        ArrayList<String> player2 = new ArrayList<>();
        ArrayList<String> player3 = new ArrayList<>();

        for (int i = 0; i < (poker.size() - 3) / 3 ;) {
            if(poker.size() <= 3){
                break;
            }

            player1.add(poker.get(i));
            poker.remove(i);
            player2.add(poker.get(i));
            poker.remove(i);
            player3.add(poker.get(i));
            poker.remove(i);
        }

        ArrayList<String> dipai = poker;

        //打印扑克牌，此时显示的牌为乱序，需要在发牌同时进行排序
        System.out.println("玩家1的牌：" + player1);
        System.out.println("玩家2的牌：" + player2);
        System.out.println("玩家3的牌：" + player3);
        System.out.println("剩余底牌：" + dipai);



    }
}


