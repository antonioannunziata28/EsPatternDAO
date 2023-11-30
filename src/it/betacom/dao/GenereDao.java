package it.betacom.dao;

import java.util.List;

import it.betacom.model.Genere;

public interface GenereDao {
	
	//Creo l'interfaccia DAO con i metodi Crud piu una lettura di tutti i generi

	List<Genere> getAllGenere();
	
	void createGenere(Genere genere);
	
	Genere readGenereById(int idGenere);
	
	void updateGenere(Genere genere);
	
	void deleteGenere(Genere genere);
}
