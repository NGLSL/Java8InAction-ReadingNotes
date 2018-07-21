package xin.codedream.java8.chap1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 苹果筛选
 *
 * @author NGLSL
 * @date 2018/7/20
 */
public class FilterApples {
    private static List<Apple> apples = Arrays.asList(new Apple(100, "red"), new Apple(101, "green")
            , new Apple(132, "green"), new Apple(90, "green"), new Apple(122, "red")
    );

    public static void main (String[] args) {
        // 筛选出绿色苹果
        List<Apple> greenApples = filterApples(apples, FilterApples::isGreenApple);
        System.out.println(greenApples);

        // 筛选重量大于120克的苹果
        List<Apple> heavyApples = filterApples(apples, FilterApples::isHeavyApple);
        System.out.println(heavyApples);
    }

    /**
     * 筛选绿色苹果
     *
     * @param apples
     * @return
     */
    public static List<Apple> filterGreenApples(List<Apple> apples) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : apples) {
            if ("green".equals(apple.getColor())) {
                result.add(apple);
            }
        }
        return result;
    }

    /**
     * 筛选重量大于120克的苹果
     *
     * @param apples
     * @return
     */
    public static List<Apple> filterHeavyApples(List<Apple> apples) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : apples) {
            if (apple.getWeight() > 120) {
                result.add(apple);
            }
        }
        return result;
    }

    public static boolean isGreenApple(Apple apple) {
        return "green".equals(apple.getColor());
    }

    public static boolean isHeavyApple(Apple apple) {
        return apple.getWeight() > 120;
    }

    public static List<Apple> filterApples(List<Apple> apples, Predicate<Apple> predicate) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : apples) {
            if (predicate.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }

    interface Predicate<T> {
        /**
         * 根据给定的参数计算此谓词
         *
         * @param t
         * @return
         */
        boolean test(T t);
    }
}
