package xin.codedream.java8.chap06;

/**
 * 交易
 *
 * @author NGLSL
 * @date 2018/9/15
 */
public class Transaction {
    private final Currency currency;
    private final Double value;

    public Transaction(Currency currency, Double value) {
        this.currency = currency;
        this.value = value;
    }

    public Currency getCurrency() {
        return currency;
    }

    public Double getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "currency=" + currency +
                ", value=" + value +
                '}';
    }
}
