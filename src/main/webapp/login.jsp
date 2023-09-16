<%--
  Created by IntelliJ IDEA.
  User: thefi
  Date: 9/12/2023
  Time: 1:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h3>LOGIN</h3>
    <form action="ControlServlet?action=login" method="post">
        <label>Your ID:</label>
        <input name="id">
        <br>
        <label>Password:</label>
        <input type="password" name="pwd">
        <br>

        <button type="submit">Login</button>
    </form>
</body>
</html>
