<%-- 
    Document   : index
    Created on : Jun 25, 2014, 2:12:35 PM
    Author     : Администратор
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/style.css" type="text/css">
        <title>JSP Page</title>
    </head>
    <body>

        <form action="main" method="post">
            <input type="hidden" name="command" value="sax"/>
            <input type="button" value="SAX" onclick="submit()"/>
        </form>

        <form action="main" method="post">
            <input type="hidden" name="command" value="dom"/>
            <input type="button" value="DOM" onclick="submit()"/>
        </form>

        <form action="main" method="post">
            <input type="hidden" name="command" value="stax"/>
            <input type="button" value="StAX" onclick="submit()"/>
        </form>

    </body>
</html>
