<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 9/23/2020
  Time: 9:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="templates/header.html"/>
<body>
<jsp:include page="templates/nav.jsp"/>
<div>
    <h4 class="title color-primary">Campuses</h4>
    <div class="row col s6">
        <form method="post" action="campuses">
            <div class="input-field">
                <input type="text" name="CampusName" id="CampusName" class="validate" required>
                <label for="CampusName">Campus Name</label>
                <input type="submit" class="pink darken-4 btn-small" value="Add Campus">
            </div>
        </form>
    </div>

    <div>
        <table class="highlight">
            <thead>
            <tr>
                <th>Campus</th>
                <th>Students</th>
                <th>Staff</th>
                <th>Shelves</th>
                <th>Action</th>
            </tr>
            </thead>

            <tbody>
            <tr>
                <td>Alvin</td>
                <td>Eclair</td>
                <td>2000</td>
                <td>100</td>
                <td>Eclair</td>
            </tr>

            </tbody>
        </table>
    </div>
</div>
</body>
</html>
