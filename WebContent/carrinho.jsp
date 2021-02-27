<%@page import="java.text.NumberFormat"%>
<%@page import="br.com.tds.bd.Produto"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Carrinho de Compras</title>
</head>
<body>
   <%@ include file="cabecalho.jsp" %>
	<h2> Carrinho de Compras</h2>
	<BR>
	    <%
	    Map<Produto,Integer> map = (Map<Produto,Integer>) request.getAttribute("carinhoCampras");
	    
	    
	    %>
	    
	
	    <table BGCOLOR="#FF8000" width ="100%" padding="1" spacing="1" border="0">
		    <tr BGCOLOR="#804000" >  
		        <TH width="10%" align="center"><FONT COLOR="WHITE" SIZE="2" FACE="ARIAL">   Código </FONT>   </TH>
			    <TH width="30%" align="center"><FONT COLOR="WHITE" SIZE="2" FACE="ARIAL">  Nome    </FONT>   </TH>
		        <TH width="10%" align="center"><FONT COLOR="WHITE" SIZE="2" FACE="ARIAL">  Quantidade </FONT> </TH>
		        <TH width="15%" align="center"><FONT COLOR="WHITE" SIZE="2" FACE="ARIAL">  preço Unit. </FONT>   </TH>
		        <TH width="15%" align="center"><FONT COLOR="WHITE" SIZE="2" FACE="ARIAL">  preço Total </FONT>   </TH>
		        <TH width="20%" align="center"> &nbsp;    </TH>
		        
		    </tr>
		    <% if(map == null || map.isEmpty()){ %>
		    <tr>
			    <td colspan="6" align="center"> Não há produtos adicionados" </td>
		    </tr>
		    <% } else{
		          for(Produto produto : map.keySet()){
		             int qtda = map.get(produto);
		          %>
		    <tr>
		     
		         <td width="5%" align="center"> <%=produto.getCodigo() %> </td>
			    <td width="10%" align="left">   <%=produto.getNome() %> </td>
		        <td width="30%" align="left">   <%=qtda%> </td>
		        <td width="10%" align="right">  <%=NumberFormat.getCurrencyInstance().format(produto.getPreco()) %> </td>
		        <td width="20%" align="right">  <%=NumberFormat.getCurrencyInstance().format(produto.getPreco()*qtda) %> </td>
		        
			    
		        <td width="20%" align="center" > 
		          
			      <a href="/LojaVirtual/CarinhoCompras?codigo=<%=produto.getCodigo() %>">remover</a>
			      
		          
			      </td>
			    
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