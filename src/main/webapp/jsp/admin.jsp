<%--
  Created by IntelliJ IDEA.
  User: rustemrustem
  Date: 12.03.2020
  Time: 13:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1 align="center">Список пользователей</h1>
<hr>
<table align="center">
    <tr>
        <th align="left">Id</th>
        <th align="left">Имя</th>

        <c:forEach items="${usersFromServer}" var="user">
    <tr>
        <td>${user.id}</td>
        <td>${user.firstName}</td>
        <td>
            <form method="post" action="<c:url value="/delete"/>">
                <input type="hidden" name="id" value="${user.id}">
                <input type="submit" name="id" value="Удалить">
            </form>
        </td>
        <td>
            <form method="post" action="<c:url value="/update"/>">
                <input type="hidden" name="id" value="${user.id}">
                <input type="submit" name="id" value="Редактировать">
            </form>
        </td>

    </tr>
    </c:forEach>
    <tr>
        <td>
            <form method="get" action="<c:url value="/addUser"/>">
                <button>Добавить</button>
            </form>
        </td>
    </tr>
    </tr>
</table>
</body>
</html>
