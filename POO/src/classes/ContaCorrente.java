package classes;

public class ContaCorrente extends ContaBancaria{
	public double limite;
	
	
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
		
		public void setLimite(double limite) {
			this.limite = limite;
		}
}
