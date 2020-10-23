package com.icis.pojo;

public class Prov {
    Integer id;
    String name;

    public Prov() {
    }

    @Override
    public String toString() {
        return "Prov{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Prov(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
}
