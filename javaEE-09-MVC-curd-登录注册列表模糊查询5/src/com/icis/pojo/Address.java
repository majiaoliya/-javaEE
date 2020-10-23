package com.icis.pojo;

public class Address {
    Integer procince_id;
    String procince_name;

    public Address() {
    }

    public Address(Integer procince_id, String procince_name) {
        this.procince_id = procince_id;
        this.procince_name = procince_name;
    }

    @Override
    public String toString() {
        return "Address{" +
                "procince_id=" + procince_id +
                ", procince_name='" + procince_name + '\'' +
                '}';
    }

    public Integer getProcince_id() {
        return procince_id;
    }

    public void setProcince_id(Integer procince_id) {
        this.procince_id = procince_id;
    }

    public String getProcince_name() {
        return procince_name;
    }

    public void setProcince_name(String procince_name) {
        this.procince_name = procince_name;
    }
}
