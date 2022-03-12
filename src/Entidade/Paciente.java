 
package Entidade;

import java.util.Date;

public class Paciente {
	
	private Long idPaciente;
	private String nomePaciente;
	private String sexoPaciente;
	private String rgPaciente;
	private String cpfPaciente;
	private Date dataNascPaciente;
	private String enderecoPaciente;
	private String telefonePaciente;

	public Long getId() {
		return idPaciente;
	}
	public void setId(Long id) {
		this.idPaciente = id;
	}
	public String getNome() {
		return nomePaciente;
	}
	public void setNome(String nome) {
		this.nomePaciente = nome;
	}
	public String getRg() {
		return rgPaciente;
	}
	public void setRg(String rg) {
		this.rgPaciente = rg;
	}
	public String getCpf() {
		return cpfPaciente;
	}
	public void setCpf(String cpf) {
		this.cpfPaciente = cpf;
	}
	public Date getDataNasc() {
		return dataNascPaciente;
	}
	public void setDataNasc(Date dataNasc) {
		this.dataNascPaciente = dataNasc;
	}
	
	public String getEndereco() {
		return enderecoPaciente;
	}
	public void setEndereco(String endereco) {
		this.enderecoPaciente = endereco;
	}
	public String getTelefone() {
		return telefonePaciente;
	}
	public void setTelefone(String telefone) {
		this.telefonePaciente = telefone;
	}
	public String getSexo() {
		return sexoPaciente;
	}
	public void setSexo(String sexo) {
		this.sexoPaciente = sexo;
	}


}
