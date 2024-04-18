package _无锡实习.secondwork;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class Work11 {
    private static int count;
    //投票人名字
    private static Set<Voter> voters = new HashSet<>();
    public void printVoterResult(){
        int i= 0;
        System.out.println("投票意见如下：");
        for (Voter voter: voters) {
            System.out.println(voter.name+" 意见 "+voter.result);
            if(voter.result.equals("是")){
                i++;
            }
        }
        System.out.println("当前投票数为："+count);
        System.out.println("选择加班的人数为："+i+",选择不加班的人数为："+(count-i));
    }
    public static void main(String[] args) {
        Work11 work11 = new Work11();
        Voter zq = new Voter("张强");
        Voter hl = new Voter("黄磊");
        Voter lm = new Voter("黎明");
        Voter lsh = new Voter("凌霜华");

        System.out.println("关于周末是否需要加班，开始投票");

        zq.voterFor("是");
        hl.voterFor("是");
        hl.voterFor("否");
        lm.voterFor("是");
        lsh.voterFor("否");
        work11.printVoterResult();
    }
    public static class Voter{
        private String name;
        private String result;

        public void voterFor(String answer){
            if (voters.contains(this)){
                System.out.println(name+" 你已投票，不允许重复投票。");
            } else {
                this.setResult(answer);
                count ++;
                voters.add(this);
                System.out.println(name+" 感谢你的投票。");
            }
        }


        public Voter(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getResult() {
            return result;
        }

        public void setResult(String result) {
            this.result = result;
        }
    }
}
