<%-- 
    Document   : input
    Created on : Oct 13, 2018, 6:55:36 PM
    Author     : roungureanu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <form action="" method="POST">
            <label for="key">Key</label>
            <input id="key" type="text" name="key"/>
            
            <label for="value">Value</label>
            <input id="value" type="text" name="value"/>
            
            <label for="category">Category</label>
            <select id="category">
                <option value="first">First Category</option>
                <option value="second">Second Category</option>
            </select>
            
            <input type="submit"/>
        </form>
    </body>
</html>
