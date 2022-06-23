package classes;

public interface OperacoesPoupanca extends Operacoes<ContaPoupanca> {
	public String calcularRendimento(double percentual);
}
