package prog.ud10.relacion01.ejercicio02;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;

public class CuentaPalabrasApp {

	private JFrame frame;
	private JTextArea textArea;
	private JButton btnContar;
	private JLabel lblResultado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CuentaPalabrasApp window = new CuentaPalabrasApp();
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
	public CuentaPalabrasApp() {
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
		
		btnContar = new JButton("Contar");
		btnContar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cuentaPalabras();
			}
		});
		
		JLabel lblNewLabel = new JLabel("La palabra más frecuente es:");
		
		lblResultado = new JLabel("                                 ");
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 411, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnContar)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblNewLabel)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblResultado, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
					.addContainerGap(13, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnContar)
						.addComponent(lblNewLabel)
						.addComponent(lblResultado))
					.addContainerGap(58, Short.MAX_VALUE))
		);
		
		textArea = new JTextArea();
		textArea.setWrapStyleWord(true);
		textArea.setLineWrap(true);
		scrollPane.setViewportView(textArea);
		frame.getContentPane().setLayout(groupLayout);
	}
	
	public void cuentaPalabras() {
		// Consigo el texto
		String textoTotal = textArea.getText();
		// Lo divido en palabras
		String[] palabras = textoTotal.split("\\s+");
		// Creo un mapa con la palabra y el numero de veces que aparece
		Map<String,Integer> frecuencias = new HashMap<>();
		
		for (String palabra: palabras) {
			// Si el mapa no tiene la palabra se añade con el contador a 0
			if (!frecuencias.containsKey(palabra)) {
				frecuencias.put(palabra, 0);
			} else {
				// Si la tiene se guarda nuevamente la palabra con los valores que tenia
				// sumando uno al contador
				frecuencias.put(palabra, frecuencias.get(palabra) + 1);				
			}
		}
		
		// Buscar la palabra de mayor frecuencia
		// Si el mapa no está vacío
		if (frecuencias.size() > 0) {
			// Inicializamos la variable que contendrá la palabra mas repetida
			String palabMasRep = "";
			// Inicializamos la variable que cuenta las veces que aparece la palabra
			int contador = 0;
			// Por cada palabra en el mapa
			for (String palabra: frecuencias.keySet()) {
				// Si es la primera palabra o el contador es mayor al que hay
				if ((palabMasRep == null) || (frecuencias.get(palabra) > contador)) {
					palabMasRep = palabra;
					contador = frecuencias.get(palabMasRep);
				}
			}
			lblResultado.setText(palabMasRep + "(" + (contador + 1) + ")");
			
		} else {
			lblResultado.setText("No hay palabras");
		}
		
	}
	
}
