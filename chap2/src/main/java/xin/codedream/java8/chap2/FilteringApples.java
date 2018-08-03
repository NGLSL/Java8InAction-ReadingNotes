package xin.codedream.java8.chap2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * 苹果筛选
 *
 * @author NGLSL
 * @date 2018/08/02
 */
public class FilteringApples {

    public static void main(String[] args) {
        List<Apple> apples = Arrays.asList(new Apple(100, "red"), new Apple(101, "green")
                , new Apple(132, "green"), new Apple(90, "green"), new Apple(152, "red")
        );

        List<Apple> greenApples = filterGreenApples(apples);
        System.out.println("筛选绿苹果:" + greenApples);

        List<Apple> redApples = filterApplesByColor(apples, "red");
        System.out.println("筛选红苹果:" + redApples);

        List<Apple> heavyApples = filterApplesByWeight(apples, 150);
        System.out.println("筛选重苹果:" + heavyApples);

        List<Apple> filterApples = filterApples(apples, "", 150, true);
        System.out.println("筛选苹果:" + filterApples);

        List<Apple> filterApples1 = filterApples(apples, new AppleGreenColorPredicate());
        System.out.println("通过谓词筛选绿苹果:" + filterApples1);

        List<Apple> filterApples2 = filterApples(apples, new AppleRedAndHeavyPredicate());
        System.out.println("通过谓词筛选红苹果并且是重苹果:" + filterApples2);

        List<Apple> filterApples3 = filterApples(apples, apple -> "red".equals(apple.getColor()));
        System.out.println("Lambda-筛选红苹果:" + filterApples3);

        List<Apple> filterApples4 = filterApples(apples, apple -> "red".equals(apple.getColor()) && apple.getWeight() > 150);
        System.out.println("Lambda-筛选红苹果重苹果:" + filterApples4);
    }

    /**
     * 筛选绿苹果
     *
     * @param apples
     * @return
     */
    private static List<Apple> filterGreenApples(List<Apple> apples) {
        List<Apple> appleList = new ArrayList<Apple>();
        for (Apple apple : apples) {
            if ("green".equals(apple.getColor())) {
                appleList.add(apple);
            }
        }
        return appleList;
    }

    /**
     * 将颜色作为参数，筛选苹果
     *
     * @param apples
     * @param color
     * @return
     */
    private static List<Apple> filterApplesByColor(List<Apple> apples, String color) {
        List<Apple> appleList = new ArrayList<Apple>();
        for (Apple apple : apples) {
            if (color.equals(apple.getColor())) {
                appleList.add(apple);
            }
        }
        return appleList;
    }

    /**
     * 将重量作为参数，筛选苹果
     *
     * @param apples
     * @param weight
     * @return
     */
    private static List<Apple> filterApplesByWeight(List<Apple> apples, int weight) {
        List<Apple> appleList = new ArrayList<Apple>();
        for (Apple apple : apples) {
            if (apple.getWeight() > weight) {
                appleList.add(apple);
            }
        }
        return appleList;
    }

    /**
     * 将能想到的条件作为参数
     *
     * @param apples
     * @param color
     * @param weight
     * @param flag true代表通过重量筛选，反之亦然
     * @return
     */
    private static List<Apple> filterApples(List<Apple> apples, String color, int weight, boolean flag) {
        List<Apple> appleList = new ArrayList<Apple>();
        for (Apple apple : apples) {
            boolean result = (flag && apple.getWeight() > weight) || (!flag && color.equals(apple.getColor()));
            if (result) {
                appleList.add(apple);
            }
        }
        return appleList;
    }

    /**
     * 通过Predicate作为参数，进行筛选
     *
     * @param apples
     * @param applePredicate
     * @return
     */
    private static List<Apple> filterApples(List<Apple> apples, ApplePredicate applePredicate) {
        List<Apple> appleList = new ArrayList<>();
        for (Apple apple : apples) {
            if (applePredicate.test(apple)) {
                appleList.add(apple);
            }
        }
        return appleList;
    }
}
