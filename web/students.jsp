<%@ page import="java.util.List" %>
<%@ page import="models.Student" %>
<%@ page import="models.Campus" %>
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
    if (user == null || !(user instanceof Staff || !((Staff) user).isAdmin())) {
        session.invalidate();
        response.sendRedirect("index.jsp");
        return;
    }
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
            <input type="search" placeholder="Search by name" id="search">
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
            <tr class="student-row">
                <td><%=student.getStudentNumber()%></td>
                <td class="student-name"><%=student%></td>
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

    function searchByName(word) {
        $('.student-row').each(function () {
            var tr = $(this);
            var td =  tr.find('.student-name');
            var title = td.text().toLocaleLowerCase();
            if (title.includes(word)) {
                tr.removeClass('d-none');
            }else {
                tr.addClass('d-none')
            }
        })
    }

    $('#search').keyup(function (e) {
        searchByName(this.value).toLocaleLowerCase();
    })

    $('#search').keydown(function (e) {
        searchByName(this.value).toLocaleLowerCase();
    })
</script>
</html>

