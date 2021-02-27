<%@page import="java.util.List"%>
<%@page import="br.com.tds.bd.Usuario"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
    <%@ include file="cabecalho.jsp" %>
	<h2> LISTA DE USUÁRIOS</h2>
	<BR>
	    <%
	    List<Usuario> lista = (List<Usuario>) request.getAttribute("listauauario");
	    
	    
	    %>
	    <table width ="100%" padding="1" spacing="1" border="0">
		    <tr bgcolor="#CCCCCC">
			    
			    <td width="10%" align="center"> Código </td>
			    <td width="40%" align="center"> Nome </td>
		        <td width="30%" align="center"> Login </td>
		        <td width="20%" align="center"> &nbsp; </td>
		    </tr>
		    <% if(lista == null || lista.isEmpty()){ %>
		    <tr>
			    <td colspan="4" align="center"> Não há usuários cadastrados" </td>
		    </tr>
		    <% } else{
		          for(Usuario usuario : lista){%>
		    <tr>
			    <td width="10%" align="center"> <%=usuario.getCodigo() %> </td>  
			    <td width="40%" align="left"> <%=usuario.getNome() %> </td>
		        <td width="30%" align="left"> <%=usuario.getLogin() %> </td>
		        <td width="20%" align="center" > 
		          <a>Detalhe</a>
			      <a href="/LojaVirtual/auterarusuario?codigo=<%=usuario.getCodigo() %>">Alterar</a>
			      <a>Excluir</a>
			      </td>
		       
		    <tr>
		     <% 
		            }
		          }
		     %>
		      
	    </table>
	    
	    
	   
	<a href="/LojaVirtual/index.jsp"> Retornar ao inicio</a>
	<BR>		
	<%@ include file="rodape.jsp" %>
</body>
</html>