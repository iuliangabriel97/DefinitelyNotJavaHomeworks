<%-- 
    Document   : result
    Created on : Oct 14, 2018, 10:22:47 PM
    Author     : LucianAlexandru
--%>

<%@page import="java.util.Map"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="records.RecordBean"%>  
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Result JSP</title>
    </head>
    <body>
        <h1>Result page</h1>
        <%
        Map<String, RecordBean> records = (Map<String, RecordBean>)request.getAttribute("records");
        for (String key : records.keySet())
        {
            out.print(records.get(key));
            out.print("<br/>");
        }
        %>
    </body>
</html>
