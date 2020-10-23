package demo1;

/**
 * 定义一个自己的注解
 * 注解属性 : byte short int long char ...
 *            enum String
 *            byte[], short[], int[], long[], char[] ...
 */

public @interface ShowFuck {
    public abstract String name();
    public abstract int age();
    Anno anno();
}
