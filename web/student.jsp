<%@ page import="models.Student" %>
<%@ page import="java.util.List" %>
<%@ page import="models.BookRequest" %>
<%@ page import="models.Borrower" %><%--
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
    if (user == null || !(user instanceof Student)) {
        session.invalidate();
        response.sendRedirect("index.jsp");
        return;
    }

    List<BookRequest> requests = (List<BookRequest>) request.getAttribute("requests");
    Borrower borrowed = (Borrower) request.getAttribute("borrowed");
    if (requests == null) {
        response.sendRedirect("student");
        return;
    }
%>
<jsp:include page="templates/nav.jsp"/>
<div class="p-2">
    <h4 class="title color-primary">Student's Dashboard</h4>
    <div class="row">
        <div class="col s12 m4 l4">
            <h6 class="title color-primary">Current Borrow</h6>
            <div class="card p-2">
                <%
                    if (borrowed != null) {
                %>
                <table>
                    <tr>
                        <td><strong>ISBN Code</strong></td>
                        <td><%=borrowed.getBook().getISBNCode()%></td>
                    </tr>
                    <tr>
                        <td><strong>Title</strong></td>
                        <td><%=borrowed.getBook().getTitle()%></td>
                    </tr>
                    <tr>
                        <td><strong>Borrowed on</strong></td>
                        <td><%=borrowed.getBorrowedFromString()%></td>
                    </tr>
                    <tr>
                        <td><strong>Return By</strong></td>
                        <td><%=borrowed.getBorrowedToString()%></td>
                    </tr>
                </table>
                <%
                    } else {
                %>
                <div class="center">
                    <label>No current borrow.</label>
                </div>
                <%
                    }
                %>
            </div>
        </div>
        <div class="col s12 m8 l8">
            <h6 class="title color-primary">Books Requested</h6>
            <div class="card p-2">
                <%
                    if (requests.size() > 0) {
                %>
                <table class="highlight">
                    <thead>
                    <tr>
                        <th>Request ID</th>
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

                        <td><%=bookRequest.getBook().getISBNCode()%></td>
                        <td><%=bookRequest.getBook().getTitle()%></td>
                        <td><%=bookRequest.getBook().getCopiesActual()%></td>
                        <td><%=bookRequest.getBook().getCopiesAvailable()%></td>
                        <td>
                            <form action="student" method="post">
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
                    } else {
                %>
                <div class="center">
                    <label>No books requested yet. </label>
                    <p><a href="books">Find books here</a></p>
                </div>
                <%
                    }
                %>
            </div>
        </div>
    </div>
</div>
</body>
</html>
