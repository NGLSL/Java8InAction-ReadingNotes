package xin.codedream.java8.chap7;

import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * ParallelStreams
 *
 * @author NGLSL
 * @date 2018/10/6
 */
public class ParallelStreams {
    public static long sequentialSum(long n) {
        // 生成自然数无限流
        return Stream.iterate(1L, i -> i + 1)
                // 限制到前n个数
                .limit(n)
                // 对所有数字求和来归纳流
                .reduce(0L, Long::sum);
    }

    public static long iterativeSum(long n) {
        long result = 0;
        for (long i = 0; i <= n; i++) {
            result += i;
        }
        return result;
    }

    public static long parallelSum(long n) {
        // 生成自然数无限流
        return Stream.iterate(1L, i -> i + 1)
                // 限制到前n个数
                .limit(n)
                // 将流转为并行流
                .parallel()
                // 对所有数字求和来归纳流
                .reduce(0L, Long::sum);
    }

    public static long rangedSum(long n) {
        return LongStream.rangeClosed(1, n)
                .reduce(0L, Long::sum);
    }

    public static long parallelRangedSum(long n) {
        return LongStream.rangeClosed(1, n)
                .parallel()
                .reduce(0L, Long::sum);
    }

    public static long sideEffectSum(long n) {
        Accumulator accumulator = new Accumulator();
        LongStream.rangeClosed(1, n)
                .forEach(accumulator::add);
        return accumulator.total;
    }

    public static long sideEffectParallelSum(long n) {
        Accumulator accumulator = new Accumulator();
        LongStream.rangeClosed(1, n)
                .parallel()
                .forEach(accumulator::add);
        return accumulator.total;
    }

    public static class Accumulator {
        private long total = 0;

        public void add(long value) {
            total += value;
        }
    }
}
