<%-- 
    Document   : jstl_table
    Created on : Oct 23, 2018, 2:16:12 PM
    Author     : lucian.alexandru
--%>

<%@tag description="JSTL Table tag" pageEncoding="UTF-8"%>
<%@taglib prefix = "tlib" uri = "WEB-INF/tag_library.tld"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@attribute name="records" required="false" type="java.util.Collection"%>

<table>
<tbody>
    <tr><th>Key</th><th>Value</th><th>Category</th></tr>
    <c:forEach items="${records}" var="record">
        <tlib:record key="${record.key}" value="${record.value}" category="${record.category}"/>
    </c:forEach>
</tbody>
</table>