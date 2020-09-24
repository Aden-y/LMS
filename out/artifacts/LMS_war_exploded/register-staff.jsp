<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 9/23/2020
  Time: 7:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="templates/header.html"/>
<body>
<jsp:include page="templates/nav.jsp"/>
<div class="p-2">
    <h4 class="title color-primary">Register Staff (User)</h4>
    <form method="post" action="register-staff">
        <div class="row">
            <div class="col s12 m6 l6 input-field">
                <input type="text" class="validate" required name="FirstName" id="FirstName">
                <label for="FirstName">First Name</label>
            </div>

            <div class="col s12 m6 l6 input-field">
                <input type="text" class="validate" required name="LastName" id="LastName">
                <label for="LastName">Last Name</label>
            </div>

            <div class="col s12 m6 l4 input-field">
                <input type="tel" class="validate" required name="Phone" id="Phone">
                <label for="Phone">Phone</label>
            </div>

            <div class="col s12 m6 l4 input-field">
                <input type="email" class="validate" required name="Email" id="Email">
                <label for="Email">Email Address</label>
            </div>

            <div class="input-field col l4 m6 s12">
                <select>
                    <option value="" disabled selected>Select Campus</option>
                    <option value="1">Option 1</option>
                    <option value="2">Option 2</option>
                    <option value="3">Option 3</option>
                </select>
                <label>Filter by  campus</label>
            </div>
            <div class="col s12">
                <button type="submit" class="btn pink darken-4">Register User</button>
            </div>
        </div>
    </form>
</div>
</body>
<script>
    $(document).ready(function(){
        $('select').formSelect();
    });
</script>
</html>
