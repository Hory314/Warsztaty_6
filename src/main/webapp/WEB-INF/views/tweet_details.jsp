<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8" content="text/html">
    <title>Tweeter 2.0</title>
    <link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
<div class="tweet">
    <h5 class="user"><a href="/user/${tweet.user.id}">${tweet.user.login}</a></h5>
    <h5 class="addDate">${tweet.created}</h5>
    <div class="content"><p>${tweet.text}</p></div>
</div>
</body>
</html>
