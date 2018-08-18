package xin.codedream.java8.chap3.v2;

import xin.codedream.java8.chap3.Apple;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * ApplesSorting
 *
 * @author NGLSL
 * @date 2018/8/18
 */
public class ApplesSorting {
    public static void main(String[] args) {
        demo1();
        demo2();
        demo3();
        demo4();
        demo5();
        demo6();
    }

    private static void demo6() {
        // 按照产地进行排序
        List<Apple> apples = Arrays.asList(new Apple(150, "red", "CN"), new Apple(110, "green", "CA"),
                new Apple(100, "green", "BD"), new Apple(100, "green", "AR"));
        apples.sort(Comparator.comparing(Apple::getWeight).reversed()
                .thenComparing(Apple::getCountry));
        System.out.println(apples);
    }

    private static void demo5() {
        // 逆序排序
        List<Apple> apples = Arrays.asList(new Apple(150, "red"), new Apple(110, "green"), new Apple(100, "green"));
        apples.sort(Comparator.comparing(Apple::getWeight).reversed());
    }

    private static void demo4() {
        List<Apple> apples = Arrays.asList(new Apple(150, "red"), new Apple(110, "green"), new Apple(100, "green"));
        apples.sort(Comparator.comparing(Apple::getWeight));
    }

    private static void demo3() {
        List<Apple> apples = Arrays.asList(new Apple(150, "red"), new Apple(110, "green"), new Apple(100, "green"));
        apples.sort((o1, o2) -> o1.getWeight().compareTo(o2.getWeight()));
    }

    private static void demo2() {
        List<Apple> apples = Arrays.asList(new Apple(150, "red"), new Apple(110, "green"), new Apple(100, "green"));
        apples.sort(new Comparator<Apple>() {
            @Override
            public int compare(Apple o1, Apple o2) {
                return o1.getWeight().compareTo(o2.getWeight());
            }
        });
    }

    private static void demo1() {
        List<Apple> apples = Arrays.asList(new Apple(150, "red"), new Apple(110, "green"), new Apple(100, "green"));
        apples.sort(new AppleComparator());
    }
}
