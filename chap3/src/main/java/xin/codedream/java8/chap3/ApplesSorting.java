package xin.codedream.java8.chap3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 苹果排序
 *
 * @author NGLSL
 * @date 2018/8/7
 */
public class ApplesSorting {
    public static void main(String[] args) {
        List<Apple> apples = Arrays.asList(new Apple(150, "red"), new Apple(110, "green"), new Apple(100, "green"));
        // Java7
        Comparator<Apple> byWeight = new Comparator<Apple>() {
            @Override
            public int compare(Apple o1, Apple o2) {
                return o1.getWeight().compareTo(o2.getWeight());
            }
        };
        apples.sort(byWeight);

        // Java8
        Comparator<Apple> byWeight2 = (Apple a1, Apple a2) -> a1.getWeight().compareTo(a2.getWeight());
        Comparator<Apple> byWeight3 = Comparator.comparing(Apple::getWeight);
        // apples.sort(byWeight2);
        // apples.sort(byWeight3);
    }
}
