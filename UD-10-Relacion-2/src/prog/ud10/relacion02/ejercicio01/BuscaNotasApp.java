package prog.ud10.relacion02.ejercicio01;

import java.awt.EventQueue;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;

public class BuscaNotasApp {

	private JFrame frame;
	private JLabel lblResultado;
	private JList lstNotas;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BuscaNotasApp window = new BuscaNotasApp();
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
	public BuscaNotasApp() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings("unchecked")
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JComboBox<Integer> comboBox = new JComboBox<Integer>();
		comboBox.setModel(new DefaultComboBoxModel<Integer>(new Integer[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10}));
		
		int notaSeleccionada = comboBox.getSelectedIndex();
		
		switch (notaSeleccionada) {
		case 0:
	
		}
		
		
		lblResultado = new JLabel("                            ");
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(lblResultado, GroupLayout.DEFAULT_SIZE, 343, Short.MAX_VALUE))
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblResultado))
					.addContainerGap(88, Short.MAX_VALUE))
		);
		
		lstNotas = new JList();
		DefaultListModel<Integer> modelo = new DefaultListModel<>();
		for (int i = 0; i < 30; i++) {
			modelo.addElement(generaNotaAleatoria());
		}
		lstNotas.setModel(modelo);
		scrollPane.setViewportView(lstNotas);
		frame.getContentPane().setLayout(groupLayout);
		

		
	}
	
	private void kasdjhajks() {
	
	}

	private int generaNotaAleatoria() {
		Random random = new Random();
    return random.nextInt(11);
	}
}

