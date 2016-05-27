
package vizsga3;

/**
 * Beteg osztály
 *
 * @author northway
 */
public class beteg extends szemely{
  
  /**
   * Kórterem száma
   */
  private int korterem_szam;

  /**
   * Kórterem száma getter
   * @return kórterem int
   */
  public int getKorterem_szam() {
    return korterem_szam;
  }

  /**
   * Kórterem száma szetter
   * @param korterem_szam int
   */
  public void setKorterem_szam(int korterem_szam) {
    this.korterem_szam = korterem_szam;
  }

  @Override
  public String toString() {
    return "beteg{" + "korterem_szam=" + korterem_szam + '}';
  }
  
}
