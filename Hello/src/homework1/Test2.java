package homework1;

public class Test2 {
    public static void main(String[] args) {
        double totalPrice = 550, discount = 1;;
        if(totalPrice >= 500) discount = .5;
        if(totalPrice >= 400 && totalPrice < 500) discount = .6;
        if(totalPrice >= 300 && totalPrice < 400) discount = .7;
        if(totalPrice >= 200 && totalPrice < 300) discount = .8;
        System.out.println("totalPrice : " + totalPrice + "\n" + "乘积 : " + (totalPrice*discount));
    }
}
