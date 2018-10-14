<%-- 
    Document   : result
    Created on : Oct 14, 2018, 10:22:47 PM
    Author     : LucianAlexandru
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="records.RecordBean"%>  
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Result JSP</title>
    </head>
    <body>
        <%
        RecordBean record=(RecordBean)request.getAttribute("record");
        out.print(record.toString());
        %>
    </body>
</html>
