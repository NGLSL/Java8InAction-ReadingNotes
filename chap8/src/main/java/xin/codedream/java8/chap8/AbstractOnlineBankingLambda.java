package xin.codedream.java8.chap8;

import java.util.function.Consumer;

/**
 * AbstractOnlineBankingLambda
 *
 * @author NGLSL
 * @date 2018/10/14
 */
public class AbstractOnlineBankingLambda {
    public static void main(String[] args) {
        new AbstractOnlineBankingLambda().processCustomer(1337, (AbstractOnlineBankingLambda.Customer c) -> System.out.println("Hello!"));
    }

    public void processCustomer(int id, Consumer<Customer> makeCustomerHappy) {
        Customer customer = Database.getCustomerWithId(id);
        makeCustomerHappy.accept(customer);
    }

    private static class Customer {
    }

    private static class Database {
        static Customer getCustomerWithId(int id) {
            return new Customer();
        }
    }
}
