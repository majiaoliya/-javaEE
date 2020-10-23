package homework3;

public class KeyBoard implements DeviceInterface {
    int num_lock;
    @Override
    public void on() {
        System.out.println("键盘 On");
    }

    @Override
    public void off() {
        System.out.println("键盘 off");
    }

    public void numLock() {
        System.out.printf("keybord %s", num_lock == 0 ? "num lock" : "num unlock");
        num_lock ^= 1;
    }
}
