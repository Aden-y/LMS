<%@ page import="java.util.List" %>
<%@ page import="models.Campus" %><%--
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
<%
    List<Campus> campuses = (List<Campus>) request.getAttribute("campuses");
    if(campuses == null) {
        response.sendRedirect("campuses");
        return;
    }
%>
<jsp:include page="templates/nav.jsp"/>
<div class="p-2">
    <h4 class="title color-primary">Campuses</h4>
    <div class="row">
        <div class="col l8 m8 s12">
            <h6 class="title color-primary">Registered Campuses</h6>
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
                <%
                    for (Campus campus: campuses) {
                %>
                <tr>
                    <td><%=campus.getCampusName()%></td>
                    <td><%=campus.studentsCount()%></td>
                    <td><%=campus.staffCount()%></td>
                    <td><%=campus.shelfCount()%></td>
                    <td>
                        <a href="shelves?c=<%=campus.getCampusNo()%>" class="btn-small pink darken-4"><i class="fa fa-trash">&nbsp;</i>Manage Shelves</a>
                    </td>
                </tr>
                <%
                    }
                %>
                </tbody>
            </table>
        </div>
        <div class="col s12 m4 l4">
            <h6 class="title color-primary">Register Campus</h6>
            <form action="campuses" method="post">
                <div class="input-field">
                    <input type="text" name="CampusName" class="validate" required id="CampusName">
                    <label for="CampusName">Campus Name</label>
                </div>
                <div class="input-field">
                    <input type="submit" name="NewCampus" value="Submit" class="btn-small w-100 pink darken-4">
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>
