<%-- 
    Document   : login
    Created on : Sep 1, 2023, 11:51:18 PM
    Author     : IdeaPad S540
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%--<c:if test="${param.error != null}">
    <div class="alert alert-danger">
        Có lỗi 
    </div>
</c:if>
<c:if test="${param.accessDenied != null}">
    <div class="alert alert-danger">
        Ban Không có quyền truy cập
    </div>
</c:if>--%>
<c:url value="/login" var="action" />
<h1>Login</h1>

<form method="post" action="${action}">
    <div class="form-group">
        <label for="username">Username</label>
        <input type="text" id="username" name="username" class="form-control"/>
    </div>
    <div class="form-group">
        <label for="password">Password</label>
        <input type="password" id="password" name="password" class="form-control"/>
    </div>
    <div class="form-group">
        <input type="submit" value="dang nhap" />
        
    </div>
</form>

