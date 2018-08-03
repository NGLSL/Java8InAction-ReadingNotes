package xin.codedream.java8.chap2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Stream Demo
 *
 * @author NGLSL
 * @date 2018/7/29
 */
public class StreamDemo {
    public static void main(String[] args) {
        stringListInJava7();
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>");
        stringListInJava8();
    }

    private static void stringListInJava7() {
        List<String> stringList = Arrays.asList("a1", "a2", "b1", "c1", "c2", "c4", "c3");

        List<String> cList = new ArrayList<>();
        for (String s : stringList) {
            // 筛选出以c开头的字符串
            if (s.startsWith("c")) {
                // 将以c开头的字符串转为大写，添加到集合
                cList.add(s.toUpperCase());
            }
        }

        // 排序
        Collections.sort(cList);

        // 遍历打印
        for (String s : cList) {
            System.out.println(s);
        }
    }

    private static void stringListInJava8() {
        List<String> stringList = Arrays.asList("a1", "a2", "b1", "c1", "c2", "c4", "c3");

        stringList.stream()
                // 筛选出以c开头的字符串
                .filter(s -> s.startsWith("c"))
                // 将刚刚以c开头的字符串转为大写
                .map(String::toUpperCase)
                // 排序
                .sorted()
                // 循环遍历
                .forEach(System.out::println);
    }
}
