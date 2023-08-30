<%-- 
    Document   : index
    Created on : Aug 30, 2023, 1:48:21 PM
    Author     : DELL
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Nam Long</title>
    </head>
    <body>
        <ul>
            <c:forEach items="${users}" var="user">
                <li>
                    ${user.userId} - ${user.username}
                </li>
            </c:forEach>
        </ul>
    </body>
</html>
