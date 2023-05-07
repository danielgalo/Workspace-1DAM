package prog.ud10.relacion01.ejercicio03;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class GestionPalabrasListaApp {

	private JFrame frame;
	private JButton btnAdd;
	private JButton btnRemove;
	private JTextField textField;
	private JLabel lblErrorMsg;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GestionPalabrasListaApp window = new GestionPalabrasListaApp();
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
	public GestionPalabrasListaApp() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 315);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JList<String> lstWords = new JList<>();
		DefaultListModel<String> modelo = new DefaultListModel<>();
		scrollPane.setViewportView(lstWords);
		
		textField = new JTextField();
		textField.setColumns(10);
		
		btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addWord(lstWords, modelo);
				
			}
		});
		
		btnRemove = new JButton("Remove");
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				removeWord(lstWords);
			}

		});
		
		lblErrorMsg = new JLabel("                              ");
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(10)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 414, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(93)
									.addComponent(lblErrorMsg, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addComponent(textField, GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(btnRemove)
								.addComponent(btnAdd, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(11)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnAdd))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblErrorMsg)
						.addComponent(btnRemove))
					.addContainerGap(59, Short.MAX_VALUE))
		);
		frame.getContentPane().setLayout(groupLayout);
	}
	
	/**
	 * Add word if text field is not empty
	 * @param lstWords
	 * @param modelo
	 */
	private void addWord(JList<String> lstWords, DefaultListModel<String> modelo) {
		String txt = textField.getText();
		if (txt.length() > 0) {
			modelo.addElement(txt);
			lstWords.setModel(modelo);
			lblErrorMsg.setText("");
		} else {
			lblErrorMsg.setText("Error, no se puede añadir palabra vacía");
		}
	}
	
	/**
	 * Removes word from jlist
	 * @param lstWords
	 */
	private void removeWord(JList<String> lstWords) {
		if (lstWords.getSelectedIndex() >= 0) {
      DefaultListModel<String> modelo = (DefaultListModel<String>)lstWords.getModel();
      modelo.remove(lstWords.getSelectedIndex());
    }
	}
	
}
