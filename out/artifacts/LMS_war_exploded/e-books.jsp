<%--
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
<jsp:include page="templates/nav.jsp"/>
<div>
    <h4 class="title color-primary">E-books</h4>
    <div class="row">
        <div class="input-field col s6">
            <select>
                <option value="" disabled selected>Choose category</option>
                <option value="1">Option 1</option>
                <option value="2">Option 2</option>
                <option value="3">Option 3</option>
            </select>
            <label>Filter by category</label>
        </div>
        <div class="input-field col s6">
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
                <th>Copies Available</th>
                <th>Action</th>
            </tr>
            </thead>

            <tbody>
            <tr>
                <td>Alvin</td>
                <td>Eclair</td>
                <td>$0.87</td>
                <td>Eclair</td>
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

