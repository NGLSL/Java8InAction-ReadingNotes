package xin.codedream.java8.chap06;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.IntStream;

import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.*;

/**
 * CollectorsExample
 *
 * @author NGLSL
 * @date 2018/9/15
 */
public class CollectorsExample {
    public static void main(String[] args) {
        maxByExample();
        summingIntExample();
        averagingIntExample();
        summarizingIntExample();
        joiningExample();
        reducingExample();
        groupingByExample();
        groupingByExample2();
        partitioningByExample();
    }

    private static void partitioningByExample() {
        // 分区函数
        List<Dish> menu = Dish.MENU;
        Map<Boolean, List<Dish>> partitionedMenu =
                menu.stream().collect(partitioningBy(Dish::isVegetarian));
        System.out.println(partitionedMenu);

        // 找出素食
        List<Dish> vegetarianDishes = partitionedMenu.get(true);
        System.out.println(vegetarianDishes);

        Map<Boolean, Map<Dish.Type, List<Dish>>> vegetarianDishesByType =
                menu.stream().collect(
                        // 分区函数
                        partitioningBy(Dish::isVegetarian,
                                // 第二个收集器
                                groupingBy(Dish::getType)));
        System.out.println(vegetarianDishesByType);

        // 找到素食和非素食中热量最高的菜
        Map<Boolean, Dish> mostCaloricPartitionedByVegetarian = menu.stream().collect(
                partitioningBy(Dish::isVegetarian, collectingAndThen(
                        maxBy(comparingInt(Dish::getCalories)),
                        Optional::get
                )));
        System.out.println(mostCaloricPartitionedByVegetarian);

        Map<Boolean, List<Integer>> partitionPrimes = partitionPrimes(10);
        System.out.println(partitionPrimes);
    }

    private static void groupingByExample2() {
        // 查找每个子组中热量最高的 Dish
        List<Dish> menu = Dish.MENU;
        Map<Dish.Type, Dish> mostCaloricByType =
                menu.stream()
                        .collect(groupingBy(Dish::getType,
                                collectingAndThen(
                                        maxBy(comparingInt(Dish::getCalories)),
                                        Optional::get)));
        System.out.println(mostCaloricByType);

        Map<Dish.Type, Integer> totalCaloriesByType = menu.stream()
                .collect(groupingBy(Dish::getType,
                        summingInt(Dish::getCalories)));
        System.out.println(totalCaloriesByType);

        /*Map<Dish.Type, Set<Dish.CaloricLevel>> caloricLevelsByType =
                menu.stream().collect(
                        groupingBy(Dish::getType, mapping(
                                dish -> {
                                    if (dish.getCalories() <= 400) {
                                        return Dish.CaloricLevel.DIET;
                                    } else if (dish.getCalories() <= 700) {
                                        return Dish.CaloricLevel.NORMAL;
                                    } else {
                                        return Dish.CaloricLevel.FAT;
                                    }
                                },
                                toSet())));*/
        Map<Dish.Type, Set<Dish.CaloricLevel>> caloricLevelsByType =
                menu.stream().collect(
                        groupingBy(Dish::getType, mapping(
                                dish -> {
                                    if (dish.getCalories() <= 400) {
                                        return Dish.CaloricLevel.DIET;
                                    } else if (dish.getCalories() <= 700) {
                                        return Dish.CaloricLevel.NORMAL;
                                    } else {
                                        return Dish.CaloricLevel.FAT;
                                    }
                                },
                                toCollection(HashSet::new))));
        System.out.println(caloricLevelsByType);
    }

