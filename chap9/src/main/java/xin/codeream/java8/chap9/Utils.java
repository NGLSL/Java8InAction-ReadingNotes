package xin.codeream.java8.chap9;

import java.util.List;

/**
 * Utils
 *
 * @author NGLSL
 * @date 2018/10/21
 */
public class Utils {
    public static void paint(List<Resizable> list) {
        list.forEach(r -> {
            r.setAbsoluteSize(42, 42);
            r.draw();
        });
    }
}
