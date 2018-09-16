package xin.codedream.java8.chap06;

import java.util.*;

import static java.util.stream.Collectors.groupingBy;

/**
 * 分组交易
 *
 * @author NGLSL
 * @date 2018/9/15
 */
public class GroupingTransactions {
    private static List<Transaction> transactions = Arrays.asList(new Transaction(Currency.EUR, 1500.0),
            new Transaction(Currency.USD, 2300.0),
            new Transaction(Currency.GBP, 9900.0),
            new Transaction(Currency.EUR, 1100.0),
            new Transaction(Currency.JPY, 7800.0),
            new Transaction(Currency.CHF, 6700.0),
            new Transaction(Currency.EUR, 5600.0),
            new Transaction(Currency.USD, 4500.0),
            new Transaction(Currency.CHF, 3400.0),
            new Transaction(Currency.GBP, 3200.0),
            new Transaction(Currency.USD, 4600.0),
            new Transaction(Currency.JPY, 5700.0),
            new Transaction(Currency.EUR, 6800.0));

    public static void main(String[] args) {
        groupImperatively();
        groupFunctionally();
    }

    /**
     * Java7
     */
    private static void groupImperatively() {
        // 建立累积交易分组的Map
        Map<Currency, List<Transaction>> transactionsByCurrencies = new HashMap<>(16);
        // 迭代 Transaction 的 List
        for (Transaction transaction : transactions) {
            // 提取 Transaction的货币
            Currency currency = transaction.getCurrency();
            List<Transaction> transactionsForCurrency = transactionsByCurrencies.get(currency);
            // 如果分组 Map 中没有这种货币的条目，就创建一个
            if (transactionsForCurrency == null) {
                transactionsForCurrency = new ArrayList<>();
                transactionsByCurrencies.put(currency, transactionsForCurrency);
            }
            // 将当前遍历的 Transaction加入同一货币的 Transaction 的 List
            transactionsForCurrency.add(transaction);
        }
        System.out.println(transactionsByCurrencies);
    }

    /**
     * Java8
     */
    private static void groupFunctionally() {
        Map<Currency, List<Transaction>> transactionsByCurrencies = transactions.stream()
        .collect(groupingBy(Transaction::getCurrency));
        System.out.println(transactionsByCurrencies);
    }
}
