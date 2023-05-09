package prog.ud10.relacion02.ejercicio04;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.JCheckBox;
import javax.swing.JScrollPane;

public class FormularioApp {

  // Minimum characters for username
  private static final int MIN_USER_CHAR = 1;

  // Maximun characters for username
  private static final int MAX_USER_CHAR = 8;

  // Minimum characters dor password
  private static final int MIN_PSWD_CHAR = 5;

  // Maximum characters for password
  private static final int MAX_PSWD_CHAR = 10;

  /** Titulo */
  private JFrame frmFormularioDeRegistro;

  /** Campo de texto para introducir usuario */
  private JTextField txtUser;

  /** Campo de texto para introducir contraseña */
  private JTextField txtPswd;

  /** Campo de texto para confirmar contraseña */
  private JTextField txtConfirmPswd;

  /** Radio button prueba de acceso */
  private JRadioButton rdbtnPruebaAcc;

  /** Radio button bachillerato */
  private JRadioButton rdbtnBach;

  /** Grupo de botones de titulacion */
  private final ButtonGroup buttonGroup = new ButtonGroup();

  /** Boton para registrar datos */
  private JButton btnRegister;

  /** Text area donde se guardan los datos registrados */
  private JTextArea textAreaData;

  /** Desplegable curso a elegir */
  private JComboBox<Object> cboxCurso;

  /** Check box DNI */
  private JCheckBox chckbxDni;

  /** Check box convalidacion */
  private JCheckBox chckbxConvalidation;

  /** Check box certificado notas */
  private JCheckBox chckbxGrades;

  /** Check box titulacion */
  private JCheckBox chckbxTitulation;

