<%@ page pageEncoding="UTF-8" %>
<%@ page import="java.util.*" %>
<%@ page import="java.text.*" %>
<html>
<%
    DateFormat df = DateFormat.getDateInstance();
    String hoje = df.format(new Date());
%>
<body>
<h1>Página JSP</h1>
<h1>Hoje é dia <%= hoje %></h1>
</body>
</html>
