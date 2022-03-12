package DAO;

import Entidade.Doutor;

public interface DoutorDAO {
	
	void adicionarDoutor(Doutor d);
	Doutor pesquisarDoutorPorNome(String nome);

}
