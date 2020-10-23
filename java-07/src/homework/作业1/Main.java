package homework.作业1;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Product> fst = new ArrayList<Product>(6),
                      sec = new ArrayList<Product>(3);
        fst.add(new Product("商品1", 1, 999));
        fst.add(new Product("商品2", 2, 998));
        fst.add(new Product("商品3", 3, 997));
        fst.add(new Product("商品1", 1, 996));
        fst.add(new Product("商品4", 4, 995));
        fst.add(new Product("商品5", 5, 994));

        sec.add(new Product("商品1", 1, 1000));
        sec.add(new Product("商品4", 4, 995));
        sec.add(new Product("商品6", 6, 994));

        if(false) { //暴力 时间复杂度 O ( max(n*n*m, m*m*n) )
            List<Product> ret = merge_list(fst, sec);
            ret.sort(Product::compareTo);
            for(Product iter : ret) {
                System.out.println(iter);
            }
        } else { //归并 复杂度 为 : 排序 O(nlogn) + 合并 O (n+m) + 去重 O (n+m) = O(nlogn)
            List<Product> tlist = new ArrayList<>(),
                          ans = new ArrayList<>();
            fst.sort(Product::compareTo);
            sec.sort(Product::compareTo);
            int i = 0, j = 0;
            for( ; i<fst.size() && j<sec.size(); ) {
                Product x = fst.get(i), y = sec.get(j);
                if(x.compareTo(y) == -1) { tlist.add(x); i ++; }
                else { tlist.add(y); j ++; }
            }
            while(i < fst.size()) tlist.add(fst.get(i++));
            while(j < sec.size()) tlist.add(sec.get(j++));
            System.out.println("合并后: " + tlist);
            for(i=0; i<tlist.size(); i++) {
                if(ans.isEmpty()) { ans.add(tlist.get(i)); }
                else {
                    Product lst = ans.get(ans.size()-1),
                            now = tlist.get(i);
                    if(lst.id != now.id) ans.add(now);
                }
            }
            System.out.println("去重后 : " + ans);
        }
    }

    //暴力 时间复杂度 O ( max(n*n*m, m*m*n) )
    public static List<Product> merge_list(List<Product> fst, List<Product> sec) {
        List<Product> ret = new ArrayList<Product>((fst.size()+sec.size()));
        for(int i=0; i<fst.size(); i++) {
            int j = 0;
            for(j=0; j<ret.size() && fst.get(i).id != ret.get(j).id; j++) ;
            if(j == ret.size()) ret.add(fst.get(i));
            else {
                Product p = ret.get(j);
                p.setPrice(Math.max(fst.get(i).price, p.getPrice()));
            }
        }
        for(int i=0; i<sec.size(); i++) {
            boolean flag = true;
            for(int j=0; j<ret.size(); j++) {
                Product x = sec.get(i), y = ret.get(i);
                if(null != x && null != y && x.id == y.id) {
                    y.setPrice(Math.max(x.price, y.price));
                }
            }
            if(flag) continue;
            ret.add(sec.get(i));
        }
        return ret;
    }
}
