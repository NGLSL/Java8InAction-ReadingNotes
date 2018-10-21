package xin.codeream.java8.chap9;


import java.util.Arrays;
import java.util.List;

/**
 * Game
 *
 * @author NGLSL
 * @date 2018/10/21
 */
public class Game {
    public static void main(String[] args) {
        List<Resizable> resizableShapes =
                Arrays.asList(new Square(), new Triangle(), new Ellipse());
        Utils.paint(resizableShapes);
    }
}
