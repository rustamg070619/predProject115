<%--
  Created by IntelliJ IDEA.
  User: rustemrustem
  Date: 12.03.2020
  Time: 20:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<c:set scope="request" var="id" value="${id}"/>
<c:set scope="request" var="userFirstName" value="${firstName}"/>
<c:set scope="request" var="password" value="${password}"/>
<c:set scope="request" var="role" value="${role}"/>

<form method="post" action="<c:url value="/update"/>">
    <label for="firstName">Имя
        <input type="hidden" name="id" value="${id}">
        <input type="hidden" name="put" value="put">
        <input type="text" id="firstName" name="firstName" value="${userFirstName}">
    </label>
    <label for="password">Пароль
        <input type="text" id="password" name="password" value="${password}">
    </label>
    <label for="role">Роль
        <input type="text" id="role" name="role" value="${role}">
    </label>
    <input type="submit" value="Изменить пользователя">
</form>

</body>
</html>
