<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Info Page</title>
</head>
<body>
<h2>User Info Page</h2>
User Name: ${userName}
Login: ${login}
Pasword: ${password}

<form action="logout" method="get">
    <table width="50%">
        <tr>
            <td><input type="submit" value="Logout"/></td>
        </tr>
    </table>
</form>
</body>
</html>