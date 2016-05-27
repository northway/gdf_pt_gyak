package vizsga3;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 * Kórház alap osztály
 *
 * @author northway
 */
public class korhaz extends JFrame implements ActionListener {

  private static ArrayList<orvos> orvosok;
  private static ArrayList<beteg> betegek;

  private static JComboBox tipusCombo;
  private static DefaultListModel szemelyDmList;
  private static JList korhazList;

  public static void main(String[] args) {

    /**
     * Feltöltés init
     */
    feltoltes();

    /**
     * GUI
     */
    gui();

  }

  public korhaz() {

    korhaz.szemelyDmList = new DefaultListModel();

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

      b_tmp.setNev(id + " Takács Péter");
      b_tmp.setSzul_ev(1997 + 1);
      b_tmp.setKorterem_szam(id);

      betegek.add(b_tmp);
    }

  }

  /**
   * Random szám 100 és 999 között
   *
   * @return int
   */
  private static int getRand() {
    return 100 + (int) (Math.random() * ((999 - 100) + 1));
  }

  /**
   * Start swing gui
   */
  private static void gui() {

    korhaz ablak = new korhaz();

    /**
     * alapok
     */
    ablak.setTitle("Kórház");
    ablak.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    /**
     * Elemek hozzáadása
     */
    ablak.addComponentsToPane(ablak);

    /**
     * Véglegesítés
     */
    ablak.pack();
    ablak.setVisible(true);

  }

  /**
   * Elemek
   *
   * @param pane
   */
  public void addComponentsToPane(Container pane) {

    /**
     * Választható elemek
     */
    String[] tipusok = {"Válassz!", "Orvosok", "Betegek", "Összes"};

    tipusCombo = new JComboBox(tipusok);
    tipusCombo.addActionListener(this);

    pane.add(tipusCombo, BorderLayout.PAGE_START);

    /**
     * Scrollozható lista a közepére
     */
    JPanel pnList = new JPanel();

    JScrollPane scPanel = new JScrollPane();

    korhazList = new JList(szemelyDmList);

    pnList.add(korhazList);
    pnList.add(scPanel);
    scPanel.getViewport().add(korhazList);

    pane.add(pnList, BorderLayout.CENTER);

  }

  @Override
  public void actionPerformed(ActionEvent e) {

    JComboBox cb = (JComboBox) e.getSource();
    String valasztottElem = (String) cb.getSelectedItem();

    szemelyDmList.removeAllElements();

    if ("Orvosok".equals(valasztottElem)) {
      getOrvosokLista();
    }

    if ("Betegek".equals(valasztottElem)) {
      getBetegekLista();
    }

    if ("Összes".equals(valasztottElem)) {
      getOsszesSzemelyLista();
    }
  }

  private static void getBetegekLista() {
    for (beteg beteg : betegek) {
      szemelyDmList.addElement(beteg.getNev() + ", " + beteg.getSzul_ev() + ", " + beteg.getKorterem_szam());
    }
  }

  private static void getOrvosokLista() {
    for (orvos orvos : orvosok) {
      szemelyDmList.addElement(orvos.getNev() + ", " + orvos.getSzul_ev() + ", " + orvos.getSzak());
    }
  }

  private static void getOsszesSzemelyLista() {
    getOrvosokLista();
    getBetegekLista();
  }
}
