<%@ page import="java.util.List" %>
<%@ page import="models.Student" %>
<%@ page import="models.Campus" %><%--
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
    List<Student> students = (List<Student>) request.getAttribute("students");
    List<Campus> campuses = (List<Campus>) request.getAttribute("campuses");

    if (students == null || campuses == null) {
        response.sendRedirect("students");
        return;
    }
%>
<jsp:include page="templates/nav.jsp"/>
<div class="p-2">
    <h4 class="title color-primary">Students</h4>
    <div class="row">
        <div class="input-field col s8">
            <select>
                <option value="" disabled selected>Select Campus</option>
                <%
                    for (Campus campus: campuses) {
                %>
                <option value="<%=campus.getCampusNo()%>"><%=campus%></option>
                <%
                    }
                %>
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
                <th>Student Number</th>
                <th>Name</th>
                <th>DOB</th>
                <th>Campus</th>
            </tr>
            </thead>

            <tbody>
            <%
                for (Student student: students) {
            %>
            <tr>
                <td><%=student.getStudentNumber()%></td>
                <td><%=student%></td>
                <td><%=student.getDateOfBirthString()%></td>
                <td><%=student.getCampus()%></td>
            </tr>
            <%
                }
            %>
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

