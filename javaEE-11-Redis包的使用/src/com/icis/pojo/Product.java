package com.icis.pojo;

import java.util.Date;

public class Product {
    String proName;
    Integer proPrice;

    String proDate;

    public Product() {
    }

    public Product(String proName, Integer proPrice, String proDate) {
        this.proName = proName;
        this.proPrice = proPrice;
        this.proDate = proDate;
    }

    @Override
    public String toString() {
        return "Product{" +
                "proName='" + proName + '\'' +
                ", proPrice=" + proPrice +
                ", proDate='" + proDate + '\'' +
                '}';
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public Integer getProPrice() {
        return proPrice;
    }

    public void setProPrice(Integer proPrice) {
        this.proPrice = proPrice;
    }

    public String getProDate() {
        return proDate;
    }

    public void setProDate(String proDate) {
        this.proDate = proDate;
    }
}
