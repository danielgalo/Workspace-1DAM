package prog.ud10.relacion01.ejercicio03;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GestionPalabrasApp {

	private JFrame frame;
	private JTextArea txtArea;
	private JButton btnRemove;
	private JTextField txtField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GestionPalabrasApp window = new GestionPalabrasApp();
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
	public GestionPalabrasApp() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addTxt();
			}
		});
		
		btnRemove = new JButton("Remove");
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				removeTxt();
			}
		});
		
		txtField = new JTextField();
		txtField.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 411, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(txtField)
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(btnRemove, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnAdd, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE))))
					.addContainerGap(13, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnAdd)
						.addComponent(txtField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnRemove)
					.addContainerGap(50, Short.MAX_VALUE))
		);
		
		txtArea = new JTextArea();
		txtArea.setEditable(false);
		txtArea.setLineWrap(true);
		txtArea.setWrapStyleWord(true);
		scrollPane.setViewportView(txtArea);
		frame.getContentPane().setLayout(groupLayout);
	}
	
	/**
	 * Add text from text field to text area
	 */
	public void addTxt() {
		String txt = txtField.getText();
		txtArea.append(txt + "\n");
		clearTxtField();
	}

	/**
	 * Remove text from text field to text area
	 */
	public void removeTxt() {
		String wordToReplace = txtField.getText();
		String txt = txtArea.getText();
		String newtxt = txt.replaceAll(wordToReplace + "\n", "");
		
		txtArea.setText(newtxt);
		clearTxtField();
	}
	
	/**
	 * Clears text from text field
	 */
	public void clearTxtField() {
		txtField.setText("");
	}
	
}
