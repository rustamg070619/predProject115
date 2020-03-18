<%--
  Created by IntelliJ IDEA.
  User: rustemrustem
  Date: 18.03.2020
  Time: 13:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1 align="center">Текущий пользователь</h1>
<hr>
<table align="center">
    <tr>

    </tr>
    <tr>
        <td>
            <h1> <c:out value="${userFromBase}" default="guest" /> </h1>
        </td>
    </tr>
    </tr>
</table>
</body>
</html>
