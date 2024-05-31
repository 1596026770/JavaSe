package _视频._5_1_ATM;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class ATM {
    private ArrayList<Account> accounts = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);
    private Random r = new Random();
    private Account loginAcc;//记住登陆后的用户账户



    public void start(){
        while (true) {
            System.out.println("-------欢迎进入ATM系统---------");
            System.out.println("1.用户登录");
            System.out.println("2.用户开户");
            System.out.println("3.退出系统");
            System.out.print("请选择操作：");
            String command = sc.next();
//            System.out.println();
            switch (command){
                case "1":
//                    用户登录
                    login();
                    break;
                case "2":
                    //用户开户
                    createAccount();
                    break;
                case "3":
                    System.out.println("你已退出系统，欢迎下次再来！");
                    return;
                default:
                    System.out.println("你输入的操作有误，请重新输入！");
            }
        }
    }

//    登陆
    private void login(){
        System.out.println("-------登录系统-------");
        if(accounts.size() == 0){
            System.out.println("当前系统没有任何账户，请先开户再进行登录！");
            return;
        }
        while (true) {
            System.out.println("请你输入登录卡号：");
            String cardId = sc.next();
            Account account = getAccountByCardId(cardId);
            if(account != null){
                while (true) {
                    System.out.println("请输入登录密码：");
                    String passWord = sc.next();
                    if (passWord.equals(account.getPassWord())) {
                        System.out.println("恭喜"+ account.getUserName() +"登录成功，你的卡号是："+ cardId);
                        loginAcc = account;
                        showUserCommand();
                        return;
                    }else {
                        System.out.println("你输入的密码不正确，请重新输入！");
                    }
                }


            }else {
                System.out.println("你登录的卡号不存在，请确认！");
            }
        }


    }
    /**展示登录后的操作页面*/
    private void showUserCommand(){
        while (true) {
            System.out.println(loginAcc.getUserName() + "你可以选择如下功能进行账户处理=====");
            System.out.println("1.查询账户");
            System.out.println("2.存款");
            System.out.println("3.取款");
            System.out.println("4.转账");
            System.out.println("5.修改密码");
            System.out.println("6.退出");
            System.out.println("7.注销当前账户");
            System.out.println("请输入操作：");
            String command = sc.next();
            switch (command){
                case "1":
                    //查询账户
                    showLoginAccount();
                    break;
                case "2":
                    //存款
                    depositMoney();
                    break;
                case "3":
                    //取款
                    drawMoney();
                    break;
                case "4":
                    //转账
                    transferMoney();
                    break;
                case "5":
                    //修改密码
                    updatePassWord();
                    return;
                case "6":
                    //退出
                    System.out.println(loginAcc.getUserName()+ "你退出系统成功");
                    return;
                case "7":
                    //注销当前账户
//                    销户成功，退出当前页面；失败留在当前页面
                    if(deleteAccount()){
                        return;
                    }else {
                        break;
                    }

                default:
                    System.out.println("你输入的操作有误，请重新输入！");
            }
        }


    }

    /*修改密码*/
    private void updatePassWord() {
        while (true) {
            System.out.println("===账户密码修改操作===");
            System.out.println("请输入当前密码：");
            String passWord = sc.next();
            if(loginAcc.getPassWord().equals(passWord)){
                while (true) {
                    System.out.println("请输入新密码：");
                    String newPassWord = sc.next();

                    if(newPassWord.equals(loginAcc.getPassWord())){
                        System.out.println("新密码不能与旧密码重复，重新输入");
                    }else {

                        System.out.println("请输入确认密码：");
                        String okPassWord = sc.next();
                        if(newPassWord.equals(okPassWord)){
                            loginAcc.setPassWord(okPassWord);
                            System.out.println("你的密码修改成功，请重新登录");
                            return;
                        }else {
                            System.out.println("你输入的两次密码不一致，请重新输入");
                        }
                    }
                }

            }else {
                System.out.println("你输入的密码有误！");
            }
        }
    }

    //    销户
    private boolean deleteAccount() {
        System.out.println("===用户销户操作===");
        System.out.println("你确定要销户吗？y/n");
        String command = sc.next();
        switch (command){
            case "y":
                if(loginAcc.getMoney() == 0){
                    accounts.remove(loginAcc);
                    System.out.println("你好，你的账户已成功销户");
                    return true;
                }else {
                    System.out.println("你的账户中存在金额，不允许销户");
                    return false;
                }
            default:
                System.out.println("好的，你的账户保留！");
                return false;
        }
    }

    /*转账*/
    private void transferMoney() {
        while (true) {
            System.out.println("===用户转账===");
            if(accounts.size() < 2){
                System.out.println("当前系统只有你一个账户，无法为其他账户转账！");
                return;
            }

            if(loginAcc.getMoney() == 0){
                System.out.println("你的账户余额为0，请先存款再转账");
                return;
            }

            System.out.println("请你输出对方的卡号：");
            String cardId = sc.next();
            Account account = getAccountByCardId(cardId);
//            判断对方卡号是否存在且不为自己的卡号
            if(account ==null){
                System.out.println("你输入的对方卡号不存在，请重新输入");
            } else if (account.getCardId().equals(loginAcc.getCardId())) {
                System.out.println("不能为自己卡号转账，请重新输入");
            } else {
//                认证对方姓氏
                String name = "*"+ account.getUserName().substring(1);// 凌霜华 => *霜华
                System.out.println("请你输入【"+ name +"】的姓氏");
                String prename = sc.next();
                if(account.getUserName().startsWith(prename)){
                    while (true) {
                        System.out.println("请你输入转账给对方的金额");
                        double money = sc.nextDouble();
//                    判断有没有超过自己余额
                        if(loginAcc.getMoney() >= money){
                            //loginAcc为自己当前登录的账户，account为通过Id查询的账户
                            loginAcc.setMoney(loginAcc.getMoney() - money);
                            account.setMoney(account.getMoney() + money);
                            System.out.println("成功为"+ account.getCardId() +"转账"+money+",当前余额为："+loginAcc.getMoney());
                            return;
                        }else {
                            System.out.println("余额不足，余额为："+ account.getMoney());
                        }
                    }
                }else {
                    System.out.println("Sorry,你输入的姓氏有误");
                }

            }

        }


    }

    /*取钱*/
    private void drawMoney() {
        while (true) {
            System.out.println("===取款操作===");
            if(loginAcc.getMoney() < 100){
                System.out.println("账户余额不足100，不允许取钱");
                return;
            }
            System.out.println("请输入取款金额：");
            double money = sc.nextDouble();

            if (loginAcc.getMoney() >= money) {
                if (money <= loginAcc.getLimit()) {
                    loginAcc.setMoney(loginAcc.getMoney() - money);
                    System.out.println("你取款"+ money +"取款后还剩余"+loginAcc.getMoney());
                    break;
                } else {
                    System.out.println("你取款金额超过限额，你每次限额为："+loginAcc.getLimit());
                }

            } else {
                System.out.println("余额不足，你的账户余额为："+ loginAcc.getMoney());
            }
        }
    }

    /*存款*/
    private void depositMoney() {
        System.out.println("===存款操作===");
        System.out.println("请输入存款金额：");
        double money = sc.nextDouble();
        loginAcc.setMoney(loginAcc.getMoney() + money);
        System.out.println("恭喜你，存入"+ money +"元，存钱后余额为："+loginAcc.getMoney());
    }


    //    展示登录的账户信息
    private void showLoginAccount(){
        System.out.println("===当前你的账户信息如下===");
        System.out.println("卡号："+loginAcc.getCardId());
        System.out.println("户主："+loginAcc.getUserName());
        System.out.println("性别："+loginAcc.getSex());
        System.out.println("余额："+loginAcc.getMoney());
        System.out.println("每次取现额度："+loginAcc.getLimit());
    }





