package br.com.tds;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import javax.swing.JOptionPane;

import br.com.tds.bd.Usuario;
//import br.com.tds.bd.UsuarioDAO;

/**
 * Servlet implementation class cadastrarusuario
 */
@WebServlet("/cadastrarusuario")
public class cadastrarusuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public cadastrarusuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String nome = request.getParameter("nome");
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		
		Usuario u = new Usuario();
		
		u.setNome(nome);
		u.setLogin(login);
		u.setSenha(senha);
		u.setDataCatastro(new Date());
		try {
			UsuarioNegocio.incluir(u);
			// "Sucesso"
			request.setAttribute("msg", "Usuário Cadastrado com Sucesso.");
			RequestDispatcher rd = request.getRequestDispatcher("/sucesso.jsp");
			rd.forward(request, response);
			return;
		}catch (validaçaoException e1) {
				// TODO Auto-generated catch block
				request.setAttribute("usuario",u);
				request.setAttribute("msg", e1.getMessage());
				RequestDispatcher rd = request.getRequestDispatcher("/FormCadastroUsuario.jsp");
				rd.forward(request, response);
				return;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			request.setAttribute("msg", "Erro ao cadastrar usuário. ");
			RequestDispatcher rd = request.getRequestDispatcher("/erro.jsp");
			rd.forward(request, response);
			return;
			//// " tela de erro
		}	
	}
}
