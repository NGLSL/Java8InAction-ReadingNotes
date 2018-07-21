package xin.codedream.java8.chap1;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 苹果排序
 *
 * @author NGLSL
 * @date 2018/7/20
 */
public class ApplesSort {

    private static List<Apple> apples = Arrays.asList(new Apple(100, "red"), new Apple(101, "green")
            , new Apple(132, "green"), new Apple(90, "green"), new Apple(122, "red")
    );

    public static void main(String[] args) {
        // applesSortOld();
        applesSortNew();
        apples.forEach(apple -> System.out.println(apple.getWeight()));
    }

    private static void applesSortOld() {
        Collections.sort(apples, new Comparator<Apple>() {
            @Override
            public int compare(Apple o1, Apple o2) {
                return o1.getWeight() < o2.getWeight() ? -1 :
                        ((o1.getWeight() == o2.getWeight()) ? 0 : 1);
            }
        });
    }

    private static void applesSortNew() {
        apples.sort(Comparator.comparing(Apple::getWeight));
    }
}
