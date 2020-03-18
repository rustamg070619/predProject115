<%@ page import="model.User" %><%--
  Created by IntelliJ IDEA.
  User: rustemrustem
  Date: 11.03.2020
  Time: 21:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <link href="/css/styles.css" rel="stylesheet" type="text/css">
</head>
<body>
<form method="post" action="<c:url value="/addUser"/>">
    <label for="firstName">Имя
        <input type="text" id="firstName" name="firstName" required placeholder="Ваше имя">
    </label>
    <label for="password">Пароль
        <input type="text" id="password" name="password" required placeholder="Ваш пароль">
    </label>
    <label for="role">Роль
        <input type="text" id="role" name="role" required placeholder="Ваша роль">
    </label>
    <input type="submit" value="Добавить пользователя">
</form>

</body>
</html>
