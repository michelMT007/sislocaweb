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

import br.com.tds.bd.Usuario;
import br.com.tds.bd.UsuarioDAO;

/**
 * Servlet implementation class auterarusuario
 */
@WebServlet("/auterarusuario")
public class auterarusuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String codigo;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public auterarusuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if(request.getParameter("Confirmar")!=null){		
			alterar(request, response);
		}else{
			solicitarAlterar(request, response);
		}	
	}

	private void alterar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		codigo = request.getParameter("codigo");
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
			request.setAttribute("msg", "Usu�rio Alterado com Sucesso.");
			RequestDispatcher rd = request.getRequestDispatcher("/sucesso.jsp");
			rd.forward(request, response);
			return;
		}catch (valida�aoException e1) {
				// TODO Auto-generated catch block
				request.setAttribute("usuario",u);
				request.setAttribute("msg", e1.getMessage());
				RequestDispatcher rd = request.getRequestDispatcher("/FormAlteracaoUsuario.jsp");
				rd.forward(request, response);
				return;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			request.setAttribute("msg", "Erro ao alterar usu�rio. ");
			RequestDispatcher rd = request.getRequestDispatcher("/erro.jsp");
			rd.forward(request, response);
			return;
			//// " tela de erro
		}
		
		
	}

	private void solicitarAlterar(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		String codigoStr = request.getParameter("codigo");
		UsuarioDAO dao = new UsuarioDAO();
		try {
			Usuario usuario = dao.ConsultaPorCodigo(Integer.parseInt(codigoStr));
			request.setAttribute("usuario", usuario);
			RequestDispatcher rd = request.getRequestDispatcher("/FormAlteracaoUsuario.jsp");
			rd.forward(request, response);
			return;
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			e.printStackTrace();
			request.setAttribute("msg", "Erro: C�digo inv�lido. ");
			RequestDispatcher rd = request.getRequestDispatcher("/erro.jsp");
			rd.forward(request, response);
			return;
		} catch (SQLException e) {
			e.printStackTrace();
			e.printStackTrace();
			request.setAttribute("msg", "Erro ao consultat usu�rio. ");
			RequestDispatcher rd = request.getRequestDispatcher("/erro.jsp");
			rd.forward(request, response);
			return;
		}	
	}
}
