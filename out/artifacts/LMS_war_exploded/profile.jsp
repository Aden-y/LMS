<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 9/29/2020
  Time: 12:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="templates/header.html"/>
<%
    Object user = session.getAttribute("user");
    if (user == null) {
        session.invalidate();
        response.sendRedirect("index.jsp");
        return;
    }
%>
<body>
<jsp:include page="templates/nav.jsp"/>
<div class="p-2">
    <h4 class="title color-primary center">Manage Profile</h4>
    <form action="profile" method="post">
        <diV class="row">
            <div class="col s12 m4 l4">
                <div class="card center p-2">
                    <p><strong>Name</strong></p>
                    <p><label>Joakim Adeny</label></p>
                    <p><strong>Employee Number</strong></p>
                    <p><label>EMP001</label></p>
                    <p><strong>Campus</strong></p>
                    <p><label>campus 1</label></p>
                </div>
            </div>
            <div class="row col s12 m8 l8">
                <div class="card p-2">
                    <div class="input-field col s12 m6 l6">
                        <input type="email" name="Email" value="" id="Email">
                        <label for="Email">Email Address</label>
                    </div>

                    <div class="input-field col s12 m6 l6">
                        <input type="tel" name="Phone" value="" id="Phone">
                        <label for="Phone">Phone Number</label>
                    </div>
                    <div class="col s12 m6 l6 input-field">
                        <input type="password" name="NewPassword" id="NewPassword">
                        <label for="NewPassword">New Password</label>
                    </div>
                    <div class="col s12 m6 l6 input-field">
                        <input type="password" name="ConfirmNewPassword" id="ConfirmNewPassword">
                        <label for="ConfirmNewPassword">Confirm New Password</label>
                    </div>

                    <div class="col s12  input-field">
                        <input type="password" name="CurrentPassword" id="CurrentPassword">
                        <label for="CurrentPassword">Enter current password to save the changes</label>
                    </div>

                    <input type="submit" class="btn pink darken-4" name="UpdateProfile" value="Save Changes">
                </div>
            </div>
        </diV>
    </form>
</div>

</body>
</html>
