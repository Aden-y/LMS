<%@ page import="java.util.List" %>
<%@ page import="models.Book" %>
<%@ page import="models.BookCategory" %>
<%@ page import="models.Campus" %><%--
  Created by IntelliJ IDEA.
  User: User
  Date: 9/23/2020
  Time: 8:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="templates/header.html"/>
<%
    List<Book> books = (List<Book>) request.getAttribute("books");
    List<BookCategory> categories = (List<BookCategory>) request.getAttribute("categories");
    List<Campus> campuses = (List<Campus>) request.getAttribute("campuses");

    if (books == null || campuses == null || categories == null) {
        response.sendRedirect("books");
        return;
    }
%>
<body>
    <jsp:include page="templates/nav.jsp"/>
<div class="p-2">
    <h4 class="title color-primary">Library Books</h4>
    <div class="row">
        <div class="input-field col l4 s12 m4">
            <select>
                <option value="" disabled selected>Select Campus</option>
                <%
                    for (Campus campus : campuses) {
                %>
                <option value="<%=campus.getCampusNo()%>"><%=campus.getCampusName()%></option>
                <%
                    }
                %>
            </select>
            <label>Filter by  campus</label>
        </div>
        <div class="input-field col l4 s12 m4">
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
        <div class="input-field col l4 s12 m4">
            <form method="post" action="books">
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
                <th>Actual Copies</th>
                <th>Copies Available</th>
                <th>Shelf</th>
                <th>Action</th>
            </tr>
            </thead>

            <tbody>
            <%
                for (Book book : books) {
            %>
            <tr>
                <td><%=book.getISBNCode()%></td>
                <td><%=book.getTitle()%></td>
                <td><%=book.getCopiesActual()%></td>
                <td><%=book.getCopiesAvailable()%></td>
                <td><%=book.getShelf()%></td>
                <td>
                    <form action="books" method="post">
                        <input name="ISBNCode" value="<%=book.getISBNCode()%>" hidden>
                        <input type="submit" name="StudentRequestBook" class="btn-small pink darken-4" value="Request">
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
