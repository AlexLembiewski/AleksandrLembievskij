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
        <table border="0">
            <tbody>
                <tr>
                    <td> <form action="main" method="post">
                            <input type="hidden" name="command" value="sax"/>
                            <input type="button" value="Parsing using SAX" onclick="submit()"/>
                        </form></td>
                    <td>   <form action="main" method="post">
                            <input type="hidden" name="command" value="dom"/>
                            <input type="button" value="Parsing using DOM" onclick="submit()"/>
                        </form></td>
                    <td> <form action="main" method="post">
                            <input type="hidden" name="command" value="stax"/>
                            <input type="button" value="Parsing using StAX" onclick="submit()"/>
                        </form>
                    </td>
                </tr>
            </tbody>
        </table>
    </body>
</html>
