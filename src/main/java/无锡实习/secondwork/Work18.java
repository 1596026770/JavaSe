package 无锡实习.secondwork;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

public class Work18 {
    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        HouseAction house = new HouseAction();
        Map<String,GoodsInHouse> map = new HashMap<>();
//        map.put("1001", new GoodsInHouse("1001","衣服",8,"1-2-001"));

        System.out.println("欢迎进入仓库管理系统");
        while(true) {
            System.out.println("请选择要进行的操作：1-入库，2-出库，3-查询,4-退出");
//            Integer it = Integer.valueOf(scan.nextLine());
            String it = scan.next();
            if(Objects.equals(it, "1")) {
                map = house.insert(map);
            }else if(Objects.equals(it, "2")) {
                house.remove(map);
            } else if(Objects.equals(it, "3")) {
                house.selectGoods(map);
            }else if(Objects.equals(it, "4")) {
                System.out.println("谢谢");
                break;
            }
        }
//1001,衣服,2,1-2-001
    }

    public static class GoodsInHouse{
//        String goodsCode(商品编码)，String goodsName(商品名称)，Integer num(数量)，String address(存放位置)，均为私有。
        private String goodsCode;
        private String goodsName;
        private Integer num;
        private String address;

        public GoodsInHouse() {
        }

        public GoodsInHouse(String goodsCode, String goodsName, Integer num, String address) {
            this.goodsCode = goodsCode;
            this.goodsName = goodsName;
            this.num = num;
            this.address = address;
        }

        public String getGoodsCode() {
            return goodsCode;
        }

        public void setGoodsCode(String goodsCode) {
            this.goodsCode = goodsCode;
        }

        public String getGoodsName() {
            return goodsName;
        }

        public void setGoodsName(String goodsName) {
            this.goodsName = goodsName;
        }

        public Integer getNum() {
            return num;
        }

        public void setNum(Integer num) {
            this.num = num;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }
    }

    /**
     * 主要做物品的入库，出库，查询的方法
     */
    public static class HouseAction{

        public Map<String,GoodsInHouse> insert(Map<String,GoodsInHouse> map){
            boolean flag = true;
            while (flag) {
                System.out.println("请输入需要入库的商品信息：");
                String input = scan.next();
                String[] strs= input.split(",");
                GoodsInHouse goods = new GoodsInHouse(strs[0], strs[1],Integer.parseInt(strs[2]), strs[3]);
                //判断该商品goods在map是否存在
                if(map.containsKey(goods.getGoodsCode())) {
                    GoodsInHouse newGoods = map.get(goods.getGoodsCode());
                    newGoods.setNum(newGoods.getNum()+goods.getNum());
                    map.put(newGoods.getGoodsCode(), newGoods);
                }else {
                    map.put(goods.getGoodsCode(), goods);
                }
                System.out.println("是否继续添加：y/n");
                String yorn = scan.next();
                flag = Objects.equals(yorn, "y") || Objects.equals(yorn, "Y");
            }
            System.out.println("物品添加完毕");
            return map;
        }

        public Map<String,GoodsInHouse> remove(Map<String,GoodsInHouse> map){
            boolean flag = true;
            while (flag) {
                System.out.println("请输入需要出库的编号：");
                String goodsCode = scan.next();
                System.out.println("请输入需要出库的数量：");
                int num = scan.nextInt();
                if (map.containsKey(goodsCode)) {
                    GoodsInHouse newGoods = map.get(goodsCode);
                    if (newGoods.getNum() > num) {
                        newGoods.setNum(newGoods.getNum() - num);
                        map.put(newGoods.getGoodsCode(), newGoods);
                    } else if (newGoods.getNum() == num) {
                        map.remove(goodsCode);
                    } else {
                        System.out.println("出库数量大于库存量，无法出库");
                    }
                } else {
                    System.out.println("商品不存在。");
                }
                System.out.println("是否继续出库其他商品：y/n");
                String yorn = scan.next();
                flag = Objects.equals(yorn, "y") || Objects.equals(yorn, "Y");
            }
            System.out.println("物品出库完毕");
            return map;
        }

        public void selectGoods(Map<String,GoodsInHouse> map){
            if(map.isEmpty()){
                System.out.println("当前暂无库存，请先进行入库操作！");
            }else {
                System.out.println("在库物品如下：");
                for (String code : map.keySet()){
                    System.out.println("商品编码："+map.get(code).getGoodsCode()+",商品名称："+map.get(code).getGoodsName()+",在库数量："
                            +map.get(code).getNum()+",存放位置："+map.get(code).getAddress());
                }
            }

        }
    }
}
