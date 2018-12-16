package models;

public class Loja extends ObjetoGeografico {
	private String nome;
	
	public Loja(String nome, double latitude, double longitude) {
		super(latitude, longitude);
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}

}
