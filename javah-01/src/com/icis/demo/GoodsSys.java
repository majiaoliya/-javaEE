package com.icis.demo;

import com.icis.pojo.GoodsItem;
import com.icis.pojo.LoginService;
import com.icis.pojo.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GoodsSys {

    public static String db_path = "G:\\Xubuntu_Work_Space\\From_Xubuntu\\codeTest_2019_2_21\\IDEA\\javah-01\\src\\com\\icis\\goodsdb";

    public static void main(String[] args) throws IOException {
        if(false) {
            FileInputStream fis = new FileInputStream("G:\\Xubuntu_Work_Space\\From_Xubuntu\\codeTest_2019_2_21\\IDEA\\javah-01\\src\\com\\icis\\test");
            System.setIn(fis);
        }
        Scanner cin = new Scanner(System.in);

        if(true) {
            LoginService ser = new LoginService();
            System.out.println("读取用户列表");
            for (User u : ser.mp)
                System.out.println(u);
            System.out.println();
            int n = 3;
            boolean flag = false;
            User u = new User();
            while(n-->0 && !flag) {
                System.out.println("用户名:");
                u.user_name = cin.next();
                u.user_pw = cin.next();
                flag = ser.try_login(u);
            }
            if(!flag) {
                System.out.println("退出系统");
                System.exit(0);
            } else {
                System.out.println("欢迎 " + u.user_name + "登陆\n");
                ser.showUserMax(u);
            }
        }

        List<GoodsItem> list = new ArrayList<>();
        initGoodsItem(list);
        ArrayList<GoodsItem> buyGoodsItem = null; // 表示购买好的商品(不要放循环里面)

        // 主干逻辑
        while (true) { // 4.	循环让用户输入
            // 1.	输出固定字符串
            System.out.println("欢迎使用超市管理系统!");
            System.out.println("请输入您要进行的操作: 1.查看商品 2.购买商品 3.打印小票 4.退出");

            // 2.	让用户键盘录入
            int operation = cin.nextInt();

            // 3.	根据用户输入的数字做不同的操作
            switch (operation) {
                case 1:
                    showGoods(list);
                    break;
                case 2:
                    buyGoodsItem = buyGoodsItem(cin, list);
                    updateGoodsDB(list);
//                    ser.updateUserGoodFile();
                    break;
                case 3:
                    printCart(buyGoodsItem);
                    break;
                case 4:
                    System.out.println("欢迎下次再来...");
                    System.exit(0);
                    break;

                default:
                    System.out.println("您的输入有误,请重新输入...");
                    break;
            }
        }
    }

    private static void updateGoodsDB(List<GoodsItem> list) throws IOException {
        BufferedWriter cout = new BufferedWriter(new FileWriter(db_path));
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<list.size(); i++) {
            sb.setLength(0);
            GoodsItem g = list.get(i);
            sb.append(g.getId()).append(',').
               append(g.getName()).append(',').
                append(g.getPrice()).append(',').
                append(g.getCount());
            cout.write(sb.toString());
            cout.newLine();
        }
        cout.flush();
        cout.close();
    }

    private static void printCart(ArrayList<GoodsItem> list) {
        if(null == list || list.size() == 0) {
            System.out.println("空购物车");
            return ;
        }
        double sum = 0, tsum = 0;
        for(int i=0; i<list.size(); i++) {
            GoodsItem g = list.get(i);
//            System.out.printf("%s-->%s-->%lf--->%d\n",
//                              g.getId(), g.getName(), g.getPrice(), g.getCount());
            sum += (tsum = g.getPrice() * g.getCount());
            System.out.printf(g.getId() + " -> " + g.getName() + " -> " + g.getPrice() + " -> " + g.getCount() + " -> " + tsum + "\n");
        }
        System.out.printf("\n应付 : %f\n\n", sum);
    }

    private static ArrayList<GoodsItem> buyGoodsItem(Scanner cin, List<GoodsItem> list) {
        ArrayList<GoodsItem> ret =  new ArrayList<>();
        while(true) {
            System.out.println("请输入购买id");
            int id = cin.nextInt();
            System.out.println("请输入数量");
            int cnt = cin.nextInt();
            if(-1 == id || -1 == cnt) break;
            GoodsItem g = null;
            for(int i=0; i<list.size(); i++)
                if(Integer.parseInt(list.get(i).getId())==id) {
                    g = list.get(i);
                    break;
                }
            if(null == g) {
                System.out.println("id不正确");
                continue;
            } else if(cnt<=0 || cnt>g.getCount()) {
                System.out.println("数量不正确");
                continue;
            }
            GoodsItem gi = new GoodsItem(g.getName(), g.getId(), g.getPrice(), cnt);
            g.setCount(g.getCount()-cnt);
            ret.add(gi);
        }
        ret = mergeGoodsCartList(ret);
        return ret;
    }

    private static ArrayList<GoodsItem> mergeGoodsCartList(ArrayList<GoodsItem> list) {
        list.sort(GoodsItem::compareTo);
        ArrayList<GoodsItem> ret = new ArrayList<>();
        GoodsItem lst = null;
        for(int i=0; i<list.size(); i++) {
            GoodsItem now = list.get(i);
            if(lst != null && now.getId().equals(lst.getId())) {
                lst.setCount(lst.getCount() + now.getCount());
            } else {
                ret.add(now);
                lst = now;
            }
        }
        return ret;
    }

    private static void initGoodsItem(List<GoodsItem> list) throws IOException {
        String path = "G:\\Xubuntu_Work_Space\\From_Xubuntu\\codeTest_2019_2_21\\IDEA\\javah-01\\src\\com\\icis\\goodsdb";
        BufferedReader cin = new BufferedReader(new FileReader(path));
        String str = null;
        while(null != (str=cin.readLine())) {
            String s[] = str.split(",");
            GoodsItem good = new GoodsItem(s[1], s[0],
                    Double.parseDouble(s[2]), Integer.parseInt(s[3]));
            list.add(good);
        }
        cin.close();
    }
    public static void showGoods(List<GoodsItem> list) {
        if(list.isEmpty()) {
            System.out.println("空的列表");
            return ;
        }
        for(GoodsItem g : list)
            System.out.println(g.toString());
    }
}
