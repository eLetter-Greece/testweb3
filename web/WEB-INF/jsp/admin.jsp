<%-- 
    Document   : admin
    Created on : Jan 17, 2019, 11:27:30 AM
    Author     : George.Pasparakis
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.afdemp.org.StaticClass"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        Hello user with id : <% StaticClass sc = new StaticClass(); 
        out.println(sc.getUserId());%>
    </body>
</html>
