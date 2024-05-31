package 无锡实习.thirdwork;

import java.io.File;

public class Work22 {
    /**
     * 文件移动，将D:\qq文件\_课程\大三下\无锡实习\作业\test1.txt文件
     * 移动至  D:\qq文件\_课程\大三下\无锡实习\作业\newtest文件夹下
     * @param args
     */
    public static void main(String[] args) {
        File file = new File("D:\\qq文件\\_课程\\大三下\\无锡实习\\作业\\test1.txt");
        File toDir = new File("D:\\qq文件\\_课程\\大三下\\无锡实习\\作业\\newtest");
        if (!toDir.exists()) {
            toDir.mkdirs();
        }
        String newFile = toDir+"\\"+file.getName();
        boolean flag = file.renameTo(new File(newFile));
        System.out.println(flag?"文件移动成功，新路径为："+toDir.getAbsolutePath():"文件移动失败！");
    }
}
