package xin.codedream.java.chap05;

import java.util.List;
import java.util.OptionalInt;
import java.util.stream.IntStream;

/**
 * 数值流
 *
 * @author NGLSL
 * @date 2018/9/9
 */
public class NumericStreams {
    public static void main(String[] args) {
        // 映射到数值流
        List<Dish> menu = Dish.MENU;
        int calories = menu.stream()
                // 返回一个IntStream
                .mapToInt(Dish::getCalories)
                .sum();
        System.out.println(calories);

        // 获取最大的卡路里
        OptionalInt maxCalories = menu.stream()
                .mapToInt(Dish::getCalories)
                .max();
        System.out.println(maxCalories.orElse(1));

        // 一个从1到100的偶数流 包含结束值
        IntStream evenNumbers = IntStream.rangeClosed(1, 100)
                .filter(n -> n % 2 == 0);
        // 从1到100共有50个偶数
        System.out.println(evenNumbers.count());
    }
}
