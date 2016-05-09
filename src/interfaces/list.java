package interfaces;

import java.util.*;

/**
 *
 * @author northway
 */
public class list {

  public static void main(String[] args) {
    
    // Creating a simple ArrayList
    List a1 = new ArrayList();
    
    a1.add("Braves");
    a1.add("Blue Jays");
    a1.add("Giants");
    a1.add("Yankees");
    a1.add("Rockies");
    
    System.out.println(a1);
    
    // Import the ArrayList to a TreeList
    TreeSet set = new TreeSet(a1);
    
    System.out.println(set);
    
    // Creating a simple LinkedList
    List l1 = new LinkedList();
    
    l1.add("Dodgers");
    l1.add("Red Sox");
    l1.add("Twins");
    l1.add("Brewers");
    
    System.out.println(l1);
    
  }
  
}
