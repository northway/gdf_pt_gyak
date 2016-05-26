package vizsga2;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeSet;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

/**
 *
 * @author northway
 */
public class vizsga extends JFrame implements ActionListener, KeyListener {

  private final JTextField jtSzoveg;

  private final JButton jbMentes;
  private final JButton jbVissza;
  private final JButton jbKilep;

  private final DefaultListModel dm;
  private final JList jlLista;
  private final JScrollPane scPanel;

  private final ArrayList szovegLista;

  public static void main(String[] args) {
    gui();
  }

  /**
   * GUI összeállítása
   */
  private static void gui() {

    // frame init
    vizsga ablak = new vizsga();

    // alapbeállítások
    ablak.setTitle("Vizsga");
    ablak.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // komponensek hozzáadása
    ablak.addComponentsToPane(ablak);

    // véglegesítés
    ablak.pack();
    ablak.setVisible(true);
  }

  /**
   * Konstruktor
   */
  public vizsga() {
    this.jtSzoveg = new JTextField("Ide írj!");
    this.jbMentes = new JButton("Mentés");
    this.jbVissza = new JButton("Vissza");
    this.jbKilep = new JButton("Kilépés");
    this.dm = new DefaultListModel();
    this.jlLista = new JList(dm);
    this.scPanel = new JScrollPane();
    this.szovegLista = new ArrayList();
  }

  /**
   * Komponensek összeállítása
   *
   * @param pane Container
   */
  public void addComponentsToPane(Container pane) {

    /**
     * Szöveges mező a telejére
     */
    jtSzoveg.requestFocus();
    jtSzoveg.addKeyListener(this);
    pane.add(jtSzoveg, BorderLayout.PAGE_START);

    /**
     * Scrollozható lista a közepére
     */
    JPanel pnList = new JPanel();

    pnList.add(jlLista);
    pnList.add(scPanel);
    scPanel.getViewport().add(jlLista);

    pane.add(pnList, BorderLayout.CENTER);

    /**
     * Kezelő gombok az aljára
     */
    JPanel pnGombok = new JPanel();

    jbMentes.addActionListener(this);
    jbVissza.addActionListener(this);
    jbKilep.addActionListener(this);

    pnGombok.add(jbMentes);
    pnGombok.add(jbVissza);
    pnGombok.add(jbKilep);

    pane.add(pnGombok, BorderLayout.PAGE_END);

  }

  @Override
  public void actionPerformed(ActionEvent e) {

    /**
     * Kilépés gomb
     */
    if (e.getSource() == jbKilep) {
      System.exit(0);
    }

    /**
     * Mentés gomb action
     */
    if (e.getSource() == jbMentes) {

      try {

        // Lista rendezés, nem tudom mennyire elegáns
        TreeSet rendezett = new TreeSet(szovegLista);

        // TreeSet iteráció beállítás
        Iterator iterator;
        iterator = rendezett.iterator();

        // Fájl init
        File fajl = new File("vizsga.txt");
        FileWriter fileWriter = new FileWriter(fajl);

        // Sorok írása fájlba
        while (iterator.hasNext()) {
          fileWriter.write(
                  // String casting kell!
                  (String) iterator.next()
                  // új sor hozzáadás
                  + System.getProperty("line.separator")
          );
        }

        // Fájl deinit
        fileWriter.flush();

        // ArrayList ürítése
        dm.removeAllElements();

      } catch (IOException h) {
        System.err.println("IO hiba: " + h.getMessage());
      }

    }

    /**
     * Visszatöltés fájlból
     */
    if (e.getSource() == jbVissza) {
    }

  }

  @Override
  public void keyReleased(KeyEvent e) {

    /**
     * Enter lenyomás után
     */
    if (e.getKeyCode() == KeyEvent.VK_ENTER) {

      dm.addElement((jtSzoveg.getText()));
      szovegLista.add(jtSzoveg.getText());
      jtSzoveg.setText("");
    }

  }

  @Override
  public void keyTyped(KeyEvent e) {
  }

  @Override
  public void keyPressed(KeyEvent e) {
  }

}
