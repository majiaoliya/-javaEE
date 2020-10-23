package homework3;

public class Main {
    public static void main(String[] args) {
        Main.Listener ls = new Main.Listener();
        ls.signal();
        Observer oer = new Main(). new Observer();
        oer.getSignal(ls);
        System.out.println(ls.timer + "  " + oer.timer);
    }

    public class Observer {
        public int timer;

        public Observer() { }

        public Observer(int timer) {
            this.timer = timer;
        }
        public void getSignal(Main.Listener ls) {
            this.timer = ls.timer + 1;
        }
    }

    public static class Listener {
        public int timer;

        public Listener() { }

        public Listener(int timer) {
            this.timer = timer;
        }
        public void signal() {
            this.timer ++;
        }
    }
}
