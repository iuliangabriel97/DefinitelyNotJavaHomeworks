<%-- 
    Document   : input
    Created on : Oct 13, 2018, 6:55:36 PM
    Author     : roungureanu
--%>

<%@page import="records.Categories"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Input JSP</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <form action="InputControllerServlet" method="POST">
            <label for="key">Key</label>
            <input id="key" type="text" name="key"/>
            
            <label for="value">Value</label>
            <input id="value" type="text" name="value"/>
            
            <label for="category">Category</label>
            <select id="category" type="text" name="category">
                
                <%
                    Categories categories = (Categories)session.getAttribute("categories");
                    Cookie cookies[] = request.getCookies();
                    String latestCategory = null;
                    if (cookies != null) {
                        for (Cookie cookie : cookies)
                        {
                            if (cookie.getName().equals("InputControllerServlet.lastCategory")) 
                            {
                                latestCategory = cookie.getValue();
                                break;
                            }
                        }
                    }

                    
                    for (String value : categories.getCategories().keySet())
                    {
                        out.print("<option value=\"" + value + "\"");
                        if (latestCategory != null && value.equals(latestCategory))
                        {
                            out.print(" selected");
                        }
                        out.print(">");
                        out.print(categories.getCategories().get(value));
                        out.print("</option>");
                    }
                %>
            </select>
            
            
            
            <input type="submit"/>
        </form>
    </body>
</html>
