package br.com.tds.bd;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.tds.FabricaConection;

public class UsuarioDAO {
	
	public void inserir(Usuario usuario) throws SQLException{
			//abrindo conexao com o banco
			Connection conn = null;
			PreparedStatement ps = null;
			conn = FabricaConection.getConection();
			
			try {
				// SQL
				String sql = "insert into usuario ( nome , login, senha , datacadastro)" + 
						"values (?, ? , ? , ? )";
				
				//PreparedStatement
				ps = conn.prepareStatement(sql);
				
				//Setar Parâmetros
				ps.setString(1, usuario.getNome());
				ps.setString(2, usuario.getLogin());
				ps.setString(3, usuario.getSenha());
				ps.setTimestamp(4, new java.sql.Timestamp(usuario.getDataCatastro().getTime()));
				
				int ret = ps.executeUpdate();
				conn.commit();
				if(ret != 1){
					conn.rollback();
					throw new SQLException("Erro ao inserir registro");
					
				}
			} catch (SQLException e) {
				//desfaz o que foi feito até gerar o erro
				
				e.printStackTrace();
				throw e;
			}
			//independente do que aconteça será executado o bloco abaixo para finalizar as conexões
			finally {
				if(ps != null){
					ps.close();
				}
				if(conn != null){
					conn.close();
				}
			}
			
					
				
	}
	
	
	public void alterar(Usuario usuario) throws SQLException{
		
		
		
		//abrindo conexao com o banco
		Connection conn = null;
		PreparedStatement ps = null;
		conn = FabricaConection.getConection();
		
		try {
			// SQL
			String sql = "UPDATE usuario SET nome=?, login=?, senha=? WHERE codigo = ?";
			
			//PreparedStatement
			ps = conn.prepareStatement(sql);
			
			//Setar Parâmetros
			ps.setString(1, usuario.getNome());
			ps.setString(2, usuario.getLogin());
			ps.setString(3, usuario.getSenha());
			ps.setInt(4, usuario.getCodigo());
			//ps.setTimestamp(4, new java.sql.Timestamp(usuario.getDataCatastro().getTime()));
			
			int ret = ps.executeUpdate();
			conn.commit();
			
			if(ret != 1){
				conn.rollback();
				throw new SQLException("Erro ao alterar registro");
				
			}
		} catch (SQLException e) {
			//desfaz o que foi feito até gerar o erro
			conn.rollback();
			e.printStackTrace();
			throw e;
		}
		//independente do que aconteça será executado o bloco abaixo para finalizar as conexões
		finally {
			if(ps != null){
				ps.close();
			}
			if(conn != null){
				conn.close();
			}
		}
	}

	public void excluir(Usuario usuario) throws SQLException{
		
		String sql =  "DELETE FROM USUARIO WHERE CODIGO = ?";
		
		
	}
	
	public  List<Usuario> listarTodos()throws SQLException{
		
		//abrindo conexao com o banco
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		conn = FabricaConection.getConection();
		
		ArrayList<Usuario> lista = new ArrayList<Usuario>();
		try {
			// SQL
			String sql = "SELECT * from usuario";
			
			//PreparedStatement
			ps = conn.prepareStatement(sql);
						
			rs = ps.executeQuery();
			while(rs.next()){
				int cod = rs.getInt("codigo");
				String nome = rs.getString("nome");
				String login = rs.getString("login");
				String senha = rs.getString("senha");
				Date dataCadastro = rs.getTimestamp("datacadastro");
								
				Usuario u = new Usuario(cod,nome,login,senha,dataCadastro);
				lista.add(u);
			}
		} catch (SQLException e) {
			//desfaz o que foi feito até gerar o erro
			
			e.printStackTrace();
			throw e;
		}
		//independente do que aconteça será executado o bloco abaixo para finalizar as conexões
		finally {
			if(ps != null){
				ps.close();
			}
			if(conn != null){
				conn.close();
			}
		}
	
	return lista;
	}

	public  Usuario ConsultaPorCodigo(int codigo) throws SQLException{
		
		//abrindo conexao com o banco
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Usuario u = null;
		conn = FabricaConection.getConection();
		
		ArrayList<Usuario> lista = new ArrayList<Usuario>();
		try {
			// SQL
			String sql = "SELECT * from usuario WHERE codigo=?";
			
			//PreparedStatement
			ps = conn.prepareStatement(sql);
			
			//Setar Parâmetros
			ps.setInt(1, codigo);
						
			rs = ps.executeQuery();
			if(rs.next()){
				int cod = rs.getInt("codigo");
				String nome = rs.getString("nome");
				String login = rs.getString("login");
				String senha = rs.getString("senha");
				Date dataCadastro = rs.getTimestamp("datacadastro");
								
				u = new Usuario(cod,nome,login,senha,dataCadastro);
				
			}
		} catch (SQLException e) {
			//desfaz o que foi feito até gerar o erro
			
			e.printStackTrace();
			throw e;
		}
		//independente do que aconteça será executado o bloco abaixo para finalizar as conexões
		finally {
			if(ps != null){
				ps.close();
			}
			if(conn != null){
				conn.close();
			}
		}
		return u;
	 }
}
