package homework3;

public class Main {
    public static void main(String[] args) {
        Computer c = new Computer();
        DeviceInterface dev[] = new DeviceInterface[2];
        dev[0] = new Mouse();
        dev[1] = new KeyBoard();
        c.useDevice(dev[0]);
        c.useDevice(dev[1]);
    }
}
