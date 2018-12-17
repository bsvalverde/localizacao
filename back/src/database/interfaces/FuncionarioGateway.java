package database.interfaces;

import java.util.List;

import models.Funcionario;

public interface FuncionarioGateway {
	
	public void salvar(Funcionario funcionario);
	
	public List<Funcionario> buscarTodos();

}
