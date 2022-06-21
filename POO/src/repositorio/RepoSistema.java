package repositorio;

import java.util.ArrayList;
import java.util.List;

import classes.PrjCliente;
import classes.PrjEndereco;
import classes.PrjUsuario;

public class RepoSistema {
	List<PrjUsuario> lstUsuario = new ArrayList<PrjUsuario>();
	List<PrjEndereco> lstEndereco = new ArrayList<PrjEndereco>();
	List<PrjCliente> lstCliente = new ArrayList<PrjCliente>();
	
	public String cadUsuario(PrjUsuario usuario) {
		lstUsuario.add(usuario);
		return "Usuário cadastrado";
	}
	public List<PrjUsuario> listarUsuario(){
		return lstUsuario;
	}
	public String cadEndereco(PrjEndereco endereco) {
		lstEndereco.add(endereco);
		return "Endereço cadastrado";
	}
	
	public List<PrjEndereco> listarEndereco(){
		return lstEndereco;
	}
	public String cadCliente(PrjCliente cliente) {
		lstCliente.add(cliente);
		return "Cliente cadastrado";
	}
	
	public List<PrjCliente> listarCliente(){
		return lstCliente;
	}
	
}
