package it.betacom.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
		
		//Con questa sitassi la connessione verrà chiusa automaticamente grazie al try-whith-resource
		
		try (Connection connection = DbHandler.getConnection();
			PreparedStatement pStm = connection.prepareStatement("INSERT INTO editore (nome, idEditore) VALUES (?, ?)")){
			
			pStm.setString(1, editore.getNome());
			pStm.setInt(2, editore.getCodiceEditore());
			pStm.executeUpdate();
			
			System.out.println("Editore inserito correttamente - Nome: " + editore.getNome() + " id: " + editore.getCodiceEditore());
		}catch (SQLException e) {
			System.out.println("Errore inserimento editore" + e);
		}
	}

	@Override
	public Editore readEditoreById(int idEditore) {
		
		try(Connection connection = DbHandler.getConnection();
			PreparedStatement pStm = connection.prepareStatement("SELECT * FROM editore WHERE idEditore = ?")){
			
			pStm.setInt(1, idEditore);
			ResultSet rs = pStm.executeQuery();
			if(rs.next()) {
				String nome = rs.getString("nome");
				int codiceEditore = rs.getInt("idEditore");
				return new Editore(nome, codiceEditore);
			} else {
				System.out.println("Corrispondenza editore non trovata");
				return null;
			}
			
			} catch (SQLException e) {
				System.out.println("Lettura editore non andata a buon fine " + e);
				return null;
			}
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
