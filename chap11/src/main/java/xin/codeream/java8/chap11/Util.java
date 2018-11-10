package xin.codeream.java8.chap11;

/**
 * Util
 *
 * @author NGLSL
 * @date 2018/11/10
 */
public class Util {
    public static void delay() {
        int delay = 1000;
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
