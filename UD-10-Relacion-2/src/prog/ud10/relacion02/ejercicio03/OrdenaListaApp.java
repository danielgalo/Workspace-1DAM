package prog.ud10.relacion02.ejercicio03;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.awt.event.ActionEvent;

public class OrdenaListaApp {

	private JFrame frame;
	private JList listOrdenada;
	private JButton btnOrdenar;
	private JScrollPane scrollPane;
	private JTextArea textAreaOrig;
	private JButton btnReset;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OrdenaListaApp window = new OrdenaListaApp();
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
	public OrdenaListaApp() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 335);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblNewLabel = new JLabel("Texto Original");
		lblNewLabel.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 14));
		
		JLabel lblTextoOrdenado = new JLabel("Texto Ordenado");
		lblTextoOrdenado.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 14));
		
		JScrollPane scrollPane_1 = new JScrollPane();
		
		btnOrdenar = new JButton("Ordenar");
		btnOrdenar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ordenar();
			}
		});
		
		scrollPane = new JScrollPane();
		
		btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetText();
			}
		});
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblTextoOrdenado, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnOrdenar)
							.addPreferredGap(ComponentPlacement.RELATED, 252, Short.MAX_VALUE)
							.addComponent(btnReset))
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel)
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
					.addGap(9)
					.addComponent(lblTextoOrdenado, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnOrdenar)
						.addComponent(btnReset))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		textAreaOrig = new JTextArea();
		textAreaOrig.setWrapStyleWord(true);
		textAreaOrig.setLineWrap(true);
		scrollPane.setViewportView(textAreaOrig);
		
		listOrdenada = new JList();
		scrollPane_1.setViewportView(listOrdenada);
		frame.getContentPane().setLayout(groupLayout);
	}
	
	private void ordenar() {
		// Capturar texto del text area
		String texto = textAreaOrig.getText();
		// Separar el texto por saltos de linea, meterlo en array
		String[] palabras = texto.split("\n");
		// Lista para meter las palabras del array
		List<String> listaPalabras = new ArrayList<>();
		// Meter palabras
		for (String palabra: palabras) {
			// Si la palabra no está vacía
			if (palabra.length() > 0) {
				listaPalabras.add(palabra);
			}
		}
		// Ordenar lista
		Collections.sort(listaPalabras);
		// Crear modelo
		DefaultListModel<String> modelo = new DefaultListModel<>();
		// Añadir las palabras de la lista ordenada al modelo
		for (String palabra: listaPalabras) {
			modelo.addElement(palabra);
		}
		// Asignarle el modelo a la Jlist
		listOrdenada.setModel(modelo);
			
	}
	
	
	private void resetText() {
		textAreaOrig.setText("");
	}
	
}
