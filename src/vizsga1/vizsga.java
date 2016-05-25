
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Vector;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListModel;

public class vizsga extends JFrame implements ActionListener, KeyListener {

    private JButton jbment = new JButton("Ment");
    private JButton jbvisszatölt = new JButton("Visszatölt");
    private JButton jbkilép = new JButton("Kilép");
    private JTextField tfszövegterület = new JTextField(20);

    private DefaultListModel dm = new DefaultListModel();//
    private JScrollPane scrollpane;
    private ArrayList<String> lista = new ArrayList<>();
    private JList list = new JList(dm);

    File szövegfájl = new File("D:/szöveg.txt");

    public vizsga() {
        tfszövegterület.setText("Írd be ide a szöveget, majd nyomj Entert!");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("vizsga");
        setLocationRelativeTo(null);
        setSize(700, 250);
        JPanel pn = new JPanel();
        JPanel pnalsó = new JPanel();
        scrollpane = new JScrollPane(list);

        tfszövegterület.addKeyListener(this);

        pn.add(list);
        pn.add(scrollpane);
        scrollpane.getViewport().add(list);
        jbment.addActionListener(this);
        jbvisszatölt.addActionListener(this);
        jbkilép.addActionListener(this);
        pnalsó.add(jbment);
        pnalsó.add(jbvisszatölt);
        pnalsó.add(jbkilép);
        pn.add(tfszövegterület);
        add(pn, BorderLayout.PAGE_START);
        add(pnalsó, BorderLayout.PAGE_END);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == jbment) {

            try {
                final DataOutputStream dos = new DataOutputStream(new FileOutputStream(szövegfájl));
                for (String elem : lista) {

                    dos.writeUTF(elem);

                }
                Collections.sort(lista);

                dos.close();
                listatörlése();
            } catch (IOException ex) {
                System.out.println("I/O hiba");
            }

            tfszövegterület.setText("");
            tfszövegterület.requestFocus();

        } else if (e.getSource() == jbvisszatölt) {
            try {

                final DataInputStream dis = new DataInputStream(new FileInputStream(szövegfájl));
                for (String elem : lista) {
                    dm.addElement(elem);
                }
                dis.close();

            } catch (IOException ex) {
                System.out.println("I/O hiba!");

            }
        } else if (e.getSource() == jbkilép) {
            System.exit(0);
        }
    }

    @Override
    public void keyTyped(KeyEvent e
    ) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {

        }
    }

    @Override
    public void keyPressed(KeyEvent e
    ) {

    }

    public void listatörlése() {

        dm.removeAllElements();

    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {

            dm.addElement((tfszövegterület.getText()));
            lista.add(tfszövegterület.getText());
            tfszövegterület.setText("");

        }
    }

    public static void main(String[] args) {
        new vizsga();

    }

}