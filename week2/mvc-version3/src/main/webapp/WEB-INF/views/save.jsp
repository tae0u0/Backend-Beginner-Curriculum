<%@ page import="com.gdgoc.web.domain.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  User user = (User) request.getAttribute("user");
%>
<html>
  <head>
    <meta charset="UTF-8">
  </head>
  <body>
    성공
    <ul>
      <li>id=<%=user.getId()%></li>
      <li>name=<%=user.getName()%></li>
    </ul>
  </body>
</html>
