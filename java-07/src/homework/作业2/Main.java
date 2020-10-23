package homework.作业2;

import homework.作业1.Product;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> fst = new ArrayList<String>(),
                     sec = new ArrayList<String>();
        fst.add("语文"); fst.add("数学"); fst.add("英语"); fst.add("java"); fst.add("python");
        sec.add("php"); sec.add("c++"); sec.add("语文"); sec.add("数学"); sec.add("德语"); sec.add("法语"); sec.add("英语");

        List<String> tmp_list = new ArrayList<>((fst.size()+sec.size())),
                     ans = new ArrayList<>((fst.size()+sec.size()));

        fst.sort(String::compareTo);
        sec.sort(String::compareTo);
        System.out.println("A开始合并前 : " + fst);
        System.out.println("B开始合并前 : " + sec);
        int i, j;
        /**
         * 前面两次排序 O(nlogn)
         * 归并复杂度 O(n)
         * 总复杂度 O(nlogn)
         */
        for(i=0, j=0; i<fst.size() && j<sec.size(); ) {
            String x = fst.get(i), y = sec.get(j), tmp = null;
            if(x.compareTo(y) < 0) {
                tmp_list.add(x);
                i ++;
            } else {
                tmp_list.add(y);
                j ++;
            }
        }
        while(i < fst.size()) tmp_list.add(fst.get(i++));
        while(j < sec.size()) tmp_list.add(sec.get(j++));
        System.out.println("去重前 : " + tmp_list);
        for(i=0; i<tmp_list.size(); i++) {
            if(ans.isEmpty()) ans.add(tmp_list.get(i));
            else if(! (ans.get(ans.size()-1).equals(tmp_list.get(i)))){
                ans.add(tmp_list.get(i));
            }
        }
        System.out.println("去重后 : " + ans);

    }
}
