<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form modelAttribute="newTweet" method="post">
    <form:textarea path="text"></form:textarea><form:errors path="text"/>
    <input type="submit" value="Add tweet">
</form:form>
</body>
</html>
