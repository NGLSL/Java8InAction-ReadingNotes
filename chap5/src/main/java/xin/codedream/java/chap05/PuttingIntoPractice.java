package xin.codedream.java.chap05;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * 付诸实战
 *
 * @author NGLSL
 * @date 2018/9/7
 */
public class PuttingIntoPractice {
    public static void main(String[] args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

        // 1.找出2011年发生的所有交易，并按交易额排序（从低到高）。
        List<Transaction> tr2011 = transactions.stream()
                // 筛选出2011年发生的所有交易
                .filter(transaction -> transaction.getYear() == 2011)
                // 按照交易额从低到高排序
                .sorted(Comparator.comparing(Transaction::getValue))
                // 转为集合
                .collect(Collectors.toList());
        System.out.println(tr2011);

        // 2.交易员都在哪些不同的城市工作过？
        List<String> cities = transactions.stream()
                // 提取出交易员所工作的城市
                .map(transaction -> transaction.getTrader().getCity())
                // 去除已有的城市
                .distinct()
                // 将Stream中所有的元素转为一个List集合
                .collect(Collectors.toList());
        System.out.println(cities);

        // 3.查找所有来自于剑桥的交易员，并按姓名排序。
        List<Trader> traders = transactions.stream()
                // 从交易中提取所有的交易员
                .map(Transaction::getTrader)
                // 进选择位于剑桥的交易员
                .filter(trader -> "Cambridge".equals(trader.getCity()))
                // 确保没有重复
                .distinct()
                // 对生成的交易员流按照姓名进行排序
                .sorted(Comparator.comparing(Trader::getName))
                .collect(Collectors.toList());
        System.out.println(traders);

        // 4.返回所有交易员的姓名字符串，按字母顺序排序。
        String traderStr =
                transactions.stream()
                        // 提取所有交易员姓名，生成一个 Strings 构成的 Stream
                        .map(transaction -> transaction.getTrader().getName())
                        // 只选择不相同的姓名
                        .distinct()
                        // 对姓名按字母顺序排序
                        .sorted()
                        // 逐个拼接每个名字，得到一个将所有名字连接起来的 String
                        .reduce("", (n1, n2) -> n1 + " " + n2);
        System.out.println(traderStr);

        // 5.没有交易员是在米兰工作的
        boolean milanBased =
                transactions.stream()
                        // 把一个谓词传递给 anyMatch ，检查是否有交易员在米兰工作
                        .anyMatch(transaction -> "Milan".equals(transaction.getTrader()
                                .getCity()));
        System.out.println(milanBased);

        // 6.打印生活在剑桥的交易员的所有交易额。
        transactions.stream()
                // 选择住在剑桥的交易员所进行的交易
                .filter(t -> "Cambridge".equals(t.getTrader().getCity()))
                // 提取这些交易的交易额
                .map(Transaction::getValue)
                // 打印每个值
                .forEach(System.out::println);

        // 7.所有交易中，最高的交易额是多少
        Optional<Integer> highestValue =
                transactions.stream()
                        // 提取每项交易的交易额
                        .map(Transaction::getValue)
                        // 计算生成的流中的最大值
                        .reduce(Integer::max);
        System.out.println("max:" + highestValue.get());

        // 8.找到交易额最小的交易。
        Optional<Transaction> smallestTransaction =
                transactions.stream()
                        // 通过反复比较每个交易的交易额，找出最小的交易
                        .reduce((t1, t2) ->
                                t1.getValue() < t2.getValue() ? t1 : t2);
        System.out.println("min:" + smallestTransaction.get().getValue());
    }
}
