package xin.codeream.java8.chap9;

/**
 * Resizable
 *
 * @author NGLSL
 * @date 2018/10/21
 */
public interface Resizable extends Drawable {
    int getWidth();

    void setWidth(int width);

    int getHeight();

    void setHeight(int height);

    void setAbsoluteSize(int width, int height);

    // void setRelativeSize(int wFactor, int hFactor);

    default void setRelativeSize(int wFactor, int hFactor){
        setAbsoluteSize(getWidth() / wFactor, getHeight() / hFactor);
    }
}
