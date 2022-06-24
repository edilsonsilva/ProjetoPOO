package aplicacao;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

import classes.ContaCorrente;
import classes.TransacoesCorrente;

public class FormCorrente extends JFrame {

	private JPanel contentPane;
	private JTextField txtBanco;
	private JTextField txtAgencia;
	private JTextField txtConta;
	private JTextField txtTitular;
	private JTextField txtSaldo;
	private JTextField txtLimite;
	private JTextField txtValorTransacao;
	private JTextArea txtSaida;
	private ContaCorrente cc = null;
	private TransacoesCorrente tc = null;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public FormCorrente() {
		
		cc = new ContaCorrente();
		tc = new TransacoesCorrente();
		
		setResizable(false);
		setTitle("Conta Corrente");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 530, 622);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel pnlDadosConta = new JPanel();
		pnlDadosConta.setBackground(Color.WHITE);
		pnlDadosConta.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		pnlDadosConta.setBounds(10, 11, 494, 214);
		contentPane.add(pnlDadosConta);
		pnlDadosConta.setLayout(null);
		
		JLabel lblDadosConta = new JLabel("Dados da Conta");
		lblDadosConta.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		lblDadosConta.setBounds(10, 11, 179, 19);
		pnlDadosConta.add(lblDadosConta);
		
		JLabel lblNumeroBanco = new JLabel("N\u00FAmero do Banco");
		lblNumeroBanco.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNumeroBanco.setBounds(10, 73, 114, 14);
		pnlDadosConta.add(lblNumeroBanco);
		
		JLabel lblNumeroAgencia = new JLabel("N\u00FAmero da Ag\u00EAncia");
		lblNumeroAgencia.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNumeroAgencia.setBounds(10, 98, 114, 14);
		pnlDadosConta.add(lblNumeroAgencia);
		
		JLabel lblNumeroConta = new JLabel("N\u00FAmero da Conta");
		lblNumeroConta.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNumeroConta.setBounds(10, 123, 114, 14);
		pnlDadosConta.add(lblNumeroConta);
		
		JLabel lblTitular = new JLabel("Titular");
		lblTitular.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTitular.setBounds(207, 70, 57, 14);
		pnlDadosConta.add(lblTitular);
		
		JLabel lblSaldo = new JLabel("Saldo");
		lblSaldo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSaldo.setBounds(207, 95, 57, 14);
		pnlDadosConta.add(lblSaldo);
		
		JLabel lblLimite = new JLabel("Limite");
		lblLimite.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLimite.setBounds(207, 120, 57, 14);
		pnlDadosConta.add(lblLimite);
		
		txtBanco = new JTextField();
		txtBanco.setBounds(132, 70, 86, 20);
		pnlDadosConta.add(txtBanco);
		txtBanco.setColumns(10);
		
		txtAgencia = new JTextField();
		txtAgencia.setColumns(10);
		txtAgencia.setBounds(132, 95, 86, 20);
		pnlDadosConta.add(txtAgencia);
		
		txtConta = new JTextField();
		txtConta.setColumns(10);
		txtConta.setBounds(132, 120, 86, 20);
		pnlDadosConta.add(txtConta);
		
		txtTitular = new JTextField();
		txtTitular.setColumns(10);
		txtTitular.setBounds(274, 67, 200, 20);
		pnlDadosConta.add(txtTitular);
		
		txtSaldo = new JTextField();
		txtSaldo.setColumns(10);
		txtSaldo.setBounds(274, 92, 86, 20);
		pnlDadosConta.add(txtSaldo);
		
		txtLimite = new JTextField();
		txtLimite.setColumns(10);
		txtLimite.setBounds(274, 117, 86, 20);
		pnlDadosConta.add(txtLimite);
		
		JButton btnAbrirConta = new JButton("Abrir Conta");
		btnAbrirConta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			cc.setNumeroBanco(Integer.parseInt(txtBanco.getText()));
			cc.setNumeroAgencia(Integer.parseInt(txtAgencia.getText()));
			cc.setNumeroConta(Integer.parseInt(txtConta.getText()));
			cc.setTitular(txtTitular.getText());
			cc.setSaldo(Double.parseDouble(txtSaldo.getText()));
			cc.setLimite(Double.parseDouble(txtLimite.getText()));
			
