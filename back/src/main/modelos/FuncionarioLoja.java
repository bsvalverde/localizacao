package main.modelos;

public class FuncionarioLoja {
	private Funcionario funcionario;
	private Loja loja;

	public FuncionarioLoja(Funcionario funcionario, Loja loja) {
		this.funcionario = funcionario;
		this.loja = loja;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public Loja getLoja() {
		return loja;
	}

	public void setLoja(Loja loja) {
		this.loja = loja;
	}

	public String toString() {
		return funcionario.getNome() + " e " + loja.getNome();
	}

}
