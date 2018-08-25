package xin.codedream.java8.chap4;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * StreamVsCollection
 *
 * @author NGLSL
 * @date 2018/8/25
 */
public class StreamVsCollection {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Java8", "Lambdas", "In", "Action");
        Stream<String> s = names.stream();
        s.forEach(System.out::println);
        // 再继续执行一次，则会抛出异常
        // s.forEach(System.out::println);
    }
}
