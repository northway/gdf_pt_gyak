package interfaces;

import java.util.*;

/**
 *
 * @author northway
 */
public class map {

  public static void main(String[] args) {

    // Simple Map
    Map m1 = new HashMap();

    m1.put("D-Backs", 4);
    m1.put("Dodgers", 2);
    m1.put("Padres", 3);
    m1.put("Rockies", 5);
    m1.put("Giants", 1);

    System.out.println(m1);

    // TreeMap, fordítve? Int String sorrendben?
    TreeMap tm = new TreeMap();

    tm.put("Blue Jays", 4);
    tm.put("Yankees", 2);
    tm.put("Red Sox", 3);
    tm.put("Rays", 5);
    tm.put("Orioles", 1);

    System.out.println(tm);

    Set set = tm.entrySet();

    System.out.println(set);

    Iterator i = set.iterator();

    while (i.hasNext()) {
      Map.Entry me = (Map.Entry) i.next();
      System.out.print(me.getKey()+ ": ");
      System.out.println(me.getValue());
    }
    
    Integer pos5 = ((Integer) tm.get("Rays"));
    Integer pos4 = ((Integer) tm.get("Blue Jays"));
    
    tm.put("Rays", (pos5-1));
    tm.put("Blue Jays", (pos4+1));
    
    System.out.println(tm);

  }

}
