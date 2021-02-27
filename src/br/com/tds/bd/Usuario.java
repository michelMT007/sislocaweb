package br.com.tds.bd;


import java.util.Date;

public class Usuario implements Comparable<Usuario>{
	private int codigo;
	private String nome;
	private String email;
	private String login;
	private String senha;
	private Date dataCatastro;
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codigo;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (codigo != other.codigo)
			return false;
		return true;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public Date getDataCatastro() {
		return dataCatastro;
	}
	public void setDataCatastro(Date dataCatastro) {
		this.dataCatastro = dataCatastro;
	}
	public Usuario(int codigo, String nome, String email, String login,
			Date dataCatastro) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.email = email;
		this.login = login;
		this.dataCatastro = dataCatastro;
	}
	public Usuario() {
		super();
	}
	@Override
	public int compareTo(Usuario obj) {
		// TODO Auto-generated method stub
		return new Integer(this.codigo).compareTo(obj.codigo);
	}
	

}
