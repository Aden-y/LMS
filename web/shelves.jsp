<%@ page import="java.util.List" %>
<%@ page import="models.Campus" %>
<%@ page import="models.Shelf" %><%--
  Created by IntelliJ IDEA.
  User: User
  Date: 9/24/2020
  Time: 6:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="templates/header.html"/>
<%
    List<Campus> campuses = (List<Campus>) request.getAttribute("campuses");
    List<Shelf> shelves = (List<Shelf>) request.getAttribute("shelves");

    if (shelves == null || campuses == null) {
        response.sendRedirect("shelves");
        return;
    }
%>

<body>
<jsp:include page="templates/nav.jsp"/>
<div class="p-2">
    <h4 class="title color-primary">Shelves</h4>
    <div class="row">
        <div class="col s12 m8 l8">
            <h6 class="title color-primary">Displaying shelves for some campus</h6>
            <div class="input-field">
                <select name="c">
                    <%
                        for (Campus campus: campuses) {
                    %>
                    <option value="<%=campus.getCampusNo()%>"><%=campus.getCampusName()%></option>
                    <%
                        }
                    %>
                </select>
                <label>Choose campus to display shelves</label>
            </div>
            <table class="highlight">
                <thead>
                <tr>
                    <th>Shelf No</th>
                    <th>Floor No</th>
                    <th>Campus</th>
                    <th>Books Count</th>
                </tr>
                </thead>

                <tbody>
                <tr>
                    <%
                        for (Shelf shelf: shelves) {
                    %>
                    <td><%=shelf.getShelfNo()%></td>
                    <td><%=shelf.getFloorNo()%></td>
                    <td><%=shelf.campusName()%></td>
                    <td><%=shelf.booksCount()%></td>
                    <%
                        }
                    %>
                </tr>

                </tbody>
            </table>
        </div>
        <div class="col s12 m4 l4">
            <h6 class="title color-primary">Create new shelf</h6>
            <form method="post" action="shelves">
                <div class="input-field">
                    <select name="CampusNo">
                        <option value="" disabled selected>Select Campus</option>
                        <%
                            for (Campus campus: campuses) {
                        %>
                        <option value="<%=campus.getCampusNo()%>"><%=campus.getCampusName()%></option>
                        <%
                            }
                        %>
                    </select>
                    <label>Campus</label>
                </div>
                <div class="input-field">
                    <input name="ShelfNo" id="ShelfNo" class="value" type="number" min="1" required>
                    <label for="ShelfNo">Shelf Number</label>
                </div>

                <div class="input-field">
                    <input name="FloorNo" id="FloorNo" class="value" type="number" min="1" required>
                    <label for="FloorNo">Floor Number</label>
                </div>

                <div class="input-field">
                    <input type="submit" class="btn-small pink darken-4" name="NewShelf" value="Create Shelf">
                </div>
            </form>
        </div>

    </div>
</div>
<script>
    $(document).ready(function(){
        $('select').formSelect();
    });
</script>
</body>
</html>
