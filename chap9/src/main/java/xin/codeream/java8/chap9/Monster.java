package xin.codeream.java8.chap9;

/**
 * Monster
 *
 * @author NGLSL
 * @date 2018/10/21
 */
public class Monster implements Rotatable, Moveable, Resizable {
    @Override
    public void draw() {

    }

    @Override
    public int getX() {
        return 0;
    }

    @Override
    public void setX(int x) {

    }

    @Override
    public int getY() {
        return 0;
    }

    @Override
    public void setY(int y) {

    }

    @Override
    public int getWidth() {
        return 0;
    }

    @Override
    public void setWidth(int width) {

    }

    @Override
    public int getHeight() {
        return 0;
    }

    @Override
    public void setHeight(int height) {

    }

    @Override
    public void setAbsoluteSize(int width, int height) {

    }

    @Override
    public int getRotationAngle() {
        return 0;
    }

    @Override
    public void setRotationAngle(int angleInDegrees) {

    }

    public static void main(String[] args) {
        Monster m = new Monster();
        m.rotateBy(180);
        m.moveVertically(10);
    }
}
