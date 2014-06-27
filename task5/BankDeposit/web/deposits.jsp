<%-- 
    Document   : deposits
    Created on : Jun 25, 2014, 3:34:39 PM
    Author     : Администратор
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/style.css" type="text/css">
        <title>JSP Page</title>
    </head>
    <body>
        
        <jsp:include page="index.jsp"></jsp:include>
        <h2>Parsed with ${type}</h2>
        <table border="0">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Bank</th>
                    <th>Country</th>
                    <th>Type</th>
                    <th>Depositor</th>
                    <th>Amount</th>
                    <th>Profitability</th>
                    <th>Time Constraints</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${deposits}" var="deposit" >
                <tr>
                    <td>${deposit.accountId}</td>
                    <td>${deposit.name}</td>
                    <td>${deposit.country}</td>
                    <td>${deposit.type}</td>
                    <td>${deposit.depositor}</td>
                    <td>${deposit.amount}$</td>
                    <td>${deposit.profitability}%</td>
                    <td>${deposit.timeConstraints}</td>
                </tr>
                </c:forEach>
            </tbody>
        </table>

    </body>
</html>
