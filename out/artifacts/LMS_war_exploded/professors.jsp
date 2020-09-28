<%@ page import="models.Professor" %>
<%@ page import="java.util.List" %>
<%@ page import="models.Staff" %><%--
  Created by IntelliJ IDEA.
  User: User
  Date: 9/23/2020
  Time: 8:54 PM
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
    List<Professor> professors = (List<Professor>) request.getAttribute("professors");
    if (professors == null ) {
        response.sendRedirect("professors");
        return;
    }
%>
<jsp:include page="templates/nav.jsp"/>
<div class="p-2">
    <h4 class="title color-primary">Professors</h4>
    <div class="row">
        <div class="input-field col s12">
            <input type="search" placeholder="Search by name">
        </div>

    </div>
    <div>
        <table class="highlight">
            <thead>
            <tr>
                <th>Employment ID</th>
                <th>Name</th>
                <th>Year Employed</th>
            </tr>
            </thead>

            <tbody>
            <%
                for (Professor professor: professors) {
            %>
            <tr>
                <td><%=professor.getEmploymentId()%></td>
                <td><%=professor%></td>
                <td><%=professor.getEmploymentYear()%></td>
            </tr>
            <%
                }
            %>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>

