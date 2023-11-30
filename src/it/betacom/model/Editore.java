package it.betacom.model;

public class Editore {
	
	private String nome;
	private int codiceEditore;
	
	public Editore(String nome, int codiceEditore) {
		super();
		this.nome = nome;
		this.codiceEditore = codiceEditore;
	}
	
	
	public String getNome() {
		return nome;
	}
	public int getCodiceEditore() {
		return codiceEditore;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setCodiceEditore(int codiceEditore) {
		this.codiceEditore = codiceEditore;
	}
	
	
}
