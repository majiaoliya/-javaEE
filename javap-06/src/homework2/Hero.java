package homework2;

public abstract class Hero {

    public String name, color, jineng;

    public Hero() { }

    public abstract void shifang();

//    public abstract void shifang() {
//        System.out.println(name + " 释放了技能 : 【" + jineng + "】");
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getJineng() {
        return jineng;
    }

    public void setJineng(String jineng) {
        this.jineng = jineng;
    }

    public Hero(String name, String color, String jineng) {
        this.name = name;
        this.color = color;
        this.jineng = jineng;
    }
}
