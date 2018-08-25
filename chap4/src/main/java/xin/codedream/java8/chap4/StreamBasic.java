package xin.codedream.java8.chap4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

/**
 * Java7 VS Java8
 *
 * @author NGLSL
 * @date 2018/8/24
 */
public class StreamBasic {

    public static void main(String[] args) {
        // Java 7
        getLowCaloricDishesNamesInJava7(Dish.MENU).forEach(System.out::println);

        System.out.println(">>>>>>>>>>>");

        // Java 8
        getLowCaloricDishesNamesInJava8(Dish.MENU).forEach(System.out::println);
    }

    /**
     * 使用Java7获取低于400卡路里的菜名
     *
     * @param dishes 菜单
     * @return List
     */
    private static List<String> getLowCaloricDishesNamesInJava7(List<Dish> dishes) {
        List<Dish> lowCaloricDishes = new ArrayList<>();
        // 遍历筛选出低于400卡路里的菜，添加到另外一个集合中
        for (Dish d : dishes) {
            if (d.getCalories() < 400) {
                lowCaloricDishes.add(d);
            }
        }

        // 对集合按照卡路里大小进行排序
        List<String> lowCaloricDishesName = new ArrayList<>();
        Collections.sort(lowCaloricDishes, new Comparator<Dish>() {
            @Override
            public int compare(Dish d1, Dish d2) {
                return Integer.compare(d1.getCalories(), d2.getCalories());
            }
        });

        // 遍历将菜名添加到另外一个集合中
        for (Dish d : lowCaloricDishes) {
            lowCaloricDishesName.add(d.getName());
        }
        return lowCaloricDishesName;
    }

    /**
     * 使用Java8中的Stream获取低于400卡路里的的菜名
     *
     * @param dishes 菜单
     * @return List
     */
    private static List<String> getLowCaloricDishesNamesInJava8(List<Dish> dishes) {
        return dishes
                // .parallelStream()
                .stream()
                // 选出400卡路里以下的菜肴
                .filter(d -> d.getCalories() < 400)
                // 按照卡路里排序
                .sorted(comparing(Dish::getCalories))
                // 提取菜名
                .map(Dish::getName)
                // 转为集合
                .collect(toList());
    }
}
