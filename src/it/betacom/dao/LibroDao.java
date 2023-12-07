package it.betacom.dao;

import java.util.List;

import it.betacom.model.Libro;

public interface LibroDao {

	List<Libro> getAllLibri();
	
	void createLibro(Libro libro);
	
	Libro readLibroById(int idLibro);
	
	void updateLibro(Libro libro);
	
	void deleteLibro(Libro libro);
}
