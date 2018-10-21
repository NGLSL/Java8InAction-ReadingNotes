package xin.codeream.java8.chap9;

/**
 * Rotatable
 *
 * @author NGLSL
 * @date 2018/10/21
 */
public interface Rotatable {
    int getRotationAngle();

    void setRotationAngle(int angleInDegrees);

    default void rotateBy(int angleInDegrees) {
        setRotationAngle((getRotationAngle() + angleInDegrees) % 360);
    }
}
