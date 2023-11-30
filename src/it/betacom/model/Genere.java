package it.betacom.model;

public class Genere {

	private String nome;
	private int codiceGenere;
	
	
	
	public Genere(String nome, int codiceGenere) {
		super();
		this.nome = nome;
		this.codiceGenere = codiceGenere;
	}
	
	
	public String getNome() {
		return nome;
	}
	public int getCodiceGenere() {
		return codiceGenere;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setCodiceGenere(int codiceGenere) {
		this.codiceGenere = codiceGenere;
	}
	
	
}
