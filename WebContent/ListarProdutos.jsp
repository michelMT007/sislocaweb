<%@page import="java.text.NumberFormat"%>
<%@page import="java.util.List"%>
<%@page import="br.com.tds.bd.Produto"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista de Produtos</title>
</head>
<body>
    <%@ include file="cabecalho.jsp" %>
	<h2> LISTA DE PRODUTOS</h2>
	<BR>
	    <%
	    List<Produto> lista = (List<Produto>) request.getAttribute("listaprodutos");
	    
	    
	    %>
	    
	
	    <table BGCOLOR="#FF8000" width ="100%" padding="1" spacing="1" border="0">
		    <tr BGCOLOR="#804000" >  
		        <TH width="5%" align="center"><FONT COLOR="WHITE" SIZE="2" FACE="ARIAL">  Código </FONT>   </TH>
			    <TH width="15%" align="center"><FONT COLOR="WHITE" SIZE="2" FACE="ARIAL"> Nome    </FONT>   </TH>
		        <TH width="30%" align="center"><FONT COLOR="WHITE" SIZE="2" FACE="ARIAL"> Descrição </FONT> </TH>
		        <TH width="10%" align="center"><FONT COLOR="WHITE" SIZE="2" FACE="ARIAL">  preço  </FONT>   </TH>
		        <TH width="20%" align="center"><FONT COLOR="WHITE" SIZE="2" FACE="ARIAL"> Categoria </FONT> </TH>
		        <TH width="15%" align="center"> &nbsp;    </TH>
		        
		    </tr>
		    <% if(lista == null || lista.isEmpty()){ %>
		    <tr>
			    <td colspan="4" align="center"> Não há produtos cadastrados" </td>
		    </tr>
		    <% } else{
		          for(Produto produto : lista){%>
		    <tr>
		     <FONT COLOR=BLUE FACE="Geneva, Arial" SIZE=6>
		         <td width="5%" align="center"> <%=produto.getCodigo() %> </td>
			    <td width="10%" align="left"> <%=produto.getNome() %> </td>
		        <td width="30%" align="left"> <%=produto.getDescricao() %> </td>
		        <td width="10%" align="right"> <%=NumberFormat.getCurrencyInstance().format(produto.getPreco()) %> </td>
		        <td width="20%" align="right"> <%=produto.getCategoria() %> </td>
		        
			    
		        <td width="20%" align="center" > 
		          <a>Detalhe</a>
			      <a href="/LojaVirtual/auterarusuario?codigo=<%=produto.getCodigo() %>">Alterar</a>
			      <a href="/LojaVirtual/CarinhoCompras?codigo=<%=produto.getCodigo() %>">Comprar</a>
		          
			      </td>
			   </font>    
		    <tr>
		     <% 
		            }
		          }
		     %>
		      
	   </table>
	   <BR>
	   <BR>
	<a href="/LojaVirtual/index.jsp"> Retornar ao inicio</a>
	<BR>		
	<%@ include file="rodape.jsp" %>
</body>
</html>