			txtSaida.setText(tc.abrirConta(cc));
			
			txtBanco.setEnabled(false);
			txtAgencia.setEnabled(false);
			txtConta.setEnabled(false);
			txtTitular.setEnabled(false);
			txtSaldo.setEnabled(false);
			txtLimite.setEnabled(false);
			btnAbrirConta.setEnabled(false);
				
			}
		});
		btnAbrirConta.setBounds(370, 94, 104, 43);
		pnlDadosConta.add(btnAbrirConta);
		
		JPanel pnlSaida = new JPanel();
		pnlSaida.setBackground(Color.WHITE);
		pnlSaida.setBounds(10, 236, 494, 154);
		contentPane.add(pnlSaida);
		pnlSaida.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 474, 132);
		pnlSaida.add(scrollPane);
		
		txtSaida = new JTextArea();
		scrollPane.setViewportView(txtSaida);
		
		JPanel pnlTransacoes = new JPanel();
		pnlTransacoes.setBounds(10, 401, 494, 171);
		contentPane.add(pnlTransacoes);
		pnlTransacoes.setLayout(null);
		
		JButton btnSacar = new JButton("Sacar");
		btnSacar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(validarValorTransacao()) {
					txtSaida.append("\n"+tc.sacar(Double.parseDouble(txtValorTransacao.getText())));
				}
				
				
			}
		});
		btnSacar.setHorizontalAlignment(SwingConstants.LEFT);
		btnSacar.setIcon(new ImageIcon(FormCorrente.class.getResource("/icons/Website \u00BB Download.png")));
		btnSacar.setBounds(81, 65, 160, 41);
		pnlTransacoes.add(btnSacar);
		
		JButton btnDepositar = new JButton("Depositar");
		btnDepositar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				if(validarValorTransacao()) {
					txtSaida.append("\n"+tc.depositar(Double.parseDouble(txtValorTransacao.getText())));
				}
				
			}
		});
		btnDepositar.setIcon(new ImageIcon(FormCorrente.class.getResource("/icons/Chest of Drawers \u00BB Open \u00BB Files.png")));
		btnDepositar.setHorizontalAlignment(SwingConstants.LEFT);
		btnDepositar.setBounds(81, 119, 160, 41);
		pnlTransacoes.add(btnDepositar);
		
		JButton btnTransferencia = new JButton("Transfer\u00EAncia");
		btnTransferencia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(validarValorTransacao()) {
					txtSaida.append("\n"+tc.transferencia(Double.parseDouble(txtValorTransacao.getText())));
				}
			}
		});
		btnTransferencia.setIcon(new ImageIcon(FormCorrente.class.getResource("/icons/Sign Post.png")));
		btnTransferencia.setHorizontalAlignment(SwingConstants.LEFT);
		btnTransferencia.setBounds(251, 65, 160, 41);
		pnlTransacoes.add(btnTransferencia);
		
		JButton btnSaldo = new JButton("Saldo");
		btnSaldo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtSaida.append("\n"+tc.saldo());
			}
		});
		btnSaldo.setIcon(new ImageIcon(FormCorrente.class.getResource("/icons/Hard Disk \u00BB Installation.png")));
		btnSaldo.setHorizontalAlignment(SwingConstants.LEFT);
		btnSaldo.setBounds(251, 119, 160, 41);
		pnlTransacoes.add(btnSaldo);
		
		JLabel lblValorTransacao = new JLabel("Valor Transa\u00E7\u00E3o");
		lblValorTransacao.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblValorTransacao.setBounds(81, 25, 115, 27);
		pnlTransacoes.add(lblValorTransacao);
		
		txtValorTransacao = new JTextField();
		txtValorTransacao.setBounds(206, 25, 205, 29);
		pnlTransacoes.add(txtValorTransacao);
		txtValorTransacao.setColumns(10);
	}
	
	private boolean validarValorTransacao() {
		boolean rs = true;
		if(txtValorTransacao.getText().equals("") || txtValorTransacao.getText()==null) {
			rs = false;
			JOptionPane.showMessageDialog(null, "O valor da transação deve ser preenchido");
		}
		
		return rs;
		
	}
	
	
}







