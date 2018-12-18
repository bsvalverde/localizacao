package database.interfaces;

import java.util.List;

import modelos.Loja;

public interface LojaGateway {
	
	public void salvar(Loja loja);
	
	public List<Loja> buscarTodos();

}
