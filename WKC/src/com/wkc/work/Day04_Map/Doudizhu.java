package com.wkc.work.Day04_Map;

import java.util.*;

/**
 * @program: WKC
 * @description: 斗地主洗牌发牌并排序
 * @author: Freeze Wu
 * @create: 2019-04-07 17:40
 **/

public class Doudizhu {
    public static void main(String[] args) {
        HashMap<Integer, String> poker = new HashMap<>();

        int index = 0;
        poker.put(index++, "大王");
        poker.put(index++, "小王");

        List<String> colors = new ArrayList<>();
        List<String> numbers = new ArrayList<>();

        Collections.addAll(colors,"♠", "♥", "♣", "♦");
        Collections.addAll(numbers,"2", "A", "K", "Q", "J", "10", "9", "8", "7", "6", "5", "4", "3");

        for(String n : numbers){
            for(String c : colors){
                poker.put(index++, c + n);
            }
        }

        //System.out.println(poker);

        ArrayList<Integer> pokerKey = new ArrayList();

        pokerKey.addAll(poker.keySet());
        Collections.shuffle(pokerKey);

        //System.out.println(pokerKey);

        ArrayList<Integer> player1 = new ArrayList<>();
        ArrayList<Integer> player2 = new ArrayList<>();
        ArrayList<Integer> player3 = new ArrayList<>();
        ArrayList<Integer> dipai = new ArrayList<>();

        for (int i = 0; i < pokerKey.size(); i++) {
            if(i >= 51){
                dipai.add(pokerKey.get(i));
            }
            else{
                if(i % 3 == 0){
                    player1.add(pokerKey.get(i));
                }
                else if(i % 3 == 1){
                    player2.add(pokerKey.get(i));
                }
                else{
                    player3.add(pokerKey.get(i));
                }
            }
        }

        //获取poker集合里面的value值之前先对key集合排序
        Collections.sort(player1);
        Collections.sort(player2);
        Collections.sort(player3);

        ArrayList<String> sPlayer1 = new ArrayList<>();
        ArrayList<String> sPlayer2 = new ArrayList<>();
        ArrayList<String> sPlayer3 = new ArrayList<>();
        ArrayList<String> sDipai = new ArrayList<>();

        for(int i : player1){
            sPlayer1.add(poker.get(i));
        }
        for(int i : player2){
            sPlayer2.add(poker.get(i));
        }
        for(int i : player3){
            sPlayer3.add(poker.get(i));
        }
        for(int i : dipai){
            sDipai.add(poker.get(i));
        }

        System.out.println("武藤游戏：" + sPlayer1);
        System.out.println("游城十代：" + sPlayer2);
        System.out.println("不动游星：" + sPlayer3);
        System.out.println("底牌：" + sDipai);

    }
}
