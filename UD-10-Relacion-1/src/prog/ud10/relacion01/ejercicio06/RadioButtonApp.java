package prog.ud10.relacion01.ejercicio06;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class RadioButtonApp {

	private JFrame frame;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RadioButtonApp window = new RadioButtonApp();
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
	public RadioButtonApp() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 331);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblNewLabel_1 = new JLabel("El ciclo seleccionado es:");
		lblNewLabel_1.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		
		JLabel lblResultado = new JLabel("                         ");
		lblResultado.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Ciclo a cursar", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 408, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1)
						.addComponent(lblResultado, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(16, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblNewLabel_1)
					.addGap(18)
					.addComponent(lblResultado)
					.addContainerGap(98, Short.MAX_VALUE))
		);
		
		JRadioButton rdbtnASIR = new JRadioButton("Administración de Sistemas Informáticos y Redes");
		rdbtnASIR.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if (rdbtnASIR.isSelected()) {
					lblResultado.setText(rdbtnASIR.getText());
				}
			}
		});
		buttonGroup_1.add(rdbtnASIR);
		
		JRadioButton rdbtnDAM = new JRadioButton("Desarrollo de Aplicaciones Multiplataforma");
		rdbtnDAM.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if (rdbtnDAM.isSelected()) {
					lblResultado.setText(rdbtnDAM.getText());
				}
			}
		});
		buttonGroup_1.add(rdbtnDAM);
		
		JRadioButton rdbtnDAW = new JRadioButton("Desarrollo de Aplicaciones Web");
		rdbtnDAW.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if (rdbtnDAW.isSelected()) {
					lblResultado.setText(rdbtnDAW.getText());
				}
			}
		});
		buttonGroup_1.add(rdbtnDAW);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
						.addComponent(rdbtnASIR, GroupLayout.DEFAULT_SIZE, 363, Short.MAX_VALUE)
						.addComponent(rdbtnDAM, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(rdbtnDAW, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addContainerGap(33, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(rdbtnDAW)
					.addGap(3)
					.addComponent(rdbtnDAM)
					.addGap(3)
					.addComponent(rdbtnASIR)
					.addContainerGap(15, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		frame.getContentPane().setLayout(groupLayout);
	}
}
