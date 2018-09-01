package xin.codedream.java.chap05;

import java.util.Arrays;
import java.util.List;

/**
 * 菜单
 *
 * @author NGLSL
 * @date 2018/8/24
 */
public class Dish {
    /**
     * 菜单
     */
    public static final List<Dish> MENU =
            Arrays.asList(new Dish("pork", false, 800, Dish.Type.MEAT),
                    new Dish("beef", false, 700, Dish.Type.MEAT),
                    new Dish("chicken", false, 400, Dish.Type.MEAT),
                    new Dish("french fries", true, 530, Dish.Type.OTHER),
                    new Dish("rice", true, 350, Dish.Type.OTHER),
                    new Dish("season fruit", true, 120, Dish.Type.OTHER),
                    new Dish("pizza", true, 550, Dish.Type.OTHER),
                    new Dish("prawns", false, 400, Dish.Type.FISH),
                    new Dish("salmon", false, 450, Dish.Type.FISH));

    /**
     * 菜名
     */
    private String name;
    /**
     * 是否是素菜
     */
    private Boolean vegetarian;
    /**
     * 卡路里
     */
    private Integer calories;
    /**
     * 菜类型
     */
    private Type type;

    public Dish(String name, boolean vegetarian, int calories, Type type) {
        this.name = name;
        this.vegetarian = vegetarian;
        this.calories = calories;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public Boolean isVegetarian() {
        return vegetarian;
    }

    public Integer getCalories() {
        return calories;
    }

    public Type getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Dish{" +
                "name='" + name + '\'' +
                ", vegetarian=" + vegetarian +
                ", calories=" + calories +
                ", type=" + type +
                '}';
    }

    public enum Type {
        /**
         * 菜的类型
         */
        MEAT, FISH, OTHER
    }
}
