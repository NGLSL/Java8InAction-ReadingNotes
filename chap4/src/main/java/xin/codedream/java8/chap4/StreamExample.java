package xin.codedream.java8.chap4;

import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * StreamExample
 *
 * @author NGLSL
 * @date 2018/8/24
 */
public class StreamExample {
    public static void main(String[] args) {
        example1();
        example2();
        example3();
    }

    private static void example3() {
        List<Dish> menu = Dish.MENU;


        List<String>  names = menu.stream()
                .filter(d -> {
                    System.out.println("filtering:" + d.getName());
                    return d.getCalories() > 300;
                })
                .map(dish -> {
                    System.out.println("mapping:" + dish.getName());
                    return dish.getName();
                })
                .limit(3)
                .collect(toList());
        System.out.println(names);
    }

    private static void example2() {
        List<Dish> menu = Dish.MENU;

        List<String> names = menu.stream()
                .map(Dish::getName)
                .collect(toList());
        System.out.println(names);
    }

    private static void example1() {
        List<Dish> menu = Dish.MENU;
        // 从menu获得流
        List<String> threeHighCaloricDishNames = menu.stream()
                // 通过链式操作，筛选出高热量的菜肴
                .filter(d -> d.getCalories() > 300)
                // 获取菜名
                .map(Dish::getName)
                .limit(3)
                .collect(toList());
        // [pork, beef, chicken]
        System.out.println(threeHighCaloricDishNames);
    }
}
