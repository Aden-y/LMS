<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 9/24/2020
  Time: 8:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="templates/header.html"/>
<body>
<jsp:include page="templates/nav.jsp"/>
<div class="p-2">
   <h4 class="title color-primary">Request For Books</h4>
        <table class="highlight">
            <thead>
            <tr>
                <th>Request ID</th>
                <th>Borrower ID</th>
                <th>Book ISBN</th>
                <th>Books Available</th>
                <th>Issue</th>
            </tr>
            </thead>

            <tbody>
            <tr>
                <td>Alvin</td>
                <td>Eclair</td>
                <td>$0.87</td>
                <td>Eclair</td>
                <td>
                    <form method="post" action="issue-book">
                        <input name="RequestId" value="1" hidden>
                        <input type="submit" class="btn-small pink darken-4" value="Issue" name="IssueBook">
                    </form>
                </td>
            </tr>

            </tbody>
        </table>
</div>
</body>
</html>
