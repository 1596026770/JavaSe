package _视频._15collections.斗地主;

/**
 * 斗地主
 * 业务：54张牌
 * 点数："3","4","5","6","7","8","9","10","J","Q","K","","A","2"
 * 花色："♠","♥","♣","♦"
 * 大小王："🃏","🤡"
 * 斗地主：发51张，留三张
 *
 */
public class Game {
    public static void main(String[] args) {
        //1.牌类
        //2.房间
        Room room = new Room();
        //3.启动游戏
        room.start();

    }
}
