<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8" content="text/html">
    <title>Tweeter 2.0</title>
    <link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
<div id="main">
    <%--FOR LOGGED USERS--%>
    <c:if test="${loggedUser != null}">
        <%-- CREATE AND LOGOUT --%>
        <p>Zalogowano jako: ${loggedUser.login} (<a href="/logout">Wyloguj</a>)</p>
        <p><a href="/create">Dodaj nowy wpis</a></p>

        <%--ALL TWEETS--%>
        <c:forEach items="${tweets}" var="tweet">
            <div class="tweet">
                <h5 class="user"><a href="/user/${tweet.user.id}">${tweet.user.login}</a></h5>
                <h5 class="addDate">${tweet.created}</h5>
                <div class="content"><p>${tweet.text}</p>(<a href="/tweet/${tweet.id}">Szczegóły</a>)</div>
            </div>
        </c:forEach>
    </c:if>

    <%-- FOR NON LOGGED USERS--%>
    <c:if test="${loggedUser == null}">
        <p><a href="/login">Zaloguj się</a></p>
        <p><a href="/registration">Rejestracja</a></p>
    </c:if>
</div>
</body>
</html>
