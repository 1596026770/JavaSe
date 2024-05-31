package _视频._15collections.斗地主;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Room {
    //一副牌
    private List<Card> allCaeds = new ArrayList<>();
    //

    public Room() {
        //1.做出54张牌放入集合中
        //a.点数、个数确定，类型确定
        String[] numbers = {"3","4","5","6","7","8","9","10","J","Q","K","A","2"};
        //b.花色
        String[] colors = {"♠","♥","♣","♦"};
        //每张牌的大小    3 => 1      4 => 2 ...
        int size = 0;
        //c.遍历点数，再遍历花色，组织牌
        for (String number : numbers) {
            //3 4 5 ...
            size++;
            for (String color : colors) {
                //"♠","♥","♣","♦"
                Card c = new Card(number, color, size);
                allCaeds.add(c);//存入牌
            }
        }
        //单独存入大小王
        Card c1 = new Card("","🃏",++size);
        Card c2 = new Card("","🤡",++size);
        Collections.addAll(allCaeds,c1,c2);
        System.out.println("新牌：" + allCaeds);
    }

    /**
     * 游戏启动
     */
    public void start() {
        //1.洗牌
        Collections.shuffle(allCaeds);
        System.out.println("打乱后："+allCaeds);
        //2.发牌 三个玩家 List()
        List<Card> lingHuChong = new ArrayList<>();
        List<Card> echo = new ArrayList<>();
        List<Card> lily = new ArrayList<>();

        for (int i = 0; i < allCaeds.size() - 3; i++) {
            switch (i%3){
                case 0:
                    lingHuChong.add(allCaeds.get(i));
                    break;
                case 1:
                    echo.add(allCaeds.get(i));
                    break;
                case 2:
                    lily.add(allCaeds.get(i));
                    break;
            }
        }

        //3.对玩家的牌进行排序
        lingHuChong.sort(((o1, o2) -> o1.getSize()-o2.getSize()));
        System.out.println("lingHuChong:"+lingHuChong);
        echo.sort(((o1, o2) -> o1.getSize()-o2.getSize()));
        System.out.println("echo:"+echo);
        lily.sort(((o1, o2) -> o1.getSize()-o2.getSize()));
        System.out.println("lily:"+lily);
        //4.看牌 选择是否叫地主

        //底牌
        List<Card> lastCards = allCaeds.subList(allCaeds.size() - 3,allCaeds.size());
        System.out.println("底牌:"+lastCards);

        //底牌给地主 echo
        echo.addAll(lastCards);
//        System.out.println("地主牌："+echo);

        //地主牌重新排序
        echo.sort((o1, o2) -> o1.getSize()-o2.getSize());
        System.out.println("地主牌："+echo);
    }
}
