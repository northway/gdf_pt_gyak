package interfaces;

import java.util.*;

/**
 *
 * @author northway
 */
public class set {

  public static void main(String[] args) {

    int count[] = {34, 22, 10, 60, 30, 22};

    Set<Integer> set = new HashSet<>();

    try {

      for (int i = 0; i < 5; i++) {

        set.add(count[i]);

      }

      // Simple set
      System.out.println(set);

      TreeSet sortedSet = new TreeSet<>(set);

      // Sorted tree set from set
      System.out.println(sortedSet);

      // Fisrt element of the set
      System.out.println(sortedSet.first());

      // Last element of the set
      System.out.println(sortedSet.last());

      System.out.println(sortedSet.lower(34));
      System.out.println(sortedSet.ceiling(34));

    } catch (Exception e) {

      System.err.println(e.getMessage());

    }

  }

}
