package com.icis.mainTest;

import com.icis.pojo.Pig;
import com.icis.pojo.Product;
import com.icis.pojo.ProductOperation;

import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean flag = true;
        Scanner cin = new Scanner(System.in);
        Product products[] = new Product[4];
        ProductOperation po = new ProductOperation();
        po.setProducts(products);
        while (flag) {
            show_main();
            int cmd = cin.nextInt();
            switch (cmd) {
                case 1 :
                    po.inputProduct(cin);
                    break;
                case 2 :
                    po.showAllProducts(products);
                    break;
                case 3 :
                    po.searchById(cin);
                    break;
            }
        }
    }

    public static void show_main() {
        System.out.println("-----商品信息系统-----");
        System.out.println("1.输入3个商品");
        System.out.println("2.查看商品信息");
        System.out.println("3.根据商品编号查找商品");
        System.out.println("请输入操作 : ");
    }

    public static void input_all(Scanner cin, int n) {
        if(false) {
            while( n -- > 0) {
                System.out.print("id:");
                String id = cin.next();
                System.out.print("name");
            }
        }
    }
}
