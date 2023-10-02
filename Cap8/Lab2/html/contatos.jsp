<%@ page pageEncoding="UTF-8" %>
<%@ page import="java.util.*" %>
<html>
<body>
<h1>Contatos</h1>
<table bgcolor="#f0f0e0" border="1" cellpadding="2">
<tr><th>Nome</th><th>E-mail</th></tr>
<%
    List<String[]> contatos = (List<String[]>)request.getAttribute("contatos");
    for(String[] umContato : contatos) {
%>
    <tr><td>
<%
        out.print(umContato[0]);
%>
    </td><td>
<%
        out.print(umContato[1]);
%>
    </td></tr>
<%
    }
%>
</table>
</body>
</html>
