package classes;

public class ContaPoupanca extends ContaBancaria{
	public String aniversario;
	
	//criar métodos de acesso:get set
	public void setNumeroBanco(int numeroBanco) {
		super.numeroBanco = numeroBanco;
	}
	public void setNumeroAgencia(int numeroAgencia) {
		super.numeroAgencia = numeroAgencia;
	}
	public void setNumeroConta(int numeroConta) {
		super.numeroConta = numeroConta;
		
	}
	public void setTitular(String titular) {
		super.titular = titular;
	}
	public void setSaldo(double saldo) {
		super.saldo = saldo;
	}
	public void setAniversario(String aniversario) {
		this.aniversario = aniversario;
	}
		
	
}
