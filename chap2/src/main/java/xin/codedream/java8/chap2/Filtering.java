package xin.codedream.java8.chap2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

/**
 * Filtering
 *
 * @author NGLSL
 * @version 1.0
 * @date 2018/8/3
 */
public class Filtering {

    public static void main(String[] args) {
        List<Apple> apples = Arrays.asList(new Apple(100, "red"), new Apple(101, "green")
                , new Apple(132, "green"), new Apple(90, "green"), new Apple(152, "red")
        );

        List<Integer> numbers = Arrays.asList(10, 11, 8, 5, 1, 2, 29, 18);

        List<Apple> heavyApples = filter(apples, (Apple apple) -> apple.getWeight() > 150);
        System.out.println("重苹果：" + heavyApples);

        List<Integer> integerList = filter(numbers, number -> number % 2 == 0);
        System.out.println("能被2整除的数:" + integerList);

        apples.sort(Comparator.comparing(Apple::getWeight));
        System.out.println("排序后：" + apples);

        Thread t = new Thread(() -> System.out.println("HelloWorld"));
        t.start();
    }

    /**
     * 通用的筛选
     *
     * @param list
     * @param predicate
     * @param <T>
     * @return
     */
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
