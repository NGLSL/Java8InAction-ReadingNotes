package xin.codedream.java.chap05;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * Example
 *
 * @author NGLSL
 * @date 2018/8/31
 */
public class Example {
    public static void main(String[] args) {
        List<Dish> menu = Dish.MENU;
        example1(menu);
        System.out.println("---------");
        example2(menu);
        System.out.println("---------");
        example3();
        System.out.println("---------");
        example4(menu);
        System.out.println("---------");
        example5(menu);
        System.out.println("---------");
        example6(menu);
        System.out.println("---------");
        example7(menu);
        System.out.println("---------");
        example8(menu);
        System.out.println("---------");
        example9();
    }

    /**
     * 使用扁平化流给单词去重复
     */
    private static void example9() {
        String[] arrayOfWords = {"Hello", "World"};
        Stream<String> streamOfwords = Arrays.stream(arrayOfWords);
        List<String> uniqueCharacters = streamOfwords
                // 将每个单词转换为由其字母构成的数组
                .map(w -> w.split(""))
                // 将各个生成流扁平化为单个流
                .flatMap(Arrays::stream)
                .distinct()
                .collect(Collectors.toList());
        uniqueCharacters.forEach(System.out::print);
    }

    /**
     * 单词去重复
     *
     * @param menu
     */
    private static void example8(List<Dish> menu) {
        List<String> words = Arrays.asList("Hello", "World");
        List<String[]> wordList = words.stream()
                .map(word -> word.split(""))
                .distinct()
                .collect(Collectors.toList());
        wordList.forEach(wordArray -> {
            for (String s : wordArray) {
                System.out.print(s);
            }
            System.out.println();
        });
    }

    /**
     * 映射长度
     *
     * @param menu
     */
    private static void example7(List<Dish> menu) {
        List<Integer> len = menu.stream()
                .map(dish -> dish.getName().length())
                .collect(toList());
        System.out.println(len);
    }

    /**
     * 映射元素
     *
     * @param menu 菜单
     */
    private static void example6(List<Dish> menu) {
        List<String> dishNames = menu.stream()
                .map(Dish::getName)
                .collect(toList());
        System.out.println(dishNames);
    }

    /**
     * 跳过
     *
     * @param menu 菜单
     */
    private static void example5(List<Dish> menu) {
        List<Dish> dishes = menu.stream()
                .filter(d -> d.getCalories() > 300)
                .skip(2)
                .collect(toList());
        dishes.forEach(dish -> System.out.println(dish.getName()));
    }

    /**
     * 截断
     *
     * @param menu 菜单
     */
    private static void example4(List<Dish> menu) {
        List<Dish> dishes = menu.stream()
                .filter(d -> d.getCalories() > 300)
                .limit(3)
                .collect(toList());
        // pork beef chicken
        dishes.forEach(dish -> System.out.println(dish.getName()));
    }

    /**
     * 去除重复
     */
    private static void example3() {
        List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 3, 2, 4);
        numbers.stream()
                .filter(i -> i % 2 == 0)
                .distinct()
                .forEach(System.out::println);
    }

    /**
     * 使用Java8的方式筛选和遍历
     *
     * @param menu 菜单
     */
    private static void example2(List<Dish> menu) {
        List<Dish> vegetarianDishes =
                menu.stream()
                        // 方法引用检查菜肴是否适合素食者
                        .filter(Dish::isVegetarian)
                        .collect(toList());
        System.out.println(vegetarianDishes);
    }

    /**
     * 使用Java8之前的方式
     *
     * @param menu 菜单
     */
    private static void example1(List<Dish> menu) {
        List<Dish> vegetarianDishes = new ArrayList<>();
        for (Dish d : menu) {
            if (d.isVegetarian()) {
                vegetarianDishes.add(d);
            }
        }
        System.out.println(vegetarianDishes);
    }
}
