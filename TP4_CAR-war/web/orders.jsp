<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/template/header.jsp" />
        <h1>Orders :</h1>
        <table>
            <c:forEach var="order" items="#{orders}" >
                <tr>
                    <td rowspan="${order.getBooks().size()}">${order.getNumber()}</td>
                    <c:forEach var="book" items="#{order.getBooks()}">
                        <td>${book.getBTitle()}</td>
                        <td>${book.getBAuthor()}</td>
                        <td>${book.getBYear()}</td>
                        </tr>
                    </c:forEach>
            </c:forEach>
            <c:if test="${empty orders}">
                <tr><td>No Book in Cart</td></tr>
            </c:if> 
        </table>
    </body>
</html>