package xin.codeream.java8.chap11;

import java.util.List;
import java.util.function.Supplier;

/**
 * BestPriceFinderMain
 *
 * @author NGLSL
 * @date 2018/11/10
 */
public class BestPriceFinderMain {

    private static BestPriceFinder bestPriceFinder = new BestPriceFinder();

    public static void main(String[] args) {
        execute("sequential", () -> bestPriceFinder.findPricesSequential("Old-Mi-Mix3"));
        execute("parallel", () -> bestPriceFinder.findPricesParallel("Old-Mi-Mix3"));
        execute("composed CompletableFuture", () -> bestPriceFinder.findPricesFuture("Old-Mi-Mix3"));
    }

    private static void execute(String msg, Supplier<List<String>> s) {
        long start = System.nanoTime();
        System.out.println(s.get());
        long duration = (System.nanoTime() - start) / 1_000_000;
        System.out.println(msg + " 完成时间 " + duration);
    }
}
