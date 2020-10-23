package homework3;

import java.awt.*;
import java.security.Key;

public class Computer {

    public void useDevice(DeviceInterface dev) {
        dev.on();
        if(dev instanceof Mouse) {
            Mouse m = (Mouse) dev;
            m.doubleClick();
        } else if(dev instanceof KeyBoard) {
            KeyBoard k = (KeyBoard) dev;
            k.numLock();
        }
        dev.off();
    }
}
