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
			msg = "Dep�sito foi realizado e seu saldo atual � "+lstCorrente.get(0).saldo;
		}
		else {
			
			double rs = (1000-lstCorrente.get(0).limite);
			lstCorrente.get(0).limite += rs;
			
			lstCorrente.get(0).saldo += (valor - rs);
			msg = "Dep�sito realizado. Seu saldo � "+lstCorrente.get(0).saldo+" e seu limite � "+lstCorrente.get(0).limite;
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
			msg = "Saque realizado. Seu saldo � "+lstCorrente.get(0).saldo+ 
					" e seu limite � "+lstCorrente.get(0).limite;
		}
		else {
			lstCorrente.get(0).saldo -= valor;
			msg = "Saque realizado. Seu saldo � "+lstCorrente.get(0).saldo;
		}
		
		return msg;
	}

	@Override
	public String saldo() {
		
		return "Seu saldo atual � "+lstCorrente.get(0).saldo+" E seu limite � "+lstCorrente.get(0).limite;
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
			msg = "Transfer�ncia realizada. Seu saldo � "+lstCorrente.get(0).saldo+ 
					" e seu limite � "+lstCorrente.get(0).limite;
		}
		else {
			lstCorrente.get(0).saldo -= valor;
			msg = "Transfer�ncia realizada. Seu saldo � "+lstCorrente.get(0).saldo;
		}
		
		return msg;
	}

	@Override
	public String taxaAdministracao(double percentual) {
		double rs = lstCorrente.get(0).saldo * percentual;
		lstCorrente.get(0).saldo -= rs;
		return "Taxa de administra��o foi de "+rs+" Seu saldo atual � "+lstCorrente.get(0).saldo;
	}

}
