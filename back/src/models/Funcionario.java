package models;

import java.util.List;

public class Funcionario extends ObjetoGeografico {
	private String nome;
	private List<Loja> lojas;
	
	public Funcionario(String nome, double latitude, double longitude) {
		super(latitude, longitude);
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public List<Loja> getLojas() {
		return lojas;
	}

}
