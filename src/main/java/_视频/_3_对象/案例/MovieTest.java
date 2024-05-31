package _视频._3_对象.案例;

import java.util.Scanner;

public class MovieTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        int movieid = sc.nextInt();
        Movie[] movies = new Movie[4];
        movies[0] = new Movie(1,"水门桥",38.8,9.8,"徐克","吴京","11万人想看");
        movies[1] = new Movie(2,"出拳吧",30.1,6.2,"echo","baby","12万人想看");
        movies[2] = new Movie(3,"哈哈哈",39.8,8.3,"凌霜华","lili","13万人想看");
        movies[3] = new Movie(4,"啦啦啦",43.2,9.4,"小可爱","jinjin","14万人想看");

        MovieOperator movieOperator = new MovieOperator(movies);
//        movieOperator.findAll();
//        System.out.println();
//        movieOperator.findInfo(4);


        while (true) {
            System.out.println("--------电影信息系统--------");
            System.out.println("1.查询全部电影信息");
            System.out.println("2.根据id查询电影详细信息");
            System.out.println("0.退出系统");
            System.out.println("请输入操作命令：");
            int command = sc.nextInt();
            switch (command){
                case 1:
                    movieOperator.findAll();
                    break;
                case 2:
                    System.out.println("请输入查询id:");
                    int id = sc.nextInt();
                    movieOperator.findInfo(id);
                    break;
                case 0:
                    return;
                default:
                    System.out.println("你输入的操作有误，请重新输入！");
                    break;
            }
        }

    }
}
