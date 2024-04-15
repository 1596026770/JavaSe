package _3_对象.案例;

public class MovieOperator {
    private Movie[] movies ;
    public MovieOperator(Movie[] movies){
        this.movies = movies;
    }

    public void findAll(){
        for (int i = 0; i < movies.length; i++) {
            Movie m = movies[i];
            System.out.println("编号："+ m.getId());
            System.out.println("名称："+ m.getName());
            System.out.println("价格："+ m.getPrice());
            System.out.println("----------------------");
        }
    }

    public void findInfo(int id){
        for (int i = 0; i < movies.length; i++) {
            Movie m = movies[i];
            if (m.getId()==id){
                System.out.println("编号"+ id +"的详细信息为：");
                System.out.println("编号："+ m.getId());
                System.out.println("名称："+ m.getName());
                System.out.println("价格："+ m.getPrice());
                System.out.println("评分："+ m.getScore());
                System.out.println("导演："+ m.getDirector());
                System.out.println("主演："+ m.getActor());
                System.out.println("其他信息："+ m.getInfo());
                System.out.println("----------------------");
                return;
            }
        }
        System.out.println("抱歉，没找到编号为："+id+"的详细信息，请查看编号是否有误！");
    }


}
