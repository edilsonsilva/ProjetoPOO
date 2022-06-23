package aplicacao;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import classes.ContaPoupanca;
import classes.TransacoesPoupanca;

public class FormPoupanca extends JFrame {

	private JPanel contentPane;
	private JTextField txtBanco;
	private JTextField txtAgencia;
	private JTextField txtConta;
	private JTextField txtTitular;
	private JTextField txtSaldo;
	private JTextField txtAniversario;
	private JTextField txtValorTransacao;
	private JTextArea txtSaida;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public FormPoupanca() {
		
		ContaPoupanca cp = new ContaPoupanca();
		TransacoesPoupanca tp = new TransacoesPoupanca();
		
		
		setTitle("Conta Poupan\u00E7a");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 435);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Transa\u00E7\u00F5es");
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setBounds(34, 183, 70, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNumeroBanco = new JLabel("N\u00FAmero do Banco:");
		lblNumeroBanco.setBounds(24, 29, 110, 21);
		contentPane.add(lblNumeroBanco);
		
		JLabel lblNumeroAgencia = new JLabel("N\u00FAmero da Ag\u00EAncia:");
		lblNumeroAgencia.setBounds(24, 80, 121, 21);
		contentPane.add(lblNumeroAgencia);
		
		JLabel lblNumeroConta = new JLabel("N\u00FAmero da Conta:");
		lblNumeroConta.setBounds(24, 133, 110, 21);
		contentPane.add(lblNumeroConta);
		
		JLabel lblTitular = new JLabel("Titular da Conta:");
		lblTitular.setBounds(165, 29, 93, 21);
		contentPane.add(lblTitular);
		
		JLabel lblSaldo = new JLabel("Saldo da Conta:");
		lblSaldo.setBounds(165, 80, 93, 21);
		contentPane.add(lblSaldo);
		
		JLabel lblAniversario = new JLabel("Anivers\u00E1rio da Conta:");
		lblAniversario.setBounds(165, 133, 135, 21);
		contentPane.add(lblAniversario);
		
		txtBanco = new JTextField();
		txtBanco.setBounds(24, 49, 120, 20);
		contentPane.add(txtBanco);
		txtBanco.setColumns(10);
		
		txtAgencia = new JTextField();
		txtAgencia.setColumns(10);
		txtAgencia.setBounds(24, 102, 120, 20);
		contentPane.add(txtAgencia);
		
		txtConta = new JTextField();
		txtConta.setColumns(10);
		txtConta.setBounds(24, 152, 120, 20);
		contentPane.add(txtConta);
		
		txtTitular = new JTextField();
		txtTitular.setColumns(10);
		txtTitular.setBounds(165, 49, 250, 20);
		contentPane.add(txtTitular);
		
		txtSaldo = new JTextField();
		txtSaldo.setColumns(10);
		txtSaldo.setBounds(165, 102, 120, 20);
		contentPane.add(txtSaldo);
		
		txtAniversario = new JTextField();
		txtAniversario.setColumns(10);
		txtAniversario.setBounds(165, 152, 120, 20);
		contentPane.add(txtAniversario);
		
		JButton btnAbrirConta = new JButton("Abrir Conta");
		btnAbrirConta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				cp.setNumeroBanco(Integer.parseInt(txtBanco.getText()) );
				
				cp.setNumeroAgencia(Integer.parseInt(txtAgencia.getText()));				
				
				cp.setNumeroConta(Integer.parseInt(txtConta.getText()));
				
				cp.setTitular(txtTitular.getText());
				
				cp.setSaldo(Double.parseDouble(txtSaldo.getText()));
				
				cp.setAniversario(txtAniversario.getText());
				
				txtSaida.setText(tp.abrirConta(cp));
								
				//desabilitar as caixas texto e o botão abrirConta.
				txtBanco.setEnabled(false);
				txtAgencia.setEnabled(false);
				txtConta.setEnabled(false);
				txtTitular.setEnabled(false);
				txtSaldo.setEnabled(false);
				txtAniversario.setEnabled(false);
				btnAbrirConta.setEnabled(false);
				
				
			}
		});
		btnAbrirConta.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnAbrirConta.setBounds(295, 101, 120, 71);
		contentPane.add(btnAbrirConta);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBorder(new LineBorder(Color.GRAY));
		panel.setLayout(null);
		panel.setBounds(24, 201, 391, 71);
		contentPane.add(panel);
		
		JLabel lblValor = new JLabel("Valor da Transa\u00E7\u00E3o");
		lblValor.setBounds(10, 11, 126, 14);
		panel.add(lblValor);
		
		txtValorTransacao = new JTextField();
		txtValorTransacao.setBounds(10, 36, 114, 20);
		panel.add(txtValorTransacao);
		txtValorTransacao.setColumns(10);
		
		JButton btnSacar = new JButton("Sacar");
		btnSacar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(validarValorTransacao()) {
					txtSaida.append("\n"+tp.sacar(Double.parseDouble(txtValorTransacao.getText())));
				}
				
			}
		});
		btnSacar.setBounds(156, 8, 89, 23);
		panel.add(btnSacar);
		
		JButton btnDepositar = new JButton("Depositar");
		btnDepositar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(validarValorTransacao()) {
					txtSaida.append("\n"+tp.depositar(Double.parseDouble(txtValorTransacao.getText())));
				}
			}
		});
		btnDepositar.setBounds(156, 39, 89, 23);
		panel.add(btnDepositar);
		
		JButton btnTransferir = new JButton("Transferir");
		btnTransferir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(validarValorTransacao()) {
					txtSaida.append("\n"+tp.transferencia(Double.parseDouble(txtValorTransacao.getText())));
				}
			}
		});
		btnTransferir.setBounds(265, 8, 102, 23);
		panel.add(btnTransferir);
		
		JButton btnSaldo = new JButton("Saldo");
		btnSaldo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtSaida.append("\n"+tp.saldo());
			}
		});
		btnSaldo.setBounds(265, 39, 102, 23);
		panel.add(btnSaldo);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(24, 283, 391, 102);
		contentPane.add(scrollPane);
		
		txtSaida = new JTextArea();
		scrollPane.setViewportView(txtSaida);
	}
	
	//Criar uma função para validar a txtValorTranscao
	private boolean validarValorTransacao() {
		boolean rt = true;
		
		if(txtValorTransacao.getText().equals("") || txtValorTransacao.getText()==null) {
			rt = false;
			JOptionPane.showMessageDialog(null, "Preencha o valor da transação");
		}
		
		return rt;
	}
	
}



