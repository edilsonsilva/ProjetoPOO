package classes;

import java.util.ArrayList;
import java.util.List;

public class TransacoesCorrente implements OperacoesCorrente{

	List<ContaCorrente> lstCorrente = new ArrayList<ContaCorrente>();
	
	@Override
	public String abrirConta(ContaCorrente conta) {
		lstCorrente.add(conta);
		return "Conta criada  com sucesso!";
		
	}

	@Override
	public String depositar(double valor) {
		
		String msg = "";
		if(lstCorrente.get(0).saldo > 0) {
			lstCorrente.get(0).saldo += valor;
			msg = "Depósito foi realizado e seu saldo atual é "+lstCorrente.get(0).saldo;
		}
		else {
			
			double rs = (1000-lstCorrente.get(0).limite);
			lstCorrente.get(0).limite += rs;
			
			lstCorrente.get(0).saldo += (valor - rs);
			msg = "Depósito realizado. Seu saldo é "+lstCorrente.get(0).saldo+" e seu limite é "+lstCorrente.get(0).limite;
		}
		
		return msg;
	}

	@Override
	public String sacar(double valor) {
		
		String msg = "";
		if(lstCorrente.get(0).saldo+lstCorrente.get(0).limite < valor) {
			msg = "Saldo insuficiente";
		}
		else if(lstCorrente.get(0).saldo < valor){
			lstCorrente.get(0).limite -= (valor-lstCorrente.get(0).saldo);
			lstCorrente.get(0).saldo = 0;
			msg = "Saque realizado. Seu saldo é "+lstCorrente.get(0).saldo+ 
					" e seu limite é "+lstCorrente.get(0).limite;
		}
		else {
			lstCorrente.get(0).saldo -= valor;
			msg = "Saque realizado. Seu saldo é "+lstCorrente.get(0).saldo;
		}
		
		return msg;
	}

	@Override
	public String saldo() {
		
		return "Seu saldo atual é "+lstCorrente.get(0).saldo+" E seu limite é "+lstCorrente.get(0).limite;
	}

	@Override
	public String transferencia(double valor) {
		String msg = "";
		if(lstCorrente.get(0).saldo+lstCorrente.get(0).limite < valor) {
			msg = "Saldo insuficiente";
		}
		else if(lstCorrente.get(0).saldo < valor){
			lstCorrente.get(0).limite -= (valor-lstCorrente.get(0).saldo);
			lstCorrente.get(0).saldo = 0;
			msg = "Transferência realizada. Seu saldo é "+lstCorrente.get(0).saldo+ 
					" e seu limite é "+lstCorrente.get(0).limite;
		}
		else {
			lstCorrente.get(0).saldo -= valor;
			msg = "Transferência realizada. Seu saldo é "+lstCorrente.get(0).saldo;
		}
		
		return msg;
	}

	@Override
	public String taxaAdministracao(double percentual) {
		double rs = lstCorrente.get(0).saldo * percentual;
		lstCorrente.get(0).saldo -= rs;
		return "Taxa de administração foi de "+rs+" Seu saldo atual é "+lstCorrente.get(0).saldo;
	}

}
