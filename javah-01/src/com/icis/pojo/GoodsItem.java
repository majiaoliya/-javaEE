package com.icis.pojo;

// 品名		货号	单价	库存
public class GoodsItem implements Comparable<Object> {
    // 品名
    public String name;

    // 货号
    public String id;

    // 单价
    public double price;

    // 库存
    public int count;

    public GoodsItem() {
    }

    public GoodsItem(String name, String id, double price, int count) {
        this.name = name;
        this.id = id;
        this.price = price;
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{").append(name).append("--->").append(this.id).append("---->").append(this.price).append("---->").append(this.count).append('}');
        return sb.toString();
    }

    @Override
    public int compareTo(Object o) {
        if(o instanceof GoodsItem) {
            GoodsItem og = (GoodsItem) o;
            if(0 == this.id.compareTo(og.id)) return this.count*this.price > og.count*og.price ? 1 : -1;
            return this.id.compareTo(og.id);
        }
        return -1;
    }

    public int cmp(Object o) {
        GoodsItem gi = (GoodsItem) o;
        return this.count < gi.count ? 1 : -1;
    }

    public String tmpString() {
        StringBuilder sb = new StringBuilder();
        sb.append('{').append(this.id).append(' ').append(this.name).append(' ').append(this.count).append('}');
        return sb.toString();
    }
}
