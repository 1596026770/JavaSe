package _视频._7_继承.test1;

public class Access extends People{
    private int num;


    public void jiedaFangFa(){
        System.out.println("咨询"+ name + "解答人数为" + num);
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
