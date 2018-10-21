package xin.codeream.java8.chap9;

/**
 * Moveable
 *
 * @author NGLSL
 * @date 2018/10/21
 */
public interface Moveable {
    int getX();

    void setX(int x);

    int getY();

    void setY(int y);

    default void moveHorizontally(int distance) {
        setX(getX() + distance);
    }

    default void moveVertically(int distance) {
        setY(getY() + distance);
    }
}
