<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/template/header.jsp" />
        <h1>List of books :</h1>
        <table>
            <c:forEach var="book" items="#{books}" >
                <tr>
                    <td>${book.getBTitle()}</td>
                    <td>${book.getBAuthor()}</td>
                    <td>${book.getBYear()}</td>
                    <td><a href="http://localhost:8080/TP4_CAR-war/addToCart?title=${book.getBTitle()}">Add to cart</a></td>
                </tr>
            </c:forEach>
            <c:if test="${empty books}">
                <tr><td>No Book found</td></tr>
            </c:if>         
        </table>
        <a href="http://localhost:8080/TP4_CAR-war/newBook">Add a book</a>
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
    </body>
</html>
