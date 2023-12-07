package it.betacom.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import it.betacom.dao.LibroDao;
import it.betacom.dbhandler.DbHandler;
import it.betacom.model.Editore;
import it.betacom.model.Libro;

public class LibroDaoImpl implements LibroDao {

	private List<Libro> listaLibri;

	public LibroDaoImpl() {

	}

	@Override
	public List<Libro> getAllLibri() {
		List<Libro> listaLibri = new ArrayList<>();

		Connection connection = DbHandler.getConnection();
		EditoreDaoImpl editoreDao = new EditoreDaoImpl();

		try {
			Statement stm = connection.createStatement();
			ResultSet rs = stm.executeQuery("SELECT * FROM libri");
						
			while (rs.next()) {
				int idLibro = rs.getInt("id_libri");
				String nome = rs.getString("nome");
				int numeroPagine = rs.getInt("numero_pagine");
				int dataUscita = rs.getInt("anno");
				int autore = rs.getInt("autori_id");
				int genere = rs.getInt("idGenere");
				int idEditore = rs.getInt("idEditore");
				
				Editore editore = editoreDao.readEditoreById(idEditore);
				
				listaLibri.add(new Libro(idLibro, nome, numeroPagine, dataUscita, autore, genere, editore));
				
			}
		} catch (SQLException e) {
			System.out.println("Errore nello stabilire la connessione " + e);
		}

		return listaLibri;
	}

	@Override
	public void createLibro(Libro libro) {
		
		try (Connection connection = DbHandler.getConnection();
				PreparedStatement pStm = connection.prepareStatement("INSERT INTO libri (id_libri, nome, numero_pagine, anno, autori_id, idGenere, idEditore) VALUES (?, ?, ?, ?, ?, ?, ?)")){
				
				pStm.setInt(1, libro.getIdLibro());
				pStm.setString(2, libro.getTitolo());
				pStm.setInt(3, libro.getNumeroPagine());
				pStm.setInt(4, libro.getDataUscita());
				pStm.setInt(5, libro.getAutore());
				pStm.setInt(6, libro.getGenere());
				pStm.setInt(7, libro.getEditore().getCodiceEditore());
				pStm.executeUpdate();
				
				System.out.println("Libro inserito correttamente");
			}catch (SQLException e) {
				System.out.println("Errore inserimento editore" + e);
			}

	}

	@Override
	public Libro readLibroById(int idLibro) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateLibro(Libro libro) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteLibro(Libro libro) {
		// TODO Auto-generated method stub

	}

}
