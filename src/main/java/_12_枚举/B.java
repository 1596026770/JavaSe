package _12_枚举;
//抽象枚举
public  enum B {
    X(){
        @Override
        public void go() {

        }
    },
    Y("张三"){
        @Override
        public void go() {
            System.out.println(getName() +"在跑");
        }
    };
    //抽象方法不能创建对象,而枚举又要在第一行罗列对象，所以罗列对象直接重写抽象方法

    private String name;

    B() {
    }

    B(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract void go();
}
