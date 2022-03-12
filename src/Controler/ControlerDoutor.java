package Controler;

import DAO.DoutorDAO;
import DAO.DoutorDAOImpl;
import Entidade.Doutor;

public class ControlerDoutor {
	
	private DoutorDAO doutorDAO = new DoutorDAOImpl();
	
	public void adicionarDoutor(Doutor d) {
			doutorDAO.adicionarDoutor(d);	
		
	}
	
	public Doutor pesquisarDoutorNome(String nome) {		
		
		return null;
	}
	
			
	
}
