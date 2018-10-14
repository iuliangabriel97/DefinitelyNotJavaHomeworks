<%-- 
    Document   : error
    Created on : Oct 14, 2018, 10:22:54 PM
    Author     : LucianAlexandru
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Error JSP</title>
    </head>
    <body>
        <h1>Error page</h1>
        <%
        out.print(request.getAttribute("error"));
        %>
    </body>
</html>
