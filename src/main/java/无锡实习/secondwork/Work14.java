package 无锡实习.secondwork;

import java.io.*;
import java.util.Scanner;

public class Work14 {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        String content  = scan.nextLine();
        inputOutput(content);
        readerWriter(content);

    }

    /**
     * 字节流
     */
    public static void inputOutput(String content) throws IOException {
        File file = new File("D:\\qq文件\\_课程\\大三下\\无锡实习\\作业\\test.txt");
        if(!file.exists()){
            file.getParentFile().mkdirs();//创建文件夹
            file.createNewFile();
        }
        OutputStream outputStream=new FileOutputStream(file);
        byte[] buffer=content.getBytes();
        outputStream.write(buffer);

        InputStream inputStream=new FileInputStream(file);
        byte[] buff=new byte[inputStream.available()];
        while((inputStream.read(buff))!=-1){
            System.out.println(new String(buff,0,buff.length));
        }
        inputStream.close();
        outputStream.close();
    }

    /**
     * 字符流
     */
    public static void readerWriter(String content) throws IOException {
        File file = new File("D:\\qq文件\\_课程\\大三下\\无锡实习\\作业\\test1.txt");
        //判空
        if(!file.exists()){
            file.getParentFile().mkdirs();//创建文件夹
            file.createNewFile();
        }
        Writer writer = new FileWriter(file);
        char[] ch = content.toCharArray();
        writer.write(ch);
        writer.flush();

        Reader reader= new FileReader(file);
        int buff = 0;
        while((buff = reader.read())!=-1) {
            System.out.print((char) buff);
        }
        reader.close();
        writer.close();
    }
}
