package Controler;

import java.util.ArrayList;
import java.util.List;

import Entidade.Paciente;

public class ControlerPaciente {

	List <Paciente> listaPaciente = new ArrayList<Paciente>();
	
	
	public void adicionarPaciente(Paciente p) {
		listaPaciente.add(p);
		
	}
	
	public Paciente pesquisarPacienteNome(String nome) {
		for (Paciente p: listaPaciente) {
			if(p.getNome().contains(nome)) {
				return p;
			}
		}
		
		return null;
	}
	
}
