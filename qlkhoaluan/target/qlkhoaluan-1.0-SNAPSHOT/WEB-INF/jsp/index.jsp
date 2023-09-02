<%-- 
    Document   : index
    Created on : Aug 30, 2023, 1:48:21 PM
    Author     : DELL
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:url value="/index" var="action" />
<ul>
    <c:forEach items="${users}" var="user">
        <li>
            ${user.userId} - ${user.username} 
        </li>
    </c:forEach>
</ul>