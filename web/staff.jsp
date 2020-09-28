<%@ page import="models.Staff" %>
<%@ page import="models.BookRequest" %>
<%@ page import="java.util.List" %>
<%@ page import="models.ProfessorBookRequest" %><%--
  Created by IntelliJ IDEA.
  User: User
  Date: 9/23/2020
  Time: 6:43 PM
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

    List<BookRequest> requests = (List<BookRequest>) request.getAttribute("requests");
    List<ProfessorBookRequest> requests1 = (List<ProfessorBookRequest>) request.getAttribute("requests1");
    if (requests == null || requests1 == null) {
        response.sendRedirect("staff");
        return;
    }
%>
<jsp:include page="templates/nav.jsp"/>
<div class="p-2">
    <h4 class="title center color-primary">Staff's Dashboard</h4>
    <h6 class="title center color-primary">Book Requests by students</h6>
    <%
        if (requests.size() > 0) {
    %>
    <table class="highlight">
        <thead>
        <tr>
            <th>Request ID</th>
            <th>Borrower ID</th>
            <th>ISBN Code</th>
            <th>Title</th>
            <th>Total Copies</th>
            <th>Copies Available</th>
            <th>Action</th>
        </tr>
        </thead>

        <tbody>
        <%
            for (BookRequest bookRequest : requests) {
        %>
        <tr>
            <td><%=bookRequest.getRequestId()%></td>
            <td><%=bookRequest.getBorrowerId()%></td>
            <td><%=bookRequest.getBook().getISBNCode()%></td>
            <td><%=bookRequest.getBook().getTitle()%></td>
            <td><%=bookRequest.getBook().getCopiesActual()%></td>
            <td><%=bookRequest.getBook().getCopiesAvailable()%></td>
            <td>
                <form action="staff" method="post">
                    <input name="RequestId" value="<%=bookRequest.getRequestId()%>" hidden>
                    <input type="submit" class="btn-small pink darken-4" name="ApproveRequest" value="Issue">
                </form>
            </td>
        </tr>
        <%
            }
        %>
        </tbody>
    </table>
    <%
    } else {
    %>
    <div class="center">
        <label>No book requests by students </label>
    </div>
    <%
        }
    %>

    <h6 class="title center color-primary">Book Requests by professors</h6>
    <%
        if (requests1.size() > 0) {
    %>
    <table class="highlight">
        <thead>
        <tr>
            <th>Request ID</th>
            <th>Employment ID</th>
            <th>ISBN Code</th>
            <th>Title</th>
            <th>Total Copies</th>
            <th>Copies Available</th>
            <th>Action</th>
        </tr>
        </thead>

        <tbody>
        <%
            for (ProfessorBookRequest bookRequest : requests1) {
        %>
        <tr>
            <td><%=bookRequest.getRequestId()%></td>
            <td><%=bookRequest.getEmploymentId()%></td>
            <td><%=bookRequest.getBook().getISBNCode()%></td>
            <td><%=bookRequest.getBook().getTitle()%></td>
            <td><%=bookRequest.getBook().getCopiesActual()%></td>
            <td><%=bookRequest.getBook().getCopiesAvailable()%></td>
            <td>
                <form action="staff" method="post">
                    <input name="RequestId" value="<%=bookRequest.getRequestId()%>" hidden>
                    <input type="submit" class="btn-small pink darken-4" name="ApproveProfessorRequest" value="Issue">
                </form>
            </td>
        </tr>
        <%
            }
        %>
        </tbody>
    </table>
    <%
    } else {
    %>
    <div class="center">
        <label>No book requests by professors </label>
    </div>
    <%
        }
    %>
</div>
</body>
</html>
