package xin.codedream.java8.chap2;

/**
 * 筛选重苹果
 *
 * @author NGLSL
 * @version 1.0
 * @date 2018/8/3
 */
public class AppleHeavyWeightPredicate implements ApplePredicate {
    @Override
    public boolean test(Apple apple) {
        return apple.getWeight() > 150;
    }
}
