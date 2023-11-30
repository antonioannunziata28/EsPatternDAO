package it.betacom.dao.impl;

import java.util.ArrayList;
import java.util.List;

import it.betacom.dao.EditoreDao;
import it.betacom.model.Editore;

public class EditoreDaoImpl implements EditoreDao {
	
	private List<Editore> listaEditori;
	
	public EditoreDaoImpl() {
		
		listaEditori = new ArrayList<>();
		listaEditori.add(new Editore("Rizzoli", 1));
		listaEditori.add(new Editore("Mondadori", 2));
		listaEditori.add(new Editore("Cairo", 3));
		listaEditori.add(new Editore("Hachette", 4));
	}

	@Override
	public List<Editore> getAllEditore() {
		
		return listaEditori;
	}

	@Override
	public void createEditore(Editore editore) {
		
		listaEditori.add(editore);
	}

	@Override
	public Editore readEditoreById(int idEditore) {
		
		for(Editore e : listaEditori) {
			if(e.getCodiceEditore() == idEditore) {
				return e;
			}
		}
		System.out.println("Corrispondenza non trovata");
		return null;
	}

	@Override
	public void updateEditore(Editore editore) {
		
		for(Editore e : listaEditori) {
			if(e.getCodiceEditore() == editore.getCodiceEditore()) {
				e = editore;
				break;
			}
		}
		
	}

	@Override
	public void deleteEditore(Editore editore) {
		
		listaEditori.remove(editore);
		
	}

}
