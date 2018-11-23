<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: hory314
  Date: 23.11.18
  Time: 12:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Rejestracja użytkownika</title>
</head>
<body>
<h1>Rejestracja nowego użytkownika</h1>

<table>
    <tbody>
    <form:form method="post" modelAttribute="registrationFormData">
        <tr>
            <td>Login:</td>
            <td><form:input path="login"/><form:errors path="login"/></td>
        </tr>
        <tr>
            <td>Email:</td>
            <td><form:input path="email" type="email"/><form:errors path="email"/></td>
        </tr>
        <tr>
            <td>Hasło:</td>
            <td><form:input path="password" type="password"/><form:errors path="password"/></td>
        </tr>
        <tr>
            <td>Powtórz hasło:</td>
            <td><form:input path="confirmedPassword" type="password"/><form:errors path="confirmedPassword"/></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="Zarejestruj"></td>
        </tr>
    </form:form>
    </tbody>
</table>
</body>
</html>
