<%@ page import="java.util.List" %>
<%@ page import="com.gdgoc.web.domain.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  List<User> users = (List<User>) request.getAttribute("users");
%>
<html>
  <head>
    <meta charset="UTF-8">
    <title>Title</title>
  </head>
  <body>
    <table>
      <thead>
        <th>id</th>
        <th>name</th>
      </thead>
      <tbody>
        <%
          for (User user : users) {
            out.write(" <tr>");
            out.write(" <td>" + user.getId() + "</td>");
            out.write(" <td>" + user.getName() + "</td>");
            out.write(" </tr>");
          }
        %>
      </tbody>
    </table>
  </body>
</html>