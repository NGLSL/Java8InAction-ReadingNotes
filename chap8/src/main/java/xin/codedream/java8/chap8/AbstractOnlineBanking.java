package xin.codedream.java8.chap8;

/**
 * AbstractOnlineBanking
 *
 * @author NGLSL
 * @date 2018/10/14
 */
public abstract class AbstractOnlineBanking {
    public void processCustomer(int id) {
        Customer customer = Database.getCustomerWithId(id);
        makeCustomerHappy(customer);
    }

    /**
     * 让客户满意
     *
     * @param customer
     */
    abstract void makeCustomerHappy(Customer customer);

    private static class Customer {}

    private static class Database {
        static Customer getCustomerWithId(int id) {
            return new Customer();
        }
    }
}
