package classes;

import java.util.ArrayList;
import java.util.List;

public class TransacoesPoupanca implements OperacoesPoupanca{
	
	
	List<ContaPoupanca> lstPoupanca = new ArrayList<ContaPoupanca>();

	@Override
	public String abrirConta(ContaPoupanca conta) {
		lstPoupanca.add(conta);
		return "Conta criada  com sucesso!";
	}

	@Override
	public String depositar(double valor) {

		lstPoupanca.get(0).saldo += valor;
		
		return "Depósito realizado. Seu saldo atual é "+lstPoupanca.get(0).saldo;
	}

	@Override
	public String sacar(double valor) {
		
		String msg = "";
		if(lstPoupanca.get(0).saldo < valor) {
			msg = "Saldo insuficiente";
		}
		else {
			lstPoupanca.get(0).saldo -= valor;
			msg = "Saque realizado. Seu saldo atual é "+lstPoupanca.get(0).saldo;
		}
		return msg;
	}

	@Override
	public String saldo() {
		
		return "Seu saldo atual é "+lstPoupanca.get(0).saldo;
	}

	@Override
	public String transferencia(double valor) {
		String msg = "";
		if(lstPoupanca.get(0).saldo < valor) {
			msg = "Saldo insuficiente";
		}
		else {
			lstPoupanca.get(0).saldo -= valor;
			msg = "Transferência realizada. Seu saldo atual é "+lstPoupanca.get(0).saldo;
		}
		return msg;
	}

	@Override
	public String calcularRendimento(double percentual) {
	
		double rs = lstPoupanca.get(0).saldo * percentual;
		lstPoupanca.get(0).saldo += rs;
		
		return "O seu rendimento foi de "+rs+" e o seu saldo atual é de "+lstPoupanca.get(0).saldo;
	}

}
