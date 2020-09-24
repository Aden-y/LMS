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
<jsp:include page="templates/nav.jsp"/>
<div>
    <h4 class="title color-primary">New Book</h4>
    <div class="row">
            <div class="row col s8">
                <h6 class="title color-primary">Create new book</h6>
                <form method="post" action="new-book">
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

                    <div class="input-field col s6">
                        <select required name="CategoryId">
                            <option value="" disabled selected>Select Category</option>
                            <option value="1">Option 1</option>
                            <option value="2">Option 2</option>
                            <option value="3">Option 3</option>
                        </select>
                        <label>Select Category</label>
                    </div>

                    <div class="input-field col s6">
                        <select required name="BindingId">
                            <option value="" disabled selected>Select Binding</option>
                            <option value="1">Option 1</option>
                            <option value="2">Option 2</option>
                            <option value="3">Option 3</option>
                        </select>
                        <label>Select Binding</label>
                    </div>

                    <div class="col s6 input-field">
                        <input type="number" min="0" name="CopiesActual" id="CopiesActual" class="validate" required>
                        <label for="CopiesActual">Total Copies</label>
                    </div>

                    <div class="input-field col s6">
                        <select required name="BindingId">
                            <option value="" disabled selected>Select shelf</option>
                            <option value="1">Option 1</option>
                            <option value="2">Option 2</option>
                            <option value="3">Option 3</option>
                        </select>
                        <label>Shelf (optional) can be updated later</label>
                    </div>
                    <div class="input-field col s12">
                        <button class="btn pink darken-4 w-100" title="submit">add book to library</button>
                    </div>
                </form>
            </div>

        <div class="col s4">
            <h6 class="title color-primary">Manage Categories & Bindings</h6>
            <label>Categories</label>
            <div>
                <div class="chip">Example Category</div>
                <form action="new-book" method="post">
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
                <div class="chip">Example Binding</div>
                <form action="new-book" method="post">
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
