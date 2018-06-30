package hello;

import java.time.LocalDate;

public class Usuario {
	
	private String nomeusuario;
	private String login;
	private String senha;
	private int matricula;
	private String cargo;
	private LocalDate datacadastro;
	
	public Usuario(String nomeusuario, String login, String senha, int matricula, String cargo, LocalDate datacadastro){
		this.nomeusuario = nomeusuario;
		this.login = login;
		this.senha = senha;
		this.matricula = matricula;
		this.cargo = cargo;
		this.datacadastro = datacadastro;
	}

	public String getNomeusuario() {
		return nomeusuario;
	}

	public void setNomeusuario(String nomeusuario) {
		this.nomeusuario = nomeusuario;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public int getMatricula() {
		return matricula;
	}

	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public LocalDate getDatacadastro() {
		return datacadastro;
	}

	public void setDatacadastro(LocalDate datacadastro) {
		this.datacadastro = datacadastro;
	}

}

