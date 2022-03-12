package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import Entidade.Doutor;

public class DoutorDAOImpl implements DoutorDAO {

	private static final String URL ="";
	private static final String USER ="";
	private static final String PASS = "";
	
	private Connection con;
	
	public DoutorDAOImpl() {
		
		try {
			con = DriverManager.getConnection(URL,USER,PASS);
			System.out.println("Conectado com sucesso");
		} catch (SQLException e) {
			System.out.println("Falha na conexão");
			e.printStackTrace();
		}
		
	}
	
	
	@Override
	public void adicionarDoutor(Doutor d) {
		
		
	}

	@Override
	public Doutor pesquisarDoutorPorNome(String nome) {
		// TODO Auto-generated method stub
		return null;
	}

}
