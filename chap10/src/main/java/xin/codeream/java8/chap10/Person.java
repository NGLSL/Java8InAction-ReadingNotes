package xin.codeream.java8.chap10;

import java.util.Optional;

/**
 * Person
 *
 * @author NGLSL
 * @date 2018/11/3
 */
public class Person {
    private Optional<Car> car;

    public Optional<Car> getCar() {
        return car;
    }
}
