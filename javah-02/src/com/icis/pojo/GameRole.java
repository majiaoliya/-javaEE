package com.icis.pojo;

public class GameRole {
    public String name, color;
    public Weapon weapon;

    @Override
    public String toString() {
        return "GameRole{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                '}';
    }

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

    public GameRole() {
    }

    public GameRole(String name, String color) {
        this.name = name;
        this.color = color;
    }
}
