package prog.ud10.relacion01.ejercicio01;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class CalculadoraSwingApp {

	private JFrame frmCalculadora;
	private JTextField txtPrimerOp;
	private JTextField txtSegundoOp;
	private JButton btnSumar;
	private JButton btnRestar;
	private JButton btnDividir;
	private JButton btnMultiplicar;
	private JLabel lblResultado;
	private JLabel lblResultadoTexto;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CalculadoraSwingApp window = new CalculadoraSwingApp();
					window.frmCalculadora.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CalculadoraSwingApp() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCalculadora = new JFrame();
		frmCalculadora.getContentPane().setBackground(new Color(64, 0, 128));
		frmCalculadora.setTitle("Calculadora");
		frmCalculadora.setBounds(100, 100, 530, 317);
		frmCalculadora.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblPrimerOperando = new JLabel("Primer operando");
		lblPrimerOperando.setForeground(new Color(255, 255, 255));
		lblPrimerOperando.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		
		JLabel lblSegundoOperando = new JLabel("Segundo operando");
		lblSegundoOperando.setForeground(new Color(255, 255, 255));
		lblSegundoOperando.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		
		txtPrimerOp = new JTextField();
		txtPrimerOp.setColumns(10);
		
		txtSegundoOp = new JTextField();
		txtSegundoOp.setColumns(10);
		
		btnSumar = new JButton("Sumar");
		btnSumar.setBackground(new Color(192, 192, 192));
		btnSumar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sumar();
			}
		});
		btnSumar.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		
		btnRestar = new JButton("Restar");
		btnRestar.setBackground(new Color(192, 192, 192));
		btnRestar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				restar();
			}
		});
		btnRestar.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		
		btnMultiplicar = new JButton("Multiplicar");
		btnMultiplicar.setBackground(new Color(192, 192, 192));
		btnMultiplicar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				multiplicar();
			}
		});
		btnMultiplicar.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		
		btnDividir = new JButton("Dividir");
		btnDividir.setBackground(new Color(192, 192, 192));
		btnDividir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dividir();
			}
		});
		btnDividir.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		
		lblResultado = new JLabel(" ");
		lblResultado.setForeground(new Color(255, 255, 255));
		lblResultado.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		
		lblResultadoTexto = new JLabel("Resultado:");
		lblResultadoTexto.setForeground(new Color(255, 255, 255));
		lblResultadoTexto.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		GroupLayout groupLayout = new GroupLayout(frmCalculadora.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
									.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
										.addComponent(lblPrimerOperando, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(txtPrimerOp, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
										.addComponent(lblSegundoOperando, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(txtSegundoOp, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
								.addComponent(lblResultadoTexto, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED, 178, Short.MAX_VALUE)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(btnSumar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnRestar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnMultiplicar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnDividir, GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(50)
							.addComponent(lblResultado, GroupLayout.PREFERRED_SIZE, 229, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnSumar)
						.addComponent(lblPrimerOperando)
						.addComponent(txtPrimerOp, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnRestar, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblSegundoOperando, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtSegundoOp, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnMultiplicar, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblResultadoTexto, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblResultado)
						.addComponent(btnDividir, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(113, Short.MAX_VALUE))
		);
		frmCalculadora.getContentPane().setLayout(groupLayout);
	}

	
	private void sumar() {
		
		try {
			int num1 = Integer.parseInt(txtPrimerOp.getText());
			int num2 = Integer.parseInt(txtSegundoOp.getText());

			int resultado = num1 + num2;

			lblResultado.setText(String.valueOf(resultado));
		} catch (NumberFormatException e) {
			setMsgError();
		}

	}
	
	private void restar() {
		try {
			int num1 = Integer.parseInt(txtPrimerOp.getText());
			int num2 = Integer.parseInt(txtSegundoOp.getText());
			
			int resultado = num1 - num2;
			
			lblResultado.setText(String.valueOf(resultado));
		} catch (NumberFormatException e) {
			setMsgError();
		}
	}
	
	private void multiplicar() {
		try {
			int num1 = Integer.parseInt(txtPrimerOp.getText());
			int num2 = Integer.parseInt(txtSegundoOp.getText());
			
			int resultado = num1 * num2;
			
			lblResultado.setText(String.valueOf(resultado));
		} catch (NumberFormatException e) {
			setMsgError();
		}
	}
	
	private void dividir() {
		try {
			int num1 = Integer.parseInt(txtPrimerOp.getText());
			int num2 = Integer.parseInt(txtSegundoOp.getText());
			
			int resultado = num1 / num2;
			
			lblResultado.setText(String.valueOf(resultado));
		} catch (NumberFormatException e) {
			setMsgError();
		}
	}
	
	private void setMsgError() {
		if (!txtPrimerOp.getText().matches("\\d+")) {
			// El primer TextField no es un número entero válido
			lblResultado.setText("Error en el primer campo");
		} else if (!txtSegundoOp.getText().matches("\\d+")) {
			// El segundo TextField no es un número entero válido
			lblResultado.setText("Error en el \nsegundo campo");
		}
	}
	
}
