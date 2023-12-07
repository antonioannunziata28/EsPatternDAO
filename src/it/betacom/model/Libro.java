package it.betacom.model;

public class Libro {

	private int idLibro;
	private String titolo;
	private int numeroPagine;
	private int dataUscita;
	private int autore;
	private int genere;
	private Editore idEditore;
	
	
	public Libro(int idLibro, String titolo, int numeroPagine, int dataUscita, int autore, int genere,
			Editore editore) {
		super();
		this.idLibro = idLibro;
		this.titolo = titolo;
		this.numeroPagine = numeroPagine;
		this.dataUscita = dataUscita;
		this.autore = autore;
		this.genere = genere;
		this.idEditore = editore;
	}


	public int getIdLibro() {
		return idLibro;
	}


	public String getTitolo() {
		return titolo;
	}


	public int getNumeroPagine() {
		return numeroPagine;
	}


	public int getDataUscita() {
		return dataUscita;
	}


	public int getAutore() {
		return autore;
	}


	public int getGenere() {
		return genere;
	}


	public Editore getEditore() {
		return idEditore;
	}


	public void setIdLibro(int idLibro) {
		this.idLibro = idLibro;
	}


	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}


	public void setNumeroPagine(int numeroPagine) {
		this.numeroPagine = numeroPagine;
	}


	public void setDataUscita(int dataUscita) {
		this.dataUscita = dataUscita;
	}


	public void setAutore(int autore) {
		this.autore = autore;
	}


	public void setGenere(int genere) {
		this.genere = genere;
	}


	public void setEditore(Editore editore) {
		this.idEditore = editore;
	}

}
