
package vizsga3;

/**
 * Orvos osztály
 *
 * @author northway
 */
public class orvos extends szemely{
  
  /**
   * Orvos szakja
   */
  private String szak;

  /**
   * Orvos szakja getter
   * @return szak String
   */
  public String getSzak() {
    return szak;
  }

  /**
   * Orvos szakja szetter
   * @param szak String
   */
  public void setSzak(String szak) {
    this.szak = szak;
  }

  @Override
  public String toString() {
    return "orvos{" + "szak=" + szak + '}';
  }
  
}