    private static void groupingByExample() {
        List<Dish> menu = Dish.MENU;
        Map<Dish.Type, List<Dish>> dishesByType =
                menu.stream().collect(groupingBy(Dish::getType));
        System.out.println(dishesByType);

        Map<Dish.CaloricLevel, List<Dish>> dishesByCaloricLevel = menu.stream().collect(
                groupingBy(dish -> {
                    if (dish.getCalories() <= 400) {
                        return Dish.CaloricLevel.DIET;
                    } else if (dish.getCalories() <= 700) {
                        return Dish.CaloricLevel.NORMAL;
                    } else {
                        return Dish.CaloricLevel.FAT;
                    }
                }));
        System.out.println(dishesByCaloricLevel);

        Map<Dish.Type, Map<Dish.CaloricLevel, List<Dish>>> dishesByTypeCaloricLevel =
                menu.stream().collect(
                        groupingBy(Dish::getType,
                                groupingBy(dish -> {
                                    if (dish.getCalories() <= 400) {
                                        return Dish.CaloricLevel.DIET;
                                    } else if (dish.getCalories() <= 700) {
                                        return Dish.CaloricLevel.NORMAL;
                                    } else {
                                        return Dish.CaloricLevel.FAT;
                                    }
                                })
                        )
                );

        System.out.println(dishesByTypeCaloricLevel);

        Map<Dish.Type, Long> typesCount = menu.stream().collect(
                groupingBy(Dish::getType, counting()));
        System.out.println(typesCount);

        Map<Dish.Type, Optional<Dish>> mostCaloricByType =
                menu.stream()
                        .collect(groupingBy(Dish::getType,
                                maxBy(comparingInt(Dish::getCalories))));

        System.out.println(mostCaloricByType);
    }

    private static void reducingExample() {
        List<Dish> menu = Dish.MENU;
        int totalCalories = menu.stream().collect(reducing(
                0, Dish::getCalories, (i, j) -> i + j));
        System.out.println(totalCalories);

        Optional<Dish> mostCalorieDish =
                menu.stream().collect(reducing(
                        (d1, d2) -> d1.getCalories() > d2.getCalories() ? d1 : d2));
        System.out.println(mostCalorieDish.get());

        int totalCalories2 = menu.stream()
                .collect(reducing(0,
                        Dish::getCalories,
                        Integer::sum));
        System.out.println(totalCalories2);
    }

    private static void joiningExample() {
        List<Dish> menu = Dish.MENU;
        // String shortMenu = menu.stream().map(Dish::getName).collect(joining());
        String shortMenu = menu.stream().map(Dish::getName).collect(joining(", "));
        System.out.println(shortMenu);
    }

    private static void summarizingIntExample() {
        List<Dish> menu = Dish.MENU;
        IntSummaryStatistics menuStatistics =
                menu.stream().collect(summarizingInt(Dish::getCalories));
        System.out.println(menuStatistics.getMax());
        System.out.println(menuStatistics.getAverage());
        System.out.println(menuStatistics.getMin());
        System.out.println(menuStatistics.getCount());
        System.out.println(menuStatistics.getSum());
    }

    private static void averagingIntExample() {
        List<Dish> menu = Dish.MENU;
        double avgCalories =
                menu.stream().collect(averagingInt(Dish::getCalories));
        System.out.println(avgCalories);
    }

    private static void summingIntExample() {
        List<Dish> menu = Dish.MENU;
        int totalCalories = menu.stream().collect(summingInt(Dish::getCalories));
        System.out.println(totalCalories);
    }

    private static void maxByExample() {
        List<Dish> menu = Dish.MENU;
        Comparator<Dish> dishCaloriesComparator =
                comparingInt(Dish::getCalories);
        Optional<Dish> mostCalorieDish =
                menu.stream().max(dishCaloriesComparator);
        System.out.println(mostCalorieDish.get());
    }

    private static boolean isPrime(int candidate) {
        int candidateRoot = (int) Math.sqrt((double) candidate);
        return IntStream.rangeClosed(2, candidateRoot)
                .noneMatch(i -> candidate % i == 0);
    }

    public static Map<Boolean, List<Integer>> partitionPrimes(int n) {
        return IntStream.rangeClosed(2, n).boxed()
                .collect(
                        partitioningBy(candidate -> isPrime(candidate)));
    }

    public static boolean isPrime(List<Integer> primes, Integer candidate){
        int candidateRoot = (int) Math.sqrt((double) candidate);
        return takeWhile(primes, i -> i <= candidateRoot)
                .stream()
                .noneMatch(p -> candidate % p == 0);
    }

    public static <A> List<A> takeWhile(List<A> list, Predicate<A> p) {
        int i = 0;
        for (A item : list) {
            if (!p.test(item)) {
                return list.subList(0, i);
            }
            i++;
        }
        return list;
    }
}
