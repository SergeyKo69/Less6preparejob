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
    <title>Registration page</title>
</head>
<body>
<p style="color: red;">${errorString}</p>
<form action="registration" method="post">
    <table width="50%">
        <tr>
            <td>Username:</td>
            <td><input type="text" name="username"/></td>
        </tr>
        <tr>
            <td>Login:</td>
            <td><input type="text" name="login"/></td>
        </tr>
        <tr>
            <td>Password:</td>
            <td><input type="password" name="password"/></td>
        </tr>
        <tr>
            <td>Re Password:</td>
            <td><input type="password" name="repassword"/></td>
        </tr>
        <tr>
            <td>E-mail:</td>
            <td><input type="text" name="email"/></td>
        </tr>
        <tr>
            <td><input type="submit" value="Registration"/></td>
        </tr>
    </table>
</form>
</body>
</html>
