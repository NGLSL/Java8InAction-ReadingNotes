package xin.codedream.java8.chap3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.*;

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
        demo1(apples);
        methodReference(apples);
    }

    private static void methodReference(List<Apple> apples) {
        // 之前
        apples.sort((Apple a1, Apple a2) -> a1.getWeight().compareTo(a2.getWeight()));
        // 之后，方法引用
        apples.sort(Comparator.comparing(Apple::getWeight));

        // 使用Supplier来构建一个对象
        Supplier<Apple> c1 = Apple::new;
        Apple apple = c1.get();

        // 使用Function
        Function<Integer, Apple> c2 = Apple::new;
        Apple a2 = c2.apply(120);
        
        // 使用BiFunction
        BiFunction<Integer, String, Apple> c3 = Apple::new;
        Apple a3 = c3.apply(120, "red");
    }

    private static void demo1(List<Apple> apples) {
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

        // 使用Consumer
        forEach(Arrays.asList("Object", "Not", "Found"), (String str) -> System.out.println(str));
        forEach(Arrays.asList(1, 2, 3, 4, 5, 6), System.out::println);

        // 使用map
        List<Integer> map = map(Arrays.asList("lambdas", "in", "action"), (String s) -> s.length());
        System.out.println(map);

        IntPredicate evenNumbers = (int i) -> i % 2 == 0;
        System.out.println(evenNumbers.test(1000));

        Predicate<Integer> oddNumbers = (Integer i) -> i % 2 == 1;
        System.out.println(oddNumbers.test(1000));

        Comparator<Apple> c1 = (Apple a1, Apple a2) -> a1.getWeight().compareTo(a2.getWeight());
        ToIntBiFunction<Apple, Apple> c2 = (Apple a1, Apple a2) -> a1.getWeight().compareTo(a2.getWeight());
        BiFunction<Apple, Apple, Integer> c3 = (Apple a1, Apple a2) -> a1.getWeight().compareTo(a2.getWeight());
        ;

        Runnable r = () -> {System.out.println("Tricky example");};

        // 参数a没有显示的指定类型
        List<Apple> greenApples = filter(apples, a -> "green".equals(a.getColor()));

        // 没有类型推断，显示的指定了类型
        Comparator<Apple> cApple1 = (Apple a1, Apple a2) -> a1.getWeight().compareTo(a2.getWeight());

        // 有类型推断，没有现实的指定类型
        Comparator<Apple> cApple2 = (a1, a2) -> a1.getWeight().compareTo(a2.getWeight());

        // 外部变量
        int portNumber = 6666;
        Runnable r3 = () -> System.out.println(portNumber);
        r3.run();
    }


    /**
     * 将输入对象的信息映射到输出
     *
     * @param list
     * @param function
     * @param <T>
     * @param <R>
     * @return
     */
    private static <T, R> List<R> map(List<T> list, Function<T, R> function) {
        List<R> result = new ArrayList<>();
        for (T s : list) {
            result.add(function.apply(s));
        }
        return result;
    }

    /**
     * 循环打印
     *
     * @param list
     * @param consumer
     * @param <T>
     */
    private static <T> void forEach(List<T> list, Consumer<T> consumer) {
        for (T i : list) {
            consumer.accept(i);
        }
    }


    private static void process(Runnable r) {
        r.run();
    }

    /**
     * 筛选
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
