package xin.codedream.java.chap05;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * 查找
 *
 * @author NGLSL
 * @date 2018/9/2
 */
public class Finding {
    public static void main(String[] args) {
        example1(Dish.MENU);
        example2(Dish.MENU);
        example3(Dish.MENU);
        findAny(Dish.MENU);
        findFirst(Dish.MENU);
    }

    private static void findFirst(List<Dish> menu) {
        List<Integer> someNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        Optional<Integer> firstSquareDivisibleByThree =
                someNumbers.stream()
                        .map(x -> x * x)
                        .filter(x -> x % 3 == 0)
                        // 9
                        .findFirst();
        System.out.println("First Number:" + firstSquareDivisibleByThree.get());
    }

    private static void findAny(List<Dish> menu) {
        Optional<Dish> dish = menu.stream()
                .filter(Dish::isVegetarian)
                .findAny();
        System.out.println("菜单中第一个素食名称：" + dish.get().getName());
    }

    private static void example3(List<Dish> menu) {
        boolean isHealthy = menu.stream()
                .noneMatch(d -> d.getCalories() >= 1000);
        System.out.println("卡路里是否都大于等于1000：" + isHealthy);
    }

    /**
     * 匹配所有菜的卡路里都低于1000
     *
     * @param menu
     */
    private static void example2(List<Dish> menu) {
        boolean isHealthy = menu.stream()
                .allMatch(d -> d.getCalories() < 1000);
        System.out.println("卡路里是否都低于1000:" + isHealthy);
    }

    /**
     * 匹配元素中是否有素菜
     *
     * @param menu
     */
    private static void example1(List<Dish> menu) {
        if (menu.stream().anyMatch(Dish::isVegetarian)) {
            System.out.println("有素菜，不用担心！");
        }
    }
}
