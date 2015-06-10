<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/template/header.jsp" />
        <h1>List of authors :</h1>
        <ul>
            <c:forEach var="author" items="#{authors}" >
                <li>${author}</li>
            </c:forEach>
            <c:if test="${empty authors}">
                <li>No Author found</li>
            </c:if>
        </ul>
</body>
</html>
