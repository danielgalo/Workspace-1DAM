package prog.ud10.relacion01.ejercicio04;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GestionPalabrasDesplegableApp {

	private JFrame frame;
	private JComboBox comboBox;
	private JButton btnAdd;
	private JButton btnRemove;
	private JTextField txtField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GestionPalabrasDesplegableApp window = new GestionPalabrasDesplegableApp();
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
	public GestionPalabrasDesplegableApp() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		comboBox = new JComboBox<>();
		DefaultComboBoxModel<String> modelo = new DefaultComboBoxModel<>();
		
		txtField = new JTextField();
		txtField.setColumns(10);
		comboBox = new JComboBox<String>();
		
		btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addWord(modelo);
			}
		});
		
		btnRemove = new JButton("Remove");
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				removeWord();
			}


		});
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(comboBox, Alignment.TRAILING, 0, 414, Short.MAX_VALUE)
						.addComponent(txtField, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE)
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
							.addComponent(btnAdd, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(btnRemove, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(12)
					.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
					.addGap(85)
					.addComponent(txtField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnAdd)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnRemove)
					.addContainerGap(16, Short.MAX_VALUE))
		);
		frame.getContentPane().setLayout(groupLayout);
	}
	
	/**
	 * add word to combo box
	 * @param modelo
	 */
	private void addWord(DefaultComboBoxModel<String> modelo) {
		String txt = txtField.getText();
		if (txt.length() > 0) {
			modelo.addElement(txt);
			comboBox.setModel(modelo);
		}
	}
	
	private void removeWord() {
		int elemento = comboBox.getSelectedIndex();
    if (elemento >= 0) {
      DefaultComboBoxModel<String> modelo = (DefaultComboBoxModel)comboBox.getModel();
      modelo.removeElementAt(elemento);
    }
	}
	
}
