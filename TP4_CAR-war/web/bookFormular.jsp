<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>
        <title>Add a book</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <h1>Add a book</h1>

        <form method="POST" action="Book">
            <table>
                <tr>
                    <td>Title :</td>
                    <td>
                        <input type=text name="title" value="<% if(request.getParameter("title") != null) {out.println(request.getParameter("title"));} %>">
                    </td>
                </tr>

                <tr>
                    <td>Author :</td>
                    <td>
                        <INPUT type=text name="author" value="<% if(request.getParameter("author") != null) {out.println(request.getParameter("author"));} %>">
                    </td>
                </tr>
                <tr>
                    <td>Date :</td>
                    <td>
                        <INPUT type="number" name="year" value="<%if(request.getParameter("year")!= null){out.print(Integer.parseInt(request.getParameter("year")));}%>" >
                    </td>
                </tr>
                <tr>
                    <TD COLSPAN=2>
                        <INPUT type="submit" value="Validate">
                    </td>
                </tr>
            </table>
        </form>
        
        <%
          if(request.getParameter("title") != null) {
              out.println("<ul>");
              out.println("<li>"+request.getParameter("title")+"</li>");
              out.println("<li>"+request.getParameter("author")+"</li>");
              out.println("<li>"+request.getParameter("year")+"</li>");
              out.println("</ul>");
          } 
        %>
    </body>
</html>
