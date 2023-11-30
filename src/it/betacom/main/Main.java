package it.betacom.main;

import it.betacom.dao.EditoreDao;
import it.betacom.dao.GenereDao;
import it.betacom.dao.impl.EditoreDaoImpl;
import it.betacom.dao.impl.GenereDaoImpl;
import it.betacom.model.Editore;
import it.betacom.model.Genere;

public class Main {

	public static void main(String[] args) {
		
		System.out.println("---------------------------------");
		System.out.println("Lista dei generi: ");
		
		GenereDao genereDao = new GenereDaoImpl();
		
		//stampiamo la lista dei generi
		for(Genere g : genereDao.getAllGenere()) {
			System.out.println("Nome genere: " + g.getNome() + " codice genere: " + g.getCodiceGenere());
		}
		
		//stampiamo i dati di un genere richiesto
		System.out.println("---------------------------------");
		String nomeGenere1 = genereDao.readGenereById(1).getNome();
		int codiceGenere1 = genereDao.readGenereById(1).getCodiceGenere();
		System.out.println("Nome genere: " + nomeGenere1 + " codice: " + codiceGenere1);
		System.out.println("---------------------------------");
		
		Genere nuovoGenere = new Genere("Rosa", 6);
		genereDao.createGenere(nuovoGenere);
		for(Genere g : genereDao.getAllGenere()) {
			System.out.println("Genere: " + g.getNome() + " codice: " + g.getCodiceGenere());
		}
		System.out.println("---------------------------------");
		
		//aggiorniamo i dati di un determinato genere
		Genere genereDaAggiornare = genereDao.readGenereById(codiceGenere1);
		genereDaAggiornare.setNome("Fantascienza");
		genereDao.updateGenere(genereDaAggiornare);
		System.out.println("Genere aggiornato, nome: " + genereDaAggiornare.getNome() + " codice: " + genereDaAggiornare.getCodiceGenere());
		System.out.println("---------------------------------");
		
		
		//eliminiamo un determinato genere e stampiamo la lista
		
		genereDao.deleteGenere(genereDaAggiornare);
		for(Genere g : genereDao.getAllGenere()) {
			System.out.println("Nome: " + g.getNome() + " Codice: " + g.getCodiceGenere());
		}
		
		System.out.println("---------------------------------");
		System.out.println("---------------------------------");
		System.out.println("---------------------------------");
		
		//stampiamo la lista degli editori
		EditoreDao eDao = new EditoreDaoImpl();
		for(Editore editore : eDao.getAllEditore()) {
			System.out.println("Nome editore: " + editore.getNome() + " codice: " + editore.getCodiceEditore());
		}
		System.out.println("---------------------------------");
		
		//stampiamo i dati di un determinato editore
		String nomeEditore = eDao.readEditoreById(1).getNome();
		int codiceEditore = eDao.readEditoreById(1).getCodiceEditore();
		System.out.println("Nome: " + nomeEditore + " codice: " + codiceEditore);
		System.out.println("---------------------------------");
		
		//inseriamo un nuovo editore e stampiamo la lista degli editore
		Editore nuovoEditore = new Editore("Marotta", 5);
		eDao.createEditore(nuovoEditore);
		System.out.println("Nuovo editore creato: " + nuovoEditore.getNome() + " codice: " + nuovoEditore.getCodiceEditore());
		System.out.println();
		
		for(Editore e : eDao.getAllEditore()) {
			System.out.println("Nome: " + e.getNome() + " codice: " + e.getCodiceEditore());
		}
		System.out.println("---------------------------------");
		
		//aggiornare un editore e stampare la lista
		nuovoEditore.setNome("Marotta e Figli");
		eDao.updateEditore(nuovoEditore);
		System.out.println("Editore aggiornato correttamente, nome: " + nuovoEditore.getNome());
		System.out.println();
		for(Editore e : eDao.getAllEditore()) {
			System.out.println("Nome: " + e.getNome() + " codice: " + e.getCodiceEditore());
		}
		System.out.println("---------------------------------");
		
		//eliminiamo un determinato editore e stampare la lista
		eDao.deleteEditore(nuovoEditore);
		System.out.println("Eliminato correttamente editore " + nuovoEditore.getNome() + " codice: " + nuovoEditore.getCodiceEditore());
		System.out.println();
		for(Editore e: eDao.getAllEditore()) {
			System.out.println("Nome: " + e.getNome() + " codice: " + e.getCodiceEditore());
		}
		
	}

}
