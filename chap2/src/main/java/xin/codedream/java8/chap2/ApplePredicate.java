package xin.codedream.java8.chap2;

/**
 * ApplePredicate
 *
 * @author NGLSL
 * @version 1.0
 * @date 2018/8/3
 */
public interface ApplePredicate {
    /**
     * 根据给定的参数计算此谓词。
     *
     * @param apple
     * @return
     */
    boolean test(Apple apple);
}
