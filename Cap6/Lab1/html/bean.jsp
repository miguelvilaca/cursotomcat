<%@ page pageEncoding="UTF-8" %>
<html>
<jsp:useBean id="hoje" class="exemplo.HojeBean" />
<body>
<h1>JSP 1.2 / JavaBean</h1>
<%-- uma forma de obter valores do JavaBean --%>
<h1>Hoje é dia <jsp:getProperty name="hoje" property="diaMesAno" /></h1>
<%-- outra forma de obter valores do JavaBean --%>
<h1>Hoje é dia <%= hoje.getDiaMesAno() %></h1>
</body>
</html>
