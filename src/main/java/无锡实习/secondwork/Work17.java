package 无锡实习.secondwork;

import java.util.*;

public class Work17 {
    public static void main(String[] args) {
        // 初始化商品信息
        Product pro1 = new Product("1001", "衣服", 199.00, 80);
        Product pro2 = new Product("1002", "书包", 99.00, 40);
        Product pro3 = new Product("1003", "鞋子", 239.00, 10);
        Product pro4 = new Product("1004", "手套", 19.90, 5);

        // 将商品加入到map中
        Map<Integer, Product> map = new HashMap<>();
        map.put(1, pro1);
        map.put(2, pro2);
        map.put(3, pro3);
        map.put(4, pro4);

        // 调用buy方法，将选中的商品加入购物车中
        Cart cart = buy(map);

        System.out.println("加入购物车商品如下：");
        // 输出购物车信息
        for (CartDetail cartDetail : cart.list) {
            System.out.println("商品名称:"+cartDetail.getProductName()+",价格:"+cartDetail.getPrice()+",购买数量"+cartDetail.getAmount()+
                    ",总价格"+cartDetail.getTotal());
        }
        System.out.println("共"+cart.totalNum+"个商品，总价格为："+cart.totalPrice+"元");
//        System.out.println(cart);
    }

    public static Cart buy(Map<Integer, Product> map) {
        System.out.println("欢迎来到echo购物商城");
        // 打印所有商品信息
        for (Map.Entry<Integer, Product> entry : map.entrySet()) {
            System.out.println(entry.getKey() + "-- " + "商品名称:"+entry.getValue().getProductName()+
                    ",商品价格:"+entry.getValue().getPrice()+",剩余数量:"+entry.getValue().getNum());
        }

        // 选择需要购买的商品信息和数量
        Scanner scanner = new Scanner(System.in);
//        System.out.println("请输入购买的商品信息和数量（购买方式：商品编号-数量，输入end结束）：");
        System.out.println("购买方式：1-2,2-1则表示衣服两件,书包一个，输入end结束");
        System.out.println("请选择需要购买的商品及数目：");
        String input = scanner.nextLine();

        Cart cart = new Cart();
        // 解析用户输入
        while (!input.equals("end")) {
            String[] strs = input.split("-");
            int productCode = Integer.parseInt(strs[0]);
            int amount = Integer.parseInt(strs[1]);

            // 获取对应的商品信息
            Product product = map.get(productCode);

            // 将选中的商品加入购物车明细
            CartDetail cartDetail = new CartDetail(product.getProductCode(), product.getProductName(),
                    product.getPrice(), product.getTotalPrice(), amount);
            cart.addCartDetail(cartDetail);

            // 继续输入下一个商品信息
            input = scanner.nextLine();
        }

        // 关闭输入流
        scanner.close();

        return cart;
    }
    public static class Product {
        private String productCode;
        private String productName;
        private double price;
        private int num;

        // 构造函数
        public Product(String productCode, String productName, double price, int num) {
            this.productCode = productCode;
            this.productName = productName;
            this.price = price;
            this.num = num;
        }

        public String getProductCode() {
            return productCode;
        }

        public void setProductCode(String productCode) {
            this.productCode = productCode;
        }

        public String getProductName() {
            return productName;
        }

        public void setProductName(String productName) {
            this.productName = productName;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public int getNum() {
            return num;
        }

        public void setNum(int num) {
            this.num = num;
        }

        // 计算总价
        public double getTotalPrice() {
            return price * num;
        }

        @Override
        public String toString() {
            return "Product{" +
                    "productCode='" + productCode + '\'' +
                    ", productName='" + productName + '\'' +
                    ", price=" + price +
                    ", num=" + num +
                    '}';
        }
    }


    public static class CartDetail {
        private String productCode;
        private String productName;
        private double price;
        private double total;
        private int amount;

        // 构造函数
        public CartDetail(String productCode, String productName, double price, double total, int amount) {
            this.productCode = productCode;
            this.productName = productName;
            this.price = price;
            this.total = total;
            this.amount = amount;
        }

        public String getProductCode() {
            return productCode;
        }

        public void setProductCode(String productCode) {
            this.productCode = productCode;
        }

        public String getProductName() {
            return productName;
        }

        public void setProductName(String productName) {
            this.productName = productName;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public double getTotal() {
            return total;
        }

        public void setTotal(double total) {
            this.total = total;
        }

        public int getAmount() {
            return amount;
        }

        public void setAmount(int amount) {
            this.amount = amount;
        }

        @Override
        public String toString() {
            return "CartDetail{" +
                    "productCode='" + productCode + '\'' +
                    ", productName='" + productName + '\'' +
                    ", price=" + price +
                    ", total=" + total +
                    ", amount=" + amount +
                    '}';
        }
    }





    public static class Cart {
        private int totalNum;
        private double totalPrice;
        private List<CartDetail> list;

        // 构造函数
        public Cart() {
            this.totalNum = 0;
            this.totalPrice = 0.0;
            this.list = new ArrayList<CartDetail>();
        }

        // 其他属性的getter和setter方法

        // 添加购物车明细
        public void addCartDetail(CartDetail cartDetail) {
            list.add(cartDetail);
            totalNum += cartDetail.getAmount();
            totalPrice += cartDetail.getTotal();
        }

        @Override
        public String toString() {
            return "Cart{" +
                    "totalNum=" + totalNum +
                    ", totalPrice=" + totalPrice +
                    ", list=" + list +
                    '}';
        }
    }

}
