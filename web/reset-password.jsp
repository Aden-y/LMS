<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 10/5/2020
  Time: 1:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="templates/header.html"/>
<body>
<jsp:include page="templates/nav.jsp"/>
<div class="p-2">
    <h4 class="title color-primary center">Password Recovery</h4>

    <div class="container">
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
            } if (request.getAttribute("updated") != null) {
        %>
        <div class="s12 alert green darken-1 center">
            Password reset. <a href="index.jsp">Go to login page</a>
        </div>
        <%
            }
        %>
    </div>

    <%
        if (request.getAttribute("Ok") == null) {
    %>
    <form action="reset-password" method="post">
        <div>
            <p>Choose role</p>
            <label>
                <input name="Role" type="radio"  value="Staff" checked/>
                <span>Staff</span>
            </label>

            <label>
                <input name="Role" type="radio"  value="Student"/>
                <span>Student</span>
            </label>

            <label>
                <input name="Role" type="radio"  value="Professor"/>
                <span>Professor</span>
            </label>
        </div>
        <div class="input-field">
            <input type="email" class="validate" required name="Email" id="Email">
            <label for="Email">Enter email address</label>
        </div>
        <input type="submit" class="btn pink darken-4" name="RequestCode" value="Request Code">
    </form>

    <div>
        <form action="reset-password" method="post">
            <div class="input-field">
                <input type="number" class="validate" name="Code" id="Code" required>
                <label for="Code">Enter code sent to email </label>
            </div>
            <input type="submit" name="ValidateCode" value="Validate" class="btn pink darken-4">
        </form>
    </div>
    <%
        }else {
    %>
        <div class="row">
           <form action="reset-password" method="post">
               <div class="col s12 m6 l6 input-field">
                   <input type="password" name="NewPassword" id="NewPassword" class="validate" required>
                   <label for="NewPassword">Enter new password</label>
               </div>

               <div class="col s12 m6 l6 input-field">
                   <input type="password" name="ConfirmNewPassword" id="ConfirmNewPassword" class="validate" required>
                   <label for="ConfirmNewPassword">Confirm new password</label>
               </div>
               <input type="submit" class="btn pink darken-4" name="ChangePassword" value="Change Password">
           </form>
        </div>
    <%
        }
    %>
</div>
</body>
<script>
    function validate(form) {
        if (form.NewPassword.value.length < 6){
            alert('Password must be 6 characters or more');
            return false;
        }

        if (form.NewPassword.value != form.ConfirmNewPassword.value) {
            alert('Passwords do not match');
            return false;
        }
        return true;
    }
</script>
</html>
