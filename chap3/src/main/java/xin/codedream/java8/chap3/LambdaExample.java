package xin.codedream.java8.chap3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * Lambda简单示例
 *
 * @author NGLSL
 * @date 2018/8/7
 */
public class LambdaExample {
    public static void main(String[] args) {
        List<Apple> apples = Arrays.asList(new Apple(150, "red"), new Apple(110, "green"), new Apple(100, "green"),
                new Apple(160, "red"));

        // 简单示例
        Runnable runnable = () -> System.out.println("Hello CodeDream");
        runnable.run();

        List<Apple> heavyApples = filter(apples, (Apple apple) -> apple.getWeight() > 150);
        System.out.println(heavyApples);
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
