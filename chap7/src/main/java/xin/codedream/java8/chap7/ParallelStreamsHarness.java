package xin.codedream.java8.chap7;

import java.util.concurrent.ForkJoinPool;
import java.util.function.Function;

/**
 * ParallelStreamsHarness
 *
 * @author NGLSL
 * @date 2018/10/6
 */
public class ParallelStreamsHarness {
    public static final ForkJoinPool FORK_JOIN_POOL = new ForkJoinPool();

    public static void main(String[] args) {
        /*System.out.println("Sequential sum done in:" +
                measurePerf(ParallelStreams::sequentialSum, 10_000_000) + " msecs");*/

        /*System.out.println("Iterative sum done in:" +
                measurePerf(ParallelStreams::iterativeSum, 10_000_000) + " msecs");*/

        /*System.out.println("Parallel sum done in: " +
                measurePerf(ParallelStreams::parallelSum, 10_000_000) + " msecs");*/

        /*System.out.println("Ranged sum done in: " +
                measurePerf(ParallelStreams::rangedSum, 10_000_000) + " msecs");*/

        /*System.out.println("Parallel range sum done in:" +
                measurePerf(ParallelStreams::parallelRangedSum, 10_000_000) +
                " msecs");*/

        /*System.out.println("SideEffect parallel sum done in: " +
                measurePerf(ParallelStreams::sideEffectParallelSum, 10_000_000L) + " msecs");*/

        System.out.println("ForkJoin sum done in: " + measurePerf(
                ForkJoinSumCalculator::forkJoinSum, 10_000_000) + " msecs");
    }

    public static long measurePerf(Function<Long, Long> adder, long n) {
        long fastest = Long.MAX_VALUE;
        for (int i = 0; i < 10; i++) {
            long start = System.nanoTime();
            long sum = adder.apply(n);
            long duration = (System.nanoTime() - start) / 1_000_000;
            System.out.println("Result: " + sum);
            if (duration < fastest) {
                fastest = duration;
            }
        }
        return fastest;
    }
}
