package homework;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) throws IOException {
        List<Product> list = Main1.inputPro();
        String path = "G:\\Xubuntu_Work_Space\\From_Xubuntu\\codeTest_2019_2_21\\IDEA\\java-10\\src\\homework\\data";
        Main1.writeToFile(list, path);
        list = readFromFile(path);
        for(int i=0; i<list.size(); i++) {
            Product p = list.get(i);
            System.out.println("[" + p.id + "," + p.name + "," + p.price + "]");
        }
    }

    public static List<Product> inputPro() throws FileNotFoundException {
        if(true) {
            FileInputStream fis = new FileInputStream("G:\\Xubuntu_Work_Space\\From_Xubuntu\\codeTest_2019_2_21\\IDEA\\java-10\\src\\homework\\test");
            System.setIn(fis);
        }
        List<Product> ret = new ArrayList<>();
        Scanner cin = new Scanner(System.in);
        for(int i=0; i<3; i++) {
            System.out.printf("请输入第 %d 个商品[编号,名称,价格]\n", (i+1));
            Product p;
            ret.add((p=new Product()));
            p.id = Integer.parseInt(cin.next());
            p.name = cin.next();
            p.price = Integer.parseInt(cin.next());
        }
        return ret;
    }
    public static int writeToFile(List<Product> list, String path) throws IOException {
        if(null == list) return 0;
        BufferedWriter cout = new BufferedWriter(new FileWriter(path));
        int i = 0;
        if(false) {
            for( ; i<list.size(); i++) {
                cout.write(list.get(i).toString());
                cout.newLine();
            }
        } else {
            StringBuilder sb = new StringBuilder();
            for( ; i<list.size(); i++) {
                sb.setLength(0);
                Product p = list.get(i);
                //"{" + this.name + "->" + this.id + "->" + this.price + "}"
                sb.append('{').append(p.name).append("->").append(p.id).append("->").append(p.price).append('}');
                cout.write(sb.toString());
                cout.newLine();
            }
        }
        cout.flush();
        cout.close();
        return i;
    }

    public static List<Product> readFromFile(String path) throws IOException {
        List<Product> ret = new ArrayList<>();
        BufferedReader cin = new BufferedReader(new FileReader(path));
        String str = null;
        while(null != (str=cin.readLine())) {
            Product p = new Product();
            ret.add(p);
            str = str.substring(1, str.length()-1);
            String s[] = str.split("->");
            p.name = s[0];
            p.id = Integer.parseInt(s[1]);
            p.price = Integer.parseInt(s[2]);
        }
        cin.close();
        return ret;
    }

}

class Product implements Comparable<Product>{
    String name;
    int id, price;

    public Product() { Object obj;}

    public Product(String name, int id, int price) {
        this.name = name;
        this.id = id;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "{" + this.name + "->" + this.id + "->" + this.price + "}";
    }

    @Override
    public int compareTo(Product other) {
        if(this.id == other.id) return this.price < other.price ? 1 : -1;
        return this.id < other.id ? -1 : (this.id==other.id ? 0 : 1);
    }
}

