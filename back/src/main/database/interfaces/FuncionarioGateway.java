package main.database.interfaces;

import java.util.List;

import main.modelos.Funcionario;

public interface FuncionarioGateway {

	public List<Funcionario> buscarTodos();

}
