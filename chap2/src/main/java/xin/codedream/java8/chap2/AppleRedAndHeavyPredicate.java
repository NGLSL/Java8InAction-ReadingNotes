package xin.codedream.java8.chap2;

/**
 * 筛选红苹果和重苹果
 *
 * @author NGLSL
 * @version 1.0
 * @date 2018/8/3
 */
public class AppleRedAndHeavyPredicate implements ApplePredicate {
    @Override
    public boolean test(Apple apple) {
        return "red".equals(apple.getColor()) && apple.getWeight() > 150;
    }
}
