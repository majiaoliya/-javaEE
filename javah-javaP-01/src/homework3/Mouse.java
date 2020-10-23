package homework3;

public class Mouse implements DeviceInterface {
    @Override
    public void on() {
        System.out.println("鼠标 on");
    }

    @Override
    public void off() {
        System.out.println("鼠标 off");
    }
    public void doubleClick() {
        System.out.println("mouse double click");
    }
}
