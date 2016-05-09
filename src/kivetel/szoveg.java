package kivetel;

/**
 *
 * @author northway
 */
public class szoveg {

  private static String[] FillStr() {

    String[] str = new String[3];

    try {
      for (int i = 0; i < 4; i++) {
        System.out.print("[" + (i + 1) + "/4] Írjon be egy szöveget: ");
        str[i] = extra.Console.readLine();
      }
    } catch (Exception e) {
      throw new RuntimeException("Elfogyott a tömb");
    }

    return str;
  }

  public static void main(String[] args) {

    FillStr();

  }

}
