<%@ page isErrorPage="true" %>
<html>
<body>
<h1>Erro de Segurança J2EE<hr></h1>
<p>
Você não tem acesso à página solicitada.
<p>
<a href="<%= request.getContextPath()%>/index.jsp ">Voltar...</a>
</body>
</html>
