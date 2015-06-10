<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/template/header.jsp" />
        <h1>Add a new book :</h1>
    </body>
        <form method="POST" action="newBook">
            <table>
                <tr>
                    <td>Title :</td>
                    <td>
                        <input type=text name="title" placeholder="Title" />
                    </td>
                </tr>
                <tr>
                    <td>Author :</td>
                    <td>
                        <input type=text name="author" placeholder="Author" />
                    </td>
                </tr>
                <tr>
                    <td>Date :</td>
                    <td>
                        <input type="number" name="year" placeholder="2000" />
                    </td>
                </tr>
                <tr>
                    <td COLSPAN=2>
                        <input type="submit" value="Validate">
                    </td>
                </tr>
            </table>
        </form>
        <c:if test="${!empty status}">
            <h1>Book Created !</h1>
        </c:if>
</html>
