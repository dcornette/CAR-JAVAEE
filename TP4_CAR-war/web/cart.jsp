<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/template/header.jsp" />
        <h1>Cart :</h1>
        <table>
            <c:forEach var="book" items="#{cart}" >
                <tr>
                    <td>${book.getBTitle()}</td>
                    <td>${book.getBAuthor()}</td>
                    <td>${book.getBYear()}</td>
                    <td><a href="http://localhost:8080/TP4_CAR-war/removeBook?title=${book.getBTitle()}">remove</a></td>
                </tr>
            </c:forEach>
            <c:if test="${empty cart}">
                <tr><td>No Book in Cart</td></tr>
            </c:if> 
        </table>
        <a href="http://localhost:8080/TP4_CAR-war/toOrder">To Order</a>
        <c:if test="${orderStatus == 'created'}">
            <h1>Ordered !</h1>
        </c:if>
        <c:if test="${orderStatus == 'empty'}">
            <h1>Empty cart. not ordered.</h1>
        </c:if>
    </body>
</html>
