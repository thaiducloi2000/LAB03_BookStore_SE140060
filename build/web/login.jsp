<%-- 
    Document   : login
    Created on : Jun 16, 2021, 7:55:35 AM
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login page</title>
    </head>
    <body>
        <form action="MainController" method="POST">
            <input type="text" placeholder="User ID" name="userID" value="" required="true"><br/>
            <input type="password" placeholder="Password" name="password" value="" required="true"><br/>
            <input type="submit" name="action" value="Login">
        </form>
    </body>
</html>
