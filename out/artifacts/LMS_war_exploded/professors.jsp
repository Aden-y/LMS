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
            <input type="search" placeholder="Search by name" id="search">
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
            <tr class="prof-row">
                <td><%=professor.getEmploymentId()%></td>
                <td class="prof-name"><%=professor%></td>
                <td><%=professor.getEmploymentYear()%></td>
            </tr>
            <%
                }
            %>
            </tbody>
        </table>
    </div>
</div>
<script>
    function searchByName(word) {
        $('.prof-row').each(function () {
            var tr = $(this);
            var td =  tr.find('.prof-name');
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
</body>
</html>

