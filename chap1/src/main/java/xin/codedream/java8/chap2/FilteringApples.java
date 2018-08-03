package xin.codedream.java8.chap2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 苹果筛选
 *
 * @author NGLSL
 * @date 2018/7/20
 */
public class FilteringApples {
    private static List<Apple> apples = Arrays.asList(new Apple(100, "red"), new Apple(101, "green")
            , new Apple(132, "green"), new Apple(90, "green"), new Apple(122, "red")
    );

    public static void main(String[] args) {
        // 筛选出绿色苹果
        List<Apple> greenApples = filterApples(apples, FilteringApples::isGreenApple);
        System.out.println(greenApples);

        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>");

        // 筛选重量大于120克的苹果
        List<Apple> heavyApples = filterApples(apples, FilteringApples::isHeavyApple);
        System.out.println(heavyApples);

        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>");

        // 筛选红苹果
        List<Apple> isRedApples = filterApples(FilteringApples.apples, apple -> "red".equals(apple.getColor()));
        System.out.println(isRedApples);

        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>");

        // 小于120克的红苹果
        List<Apple> appleList = filterApples(FilteringApples.apples, apple -> apple.getWeight() < 120
                && "red".equals(apple.getColor()));
        System.out.println(appleList);

        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>");

        List<Apple> isGreenApple = apples.stream().filter(apple -> "green".equals(apple.getColor()))
                .collect(Collectors.toList());
        System.out.println(isGreenApple);
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
