<%@ page import="java.time.LocalDateTime" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <tbody>
    <form:form modelAttribute="loginFormData" method="post">
        <tr>
            <td>Login:</td>
            <td><form:input path="login"/><form:errors path="login"/></td>
        </tr>
        <tr>
            <td>Hasło:</td>
            <td><form:input path="password" type="password"/><form:errors path="password"/></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="Zaloguj"/></td>
        </tr>
    </form:form>
    </tbody>
</table>
</body>
</html>
