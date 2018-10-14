package xin.codedream.java8.chap8;

import java.util.function.Function;
import java.util.function.UnaryOperator;

/**
 * ChainOfResponsibilityMain
 *
 * @author NGLSL
 * @date 2018/10/14
 */
public class ChainOfResponsibilityMain {

    public static void main(String[] args) {
        AbstractProcessingObject<String> p1 = new HeaderTextProcessing();
        AbstractProcessingObject<String> p2 = new SpellCheckerProcessing();
        p1.setSuccessor(p2);
        String result = p1.handle("Aren't labdas really sexy?!!");
        System.out.println(result);

        UnaryOperator<String> headerProcessing =
                (String text) -> "From Raoul, Mario and Alan: " + text;
        UnaryOperator<String> spellCheckerProcessing =
                (String text) -> text.replaceAll("labda", "lambda");
        Function<String, String> pipeline = headerProcessing.andThen(spellCheckerProcessing);
        String result2 = pipeline.apply("Aren't labdas really sexy?!!");
        System.out.println(result2);
    }

    private static abstract class AbstractProcessingObject<T> {
        protected AbstractProcessingObject<T> successor;

        public void setSuccessor(AbstractProcessingObject<T> successor) {
            this.successor = successor;
        }

        public T handle(T input) {
            T r = handleWork(input);
            if (successor != null) {
                return successor.handle(r);
            }
            return r;
        }

        protected abstract T handleWork(T input);
    }

    private static class HeaderTextProcessing extends AbstractProcessingObject<String> {

        @Override
        protected String handleWork(String text) {
            return "From Raoul, Mario and Alan: " + text;
        }
    }

    private static class SpellCheckerProcessing extends AbstractProcessingObject<String> {

        @Override
        protected String handleWork(String text) {
            return text.replaceAll("labda", "lambda");
        }
    }
}
