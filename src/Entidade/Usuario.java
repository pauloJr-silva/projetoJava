package Entidade;

public class Usuario {
	
	private String idUsuario;
	private String nomeUsuario = "admin";
	private long senha = 123;
	
	
	public String getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getNomeUsuario() {
		return nomeUsuario;
	}
	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}
	public long getSenha() {
		return senha;
	}
	public void setSenha(long senha) {
		this.senha = senha;
	}
	
	

}
