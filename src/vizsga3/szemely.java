
package vizsga3;

/**
 * Személy osztály
 *
 * @author northway
 */
public class szemely {
  
  /**
   * Személy neve
   */
  private String nev;
  
  /**
   * Születés éve
   */
  private int szul_ev;

  /**
   * Személy neve getter
   * @return név String
   */
  public String getNev() {
    return nev;
  }

  /**
   * Személy neve szetter
   * @param nev String
   */
  public void setNev(String nev) {
    this.nev = nev;
  }

  /**
   * Születés éve getter
   * @return évszám int
   */
  public int getSzul_ev() {
    return szul_ev;
  }

  /**
   * Születés éve szetter
   * @param szul_ev int
   */
  public void setSzul_ev(int szul_ev) {
    this.szul_ev = szul_ev;
  }

  @Override
  public String toString() {
    return "szemely{" + "nev=" + nev + ", szul_ev=" + szul_ev + '}';
  }
  
}