  /** Scroll para text area */
  private JScrollPane scrollPane;

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          FormularioApp window = new FormularioApp();
          window.frmFormularioDeRegistro.setVisible(true);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    });
  }

  /**
   * Create the application.
   */
  public FormularioApp() {
    initialize();
  }

  /**
   * Initialize the contents of the frame.
   */
  private void initialize() {
    frmFormularioDeRegistro = new JFrame();
    frmFormularioDeRegistro.setTitle("Formulario de registro");
    frmFormularioDeRegistro.getContentPane().setBackground(SystemColor.control);
    frmFormularioDeRegistro.setBounds(100, 100, 450, 641);
    frmFormularioDeRegistro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // Labels
    JLabel lblNewLabel = new JLabel("Nombre de Usuario");
    lblNewLabel.setForeground(SystemColor.desktop);
    lblNewLabel.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 14));

    JLabel lblContrasea = new JLabel("Contraseña");
    lblContrasea.setForeground(SystemColor.desktop);
    lblContrasea.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 14));

    JLabel lblConfirmaContrasea = new JLabel("Confirma Contraseña");
    lblConfirmaContrasea.setForeground(SystemColor.desktop);
    lblConfirmaContrasea.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 14));

    // Campos de texto
    txtUser = new JTextField();
    txtUser.setBackground(SystemColor.window);
    txtUser.setColumns(10);

    txtPswd = new JTextField();
    txtPswd.setBackground(SystemColor.window);
    txtPswd.setColumns(10);

    txtConfirmPswd = new JTextField();
    txtConfirmPswd.setBackground(SystemColor.window);
    txtConfirmPswd.setColumns(10);

    // Combo box
    cboxCurso = new JComboBox<Object>();
    cboxCurso.setBackground(SystemColor.control);
    cboxCurso.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 12));
    cboxCurso.setModel(new DefaultComboBoxModel<Object>(new String[] {"DAM", "DAW", "ASIR"}));

    JLabel lblCursoAPresentar = new JLabel("Curso a presentar");
    lblCursoAPresentar.setBackground(SystemColor.control);
    lblCursoAPresentar.setForeground(SystemColor.desktop);
    lblCursoAPresentar.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 14));

    JPanel panel = new JPanel();
    panel.setForeground(new Color(51, 15, 96));
    panel.setBorder(new TitledBorder(
        new TitledBorder(
            new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255),
                new Color(160, 160, 160)),
            "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)),
        "Titulaci\u00F3n que se presenta", TitledBorder.LEADING, TitledBorder.TOP, null,
        SystemColor.desktop));
    panel.setBackground(SystemColor.window);

    btnRegister = new JButton("Registrar");
    btnRegister.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        regiserData();
      }
    });
    btnRegister.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 12));
    btnRegister.setBackground(SystemColor.control);

    rdbtnBach = new JRadioButton("Bachillerato");
    rdbtnBach.setBackground(SystemColor.window);
    rdbtnBach.addChangeListener(new ChangeListener() {
      public void stateChanged(ChangeEvent e) {
        getSelectedTitulation();
      }
    });
    buttonGroup.add(rdbtnBach);
    rdbtnBach.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 12));

    rdbtnPruebaAcc = new JRadioButton("Prueba de acceso");
    rdbtnPruebaAcc.addChangeListener(new ChangeListener() {
      public void stateChanged(ChangeEvent e) {
        getSelectedTitulation();
      }
    });
    buttonGroup.add(rdbtnPruebaAcc);
    rdbtnPruebaAcc.setBackground(SystemColor.window);
    rdbtnPruebaAcc.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 12));
    GroupLayout gl_panel = new GroupLayout(panel);
    gl_panel
        .setHorizontalGroup(
            gl_panel.createParallelGroup(Alignment.LEADING)
                .addGroup(gl_panel.createSequentialGroup().addContainerGap()
                    .addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
                        .addComponent(rdbtnBach).addComponent(rdbtnPruebaAcc))
                    .addContainerGap(271, Short.MAX_VALUE)));
    gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
        .addGroup(gl_panel.createSequentialGroup().addComponent(rdbtnBach)
            .addPreferredGap(ComponentPlacement.UNRELATED).addComponent(rdbtnPruebaAcc)
            .addContainerGap(23, Short.MAX_VALUE)));
    panel.setLayout(gl_panel);

    JLabel lblDatosDeRegistro = new JLabel("Datos de registro:");
    lblDatosDeRegistro.setForeground(Color.BLACK);
    lblDatosDeRegistro.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 14));

    JPanel panel_1 = new JPanel();
    panel_1.setForeground(new Color(51, 15, 96));
    panel_1.setBorder(new TitledBorder(
        new TitledBorder(
            new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255),
                new Color(160, 160, 160)),
            "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)),
        "Documentaci\u00F3n a aportar", TitledBorder.LEADING, TitledBorder.TOP, null,
        new Color(0, 0, 0)));
    panel_1.setBackground(SystemColor.window);

    chckbxTitulation = new JCheckBox("Título oficial");
    chckbxTitulation.setBackground(SystemColor.window);
    chckbxTitulation.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 12));

    chckbxGrades = new JCheckBox("Certificado de notas");
    chckbxGrades.setBackground(SystemColor.window);
    chckbxGrades.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 12));

    chckbxConvalidation = new JCheckBox("Convalidación");
    chckbxConvalidation.setBackground(SystemColor.window);
    chckbxConvalidation.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 12));

    chckbxDni = new JCheckBox("DNI");
    chckbxDni.setBackground(SystemColor.window);
    chckbxDni.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 12));
    GroupLayout gl_panel_1 = new GroupLayout(panel_1);
    gl_panel_1.setHorizontalGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
        .addGroup(gl_panel_1.createSequentialGroup().addContainerGap()
            .addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
                .addComponent(chckbxTitulation, GroupLayout.PREFERRED_SIZE, 142,
                    GroupLayout.PREFERRED_SIZE)
                .addComponent(chckbxGrades, GroupLayout.PREFERRED_SIZE, 142,
                    GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(ComponentPlacement.RELATED, 116, Short.MAX_VALUE)
            .addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
                .addComponent(chckbxConvalidation, GroupLayout.PREFERRED_SIZE, 142,
                    GroupLayout.PREFERRED_SIZE)
                .addComponent(chckbxDni, GroupLayout.PREFERRED_SIZE, 142,
                    GroupLayout.PREFERRED_SIZE))));
    gl_panel_1.setVerticalGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
        .addGroup(gl_panel_1.createSequentialGroup().addContainerGap()
            .addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
                .addComponent(chckbxTitulation).addComponent(chckbxConvalidation,
                    GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(ComponentPlacement.RELATED)
            .addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
                .addComponent(chckbxGrades, GroupLayout.PREFERRED_SIZE, 25,
                    GroupLayout.PREFERRED_SIZE)
                .addComponent(chckbxDni, GroupLayout.PREFERRED_SIZE, 25,
                    GroupLayout.PREFERRED_SIZE))
            .addContainerGap(19, Short.MAX_VALUE)));
    panel_1.setLayout(gl_panel_1);

    scrollPane = new JScrollPane();
    GroupLayout groupLayout = new GroupLayout(frmFormularioDeRegistro.getContentPane());
    horizontalLayout(lblNewLabel, lblContrasea, lblConfirmaContrasea, lblCursoAPresentar, panel,
        lblDatosDeRegistro, panel_1, groupLayout);
    verticalLayout(lblNewLabel, lblContrasea, lblConfirmaContrasea, lblCursoAPresentar, panel,
        lblDatosDeRegistro, panel_1, groupLayout);

    textAreaData = new JTextArea();
    scrollPane.setViewportView(textAreaData);
    textAreaData.setEditable(false);

    frmFormularioDeRegistro.getContentPane().setLayout(groupLayout);
  }

  /* MÉTODOS DE CLASE */

  /**
   * Sets vertical group layout
   * 
   * @param lblNewLabel
   * @param lblContrasea
   * @param lblConfirmaContrasea
   * @param lblCursoAPresentar
   * @param panel
   * @param lblDatosDeRegistro
   * @param panel_1
   * @param groupLayout
   */
  public void verticalLayout(JLabel lblNewLabel, JLabel lblContrasea, JLabel lblConfirmaContrasea,
      JLabel lblCursoAPresentar, JPanel panel, JLabel lblDatosDeRegistro, JPanel panel_1,
      GroupLayout groupLayout) {
    groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
        .addGroup(groupLayout.createSequentialGroup().addGap(13)
            .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                .addComponent(txtUser, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                    GroupLayout.PREFERRED_SIZE)
                .addComponent(lblNewLabel))
            .addGap(8)
            .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                .addComponent(txtPswd, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                    GroupLayout.PREFERRED_SIZE)
                .addComponent(lblContrasea))
            .addGap(8)
            .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                .addComponent(txtConfirmPswd, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                    GroupLayout.PREFERRED_SIZE)
                .addComponent(lblConfirmaContrasea))
            .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                .addGroup(groupLayout.createSequentialGroup().addGap(18).addComponent(cboxCurso,
                    GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                    GroupLayout.PREFERRED_SIZE))
                .addGroup(groupLayout.createSequentialGroup()
                    .addPreferredGap(ComponentPlacement.UNRELATED)
                    .addComponent(lblCursoAPresentar)))
            .addGap(18)
            .addComponent(panel, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
            .addGap(18)
            .addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
            .addGap(18).addComponent(btnRegister).addGap(12)
            .addComponent(lblDatosDeRegistro, GroupLayout.PREFERRED_SIZE, 20,
                GroupLayout.PREFERRED_SIZE)
            .addGap(18)
            .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE)
            .addContainerGap(60, Short.MAX_VALUE)));
  }


  /**
   * Sets horizontal group layout
   * 
   * @param lblNewLabel
   * @param lblContrasea
   * @param lblConfirmaContrasea
   * @param lblCursoAPresentar
   * @param panel
   * @param lblDatosDeRegistro
   * @param panel_1
   * @param groupLayout
   */
  public void horizontalLayout(JLabel lblNewLabel, JLabel lblContrasea, JLabel lblConfirmaContrasea,
      JLabel lblCursoAPresentar, JPanel panel, JLabel lblDatosDeRegistro, JPanel panel_1,
      GroupLayout groupLayout) {
    groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
        .addGroup(groupLayout.createSequentialGroup().addContainerGap().addGroup(groupLayout
            .createParallelGroup(Alignment.LEADING)
            .addComponent(scrollPane, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 414,
                GroupLayout.PREFERRED_SIZE)
            .addGroup(Alignment.TRAILING,
                groupLayout.createSequentialGroup().addComponent(lblNewLabel)
                    .addPreferredGap(ComponentPlacement.RELATED, 123, Short.MAX_VALUE).addComponent(
                        txtUser, GroupLayout.PREFERRED_SIZE, 169, GroupLayout.PREFERRED_SIZE))
            .addGroup(Alignment.TRAILING,
                groupLayout.createSequentialGroup()
                    .addComponent(lblContrasea, GroupLayout.PREFERRED_SIZE, 155,
                        GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(ComponentPlacement.RELATED, 90, Short.MAX_VALUE).addComponent(
                        txtPswd, GroupLayout.PREFERRED_SIZE, 169, GroupLayout.PREFERRED_SIZE))
            .addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
                .addComponent(lblConfirmaContrasea, GroupLayout.PREFERRED_SIZE, 141,
                    GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(ComponentPlacement.RELATED, 104, Short.MAX_VALUE).addComponent(
                    txtConfirmPswd, GroupLayout.PREFERRED_SIZE, 169, GroupLayout.PREFERRED_SIZE))
            .addGroup(Alignment.TRAILING,
                groupLayout.createSequentialGroup()
                    .addComponent(lblCursoAPresentar, GroupLayout.PREFERRED_SIZE, 141,
                        GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(ComponentPlacement.RELATED, 193, Short.MAX_VALUE).addComponent(
                        cboxCurso, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE))
            .addComponent(btnRegister)
            .addComponent(lblDatosDeRegistro, GroupLayout.PREFERRED_SIZE, 155,
                GroupLayout.PREFERRED_SIZE)
            .addComponent(panel, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 414,
                GroupLayout.PREFERRED_SIZE)
            .addComponent(panel_1, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 414,
                GroupLayout.PREFERRED_SIZE))
            .addContainerGap()));
  }



  /**
   * Register the user data if fields are correct
   */
  public void regiserData() {
    String user = txtUser.getText();
    String password = txtPswd.getText();
    String confirmPassword = txtConfirmPswd.getText();

    String registerResult = "";

    // Si las contraseñas coinciden
    if (validateFields(user, password, confirmPassword)) {
      registerResult += "Usuario: " + user + "\nContraseña: " + password + "\n";

      // Curso a presentar, nos quedamos con el que esté seleccionado y lo añadimos al resultado
      String course = (String) cboxCurso.getSelectedItem();
      registerResult += "Curso: " + course + "\n";

      // Añadir titulacion seleccionada
      String titulation = getSelectedTitulation();
      registerResult += "Titulación presentada:  " + titulation + "\n";

      // Añadir documentación aportada
      String documentation = getSelectedDocumentations();
      registerResult += "Documentación aportada: \n" + documentation;

      // Añadir el texto al textArea
      textAreaData.setText(registerResult);
      
      // Si no coinciden contraseñas sacamos error
    } else {
      textAreaData.setText(getErrorMsg(user, password, confirmPassword));
    }
  }

  /**
   * Returns string with selected documentation
   * 
   * @return
   */
  private String getSelectedDocumentations() {
    String documentation = "";

    // Si el DNI es seleccionado
    if (chckbxDni.isSelected()) {
      documentation += "- DNI\n";
    }

    // Si la convalidación es seleccionada
    if (chckbxConvalidation.isSelected()) {
      documentation += "- Convalidación\n";
    }

    // Si el certificado de notas es seleccionado
    if (chckbxGrades.isSelected()) {
      documentation += "- Certificado de notas\n";
    }

    // Si titulacion es seleccionado
    if (chckbxTitulation.isSelected()) {
      documentation += "- Titulación\n";
    }

    return documentation;
  }

  /**
   * Validates introduced fields
   * 
   * @param user
   * @param password
   * @param confirmPassword
   * @return true if correct, false if not
   */
  public boolean validateFields(String user, String password, String confirmPassword) {
    return confirmPassword.equals(password)
        && (user.length() >= MIN_USER_CHAR && user.length() <= MAX_USER_CHAR)
        && (password.length() >= MIN_PSWD_CHAR && password.length() <= MAX_PSWD_CHAR);
  }

  /**
   * In case fields are wrong
   * 
   * @param user
   * @param password
   * @param confirmPassword
   * @return errorMsg
   */
  public String getErrorMsg(String user, String password, String confirmPassword) {
    String errorMsg = "";

    // Si no coinciden contraseñas
    if (!confirmPassword.equals(password)) {
      errorMsg += "Error, las contraseñas deben coincidir.\n";
    }

    // Si el usuario no tiene la longitud adecuada
    if ((user.length() < MIN_USER_CHAR || user.length() > MAX_USER_CHAR)) {
      errorMsg += "Error, el usuario debe de tener entre 1 y 8 caracteres.\n";
    }

    // Si la contraseña no tiene la longitud adecuada
    if ((password.length() < MIN_PSWD_CHAR || password.length() > MAX_PSWD_CHAR)) {
      errorMsg += "Error, la contraseña debe de tener entre 5 y 10 caracteres.\n";
    }

    // Returns error message
    return errorMsg;
  }

  /**
   * Gets the text from selected checkbox
   * 
   * @return String from the selected checkbox
   */
  public String getSelectedTitulation() {
    String titulation = "";

    // Documentacion presentada, bachillerato
    if (rdbtnBach.isSelected()) {
      titulation = "Bachillerato";

      // Documentacion presentada, prueba de acceso
    } else if (rdbtnPruebaAcc.isSelected()) {
      titulation = "Prueba de acceso";

      // Ninguna documentación seleccionada
    } else {
      titulation = "Ninguna documentación seleccionada";
    }

    return titulation;
  }
}
