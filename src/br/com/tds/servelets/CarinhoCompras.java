package br.com.tds.servelets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Request;

import br.com.tds.bd.Produto;
import br.com.tds.bd.ProdutoDAO;

/**
 * Servlet implementation class CarinhoCompras
 */
@WebServlet("/carrinho")
public class CarinhoCompras extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CarinhoCompras() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("add") != null){
			adicionarProdutoCarrinho(request,response);
			
		}
		else if(request.getParameter("remove") != null){
			removeProdutoCarrinho(request,response);
		}
	    else if(request.getParameter("clear") != null){
		    clearProdutoCarrinho(request,response);
	    }
	}

	private void clearProdutoCarrinho(HttpServletRequest request,HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	private void adicionarProdutoCarrinho(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		int codigo = Integer.parseInt(request.getParameter("codigo"));
		ProdutoDAO dao = new ProdutoDAO();
		
		try {
			Produto prod = dao.consultaPorCodigo(codigo);
			Map<Produto,Integer> map = (Map<Produto,Integer>) request.getAttribute("carinhoCampras");
			if(map == null){
				map = new LinkedHashMap<Produto, Integer>();
			}
			else{
				if(map.containsKey(prod)){
					int qdaAtual = map.get(prod);
					map.put(prod, qdaAtual );
				}
				else{
					map.put(prod, 1 );
				}
			}
			request.getSession().setAttribute("carrinhoCompras", map);
			
			RequestDispatcher rd = request.getRequestDispatcher("/carrinho.jsp");
			rd.forward(request, response);
			return;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			request.setAttribute("msg", "Erro ao adicionar produto. ");
			RequestDispatcher rd = request.getRequestDispatcher("/erro.jsp");
			rd.forward(request, response);
			return;
		}
		
		
		
	}

	private void removeProdutoCarrinho(HttpServletRequest request,HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}
}
