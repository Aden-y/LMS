<%@ page import="models.Professor" %>
<%@ page import="models.ProfessorBookRequest" %>
<%@ page import="models.ProfessorBorrow" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: User
  Date: 9/23/2020
  Time: 6:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="templates/header.html"/>
<body>
<%
    Object user = session.getAttribute("user");
    if (user == null || !(user instanceof Professor)) {
        session.invalidate();
        response.sendRedirect("index.jsp");
        return;
    }

    List<ProfessorBookRequest> requests = (List<ProfessorBookRequest>) request.getAttribute("requests");
    List<ProfessorBorrow> borrowed = (List<ProfessorBorrow>) request.getAttribute("borrowed");
    if (requests == null || borrowed == null) {
        response.sendRedirect("professor");
        return;
    }
%>
<jsp:include page="templates/nav.jsp"/>
<div class="p-2">
    <h4 class="title center color-primary">Professor's Dashboard</h4>
    <h6 class="title center color-primary">Current Borrows</h6>
    <%
        if (borrowed.size() == 0) {
    %>
    <div class="center"><label>No book borrowed</label></div>
    <%
        } else {
    %>
    <table class="highlight">
        <thead>
        <tr>
            <th>ISBN Code</th>
            <th>Title</th>
            <th>From</th>
            <th>To</th>
        </tr>
        </thead>

        <tbody>
        <%
            for (ProfessorBorrow borrow: borrowed) {
        %>
        <tr>
            <td><%=borrow.getBookId()%></td>
            <td><%=borrow.getBook().getTitle()%></td>
            <td><%=borrow.getBorrowedFromString()%></td>
            <td><%=borrow.getBorrowedToString()%></td>
        </tr>
        <%
            }
        %>
        </tbody>
    </table>
    <%
        }
    %>


    <h6 class="title center color-primary">Books Requested</h6>
    <%
        if (requests.size() == 0) {
    %>
    <div class="center">
        <label>No book requested</label>
        <p><a href="books">Find books here.</a> </p>
    </div>
    <%
    } else {
    %>
    <table class="highlight">
        <thead>
        <tr>
            <th>Request ID</th>
            <th>ISBN Code</th>
            <th>Title</th>
            <th>Total Copies</th>
            <th>Available Copies</th>
            <th>Action</th>
        </tr>
        </thead>

        <tbody>
        <%
            for (ProfessorBookRequest bookRequest: requests) {
        %>
        <tr>
            <td><%=bookRequest.getRequestId()%></td>
            <td><%=bookRequest.getISBNCode()%></td>
            <td><%=bookRequest.getBook().getTitle()%></td>
            <td><%=bookRequest.getBook().getCopiesActual()%></td>
            <td><%=bookRequest.getBook().getCopiesAvailable()%></td>
            <td>
                <form action="professor" method="post">
                    <input name="RequestId" value="<%=bookRequest.getRequestId()%>" hidden>
                    <input type="submit" class="btn-small pink darken-4" name="CancelRequest" value="Cancel">
                </form>
            </td>
        </tr>
        <%
            }
        %>

        </tbody>
    </table>
    <%
        }
    %>
</div>
</body>
</html>
