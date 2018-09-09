package xin.codedream.java.chap05;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.function.IntSupplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 构建流
 *
 * @author NGLSL
 * @date 2018/9/9
 */
public class BuildingStreams {
    public static void main(String[] args) {
        Stream<String> stream = Stream.of("Java 8 ", "Lambdas ", "In ", "Action");
        stream.map(String::toUpperCase).forEach(System.out::println);

        int[] numbers = {2, 3, 5, 7, 11, 13};
        int sum = Arrays.stream(numbers).sum();
        System.out.println(sum);

        long uniqueWords;
        try (Stream<String> lines = Files.lines(Paths.get(ClassLoader.getSystemResource("data.txt").toURI()),
                Charset.defaultCharset())) {
            uniqueWords = lines.flatMap(line -> Arrays.stream(line.split(" ")))
                    .distinct()
                    .count();
            System.out.println("uniqueWords:" + uniqueWords);
        } catch (IOException e) {
            e.fillInStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        Stream.iterate(0, n -> n + 2)
                .limit(10)
                .forEach(System.out::println);

        Stream.generate(Math::random)
                .limit(5)
                .forEach(System.out::println);

        // 生成无限流
        IntStream ones = IntStream.generate(() -> 1);

        IntStream twos = IntStream.generate(new IntSupplier() {
            @Override
            public int getAsInt() {
                return 2;
            }
        });

        System.out.println("--->斐波那契数列");
        IntSupplier fib = new IntSupplier() {
            private int previous = 0;
            private int current = 1;

            @Override
            public int getAsInt() {
                int oldPrevious = this.previous;
                int nextValue = this.previous + this.current;
                this.previous = this.current;
                this.current = nextValue;
                return oldPrevious;
            }
        };
        IntStream.generate(fib).limit(10).forEach(System.out::println);
    }
}
