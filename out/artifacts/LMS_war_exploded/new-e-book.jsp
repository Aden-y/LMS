<%@ page import="java.util.List" %>
<%@ page import="models.BookCategory" %>
<%@ page import="models.Staff" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 9/23/2020
  Time: 7:50 PM
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
    if (categories == null) {
        response.sendRedirect("new-e-book");
        return;
    }
%>
<jsp:include page="templates/nav.jsp"/>
<div class="p-2">
    <h4 class="title color-primary">e-book</h4>
    <div class="row">
        <div class="row col s8">
            <h6 class="title color-primary">Create new e-book</h6>
            <form method="post" action="new-e-book" enctype="multipart/form-data">
            <div class="col s12 input-field">
                    <input type="text" name="Title" id="Title" class="validate" required>
                    <label for="Title">Book Title</label>
                </div>

                <div class="col s6 input-field">
                    <input type="text" name="Author" id="Author" class="validate" required>
                    <label for="Author">Author</label>
                </div>
                <div class="col s6 input-field">
                    <input type="text" name="Language" id="Language" class="validate" required>
                    <label for="Language">Language</label>
                </div>
                <div class="col s12 input-field">
                    <input type="number" min="0" name="PublicationYear" id="PublicationYear" class="validate" required>
                    <label for="PublicationYear">Publication Year</label>
                </div>

                <div class="input-field col s12">
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
                    <label>Category</label>
                </div>

                <div class="file-field input-field col s12">
                    <div class="btn-small pink darken-4">
                        <span>File</span>
                        <input type="file" name="File">
                    </div>
                    <div class="file-path-wrapper">
                        <input class="file-path validate" type="text">
                    </div>
                </div>


                <div class="input-field col s12">
                    <button class="btn pink darken-4 w-100" title="submit">upload e-book</button>
                </div>
            </form>
        </div>

        <div class="col s4">
            <h6 class="title color-primary">Manage Categories</h6>
            <label>Categories</label>
            <div>
                <%
                    for (BookCategory category: categories) {
                %>
                <div class="chip"><%=category.getCategoryName()%></div>
                <%
                    }
                %>
                <form action="new-e-book" method="post">
                    <div class="input-field">
                        <input class="validate" name="CategoryName" id="CategoryName" required placeholder="Category name">
                    </div>
                    <div class="input-field">
                        <input  type="submit" class="btn-small pink darken-4" name="NewCategory" value="add category">
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
