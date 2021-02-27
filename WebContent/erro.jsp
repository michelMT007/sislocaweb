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
			

 
 
<BR/>
<BR/>
<font color="red">


<font color="blue"> 
<% 
String mensagem = (String) request.getAttribute("msg");
if(mensagem == null){
	mensagem = "Ocorreu um erro na Operação.";
}
%>
<%=mensagem%>
</font>


</font>
<BR/>
<a href="/LojaVirtual/index.jsp"> Retornar ao inicio</a>
<%@ include file="rodape.jsp" %>
  

</body>
</html>