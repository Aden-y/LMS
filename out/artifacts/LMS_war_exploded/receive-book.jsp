<%@ page import="models.Borrower" %>
<%@ page import="java.util.List" %>
<%@ page import="models.ProfessorBorrow" %><%--
  Created by IntelliJ IDEA.
  User: User
  Date: 9/29/2020
  Time: 12:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="templates/header.html"/>
<body>
<jsp:include page="templates/nav.jsp"/>
<div class="p-2">
    <h4 class="center color-primary">Receive borrowed book</h4>
    <div class="row">
        <div class="col s12 m6 l6">
            <form action="receive-book" method="post">
                <div class="input-field">
                    <input type="text" name="BorrowerId" required id="BorrowerId" class="validate">
                    <input placeholder="Enter Borrower Id" type="submit" class="btn-small pink darken-4" name="ReceiveFromStudent" value="From Student">
                </div>
            </form>
        </div>

        <div class="col s12 m6 l6">
            <form action="receive-book" method="post">
                <div class="input-field">
                    <input type="text" name="EmploymentNo" required id="EmploymentNo" class="validate">
                    <input type="submit" placeholder="Enter Employment Number" class="btn-small pink darken-4" name="ReceiveFromProfessor" value="From Professor">
                </div>
            </form>
        </div>
    </div>

        <%
            if (request.getAttribute("error") != null) {
        %>
        <div class="center  red lighten-2 alert">
            <%=request.getAttribute("error")%>
        </div>
        <%
            }
            if (request.getAttribute("borrower") !=null) {
                Borrower borrower = (Borrower) request.getAttribute("borrower");
        %>
    <table class="highlight">
        <thead>
        <tr>
            <th>ISBN Code</th>
            <th>Title</th>
            <th>Borrower Name</th>
            <th>Issued By</th>
            <th>Action</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td><%=borrower.getBookId()%></td>
            <td><%=borrower.getBook().getTitle()%></td>
            <td><%=borrower.getStudent()%></td>
            <td><%=borrower.getStaffIssuer()%></td>
            <td>
                <form action="receive-book" method="post">
                    <input type="number" name="BorrowerId" hidden value="<%=borrower.getBorrowerId()%>">
                    <input type="submit" class="btn-small pink darken-4" name="ClearStudent" value="clear">
                </form>
            </td>
        </tr>
        </tbody>
    </table>

    <%
        } if (request.getAttribute("borrows") != null) {
        List<ProfessorBorrow> borrows = (List<ProfessorBorrow>) request.getAttribute("borrows");
        if (borrows.size() >0) {
    %>

    <table>
        <thead>
        <tr>
            <th>ISBN Code</th>
            <th>Title</th>
            <th>Borrower Name</th>
            <th>Issued By</th>
            <th>Action</th>
        </tr>
        </thead>
        <tbody>
        <%
            for (ProfessorBorrow borrow: borrows) {
        %>
        <tr>
            <td><%=borrow.getBookId()%></td>
            <td><%=borrow.getBook().getTitle()%></td>
            <td><%=borrow.getProfessor()%></td>
            <td><%=borrow.getStaffIssuer()%></td>
            <td>
                <form action="receive-book" method="post">
                    <input type="number" name="EmploymentNo" hidden value="<%=borrow.getEmploymentId()%>">
                    <input type="number" name="ISBNCode" hidden value="<%=borrow.getBookId()%>">
                    <input type="submit" class="btn-small pink darken-4" name="ClearProfessor" value="clear">
                </form>
            </td>
        </tr>
        <%
            }
        %>
        </tbody>
    </table>
    <%
        }else {
    %>
    <div class="center  red lighten-2 alert">
        No borrowing record found for this professor
    </div>
    <%
        }}
    %>


</div>
</body>
</html>
