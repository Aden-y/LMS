<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 9/23/2020
  Time: 8:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="templates/header.html"/>
<body>
    <jsp:include page="templates/nav.jsp"/>
<div class="p-2">
    <h4 class="title color-primary">Library Books</h4>
    <div class="row">
        <div class="input-field col l4 s12 m4">
            <select>
                <option value="" disabled selected>Select Campus</option>
                <option value="1">Option 1</option>
                <option value="2">Option 2</option>
                <option value="3">Option 3</option>
            </select>
            <label>Filter by  campus</label>
        </div>
        <div class="input-field col l4 s12 m4">
            <select>
                <option value="" disabled selected>Choose category</option>
                <option value="1">Option 1</option>
                <option value="2">Option 2</option>
                <option value="3">Option 3</option>
            </select>
            <label>Filter by category</label>
        </div>
        <div class="input-field col l4 s12 m4">
            <form method="post" action="books.jsp">
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
                <th>Copies Available</th>
                <th>Action</th>
            </tr>
            </thead>

            <tbody>
            <tr>
                <td>Alvin</td>
                <td>Eclair</td>
                <td>$0.87</td>
                <td>
                    <form action="book-requests" method="post">
                        <input name="ISBNCode" value="1" hidden>
                        <input type="submit" name="RequestBook" class="btn-small pink darken-4" value="Request">
                    </form>
                </td>
            </tr>

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
