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
		
		Connection connection = null;
		
		try {	
			connection = DbHandler.getConnection();
		    PreparedStatement pStm = connection.prepareStatement("SELECT * FROM editore WHERE idEditore = ?");

		        pStm.setInt(1, idEditore);
		        ResultSet rs = pStm.executeQuery();
		        if (rs.next()) {
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
		    } finally {
		    	DbHandler.closeConnection(connection);
		        }
	}

	@Override
	public void updateEditore(Editore editore) {
		
		Connection connection = null;
		
		try {
			connection = DbHandler.getConnection();
			PreparedStatement pStm = connection.prepareStatement("UPDATE editore SET nome = ? WHERE idEditore = ?");
			
			pStm.setString(1, editore.getNome());
			pStm.setInt(2, editore.getCodiceEditore());
			
			int rowsUpdated = pStm.executeUpdate();
			if(rowsUpdated > 0) {
				System.out.println("Editore aggiornato correttamente");
			} else {
				System.out.println("Non è stato possibile aggiornare l'editore");
			}
		} catch (SQLException e1) {
			System.out.println("Impossibile aggiornare l'editore: " + e1);
		} finally {
			DbHandler.closeConnection(connection);
		}
		
	}

	@Override
	public void deleteEditore(Editore editore) {
		
		Connection connection = null;
		
		try {
			connection = DbHandler.getConnection();
			PreparedStatement pStm = connection.prepareStatement("DELETE FROM editore WHERE idEditore = ?");
			pStm.setInt(1, editore.getCodiceEditore());
			
			int rowsDeleted = pStm.executeUpdate();
			
			if(rowsDeleted > 0) {
				System.out.println("Editore eliminato correttamente");
			} else {
				System.out.println("Impossibile eliminare l'editore specificato");
			}
			
		} catch (SQLException e) {
			System.out.println("Errore eliminazione editore: "+ e);
		} finally {
			DbHandler.closeConnection(connection);
		}
	}

}
