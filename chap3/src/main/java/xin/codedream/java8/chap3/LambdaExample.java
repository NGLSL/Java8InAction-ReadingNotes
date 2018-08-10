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

        // 使用Lambda表达式
        Runnable r1 = () -> System.out.println("HelloWorld 1");

        // 使用匿名类
        Runnable r2 = new Runnable() {
            @Override
            public void run() {
                System.out.println("HelloWorld 2");
            }
        };

        // 运行结果
        System.out.println("Runnable运行结果：");
        // HelloWorld 1
        process(r1);
        // HelloWorld 2
        process(r2);
        // HelloWorld 3
        process(() -> System.out.println("HelloWorld 3"));

        // 使用Predicate
        List<String> strings = Arrays.asList("Hello", "", "Java8", "", "In", "Action");
        Predicate<String> nonEmptyStringPredicate = (String s) -> !s.isEmpty();
        List<String> stringList = filter(strings, nonEmptyStringPredicate);
        System.out.println(stringList);
    }


    private static void process(Runnable r) {
        r.run();
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
