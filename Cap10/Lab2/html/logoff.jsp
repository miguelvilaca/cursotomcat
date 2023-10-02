<%
    request.getSession().invalidate();
%>
<html>
<body>
<h1>Demo de Segurança J2EE (BD)<hr></h1>
<p>
Sessão encerrada.
<p>
<a href="<%= request.getContextPath() %>">Voltar...</a>
</body>
</html>
