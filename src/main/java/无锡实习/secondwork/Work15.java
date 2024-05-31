package 无锡实习.secondwork;

import java.io.*;

public class Work15 {
    public static void main(String[] args) throws IOException {
        String pathSrc= "D:\\qq文件\\_课程\\大三下\\无锡实习\\作业\\test.txt";
        //文件夹
        String pathDes= "D:\\qq文件\\_课程\\大三下\\无锡实习\\作业\\newtest";
        fileCopy(pathSrc,pathDes);
    }

    public static void fileCopy(String src, String des) throws IOException {

        File file = new File(src);
        String topath = des + "\\" + file.getName();
        File fileDir=new File(des);
        if(!fileDir.exists()){
            fileDir.mkdirs();//创建文件夹
        }
        InputStream inStream = new FileInputStream(src); // 读入原文件
        FileOutputStream fs = new FileOutputStream(topath);
        byte[] buffer = new byte[inStream.available()];
        while ((inStream.read(buffer)) != -1) {
            fs.write(buffer);
        }
        System.out.println("文件复制成功");
        inStream.close();
        fs.close();


    }
}
