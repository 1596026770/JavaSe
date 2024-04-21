package _无锡实习.thirdwork;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Work28 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        StudentDao dao = new StudentDao();
        Stu stu = new Stu();

        //增
//        stu.setStuCode("1003");
//        stu.setStuName("李四");
//        stu.setSex("男");
//        stu.setAge(20);
//        stu.setTel("15899445678");
//        dao.addStudent(stu);

        //改
//        stu.setStuCode("1003");
//        stu.setStuName("王小二");
//        stu.setAge(18);
//        stu.setSex("男");
//        stu.setTel("15899000008");
//        dao.updateStudent(stu);

        //删
        dao.delStudent("1003");

        //查
        List<Stu> list = dao.listStudent();
        for(Stu student:list){
            System.out.println(student.getStuCode()+":"+student.getStuName()+":"
                    +student.getAge()+":"+student.getSex()+":"+student.getTel());
        }
    }
}

class StudentDao {
    public List<Stu> listStudent() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/echo",
                "root", "123");
        String  sql = "select code,name,age,sex,tel from stu";
        PreparedStatement stat = conn.prepareStatement(sql);
        ResultSet result = stat.executeQuery();
        List<Stu> list = new ArrayList<>();
        while(result.next()) {
            Stu stu = new Stu();
            stu.setStuCode(result.getString(1));
            stu.setStuName(result.getString(2));
            stu.setAge(result.getInt(3));
            stu.setSex(result.getString(4));
            stu.setTel(result.getString(5));
            list.add(stu);
        }
        System.out.println("查询数据成功");
        return list;
    }

    public void addStudent(Stu student) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/echo",
                "root", "123");
        String sql = "insert into stu(code,name,age,sex,tel)values(?,?,?,?,?)";
        PreparedStatement stat = conn.prepareStatement(sql);
        stat.setString(1, student.getStuCode());
        stat.setString(2, student.getStuName());
        stat.setInt(3, student.getAge());
        stat.setString(4, student.getSex());
        stat.setString(5, student.getTel());
        //执行stat.executeUpdate(); 进行数据更新
        stat.executeUpdate();
        System.out.println("新增数据成功");

    }

    public void updateStudent(Stu student) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/echo",
                "root", "123");
        String sql = "update stu set name=?,age=?,sex=?,tel=? where code=?";
        PreparedStatement stat = conn.prepareStatement(sql);
        //                 此处为?占位符的索引从1开始
        stat.setString(1, student.getStuName());
        stat.setInt(2, student.getAge());
        stat.setString(3, student.getSex());
        stat.setString(4, student.getTel());
        stat.setString(5, student.getStuCode());
        //执行stat.executeUpdate(); 进行数据更新。
        stat.executeUpdate();
        System.out.println("更新数据成功");

    }

    public void delStudent(String stuCode) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/echo",
                "root", "123");
        String sql ="delete from stu where code='"+stuCode+"'";
        PreparedStatement stat = conn.prepareStatement(sql);
        stat.executeUpdate();
        System.out.println("删除数据成功");

    }
}
class Stu{
    //类中创建四个私有属性String stuCode, String stuName, int age, Boolean sex, String tel. 给四个属性附上get/set方法。
    private String stuCode;
    private String stuName;
    private int age;
    private String sex;
    private String tel;

    public Stu() {
    }

    public Stu(String stuCode, String stuName, int age, String sex, String tel) {
        this.stuCode = stuCode;
        this.stuName = stuName;
        this.age = age;
        this.sex = sex;
        this.tel = tel;
    }

    public String getStuCode() {
        return stuCode;
    }

    public void setStuCode(String stuCode) {
        this.stuCode = stuCode;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
}
