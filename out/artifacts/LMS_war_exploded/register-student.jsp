<%--
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
<jsp:include page="templates/nav.jsp"/>
<div class="p-2">
    <form action="register-student" method="post">
        <h4 class="title color-primary">Register Student</h4>
        <div class="row">
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
                    <input name="Sex" type="radio"  value="Male"/>
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
                    <option value="1">Option 1</option>
                    <option value="2">Option 2</option>
                    <option value="3">Option 3</option>
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
</script>
</body>
</html>
