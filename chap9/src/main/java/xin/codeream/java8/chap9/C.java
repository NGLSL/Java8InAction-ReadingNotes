package xin.codeream.java8.chap9;

/**
 * C
 *
 * @author NGLSL
 * @date 2018/10/21
 */
public class C implements A, B {
    public static void main(String[] args) {
        new C().hello();
    }

    @Override
    public void hello() {
       System.out.println("Hello from C!");
    }
}
