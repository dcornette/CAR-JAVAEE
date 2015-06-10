<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/template/header.jsp" />
        <c:if test="${initBookStatus == 'ok'}">
                <h1>Book initialized !</h1>
        </c:if>  
        <c:if test="${initBookStatus == 'error'}">
                <h1>Books already initialized.</h1>
        </c:if>  
    </body>
</html>
