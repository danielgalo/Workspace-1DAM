package prog.ud10.relacion01.ejercicio04;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ComboBoxApp {

  private JFrame frame;
  private JTextField txtNombre;
  private JComboBox cbLista;

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          ComboBoxApp window = new ComboBoxApp();
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
  public ComboBoxApp() {
    initialize();
  }

  /**
   * Initialize the contents of the frame.
   */
  private void initialize() {
    frame = new JFrame();
    frame.setBounds(100, 100, 450, 188);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    cbLista = new JComboBox<String>();
    
    txtNombre = new JTextField();
    txtNombre.setColumns(10);
    
    JButton btnAdd = new JButton("Añadir");
    btnAdd.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        String texto = txtNombre.getText();
        if (!texto.isBlank()) {
          DefaultComboBoxModel<String> modelo = (DefaultComboBoxModel<String>)cbLista.getModel();
          modelo.addElement(texto);
        }
      }
    });
    
    JButton btnEliminar = new JButton("Eliminar");
    btnEliminar.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        // Si hay elemento seleccionado
        int elemento = cbLista.getSelectedIndex();
        if (elemento >= 0) {
          DefaultComboBoxModel<String> modelo = (DefaultComboBoxModel)cbLista.getModel();
          modelo.removeElementAt(elemento);
        }
      }
    });
    GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
    groupLayout.setHorizontalGroup(
      groupLayout.createParallelGroup(Alignment.LEADING)
        .addGroup(groupLayout.createSequentialGroup()
          .addContainerGap()
          .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
            .addComponent(cbLista, Alignment.TRAILING, 0, 426, Short.MAX_VALUE)
            .addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
              .addComponent(txtNombre, GroupLayout.PREFERRED_SIZE, 321, GroupLayout.PREFERRED_SIZE)
              .addPreferredGap(ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
              .addComponent(btnAdd))
            .addComponent(btnEliminar, Alignment.TRAILING))
          .addContainerGap())
    );
    groupLayout.setVerticalGroup(
      groupLayout.createParallelGroup(Alignment.LEADING)
        .addGroup(groupLayout.createSequentialGroup()
          .addContainerGap()
          .addComponent(cbLista, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
          .addGap(39)
          .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
            .addComponent(txtNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
            .addComponent(btnAdd))
          .addPreferredGap(ComponentPlacement.UNRELATED)
          .addComponent(btnEliminar)
          .addContainerGap(128, Short.MAX_VALUE))
    );
    frame.getContentPane().setLayout(groupLayout);
  }
}
