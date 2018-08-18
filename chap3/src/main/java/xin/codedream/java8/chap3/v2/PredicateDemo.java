package xin.codedream.java8.chap3.v2;

import xin.codedream.java8.chap3.Apple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * PredicateDemo
 *
 * @author NGLSL
 * @date 2018/8/18
 */
public class PredicateDemo {
    public static void main(String[] args) {
        List<Apple> apples = Arrays.asList(new Apple(150, "red"), new Apple(110, "green"), new Apple(100, "green"));
         // 只要红苹果
        Predicate<Apple> apple = a -> "red".equals(a.getColor());
        // 只要红苹果的非
        Predicate<Apple> notRedApple = apple.negate();
        // 筛选
        List<Apple> appleList = filter(apples, notRedApple);
        // 遍历打印
        appleList.forEach(System.out::println);

        // 是红苹果又是重苹果
        Predicate<Apple> redAndHeavyApple = apple.and(a -> a.getWeight() >= 150);

        // 要么是重的红苹果，要么是绿苹果
        Predicate<Apple> redAndHeavyAppleOrGreen =
                apple.and(a -> a.getWeight() >= 150)
                        .or(a -> "green".equals(a.getColor()));
    }


    private static <T> List<T> filter(List<T> list, Predicate<T> predicate) {
        List<T> result = new ArrayList<>();
        for (T t : list) {
            if (predicate.test(t)) {
                result.add(t);
            }
        }
        return result;
    }

}
