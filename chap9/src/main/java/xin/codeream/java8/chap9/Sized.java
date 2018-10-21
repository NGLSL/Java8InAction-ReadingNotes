package xin.codeream.java8.chap9;

/**
 * Sized
 *
 * @author NGLSL
 * @date 2018/10/21
 */
public interface Sized {
    int size();

    default boolean isEmpty() {
        return size() == 0;
    }
}
