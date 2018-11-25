<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8" content="text/html">
    <title>Tweeter 2.0</title>
    <link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
<h1>${user.login}</h1>
<p>Email: ${user.email}</p>
<h3>Tweety:</h3>
<c:forEach items="${user.tweets}" var="tweet">
    <div class="tweet">
        <h5 class="user"><a href="/user/${tweet.user.id}">${tweet.user.login}</a></h5>
        <h5 class="addDate">${tweet.created}</h5>
        <div class="content"><p>${tweet.text}</p>(<a href="/tweet/${tweet.id}">Szczegóły</a>)</div>
    </div>
</c:forEach>
</body>
</html>
