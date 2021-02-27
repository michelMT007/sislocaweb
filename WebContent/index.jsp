<%@page import="br.com.tds.bd.Produto"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Loja Virtual</title>
</head>
<body>
	
	<%@ include file="cabecalho.jsp" %>
	
	<BR/>
	 <a href="<%=request.getContextPath() %>/FormCadastroUsuario.jsp"> Cadastrar Usuários</a>
	 <BR/>
     <a href="<%=request.getContextPath() %>/ListaUsuario"> Listar Usuários</a>
     <BR/>
     <a href="<%=request.getContextPath() %>/ListaProdutos"> Listar Produtos</a>
      <BR/>
     <a href="<%=request.getContextPath() %>/carrinho.jsp"> Carrinho de Compras</a>
     
     <%Map<Produto,Integer> map = (Map<Produto,Integer>)
     request.getSession().getAttribute("carrinhoCampras");%>                  
                     %>
     <%=(map != null)?map.size():0 %> Produtos no Carrinho           
	<BR/>		
	<%@ include file="rodape.jsp" %>

</body>
</html>