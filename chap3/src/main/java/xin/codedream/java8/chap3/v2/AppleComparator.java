package xin.codedream.java8.chap3.v2;

import xin.codedream.java8.chap3.Apple;

import java.util.Comparator;

/**
 * AppleComparator
 *
 * @author NGLSL
 * @date 2018/8/18
 */
public class AppleComparator implements Comparator<Apple> {
    @Override
    public int compare(Apple o1, Apple o2) {
        return o1.getWeight().compareTo(o2.getWeight());
    }
}
