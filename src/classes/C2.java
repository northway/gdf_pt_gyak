package classes;

/**
 *
 * @author northway
 */
public class C2 extends C1 {

    int a = 2;

    @Override
    public void printMethod() {
        super.printMethod();
        System.out.println("C2 Subclass");
    }

}
