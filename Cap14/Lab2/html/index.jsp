<%@ page pageEncoding="UTF-8" %>
<html>
<jsp:useBean id="contador" class="exemplo.Contador" scope="session"/>
<body>
<!-- altere aqui para saber qual servidor forneceu a página -->
<h1>Servidor Tomcat 1 (no1)</h1>
<h1>Página visitada <%= contador.getProximoValor() %> vezes.</h1>
<h1>Sessão: <%= request.getSession().getId() %></h1>
</body>
<%
    request.getSession().setAttribute("contador", contador);
%>
</html>
