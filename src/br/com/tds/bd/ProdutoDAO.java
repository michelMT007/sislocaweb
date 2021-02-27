package br.com.tds.bd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Map;
import java.util.List;

import br.com.tds.FabricaConection;

public class ProdutoDAO {
	
	public void inserir( Produto produto )throws SQLException {
		//Connection
		Connection conn = null;
		PreparedStatement ps = null;		
		conn = FabricaConection.getConection();
		try{
			// SQL
			String sql = "INSERT INTO PRODUTO (NOME, DESCRICAO, PRECO , IMAGEM , CATEGORIA) " +
					"  VALUES (? , ? , ? , ? ,? ) ";
			//PreparedStatement
			ps = conn.prepareStatement( sql );
			// Setar Parametros
			ps.setString( 1 ,  produto.getNome() );
			ps.setString(2, produto.getDescricao());
			ps.setDouble( 3 , produto.getPreco());
			ps.setString( 4 ,  produto.getImagem() );
			ps.setString( 5 ,  produto.getCategoria().toString() );
			// executa operação
			int ret = ps.executeUpdate();
			if(ret != 1){
				throw new SQLException("Erro ao inserir registro.");
			}	
			conn.commit();
		}
		catch(SQLException e)
		{
			conn.rollback();
			throw e;
		}
		finally{
			if(conn != null){
				try {
					conn.close();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
	
	
	public void alterar(Produto produto) throws SQLException{
		// Connection
		Connection conn = null;
		PreparedStatement ps = null;		
		conn = FabricaConection.getConection();
		try{
			
			String sql = "UPDATE PRODUTO SET NOME=? , DESCRICAO=? , PRECO = ?, IMAGEM=? , CATEGORIA = ? WHERE CODIGO = ?";
			ps = conn.prepareStatement( sql );
			// Setar Parametros
			ps.setString( 1 ,  produto.getNome() );
			ps.setString(2, produto.getDescricao());
			ps.setDouble( 3 , produto.getPreco());
			ps.setString( 4 ,  produto.getImagem() );
			ps.setString( 5 ,  produto.getCategoria().toString() );
			ps.setInt( 6 , produto.getCodigo());
			
			int ret = ps.executeUpdate();
			if(ret != 1){
				throw new SQLException("Erro ao alterar registro.");
			}
			conn.commit();
		}
		catch(SQLException e)
		{
			conn.rollback();
			throw e;
		}
		finally{
			if(conn != null){
				try {
					conn.close();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
	
	public void excluir(Produto produto) throws SQLException{
		
		String sql = "DELETE FROM PRODUTO WHERE CODIGO = ?;"; 
		
	}
	
	
	public List<Produto> listarTodos() throws SQLException{
		// Connection
		List<Produto> lista = new ArrayList<Produto>();
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		conn = FabricaConection.getConection();
		try{
			
			String sql = "SELECT * FROM PRODUTO";
			ps = conn.prepareStatement( sql );
			//setar parametros
			
			//executa a consulta
			rs = ps.executeQuery();
			//popular lista
			while(rs.next()){
				int cod = rs.getInt("codigo");
				String nome = rs.getString("nome");
				String descricao = rs.getString("descricao");
				String imagem = rs.getString("imagem");
				String categoria = rs.getString("categoria");
				
				double preco = rs.getDouble("preco");
				Produto produto = new Produto();
				produto.setCodigo(cod);
				produto.setNome(nome);
				produto.setDescricao(descricao);
				produto.setImagem(imagem);
				produto.setPreco(preco);
				produto.setCategoria( Categoria.valueOf(rs.getString("categoria")));
				
				lista.add(produto);						
			}
			
		}
		finally{
			if(conn != null){
				try {
					conn.close();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return lista;
	}
	
	
	public Produto consultaPorCodigo(int codigo) throws SQLException{
		Produto produto = null;
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		conn = FabricaConection.getConection();
		try{
			
			String sql = "SELECT * FROM PRODUTO WHERE CODIGO=?";
			ps = conn.prepareStatement( sql );
			//setar parametros
			ps.setInt( 1 ,  codigo );
			
			rs = ps.executeQuery();
			//popular lista
			if(rs.next()){
				int cod = rs.getInt("codigo");
				String nome = rs.getString("nome");
				String descricao = rs.getString("descricao");
				String imagem = rs.getString("imagem");
				String categoria = rs.getString("categoria");
				
				double preco = rs.getDouble("preco");
				produto = new Produto();
				produto.setCodigo(cod);
				produto.setNome(nome);
				produto.setDescricao(descricao);
				produto.setImagem(imagem);
				produto.setPreco(preco);
				produto.setCategoria( Categoria.valueOf(rs.getString("categoria")));			}			
		}
		finally{
			if(conn != null){
				try {
					conn.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return produto;
	}
}
