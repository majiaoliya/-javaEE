package com.icis.pojo;

import java.util.Random;
import java.util.Scanner;

public class ProductOperation {
    public static final int N = 3;
    private Product[] products;

    public void inputProduct(Scanner cin) {
        for(int i=0; i<N; i++) {
            System.out.println("请输入第" + (i+1) + "个商品");
            System.out.print("名称:");
            products[i] = new Product();
            products[i].setPro_name(cin.next());
            System.out.println("价格:");
            products[i].setPro_price(cin.nextDouble());
//            products[i].setPro_id(""+(new Random(17)).nextInt(999));

            //商品编号 一个大写字母 + (100到200)的随机数
            products[i].setPro_id(generatePid());
        }
    }

    public static String generatePid() {
        Random rand = new Random();
        char pre = (char)(Math.abs(rand.nextInt())%26);
        pre += 'A';
        int lst = rand.nextInt(101) + 100 + 1;
        return ("" + pre + "" + lst);
    }

    public void showAllProducts(Product[] pro) {
        for(int i=0; i<pro.length; i++) {
            if(null == pro[i]) continue;
            Product p = pro[i];
            System.out.println("商品id: " + p.getPro_id() + ""
             + "商品name: " + p.getPro_name() + " 商品价格: " + p.getPro_price());
        }
    }

    public static int getN() {
        return N;
    }

    public Product[] getProducts() {
        return products;
    }

    public void setProducts(Product[] products) {
        this.products = products;
    }

    public void searchById(Scanner cin) {
        System.out.println("请输入id:");
        String str = cin.next();
        for(int i=0; i<N; i++) {
            Product p = products[i];
            if(null != p && str.equals(products[i].getPro_id())) {
                System.out.println("商品id: " + p.getPro_id() + ""
             + "商品name: " + p.getPro_name() + " 商品价格: " + p.getPro_price());
                return ;
            }
        }
        System.out.println("无商品 : " + str);
    }
}
