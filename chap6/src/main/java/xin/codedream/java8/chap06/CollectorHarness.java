package xin.codedream.java8.chap06;

import java.util.function.Consumer;

/**
 * CollectorHarness
 *
 * @author NGLSL
 * @date 2018/9/23
 */
public class CollectorHarness {
    public static void main(String[] args) {
        excute(PrimeNumbersCollectorExample::partitionPrimesWithCustomCollector);
    }

    private static void excute(Consumer<Integer> primePartitioner) {
        long fastest = Long.MAX_VALUE;
        // 运行十次
        for (int i = 0; i < 10; i++) {
            long start = System.nanoTime();
            // 将前100万个自然数按指数和非质数区分
            // partitionPrimes(1_000_000);
            primePartitioner.accept(1_000_000);
            long duration = (System.nanoTime() - start) / 1_000_000;
            // 检查这个执行是否是最快的一个
            if (duration < fastest) {
                fastest = duration;
            }
            System.out.println("done in " + duration);
        }
        System.out.println("Fastest execution done in " + fastest + " msecs");
    }
}
