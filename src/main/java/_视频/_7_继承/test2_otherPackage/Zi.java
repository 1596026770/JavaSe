package _视频._7_继承.test2_otherPackage;

import _视频._7_继承.test2Modifer.Fu;

public class Zi extends Fu {
    public void test(){
        //不能访问private 缺省
        protectedMethod();
        publicMethod();
    }
}
