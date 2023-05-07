package prog.ud10.relacion02.ejercicio02;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JList;
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.event.ActionEvent;

public class ParteListas {

	private JFrame frame;
	private JTextField txtCantidad;
	private JTextField txtValMin;
	private JTextField txtValMax;
	private JButton btnGenerar;
	private JList listListaGenerada;
	private JLabel lblMedia;
	private JList listDebajoMedia;
	private JList listEncimaMedia;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ParteListas window = new ParteListas();
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
	public ParteListas() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 507);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblNewLabel = new JLabel("Cantidad de números a generar (mínimo 3)");
		lblNewLabel.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 12));
		
		JLabel lblValorMnimoDe = new JLabel("Valor mínimo de los números a generar");
		lblValorMnimoDe.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 12));
		
		JLabel lblValorMximoDe = new JLabel("Valor máximo de los números a generar");
		lblValorMximoDe.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 12));
		
		txtCantidad = new JTextField();
		txtCantidad.setColumns(10);
		
		txtValMin = new JTextField();
		txtValMin.setColumns(10);
		
		txtValMax = new JTextField();
		txtValMax.setColumns(10);
		
		btnGenerar = new JButton("Generar");
		btnGenerar.setEnabled(true);
		btnGenerar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				generarLista();
			}
		});
		
		JLabel lblListaGenerada = new JLabel("Lista generada:");
		lblListaGenerada.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 12));
		
		JScrollPane scrollPane = new JScrollPane();
		
		lblMedia = new JLabel("          ");
		lblMedia.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 12));
		
		JScrollPane scrollPane_1 = new JScrollPane();
		
		JScrollPane scrollPane_2 = new JScrollPane();
		
		JLabel lblListaDebajoMediia = new JLabel("Lista debajo mediia");
		lblListaDebajoMediia.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 12));
		
		JLabel lblListaEncimaMediia = new JLabel("Lista encima mediia");
		lblListaEncimaMediia.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 12));
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(txtCantidad, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblValorMnimoDe, GroupLayout.PREFERRED_SIZE, 228, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(txtValMin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnGenerar))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblValorMximoDe, GroupLayout.PREFERRED_SIZE, 228, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(txtValMax, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblListaGenerada, GroupLayout.PREFERRED_SIZE, 228, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblMedia, GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(lblListaDebajoMediia, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(scrollPane_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblListaEncimaMediia, GroupLayout.PREFERRED_SIZE, 198, GroupLayout.PREFERRED_SIZE)
								.addComponent(scrollPane_2, GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE))))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(txtCantidad, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblValorMnimoDe, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtValMin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnGenerar))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblValorMximoDe, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtValMax, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(lblListaGenerada, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblMedia, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(scrollPane_2)
						.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblListaDebajoMediia, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblListaEncimaMediia, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(16, Short.MAX_VALUE))
		);
		
		listEncimaMedia = new JList();
		scrollPane_2.setViewportView(listEncimaMedia);
		
		listDebajoMedia = new JList();
		scrollPane_1.setViewportView(listDebajoMedia);
		
		listListaGenerada = new JList();
		scrollPane.setViewportView(listListaGenerada);
		frame.getContentPane().setLayout(groupLayout);
	}
	private void generarLista() {
		// Cantidad introducida
		int cantidad = Integer.parseInt(txtCantidad.getText());
		// Valor minimo
		int valorMin = Integer.parseInt(txtValMin.getText());
		// Valor minimo
		int valorMax = Integer.parseInt(txtValMax.getText());
		
		// Si ha introducido todos los campos habilitar boton
		if (!txtCantidad.getText().isBlank() && !txtValMin.getText().isBlank() && !txtValMax.getText().isBlank()) {
			btnGenerar.setEnabled(true);
		}
		
		
		DefaultListModel<Integer> modelo = new DefaultListModel<>();
		
		// Si los datos son correctos
		if (cantidad >= 3 && valorMin < valorMax) {
			// Rellenar lista
			for (int i = 0; i < cantidad; i++) {
				modelo.addElement(generaDoubleAleatorioEnRango(valorMin, valorMax));
			}
			
			listListaGenerada.setModel(modelo);
			// Calcular media
			double suma = 0;
			double media = 0;
			for (int i = 0; i < modelo.size(); i++) {
				suma += modelo.get(i);
			}
			media = suma / modelo.size();
			lblMedia.setText("La media es: " + media);
			
			generaListaEncimaMedia(modelo, media);
			generaListaDebajoMedia(modelo, media);
			// Si los datos no son correctos
		} else if (cantidad < 3) {
			
			lblMedia.setText("Debe introducir al menos 3 números");
			
		} else if (valorMin > valorMax) {
			
			lblMedia.setText("Error. " + valorMin + " debe ser menor que " + valorMax);
			
		}
	}

	private void generaListaEncimaMedia(DefaultListModel<Integer> modelo, double media) {
		DefaultListModel<Integer> modeloEncimaMedia = new DefaultListModel<>();
		
		for (int i = 0; i < modelo.size(); i++) {
			// Si está por encima de la media se añade
			if (modelo.get(i) > media) {
				modeloEncimaMedia.addElement(modelo.get(i));
			}
		}
		
		listEncimaMedia.setModel(modeloEncimaMedia);
	}

	private void generaListaDebajoMedia(DefaultListModel<Integer> modelo, double media) {
		DefaultListModel<Integer> modeloDebajoMedia = new DefaultListModel<>();
		
		for (int i = 0; i < modelo.size(); i++) {
			// Si está por encima de la media se añade
			if (modelo.get(i) <= media) {
				modeloDebajoMedia.addElement(modelo.get(i));
			}
		}
		
		listDebajoMedia.setModel(modeloDebajoMedia);
	}
	
	private int generaDoubleAleatorioEnRango(int min, int max) {
		Random random = new Random();
    return (int) (min + (max - min) * random.nextDouble()); 
	}
}
