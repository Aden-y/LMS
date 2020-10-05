<%@ page import="java.util.List" %>
<%@ page import="models.Campus" %>
<%@ page import="models.Staff" %><%--
  Created by IntelliJ IDEA.
  User: User
  Date: 9/23/2020
  Time: 8:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="templates/header.html"/>
<%
    Object user = session.getAttribute("user");
    if (user == null || !(user instanceof Staff || !((Staff) user).isAdmin())) {
        session.invalidate();
        response.sendRedirect("index.jsp");
        return;
    }
    List<Campus> campuses = (List<Campus>) request.getAttribute("campuses");
    List<Staff> users = (List<Staff>) request.getAttribute("users");

    if (campuses == null || users == null) {
        response.sendRedirect("users");
        return;
    }

%>
<body>
<jsp:include page="templates/nav.jsp"/>
<div class="p-2">
    <h4 class="title color-primary">System Users (Staff)</h4>
    <div class="row">
        <div class="input-field col s8">
            <form action="users" method="post">
                <select name="CampusIdFilter" id="CampusIdFilter">
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
                <input type="submit" name="CampusFilter" hidden id="CampusFilter">
            </form>
        </div>
        <div class="input-field col s4">
                <input type="search" placeholder="Search by name" id="search">
        </div>

    </div>
    <div>
        <table class="highlight">
            <thead>
            <tr>
                <th>User ID</th>
                <th>Name</th>
                <th>Campus</th>
                <th>Action</th>
            </tr>
            </thead>

            <tbody>
            <%
                for (Staff staff: users) {
            %>
            <tr class="staff-row">
                <td><%=staff.getUserId()%></td>
                <td class="staff-name"><%=staff%></td>
                <td><%=staff.getCampus()%></td>
                <td>
                    <form action="users" method="post">
                        <input type="text" name="UserId" value="<%=staff.getUserId()%>" hidden>
                        <input type="submit" class="btn-small red darken-4" name="DeleteStaff" value="Delete">
                    </form>

                    <%
                        if (!staff.isAdmin()) {
                    %>
                    <form action="users" method="post">
                        <input type="text" name="UserId" value="<%=staff.getUserId()%>" hidden>
                        <input type="submit" class="btn-small pink darken-4" name="MakeAdmin" value="Make Admin">
                    </form>
                    <%
                        }
                    %>
                </td>
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
    $('#CampusIdFilter').change(function (e) {
        document.getElementById('CampusFilter').click();
    })

    function searchByName(word) {
        $('.staff-row').each(function () {
            var tr = $(this);
            var td =  tr.find('.staff-name');
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
