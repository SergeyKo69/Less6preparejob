<%--
  Created by IntelliJ IDEA.
  User: koguts
  Date: 2019-04-04
  Time: 18:41
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login page</title>
</head>
<body>
    <h2>Login</h2>
    <p style="color: red;">${errorString}</p>
    <form action="login" method="post">
        <table width="50%">
            <tr>
                <td>Login:</td>
                <td><input type="text" name="login"/></td>
            </tr>
            <tr>
                <td>Password:</td>
                <td><input type="password" name="password"/></td>
            </tr>
            <tr>
                <td><input type="submit" value="Sigh in"/></td>
            </tr>
        </table>
    </form>
</body>
</html>
