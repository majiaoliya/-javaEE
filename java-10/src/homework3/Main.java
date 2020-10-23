package homework3;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        File file = new File("./java-10/mydir/");
        if(!file.exists()) {
            file.mkdirs();
            System.out.println("mkdir mydir");
        } else {
            System.out.println(file.getAbsolutePath());
        }
        List<Product> list = readFromFile("G:\\Xubuntu_Work_Space\\From_Xubuntu\\codeTest_2019_2_21\\IDEA\\java-10\\src\\homework3\\test");
        list.sort(Product::compareTo);
        if(true) {
            for(Product p : list)
                System.out.println(p);
        }
        List<List<Product>> llist = new ArrayList<>();
        List<Product> ptr = null;
        for(int i=0; i<list.size(); i++) {
            if(i==0 || !list.get(i).gruop.equals(list.get(i-1).gruop)) {
//                if(i!=0) System.out.println(list.get(i).gruop + " , " + list.get(i-1).gruop);
                ptr = new ArrayList<>();
                llist.add(ptr);
            }
            ptr.add(list.get(i));
        }
        System.out.println(llist.size());
        String pre = file.getPath(), suf = null;
        for(List<Product> ls : llist) {
            String gruop = ls.get(0).gruop;
            System.out.printf("---------名称 : %s  个数: %d---------------\n", gruop, ls.size());
            for(Product p : ls)
                System.out.println(p);
            suf = gruop + ".txt";
            writeListToFile(ls, ls.size(), pre, suf);
        }
    }

    public static int writeListToFile(List<Product> list, int cnt, String pre_path, String suf_path) throws IOException {
        String path = pre_path + (pre_path.charAt(pre_path.length()-1)=='\\' ? "" : "\\\\") + suf_path;
        if(0 == list.size()) return 0;
        System.out.println("path:" + path);
//        String path = pre_path + suf_path;
        int i = 0;
        BufferedWriter cout = new BufferedWriter(new FileWriter(path));
        Product tmax = list.get(0);
        double avg = 0;
        for(Product p=null; i<list.size() && (cnt-- > 0); i++) {
            p = list.get(i);
            cout.write(p.getTmpString());
            cout.newLine();
            avg += p.price;
            tmax = tmax.price > p.price ? tmax : p;
        }
//        cout.write("平均价格:" + (avg/i) + "\n");
        cout.write("平均价格:" + (avg/list.size()));
        cout.newLine();
        cout.write("最高价格商品是 : " + tmax.getTmpString());

        cout.flush();
        cout.close();
        return i;
    }

    public static List<Product> readFromFile(String path) throws IOException {
        List<Product> ret = new ArrayList<>();
        BufferedReader cin = new BufferedReader(new FileReader(path));
        cin.readLine();
        String str = null;
        while(null != (str=cin.readLine())) {
            String s[] = str.split(",");
            Product p = new Product();
            p.name = s[0];
            p.price = Double.parseDouble(s[1]);
            p.up = s[2].equals("1");
            p.gruop = s[3];
            ret.add(p);
        }

        cin.close();
        return ret;
    }

}

class Product implements Comparable<Object> {
    String name;
    double price;
    boolean up;
    String gruop;

    public Product() { }

    public Product(String name, double price, boolean up, String gruop) {
        this.name = name;
        this.price = price;
        this.up = up;
        this.gruop = gruop;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", up=" + up +
                ", gruop='" + gruop + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isUp() {
        return up;
    }

    public void setUp(boolean up) {
        this.up = up;
    }

    public String getGruop() {
        return gruop;
    }

    public void setGruop(String gruop) {
        this.gruop = gruop;
    }


    @Override
    public int compareTo(Object o) {
        if(o instanceof String)
            return this.gruop.compareTo((String)o);
        if(o instanceof Product) {
            int cmp = this.gruop.compareTo(((Product)o).gruop);
            if(0 == cmp) cmp = this.price > ((Product)o).price ? 1 : -1;
            return cmp;
        }
        return -1;
    }

    public String getTmpString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", up=" + (up ? "上架" : "不上架") +
                ", gruop='" + gruop + '\'' +
                '}';
    }
}
