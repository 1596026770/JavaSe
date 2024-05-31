package _视频._7_继承.test1;

public class Teacher extends People{
    private String skill;

    public void skillFangFa(){
        System.out.println("教师"+ name +"会"+ skill);
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }
}
