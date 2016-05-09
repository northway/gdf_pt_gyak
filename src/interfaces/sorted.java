package interfaces;

import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 *
 * @author northway
 */
public class sorted {

  public static void main(String[] args) {
    
    SortedSet set = new TreeSet();
    
    set.add("a");
    set.add("f");
    set.add("x");
    set.add("x");
    set.add("h");
    set.add("k");
    
    System.out.println(set);
    
    Iterator it = set.iterator();
    
    while (it.hasNext()) {
      Object next = it.next();
      System.out.println(next.toString());
    }
    
  }
  
}
