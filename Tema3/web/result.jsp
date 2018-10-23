<%-- 
    Document   : result
    Created on : Oct 14, 2018, 10:22:47 PM
    Author     : LucianAlexandru
--%>

<%@page import="java.util.Map"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="records.RecordBean"%>  
<%@taglib prefix = "tlib" uri = "WEB-INF/tag_library.tld"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Result JSP</title>
        <style>
            table,th,td
            {
                border:1px solid black;
            }
        </style>
    </head>
    <body>
        <h1>Result page</h1>
        
        <%--<tlib:record key="testKey" value="testValue"/>--%>
        <br>
        
        <table>
        <tbody>
            <tr><th>Key</th><th>Value</th><th>Category</th></tr>
            <c:forEach items="${requestScope.records}" var="record">
                <tlib:record key="${record.key}" value="${record.value}" category="${record.category}"/>
            </c:forEach>
        </tbody>
        </table>
        
    </body>
</html>
