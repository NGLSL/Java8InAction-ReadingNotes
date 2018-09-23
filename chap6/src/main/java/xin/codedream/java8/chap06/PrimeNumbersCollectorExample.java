package xin.codedream.java8.chap06;

import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

/**
 * PrimeNumbersCollectorExample
 *
 * @author NGLSL
 * @date 2018/9/23
 */
public class PrimeNumbersCollectorExample {
    public static void main(String[] args) {
        Map<Boolean, List<Integer>> primes = partitionPrimesWithCustomCollector(10);
        System.out.println(primes);
    }

    public static Map<Boolean, List<Integer>> partitionPrimesWithCustomCollector(int n) {
        return IntStream.rangeClosed(2, n).boxed()
                .collect(new PrimeNumbersCollector());
    }
}
