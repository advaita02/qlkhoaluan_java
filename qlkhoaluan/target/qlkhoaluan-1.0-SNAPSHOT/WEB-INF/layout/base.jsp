<%-- 
    Document   : base
    Created on : Aug 30, 2023, 9:55:06 PM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title></title>
    </head>
    <body>
    <head>
        <meta charset="utf-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" />
        <title><tiles:insertAttribute name="title" /></title>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.min.js"></script>
    </head>
    <body>
        <div class="container">
            <!-- HEADER -->
            <tiles:insertAttribute name="header" /> 
            <!-- CONTENT -->
            <tiles:insertAttribute name="content" /> 
            <!-- FOOTER -->
            <tiles:insertAttribute name="footer" />
        </div>
    </body>
</body>
</html>
