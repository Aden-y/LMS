<%@ page import="models.EBook" %>
<%@ page import="java.util.List" %>
<%@ page import="models.BookCategory" %><%--
  Created by IntelliJ IDEA.
  User: User
  Date: 9/23/2020
  Time: 8:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="templates/header.html"/>
<body>
<%
    List<EBook> books = (List<EBook>) request.getAttribute("e-books");
    List<BookCategory> categories = (List<BookCategory>) request.getAttribute("categories");

    if (books == null ||  categories == null) {
        response.sendRedirect("e-books");
        return;
    }
%>
<jsp:include page="templates/nav.jsp"/>
<div class="p-2">
    <h4 class="title color-primary">E-books</h4>
    <div class="row">
        <div class="input-field col s12 l6 m6">
            <select>
                <option value="" disabled selected>Choose category</option>
                <%
                    for (BookCategory category: categories) {
                %>
                <option value="<%=category.getCategoryId()%>"><%=category.getCategoryName()%></option>
                <%
                    }
                %>
            </select>
            <label>Filter by category</label>
        </div>
        <div class="input-field col s12 l6 m6">
            <form method="post" action="e-books.jsp">
                <input type="search" placeholder="Search by title">
            </form>
        </div>
    </div>
    <div>
        <table class="highlight">
            <thead>
            <tr>
                <th>ISBN</th>
                <th>Title</th>
                <th>Action</th>
            </tr>
            </thead>

            <tbody>
            <%
                for (EBook book : books) {
            %>
            <tr>
                <td><%=book.getISBNCode()%></td>
                <td><%=book.getTitle()%></td>
                <td>
                    <form action="e-books" method="post">
                        <input name="ISBNCode" value="<%=book.getISBNCode()%>" hidden>
                        <input type="submit" name="DownloadEBook" class="btn-small pink darken-4" value="Download">
                    </form>
                </td>
            </tr>
            <%
                }
            %>

            </tbody>
        </table>
    </div>
</div>
</body>
<script>
    $(document).ready(function(){
        $('select').formSelect();
    });
</script>
</html>

