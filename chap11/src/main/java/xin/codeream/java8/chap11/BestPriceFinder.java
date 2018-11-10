package xin.codeream.java8.chap11;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

/**
 * BestPriceFinder
 *
 * @author NGLSL
 * @date 2018/11/10
 */
public class BestPriceFinder {
    private final List<Shop> shops = Arrays.asList(new Shop("BestPrice"),
            new Shop("LetsSaveBig"),
            new Shop("MyFavoriteShop"),
            new Shop("BuyItAll"),
            new Shop("ShopEasy"));

    private final Executor executor = Executors.newFixedThreadPool(shops.size(), new ThreadFactory() {
        @Override
        public Thread newThread(Runnable r) {
            Thread t = new Thread(r);
            t.setDaemon(true);
            return t;
        }
    });

    public static void main(String[] args) {
        BestPriceFinder finder = new BestPriceFinder();
        finder.testFindPrices();
    }

    public void testFindPrices() {
        long start = System.nanoTime();
        System.out.println(findPricesSequential("Old-Mi-Mix3"));
        long duration = (System.nanoTime() - start) / 1_000_000;
        System.out.println("完成时间 " + duration);
    }

    public List<String> findPricesParallel(String product) {
        return shops.parallelStream()
                .map(shop -> String.format("%s 价格 %.2f",
                        shop.getName(), shop.getPrice(product)))
                .collect(toList());
    }

    public List<String> findPricesSequential(String product) {
        return shops.stream()
                .map(shop -> String.format("%s 价格 %.2f",
                        shop.getName(), shop.getPrice(product)))
                .collect(toList());
    }


    public List<String> findPricesFuture(String product) {
        List<CompletableFuture<String>> priceFutures = shops.stream()
                .map(shop -> CompletableFuture.supplyAsync(() -> String.format("%s 价格 %.2f",
                        shop.getName(), shop.getPrice(product)), executor))
                .collect(toList());

        return priceFutures.stream()
                .map(CompletableFuture::join)
                .collect(Collectors.toList());
    }
}
