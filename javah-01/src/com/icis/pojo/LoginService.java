package com.icis.pojo;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LoginService {
    public List<User> mp;
    public String user_db_path = "G:\\Xubuntu_Work_Space\\From_Xubuntu\\codeTest_2019_2_21\\IDEA\\javah-01\\src\\com\\icis\\userdb";
    public String pre_path = "G:\\Xubuntu_Work_Space\\From_Xubuntu\\codeTest_2019_2_21\\IDEA\\javah-01\\src\\com\\icis\\";
    public LoginService() throws IOException { init() ; }

    private void init() throws IOException {
        BufferedReader cin = new BufferedReader(new FileReader(user_db_path));
        Scanner scan = new Scanner(cin);
        if(null == mp) mp = new ArrayList<>();
        while(scan.hasNext()) {
            User u = new User();
            mp.add(u);
            u.user_name = scan.next();
            u.user_pw = scan.next();
        }
        cin.close();
    }

    public boolean try_login(User u) {
        for (User it : mp)
            if(u.user_name.equals(it.user_name) &&
                    u.user_pw.equals(it.user_pw)) return true;
        return false;
    }

    public void showUserMax(User u) throws IOException {
        StringBuilder sb = new StringBuilder(pre_path);
        sb.append(u.user_name);
        System.out.println(sb.toString());
        BufferedReader cin = new BufferedReader(new FileReader(sb.toString()));
        Scanner scan = new Scanner(cin);
        List<GoodsItem> list = new ArrayList<>();
        while(scan.hasNext()) {
            GoodsItem g = new GoodsItem();
            g.id = scan.next();
            g.name = scan.next();
            g.count = scan.nextInt();
            list.add(g);
        }
        list.sort(GoodsItem::cmp);
        u.list = list;
//        System.out.println(list);
        if(list.isEmpty())
            System.out.println("该用户没有购买过");
        else {
            System.out.println("购买次数最多的商品是:");
            System.out.println(list.get(0).tmpString());
        }

        cin.close();
    }
}
