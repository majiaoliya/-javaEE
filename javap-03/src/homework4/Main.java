package homework4;

import java.io.IOException;
import java.io.InputStream;

public class Main {
    public int num = 0x3f3f3f3f;
    public static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        slove();
        sb.append("0x3f3f3f3f");
        InputStream cin = new InputStream() {
            public int pos = 0;
            StringBuilder sb;

            public InputStream setBuffer(StringBuilder sb) {
                this.sb = sb;
                return this;
            }

            @Override
            public int read() throws IOException {
                for(; pos < sb.length() && (sb.charAt(pos)<'0' || sb.charAt(pos)>'9'); pos++) ;
                return pos < sb.length() ? (sb.charAt(pos++)-'0') : -1;
            }
        }.setBuffer(sb);

        int num = -1;
        while((num=cin.read()) != -1) {
            System.out.printf("[%s] ", num);
        }
    }

    private static void slove() {
        class C {
            public int num = 0x7f7f7f7f;
            public void show() {
                System.out.println(this.num);
            }
        }
        C c = new C();
        System.out.println(c.num);
        c.show();
    }

}
