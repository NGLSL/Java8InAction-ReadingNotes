package xin.codedream.java.chap05;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * Reducing
 *
 * @author NGLSL
 * @date 2018/9/2
 */
public class Reducing {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(3, 4, 5, 5, 1, 2);
        int sum = numbers.stream().reduce(0, (a, b) -> a + b);
        System.out.println(sum);

        int sum2 = numbers.stream().reduce(0, Integer::sum);
        System.out.println(sum2);

        Optional<Integer> max = numbers.stream().reduce(Integer::max);
        System.out.println("最大值:" + max
                .get());

        Optional<Integer> min = numbers.stream().reduce(Integer::min);
        System.out.println("最小值:" + min.get());
    }
}
