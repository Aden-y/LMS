<%@ page import="models.Staff" %><%--
  Created by IntelliJ IDEA.
  User: User
  Date: 9/24/2020
  Time: 6:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="templates/header.html"/>
<body>
<%
    Object user = session.getAttribute("user");
    if (user == null || !(user instanceof Staff || !((Staff) user).isAdmin())) {
        session.invalidate();
        response.sendRedirect("index.jsp");
        return;
    }
%>
<jsp:include page="templates/nav.jsp"/>
<div class="p-2">
    <form action="register-professor" method="post">
        <h4 class="title color-primary">Register Professor</h4>
        <div class="row">
            <%
                if(request.getAttribute("message") != null) {
            %>
            <div class="s12 alert blue darken-1 center">
                <%=request.getAttribute("message")%>
            </div>
            <%
                }
            %>
            <div class="col l4 m6 s12 input-field">
                <input type="text" name="EmploymentId" class="validate" required id="EmploymentId">
                <label for="EmploymentId">EmploymentNumber</label>
            </div>
            <div class="col l4 m6 s12 input-field">
                <input type="text" name="FirstName" class="validate" required id="FirstName">
                <label for="FirstName">First Name</label>
            </div>
            <div class="col l4 m6 s12 input-field">
                <input type="text" name="LastName" class="validate" required id="LastName">
                <label for="LastName">Last Name</label>
            </div>


            <div class="col l6 m6 s12 input-field">
                <input type="email" name="Email" class="validate" required id="Email">
                <label for="Email">Email Address</label>
            </div>
            <div class="col l6 s12 input-field">
                <input type="tel" name="Phone" class="validate" required id="Phone">
                <label for="Phone">Phone</label>
            </div>

            <div class="col l6 s12 input-field">
                <input type="text" name="Department" class="validate" required id="Department">
                <label for="Department">Department</label>
            </div>

            <div class="col l6 s12 input-field">
                <input type="number" min="1800" max="<%=new java.util.Date().getYear() + 1900%>" name="EmploymentYear" class="validate" required id="EmploymentYear">
                <label for="EmploymentYear">Employment Year</label>
            </div>

        </div>
        <div>
            <button class="btn pink darken-4" type="submit">Register Professor</button>
        </div>
    </form>
</div>
</body>
</html>