//    开户功能
    private void createAccount(){
        //1.创建开户信息
        Account account = new Account();

        System.out.println("------系统开户操作-------");
        //2.输入开户信息
        System.out.println("请输入你的账户名称：");
        String name = sc.next();
        account.setUserName(name);

        while (true) {
            System.out.println("请输入性别：");
            char sex = sc.next().charAt(0);//"男"
            if (sex == '男' || sex == '女') {
                account.setSex(sex);
                break;
            } else {
                System.out.println("你输入的性别有误，请重新输入");

            }
        }

        while (true) {
            System.out.println("请输入你的账户密码：");
            String passWord = sc.next();

            System.out.println("请确认你的账户密码：");
            String okPassWord = sc.next();
            if(passWord.equals(okPassWord)){
                account.setPassWord(passWord);
                break;
            }else {
                System.out.println("两次密码输入不同，请重新输入密码！");
            }
        }

        System.out.println("请输入你的取现额度：");
        double limit = sc.nextDouble();
        account.setLimit(limit);

//        生成一个8位卡号，且不能与其他账户重复
        String newCardId = createCardId();
        account.setCardId(newCardId);

        //3.将信息放入集合
        accounts.add(account);
        System.out.println("恭喜你，"+ account.getUserName() +"开户成功" + "你的卡号是："+ account.getCardId());
    }



    private String createCardId(){
        while (true) {
            String cardId = "";
            for (int i = 0; i < 8; i++) {
                cardId += r.nextInt(10);
            }
            Account account = getAccountByCardId(cardId);
            if(account == null){
//                判断是否有此卡号的账户，如果为null说明卡号不重复
                return cardId;
            }
        }
    }


//    根据卡号查账户对象
    private Account getAccountByCardId(String cardId){
        for (int i = 0; i < accounts.size(); i++) {
            Account acc = accounts.get(i);
            if (acc.getCardId().equals(cardId)) {
//                查询有没有这个账户，有返回对象，没有返回null
                return acc;
            }
        }
        return null;//无此账户
    }









}
