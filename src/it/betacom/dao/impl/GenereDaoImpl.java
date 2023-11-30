package it.betacom.dao.impl;

import java.util.ArrayList;
import java.util.List;

import it.betacom.dao.GenereDao;
import it.betacom.model.Genere;

public class GenereDaoImpl implements GenereDao {
	
	private List<Genere> listaGeneri;
	
	

	public GenereDaoImpl() {
		super();
		listaGeneri = new ArrayList<Genere>();
		listaGeneri.add(new Genere("Giallo", 1));
		listaGeneri.add(new Genere("Romanzo", 2));
		listaGeneri.add(new Genere("Documentario", 3));
		listaGeneri.add(new Genere("Horror", 4));
		listaGeneri.add(new Genere("Romanzo", 5));
	}

	@Override
	public List<Genere> getAllGenere() {
		
		return listaGeneri;
	}

	@Override
	public void createGenere(Genere genere) {
		
		listaGeneri.add(genere);
		
	}

	@Override
	public Genere readGenereById(int idGenere) {
		
		for(Genere g : listaGeneri) {
			if(g.getCodiceGenere() == idGenere) {
				return g;
			}
		}
		System.out.println("Corrispondenza non trovata");
		return null;
		
	}

	@Override
	public void updateGenere(Genere genere) {
		
		for(Genere g : listaGeneri) {
			if(g.getCodiceGenere() == genere.getCodiceGenere()) {
				g = genere;
				break;
			}
		}
		
	}

	@Override
	public void deleteGenere(Genere genere) {
		
		listaGeneri.remove(genere);
		
	}
	

}
