package br.com.tds;

import java.sql.SQLException;

import br.com.tds.bd.Usuario;
import br.com.tds.bd.UsuarioDAO;

public class UsuarioNegocio {

	public static void validarIncluirUsuario(Usuario u) throws validaçaoException{
		
		boolean erro = false;
		StringBuffer sb = new StringBuffer();
		
		if(u.getNome()==null || u.getNome().trim().isEmpty()){
			sb.append(" - Nome deve ser informado.<br>");
			erro = true;
		}
		if(u.getLogin()==null || u.getLogin().trim().isEmpty()){
			sb.append(" - Login deve ser informado.<br>");
			erro = true;
		}
		if(u.getSenha()==null || u.getSenha().trim().isEmpty()){
			sb.append(" - Senha deve ser informada.<br>");
			erro = true;
		}
		
		if(erro){
			throw new validaçaoException(sb.toString());
		}
		
	}
	
	public static void incluir(Usuario u) throws validaçaoException, SQLException{
		UsuarioDAO dao = new UsuarioDAO();
		UsuarioNegocio.validarIncluirUsuario(u);
		dao.inserir(u);
	}
	
	public static void alterar(Usuario u) throws validaçaoException, SQLException{
		UsuarioDAO dao = new UsuarioDAO();
		UsuarioNegocio.validarIncluirUsuario(u);
		dao.inserir(u);
	}
	public static void validarAlterarUsuario(Usuario u) throws validaçaoException{
		if(u.getCodigo()==0){
			throw new validaçaoException("Código nao informado");
	    }
		validarIncluirUsuario(u);
	}
	
}
