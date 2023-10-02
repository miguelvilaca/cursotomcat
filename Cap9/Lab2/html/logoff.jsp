<%
    request.getSession().invalidate();
%>
<html>
<body>
<h1>Demo de Segurança J2EE (Form)<hr></h1>
<p>
Sessão encerrada.
<p>
<a href="<%= request.getContextPath() %>/index.jsp">Voltar...</a>
</body>
</html>
