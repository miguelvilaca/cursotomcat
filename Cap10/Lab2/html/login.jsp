<html>
<body>
<%
    request.getSession().setAttribute("pagina", request.getRequestURL());
%>
<h1>Demo de Segurança J2EE (BD)<hr></h1>
<p>
Esta página só pode ser acessada por usuários autenticados
<form method="post" action="j_security_check">
<table>
<tr><td>Login:</td>
<td><input size=15 name="j_username">
</tr>
<tr><td>Senha:</td>
<td><input type="password" size=15 name="j_password">
</tr>
<tr><td colpsan="2"><input type="submit" value=" Ok ">
</tr>
</table>
</form>
</body>
</html>
