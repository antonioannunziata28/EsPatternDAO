package it.betacom.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import it.betacom.dao.EditoreDao;
import it.betacom.dbhandler.DbHandler;
import it.betacom.model.Editore;

public class EditoreDaoImpl implements EditoreDao {
	
	private List<Editore> listaEditori;
	
	public EditoreDaoImpl() {
		
	}

	@Override
	public List<Editore> getAllEditore() {
		List<Editore> listaEditori = new ArrayList<>();
		
		Connection connection = DbHandler.getConnection();
		try {
			Statement stm = connection.createStatement();
			ResultSet rs = stm.executeQuery("SELECT * FROM editore");
			
			while(rs.next()) {
				String nome = rs.getString("nome");
				int idEditore = rs.getInt("idEditore");
				listaEditori.add(new Editore(nome, idEditore));
			}
		} catch (SQLException e) {
			System.out.println("Errore nello stabilire la connessione " + e);
		}
		
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
