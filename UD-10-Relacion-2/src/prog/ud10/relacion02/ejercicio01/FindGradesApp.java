package prog.ud10.relacion02.ejercicio01;

import java.awt.EventQueue;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;

public class FindGradesApp {

	private JFrame frame;
	private JComboBox comboBoxNotas;
	private JLabel lblResultado;
	private JList listNotas;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FindGradesApp window = new FindGradesApp();
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
	public FindGradesApp() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JScrollPane scrollPane = new JScrollPane();
		
		comboBoxNotas = new JComboBox();
		comboBoxNotas.addItemListener(new ItemListener() {
      public void itemStateChanged(ItemEvent e) {
        cuentaNotas();
      }
    });
		comboBoxNotas.setModel(new DefaultComboBoxModel(new String[] {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}));
		
		lblResultado = new JLabel("             ");
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(comboBoxNotas, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(lblResultado, GroupLayout.DEFAULT_SIZE, 351, Short.MAX_VALUE))
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(comboBoxNotas, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblResultado))
					.addContainerGap(99, Short.MAX_VALUE))
		);
		
		listNotas = new JList<String>();
		DefaultListModel<String> modelo = new DefaultListModel<>();
		rellenaLista(modelo);
		
		scrollPane.setViewportView(listNotas);
		frame.getContentPane().setLayout(groupLayout);
		
		// Por defecto
		cuentaNotas();

	}

	private void cuentaNotas() {

		String calificacion = (String)comboBoxNotas.getSelectedItem();
		
		DefaultListModel<String> modelo = (DefaultListModel<String>)listNotas.getModel();
		
		int contador = 0;
		for (int i = 0; i <modelo.size(); i++) {
			if (modelo.get(i).equals(calificacion)) {
				contador++;
			}
		}
		lblResultado.setText("Hay "+ contador + " notas encontradas");
	}

	@SuppressWarnings("unchecked")
	private void rellenaLista(DefaultListModel<String> modelo) {
		for (int i = 0; i < 30; i++) {
			modelo.addElement(String.valueOf(generaNotaAleatoria()));
		}
		listNotas.setModel(modelo);
	}

	private int generaNotaAleatoria() {
		Random random = new Random();
    return random.nextInt(11);
	}

	
}
