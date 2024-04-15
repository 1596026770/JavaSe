package _9_抽象类.abstract1;

public abstract class Animal {
    private String name;
    public abstract void cry();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
