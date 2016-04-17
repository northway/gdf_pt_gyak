package classes;

/**
 *
 * @author northway
 */
public class C3 extends C2 {

    static String str = "C3";

    int b = 30;

    public static void main(String[] args) {

        System.out.println(C1.str + " " + C2.str + " " + str);

        C2 s = new C2();
        s.printMethod();
    }

}
