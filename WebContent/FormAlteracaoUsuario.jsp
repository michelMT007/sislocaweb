<%@page import="br.com.tds.bd.Usuario"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Alteração de Usuário</title>
</head>
<body>

<%@ include file="cabecalho.jsp" %>

<h2>Alterar Usuário</h2>

<form method = "post" action="/LojaVirtual/auterarusuario">
	<table>
	<% if (request.getAttribute("msg") != null){ %>
	<tr>
			<td colspan="2">
			<font color="red"> <%=request.getAttribute("msg") %></font>
			</td>
	</tr>
	<%}%>
	<%Usuario usuario = (Usuario) request.getAttribute("usuario"); %>
	
	    <input type="hidden" name="codigo" value = "<%=(usuario != null )? usuario.getNome(): 0  %> "/> 
		
		<tr>
			<td>Nome</td>
			<td><input type="text" name="nome" value = "<%=(usuario != null && usuario.getNome()!= null)? usuario.getNome(): ""  %> "/> </td>
		</tr>
		<tr>
			<td>Login</td>
			<td><input type="text" name="login" value = "<%=(usuario != null && usuario.getLogin() !=null)? usuario.getLogin(): "" %>"/></td>
		</tr>
		<tr>
			<td>Senha</td>
			<td><input type="password" name="senha" /> </td>
		</tr>
		<tr>
			<td colspan="2" ><input type="submit" name="Confirmar" VALUE="Cadastrar"/> </td>
		</tr>
		
	</table>
</form>
<hr><br>
<a href="/LojaVirtual/index.jsp"> Retornar ao inicio</a>
</body>
</html>