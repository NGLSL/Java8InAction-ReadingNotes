package xin.codedream.java8.chap2;

/**
 * 筛选绿苹果
 *
 * @author NGLSL
 * @version 1.0
 * @date 2018/8/3
 */
public class AppleGreenColorPredicate implements ApplePredicate {
    @Override
    public boolean test(Apple apple) {
        return "green".equals(apple.getColor());
    }
}
