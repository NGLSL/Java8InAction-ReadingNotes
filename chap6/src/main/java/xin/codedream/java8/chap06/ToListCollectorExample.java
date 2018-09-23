package xin.codedream.java8.chap06;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * ToListCollectorExample
 *
 * @author NGLSL
 * @date 2018/9/22
 */
public class ToListCollectorExample {
    public static void main(String[] args) {
        Stream<Dish> menuStream = Dish.MENU.stream();
        // List<Dish> dishes = menuStream.collect(new ToListCollector<>());

        List<Dish> dishes = menuStream.collect(
                ArrayList::new,
                List::add,
                List::addAll);
    }
}
