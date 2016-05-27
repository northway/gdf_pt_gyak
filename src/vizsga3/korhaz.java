package vizsga3;

import java.util.ArrayList;
import java.util.TreeSet;

/**
 * Kórház alap osztály
 *
 * @author northway
 */
public class korhaz {

  private static ArrayList<orvos> orvosok;
  private static ArrayList<beteg> betegek;

  public static void main(String[] args) {

    /**
     * Feltöltés init
     */
    feltoltes();

  }

  private static void feltoltes() {
    /**
     * Orvosok feltöltés
     */
    orvosok = new ArrayList<>();

    for (int i = 0; i < 5; i++) {

      orvos o_tmp = new orvos();

      int id = getRand();
      
      o_tmp.setNev(id + " Kovács Tamás");
      o_tmp.setSzul_ev(1987 + i);
      o_tmp.setSzak("Belgyógyász");

      orvosok.add(o_tmp);
    }

    /**
     * Betegek feltöltés
     */
    betegek = new ArrayList<>();

    for (int i = 0; i < 5; i++) {

      beteg b_tmp = new beteg();

      int id = getRand();
      
      b_tmp.setNev(id +  "Takács Péter");
      b_tmp.setSzul_ev(1997 + 1);
      b_tmp.setKorterem_szam(id);

      betegek.add(b_tmp);
    }

  }

  /**
   * Random szám 1 és 999 között
   * 
   * @return int 
   */
  private static int getRand() {
    return 1 + (int) (Math.random() * ((999 - 1) + 1));
  }

}
