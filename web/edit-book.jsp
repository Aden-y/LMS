<%@ page import="java.util.List" %>
<%@ page import="models.*" %><%--
  Created by IntelliJ IDEA.
  User: User
  Date: 9/29/2020
  Time: 12:21 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="templates/header.html"/>
<body>
<%
    Object user = session.getAttribute("user");
    if (user == null || !(user instanceof Staff)) {
        session.invalidate();
        response.sendRedirect("index.jsp");
        return;
    }
    List<BookCategory> categories = (List<BookCategory>) request.getAttribute("categories");
    List<Binding> bindings = (List<Binding>) request.getAttribute("bindings");
    List<Shelf> shelves = (List<Shelf>) request.getAttribute("shelves");
    Book book = (Book) request.getAttribute("book");
    if (categories == null || bindings == null || shelves == null || book == null) {
        response.sendRedirect("books");
        return;
    }
%>
<jsp:include page="templates/nav.jsp"/>
<div class="p-2">
    <h4 class="title color-primary">Edit Book</h4>
    <div class="row">
        <div class="row col s8">
            <h6 class="title color-primary">Edit Book Details</h6>
            <form method="post" action="edit-book">
                <div class="col s12 input-field">
                    <input name="ISBNCode" hidden >
                    <input type="text" value="<%=book.getTitle()%>" name="Title" id="Title" class="validate" required>
                    <label for="Title">Book Title</label>
                </div>

                <div class="col s6 input-field">
                    <input type="text" value="<%=book.getAuthor()%>" name="Author" id="Author" class="validate" required>
                    <label for="Author">Author</label>
                </div>
                <div class="col s6 input-field">
                    <input type="text" value="<%=book.getLanguage()%>" name="Language" id="Language" class="validate" required>
                    <label for="Language">Language</label>
                </div>
                <div class="col s12 input-field">
                    <input type="number" value="<%=book.getPublicationYear()%>" min="0" name="PublicationYear" id="PublicationYear" class="validate" required>
                    <label for="PublicationYear">Publication Year</label>
                </div>

                <div class="input-field col s6">
                    <select required name="CategoryId">
                        <option value="" disabled selected>Select Category</option>
                        <%
                            for (BookCategory category: categories) {
                        %>
                        <option value="<%=category.getCategoryId()%>"><%=category.getCategoryName()%></option>
                        <%
                            }
                        %>
                    </select>
                    <label>Select Category</label>
                </div>

                <div class="input-field col s6">
                    <select required name="BindingId">
                        <option value="" disabled selected>Select Binding</option>
                        <%
                            for (Binding binding: bindings) {
                        %>
                        <option value="<%=binding.getBindingId()%>"><%=binding.getBindingName()%></option>
                        <%
                            }
                        %>
                    </select>
                    <label>Select Binding</label>
                </div>

                <div class="col s6 input-field">
                    <input type="number" value="<%=book.getCopiesActual()%>" min="0" name="CopiesActual" id="CopiesActual" class="validate" required>
                    <label for="CopiesActual">Total Copies</label>
                </div>

                <div class="input-field col s6">
                    <select required name="ShelfId">
                        <option value="" disabled selected>Select shelf</option>
                        <%
                            for (Shelf shelf: shelves) {
                        %>
                        <option value="<%=shelf.getShelfId()%>"><%=shelf%></option>
                        <%
                            }
                        %>
                    </select>
                    <label>Shelf</label>
                </div>
                <div class="input-field col s12">
                    <button class="btn pink darken-4 w-100" title="submit">Save changes</button>
                </div>
            </form>
        </div>

        <div class="col s4">
            <h6 class="title color-primary">Manage Categories & Bindings</h6>
            <label>Categories</label>
            <div>
                <%
                    for (BookCategory category: categories) {
                %>
                <div class="chip"><%=category.getCategoryName()%></div>
                <%
                    }
                %>
                <form action="edit-book" method="post">
                    <div class="input-field">
                        <input class="validate" name="CategoryName" id="CategoryName" required placeholder="Category name">
                    </div>
                    <div class="input-field">
                        <input  type="submit" class="btn-small pink darken-4" name="NewCategory" value="add category">
                    </div>
                </form>
            </div>
            <label>Bindings</label>
            <div>
                <%
                    for (Binding binding: bindings) {
                %>
                <div class="chip"><%=binding.getBindingName()%></div>
                <%
                    }
                %>
                <form action="edit-book" method="post">
                    <div class="input-field">
                        <input class="validate" name="BindingName" id="BindingName" required placeholder="Binding Name">
                    </div>
                    <div class="input-field">
                        <input type="submit" class="btn-small pink darken-4" name="NewBinding" value="Create Binding">
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
<script>
    $(document).ready(function(){
        $('select').formSelect();
    });
</script>
</html>
