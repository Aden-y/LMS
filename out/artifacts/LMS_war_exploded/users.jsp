<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 9/23/2020
  Time: 8:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="templates/header.html"/>
<body>
<jsp:include page="templates/nav.jsp"/>
<div>
    <h4 class="title color-primary">System Users (Staff)</h4>
    <div class="row">
        <div class="input-field col s8">
            <select>
                <option value="" disabled selected>Select Campus</option>
                <option value="1">Option 1</option>
                <option value="2">Option 2</option>
                <option value="3">Option 3</option>
            </select>
            <label>Filter by  campus</label>
        </div>
        <div class="input-field col s4">
                <input type="search" placeholder="Search by name">
        </div>

    </div>
    <div>
        <table class="highlight">
            <thead>
            <tr>
                <th>User ID</th>
                <th>Name</th>
                <th>Campus</th>
                <th>Action</th>
            </tr>
            </thead>

            <tbody>
            <tr>
                <td>1</td>
                <td>Test User</td>
                <td>Test Campus</td>
                <td>Sample</td>
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
