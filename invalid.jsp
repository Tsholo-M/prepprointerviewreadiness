<%-- 
    Document   : invalid
    Created on : 05 Apr 2024, 15:46:14
    Author     : motau
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
        <% 
         String invalid =(String)request.getAttribute("invalid");
            %>
            <%=invalid%>
    </body>
</html>
