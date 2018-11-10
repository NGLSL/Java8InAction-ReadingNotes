package xin.codeream.java8.chap11;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * ShopMain
 *
 * @author NGLSL
 * @date 2018/11/10
 */
public class ShopMain {

    public static void main(String[] args) {
        Shop shop = new Shop("最好的商店");
        long start = System.nanoTime();
        Future<Double> futurePrice = shop.getPriceAsync("我最喜欢的商品");
        long invocationTime = ((System.nanoTime() - start) / 1_000_000);
        System.out.println("调用时间 " + invocationTime);
        // 这里可以做其他的事情，比如查询其他的商店
        doSomethingElse();
        // 计算商品价格
        try {
            double price = futurePrice.get();
            System.out.printf("价格是 %.2f%n", price);
        } catch (ExecutionException | InterruptedException e) {
            throw new RuntimeException(e);
        }
        long retrievalTime = ((System.nanoTime() - start) / 1_000_000);
        System.out.println("计算价格时间 " + retrievalTime);
    }

    private static void doSomethingElse() {
        System.out.println("正在查询其他的商店...");
    }

}
