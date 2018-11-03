package xin.codeream.java8.chap10;

import java.util.Optional;

/**
 * Car
 *
 * @author NGLSL
 * @date 2018/11/3
 */
public class Car {
    private Optional<Insurance> insurance;

    public Optional<Insurance> getInsurance() {
        return insurance;
    }
}
