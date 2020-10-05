<%@ page import="models.Campus" %>
<%@ page import="java.util.List" %>
<%@ page import="models.Staff" %><%--
  Created by IntelliJ IDEA.
  User: User
  Date: 9/23/2020
  Time: 6:43 PM
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
    List<Campus> campuses = (List<Campus>) request.getAttribute("campuses");
    if (campuses == null) {
        //request.getRequestDispatcher("register-staff").forward(request, response);
        response.sendRedirect("register-student");
        return;
    }
%>
<jsp:include page="templates/nav.jsp"/>
<div class="p-2">
    <form action="register-student" method="post" onsubmit="return validate(this)">
        <h4 class="title color-primary">Register Student</h4>
        <div class="row">
            <%
                if(request.getAttribute("message") != null) {
            %>
            <div class="s12 alert green darken-1 center">
                <%=request.getAttribute("message")%>
            </div>
            <%
                }
                if (request.getAttribute("error") != null) {
            %>
            <div class="s12 alert red darken-1 center">
                <%=request.getAttribute("error")%>
            </div>
            <%
                }
            %>
            <div class="col l4 m6 s12 input-field">
                <input type="text" name="StudentNumber" class="validate" required id="StudentNumber">
                <label for="StudentNumber">Student Number</label>
            </div>
            <div class="col l4 m6 s12 input-field">
                <input type="text" name="FirstName" class="validate" required id="FirstName">
                <label for="FirstName">First Name</label>
            </div>
            <div class="col l4 m6 s12 input-field">
                <input type="text" name="LastName" class="validate" required id="LastName">
                <label for="LastName">Last Name</label>
            </div>



            <div class="col l6 m6 s12">
                <p>Choose gender</p>
                <label>
                    <input name="Sex" type="radio"  value="Male" checked/>
                    <span>Male</span>
                </label>

                <label>
                    <input name="Sex" type="radio"  value="Female"/>
                    <span>Female</span>
                </label>

                <label>
                    <input name="Sex" type="radio"  value="Other"/>
                    <span>Other</span>
                </label>
            </div>

            <div class="col l6 m6 s12 input-field">
                <input type="date" name="DateOfBirth" class="validate" required id="DateOfBirth">
                <label for="DateOfBirth">Date Of Birth</label>
            </div>

            <div class="col l6 m6 s12 input-field">
                <input type="email" name="Email" class="validate" required id="Email">
                <label for="Email">Email Address</label>
            </div>
            <div class="col l6 s12 input-field">
                <input type="tel" name="Phone" class="validate" required id="Phone">
                <label for="Phone">Phone</label>
            </div>

            <div class="input-field col l6 s12">
                <select name="CampusNo">
                    <option value="" disabled selected>Select Campus</option>
                    <%
                        for (Campus campus : campuses) {
                    %>
                    <option value="<%=campus.getCampusNo()%>"><%=campus.getCampusName()%></option>
                    <%
                        }
                    %>
                </select>
                <label>Campus</label>
            </div>

            <div class="col l6 s12 input-field">
                <input type="text" name="Department" class="validate" required id="Department">
                <label for="Department">Department</label>
            </div>

        </div>
        <div>
            <button class="btn pink darken-4" type="submit">Register Student</button>
        </div>
    </form>
</div>
<script>
    $(document).ready(function(){
        $('select').formSelect();
    });

    function validate(form) {
        if (form.StudentNumber.value.trim() === '') {
            alert('Student number needed');
            return false;
        }

        if (form.FirstName.value.trim() === '') {
            alert('First name needed');
            return false;
        }
        if (form.LastName.value.trim() === '') {
            alert('Last name  needed');
            return false;
        }

        if (_calculateAge(parseDate(form.DateOfBirth.value)) < 15) {
            alert('Can not register a student who is bellow 15 years of age');
            return false;
        }
        if (form.Phone.value.trim().length !== 10 || isNaN(form.Phone.value)) {
            alert('Enter a valid phone number');
            return false;
        }
        if (form.CampusNo.value.trim() === null || form.CampusNo.value === '') {
            alert('Select campus ');
            return false;
        }

        if (form.Department.value.trim() === '') {
            alert('Please enter the department');
            return false;
        }

        return true;

    }

    function _calculateAge(birthday) { // birthday is a date
        var ageDifMs = Date.now() - birthday.getTime();
        var ageDate = new Date(ageDifMs); // miliseconds from epoch
        return Math.abs(ageDate.getUTCFullYear() - 1970);
    }

    function parseDate(s) {
        var b = s.split(/\D/);
        return new Date(b[0], --b[1], b[2]);
    }
</script>
</body>
</html>
