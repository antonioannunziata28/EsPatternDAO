package it.betacom.dao;

import java.util.List;

import it.betacom.model.Editore;

public interface EditoreDao {

	List<Editore> getAllEditore();
	
	void createEditore(Editore editore);
	
	Editore readEditoreById(int idEditore);
	
	void updateEditore(Editore editore);
	
	void deleteEditore(Editore editore);
}
