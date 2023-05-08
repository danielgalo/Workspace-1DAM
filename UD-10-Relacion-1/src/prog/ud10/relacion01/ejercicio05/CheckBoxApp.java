package prog.ud10.relacion01.ejercicio05;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JCheckBox;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class CheckBoxApp {

  private JFrame frame;
  private JCheckBox chckbxLectura;
  private JCheckBox chckbxSeries;
  private JCheckBox chckbxAnime;
  private JCheckBox chckbxComic;
  private JLabel lblSalida;

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          CheckBoxApp window = new CheckBoxApp();
          window.frame.setVisible(true);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    });
  }

  /**
   * Create the application.
   */
  public CheckBoxApp() {
    initialize();
  }

  /**
   * Initialize the contents of the frame.
   */
  private void initialize() {
    frame = new JFrame();
    frame.setBounds(100, 100, 450, 300);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    JLabel lblNewLabel = new JLabel("Aficiones");
    lblNewLabel.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 16));

    chckbxLectura = new JCheckBox("Lectura");
    chckbxLectura.addChangeListener(new ChangeListener() {
      public void stateChanged(ChangeEvent e) {
        actualizaAficiones();

      }
    });

    chckbxSeries = new JCheckBox("Series");
    chckbxSeries.addChangeListener(new ChangeListener() {
      public void stateChanged(ChangeEvent e) {
        actualizaAficiones();
      }
    });

    chckbxComic = new JCheckBox("Comic");
    chckbxComic.addChangeListener(new ChangeListener() {
      public void stateChanged(ChangeEvent e) {
        actualizaAficiones();
      }
    });

    chckbxAnime = new JCheckBox("Anime");
    chckbxAnime.addChangeListener(new ChangeListener() {
      public void stateChanged(ChangeEvent e) {
        actualizaAficiones();
      }
    });

    JLabel lblTusAficiones = new JLabel("Tus aficiones:");
    lblTusAficiones.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 16));

    lblSalida = new JLabel("           ");
    lblSalida.setFont(new Font("Segoe UI", Font.PLAIN, 14));
    GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
    groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
        .addGroup(groupLayout.createSequentialGroup().addContainerGap()
            .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                .addComponent(lblSalida, GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE)
                .addComponent(chckbxAnime).addComponent(chckbxComic).addComponent(chckbxSeries)
                .addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 82,
                    GroupLayout.PREFERRED_SIZE)
                .addComponent(chckbxLectura).addComponent(lblTusAficiones,
                    GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE))
            .addContainerGap()));
    groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
        .addGroup(groupLayout.createSequentialGroup().addContainerGap().addComponent(lblNewLabel)
            .addGap(18).addComponent(chckbxLectura).addPreferredGap(ComponentPlacement.UNRELATED)
            .addComponent(chckbxSeries).addPreferredGap(ComponentPlacement.UNRELATED)
            .addComponent(chckbxComic).addPreferredGap(ComponentPlacement.UNRELATED)
            .addComponent(chckbxAnime).addGap(18)
            .addComponent(lblTusAficiones, GroupLayout.PREFERRED_SIZE, 22,
                GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
            .addComponent(lblSalida).addContainerGap()));
    frame.getContentPane().setLayout(groupLayout);
  }


  public void actualizaAficiones() {
    String textoAficiones = "";
    if (chckbxLectura.isSelected()) {
      textoAficiones = "Lectura ";
    }
    if (chckbxSeries.isSelected()) {
      textoAficiones += "Series ";
    }
    if (chckbxComic.isSelected()) {
      textoAficiones += "Comic ";
    }
    if (chckbxAnime.isSelected()) {
      textoAficiones += "Anime ";
    }
    lblSalida.setText(textoAficiones);
  }


}
