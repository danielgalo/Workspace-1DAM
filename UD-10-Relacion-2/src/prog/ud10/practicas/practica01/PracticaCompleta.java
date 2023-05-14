package prog.ud10.practicas.practica01;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.TitledBorder;

public class PracticaCompleta {

	private static final String ERROR_MSG_PASSWORD_LENGHT = "Error, la contraseña debe tener entre 5 y 10 carácteres";
	private static final String ERROR_MSG_PASSWORD_MATCH = "Error, las contraseñas deben coincidir";
	private static final String ERROR_MSG_USER_LENGTH = "Error, el usuario debe tener entre 1 y 10 carácteres";
	private static final int MAX_PASSWORD_LENGTH = 10;
	private static final int MIN_PASSWORD_LENGTH = 5;
	private static final int MAX_USER_LENGTH = 10;
	private static final int MIN_USER_LENGTH = 1;
	private JFrame frame;
	private JTextField txtUser;
	private JTextField txtPassword;
	private JTextField txtConfirmPassword;
	private JRadioButton rdbtnBach;
	private JRadioButton rdbtnPruebaAcceso;
	private JRadioButton rdbtnGradoMedio;
	private JRadioButton rdbtnGradoSuperior;
	private JComboBox<String> cboxCurso;
	private JCheckBox chckboxDni;
	private JCheckBox chckbxCertificado;
	private JCheckBox chckbxConvalidacion;
	private JCheckBox chckbxTitulo;
	private JTextArea textAreaObservaciones;
	private JButton btnRegister;
	private JList<String> listRegister;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JButton btnRemoveListElement;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PracticaCompleta window = new PracticaCompleta();
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
	public PracticaCompleta() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 730);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JLabel lblNewLabel = new JLabel("Nombre de Usuario");

		JLabel lblContrasea = new JLabel("Contraseña");

		JLabel lblRepiteContrasea = new JLabel("Repite Contraseña");

		txtUser = new JTextField();
		txtUser.setColumns(10);

		txtPassword = new JTextField();
		txtPassword.setColumns(10);

		txtConfirmPassword = new JTextField();
		txtConfirmPassword.setColumns(10);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Titulo", TitledBorder.LEADING, TitledBorder.TOP, null, null));

		JLabel lblNewLabel_1 = new JLabel("Ciclo a cursar");

		cboxCurso = new JComboBox<String>();
		cboxCurso.setModel(new DefaultComboBoxModel<String>(new String[] { "DAM", "DAW", "ASIR", "SMR" }));

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Documentacion", TitledBorder.LEADING, TitledBorder.TOP, null, null));

		JLabel lblNewLabel_2 = new JLabel("Observaciones");

		textAreaObservaciones = new JTextArea();
		textAreaObservaciones.setWrapStyleWord(true);
		textAreaObservaciones.setLineWrap(true);

		btnRegister = new JButton("Registrar");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				register();
			}
		});

		JScrollPane scrollPane = new JScrollPane();

		btnRemoveListElement = new JButton("Eliminar elemento");
		btnRemoveListElement.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultListModel<String> registerModel = new DefaultListModel<>();
				removeListElement(registerModel);
				listRegister.setModel(registerModel);
			}
		});
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup().addContainerGap()
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(scrollPane, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE)
								.addComponent(textAreaObservaciones, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE)
								.addComponent(panel_1, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE)
								.addComponent(panel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE)
								.addGroup(
										Alignment.TRAILING,
										groupLayout
												.createSequentialGroup().addComponent(lblNewLabel_1)
												.addPreferredGap(ComponentPlacement.UNRELATED)
												.addComponent(cboxCurso, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE))
								.addComponent(lblNewLabel_2, Alignment.TRAILING).addComponent(btnRegister, Alignment.TRAILING)
								.addGroup(Alignment.TRAILING,
										groupLayout.createSequentialGroup().addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addComponent(lblRepiteContrasea, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
												.addComponent(lblContrasea, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
												.addComponent(lblNewLabel)).addPreferredGap(ComponentPlacement.RELATED, 118, Short.MAX_VALUE)
												.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false).addComponent(txtUser)
														.addComponent(txtPassword)
														.addComponent(txtConfirmPassword, GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)))
								.addComponent(btnRemoveListElement))
						.addContainerGap()));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup().addContainerGap()
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel).addComponent(txtUser,
						GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.UNRELATED)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(lblContrasea).addComponent(
						txtPassword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.UNRELATED)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(lblRepiteContrasea).addComponent(
						txtConfirmPassword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.UNRELATED)
				.addComponent(panel, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE).addGap(18)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel_1)
						.addComponent(cboxCurso, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(18).addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(lblNewLabel_2)
				.addPreferredGap(ComponentPlacement.RELATED)
				.addComponent(textAreaObservaciones, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(btnRegister).addGap(18)
				.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(btnRemoveListElement)
				.addContainerGap(31, Short.MAX_VALUE)));

		listRegister = new JList<String>();

		listRegister = new JList<String>();
		scrollPane.setViewportView(listRegister);

		chckboxDni = new JCheckBox("DNI");

		chckbxCertificado = new JCheckBox("Certificado de notas");

		chckbxConvalidacion = new JCheckBox("Convalidación");

		chckbxTitulo = new JCheckBox("Titulo");
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup().addContainerGap()
						.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_1.createSequentialGroup()
										.addComponent(chckboxDni, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED, 82, Short.MAX_VALUE)
										.addComponent(chckbxConvalidacion, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel_1.createSequentialGroup()
										.addComponent(chckbxCertificado, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED, 86, Short.MAX_VALUE)
										.addComponent(chckbxTitulo, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)))
						.addContainerGap()));
		gl_panel_1.setVerticalGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup().addContainerGap()
						.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE).addComponent(chckboxDni)
								.addComponent(chckbxConvalidacion))
						.addPreferredGap(ComponentPlacement.UNRELATED).addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
								.addComponent(chckbxCertificado).addComponent(chckbxTitulo))
						.addContainerGap(25, Short.MAX_VALUE)));
		panel_1.setLayout(gl_panel_1);

		rdbtnBach = new JRadioButton("Bachillerato");
		buttonGroup.add(rdbtnBach);

		rdbtnPruebaAcceso = new JRadioButton("Prueba acceso");
		buttonGroup.add(rdbtnPruebaAcceso);

		rdbtnGradoMedio = new JRadioButton("Grado Medio");
		buttonGroup.add(rdbtnGradoMedio);

		rdbtnGradoSuperior = new JRadioButton("Grado Superior");
		buttonGroup.add(rdbtnGradoSuperior);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup().addContainerGap()
						.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(rdbtnBach, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)
								.addComponent(rdbtnPruebaAcceso, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE))
						.addPreferredGap(ComponentPlacement.RELATED, 132, Short.MAX_VALUE)
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(rdbtnGradoMedio, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
								.addComponent(rdbtnGradoSuperior, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE))
						.addContainerGap()));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup().addContainerGap()
						.addGroup(
								gl_panel.createParallelGroup(Alignment.BASELINE).addComponent(rdbtnBach).addComponent(rdbtnGradoMedio))
						.addPreferredGap(ComponentPlacement.RELATED).addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(rdbtnPruebaAcceso).addComponent(rdbtnGradoSuperior))
						.addContainerGap(24, Short.MAX_VALUE)));
		panel.setLayout(gl_panel);
		frame.getContentPane().setLayout(groupLayout);
	}

	private void register() {

		registerUserData();

	}

	private void registerUserData() {
		// Conseguir datos y almacenarlos en variables
		String username = txtUser.getText();
		String password = txtPassword.getText();
		String passwordConfirm = txtConfirmPassword.getText();
		String obserbations = textAreaObservaciones.getText();

		// Modelo
		DefaultListModel<String> registerModel = new DefaultListModel<>();

		// Si los datos son correctos
		if (isDataCorrect(username, password, passwordConfirm)) {

			// Añade datos usuario
			addUserData(username, password, listRegister, registerModel);

			// Añade titulo
			addSelectedTitle(registerModel);

			// Añade curso
			addSelectedCourse(registerModel);

			// Añadir documentación
			addSelectedDocumentations(registerModel);

			// Añadir observaciones
			addObservations(obserbations, registerModel);

			// Si no son correctos
		} else {
			setErrorMsg(username, password, passwordConfirm, listRegister, registerModel);
		}
		// Añadir modelo a lista
		listRegister.setModel(registerModel);
	}

	/**
	 * Adds user data to register data list
	 * 
	 * @param username
	 * @param password
	 * @param list
	 */
	private void addUserData(String username, String password, JList<String> list,
			DefaultListModel<String> registerModel) {

		// Añadir datos a modelo
		registerModel.addElement("Nombre de usuario: " + username);
		registerModel.addElement("Contraseña: " + password);

	}

	/**
	 * Adds to list selected radio button titulation
	 */
	private void addSelectedTitle(DefaultListModel<String> registerModel) {

		String title = "Titulo seleccionado: ";

		// Si bachillerato es seleccionado
		if (rdbtnBach.isSelected()) {
			registerModel.addElement(title + rdbtnBach.getText());
		}

		// Si prueba de acceso es seleccionado
		if (rdbtnPruebaAcceso.isSelected()) {
			registerModel.addElement(title + rdbtnPruebaAcceso.getText());
		}

		// Si grado medio es seleccionado
		if (rdbtnGradoMedio.isSelected()) {
			registerModel.addElement(title + rdbtnGradoMedio.getText());
		}

		// Si grado superior es seleccionado
		if (rdbtnGradoSuperior.isSelected()) {
			registerModel.addElement(title + rdbtnGradoSuperior.getText());
		}

	}

	/**
	 * Add to list selected course from combo box
	 */
	private void addSelectedCourse(DefaultListModel<String> registerModel) {

		String course = "Curso seleccionado: ";

		// Adds selected item to list
		registerModel.addElement(course + (String) cboxCurso.getSelectedItem());

	}

	/**
	 * Adds selected documentations from selected checkboxes
	 * 
	 * @param registerModel
	 */
	private void addSelectedDocumentations(DefaultListModel<String> registerModel) {

		registerModel.addElement("--DOCUMENTACIÓN APORTADA --");

		// Si se selecciona el dni
		if (chckboxDni.isSelected()) {
			registerModel.addElement(chckboxDni.getText());
		}

		// Si se selecciona el Certificado
		if (chckbxCertificado.isSelected()) {
			registerModel.addElement(chckbxCertificado.getText());
		}

		// Si se selecciona el Convalidacion
		if (chckbxConvalidacion.isSelected()) {
			registerModel.addElement(chckbxConvalidacion.getText());
		}

		// Si se selecciona titulo
		if (chckbxTitulo.isSelected()) {
			registerModel.addElement(chckbxTitulo.getText());
		}

		registerModel.addElement("---------------------------");

	}

	/**
	 * Adds to list observations from textArea
	 * 
	 * @param registerModel
	 */
	private void addObservations(String observations, DefaultListModel<String> registerModel) {

		registerModel.addElement(observations);
	}

	/**
	 * Checks if the input data is correct depending on certain restrictions
	 * 
	 * @param username
	 * @param password
	 * @param passwordConfirm
	 * @return boolean
	 */
	private boolean isDataCorrect(String username, String password, String passwordConfirm) {

		return ((username.length() >= MIN_USER_LENGTH && username.length() <= MAX_USER_LENGTH)
				&& (password.equals(passwordConfirm))
				&& (password.length() >= MIN_PASSWORD_LENGTH && password.length() <= MAX_PASSWORD_LENGTH));
	}

	/**
	 * Sets an error message informing the user if the data input is not correct
	 * 
	 * @param username
	 * @param password
	 * @param passwordConfirm
	 */
	private void setErrorMsg(String username, String password, String passwordConfirm, JList<String> listRegister,
			DefaultListModel<String> registerModel) {

		if (username.length() < MIN_USER_LENGTH && username.length() > MAX_USER_LENGTH) {
			registerModel.addElement(ERROR_MSG_USER_LENGTH);
		}

		if (!password.equals(passwordConfirm)) {
			registerModel.addElement(ERROR_MSG_PASSWORD_MATCH);
		}

		if (password.length() < MIN_PASSWORD_LENGTH && password.length() > MAX_PASSWORD_LENGTH) {
			registerModel.addElement(ERROR_MSG_PASSWORD_LENGHT);
		}

		listRegister.setModel(registerModel);

	}

	/**
	 * Removes selected item from list
	 */
	private void removeListElement(DefaultListModel<String> registerModel) {

		registerModel.remove(listRegister.getSelectedIndex());

	}

}
