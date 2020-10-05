<%@ page import="models.Staff" %>
<%@ page import="models.Student" %>
<%@ page import="models.Professor" %><%--
  Created by IntelliJ IDEA.
  User: User
  Date: 9/23/2020
  Time: 3:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<nav class="pink darken-4" role="navigation">
    <div class="nav-wrapper">
        <a id="logo-container" href="#" class="brand-logo">LMS</a>
        <ul class="right hide-on-med-and-down">
            <%
                Object user = session.getAttribute("user");
                if (user == null) {
            %>
            <li><a href="index.jsp">Home</a></li>
            <li><a href="books">Books</a></li>
            <li><a href="help.jsp">Help</a></li>
            <li><a href="#">Contact</a></li>
            <%
                } else if (user instanceof Staff) {
                    Staff staff = (Staff) user;
            %>
            <li><a href="staff">Home</a></li>
            <li><a class='dropdown-trigger' href='#' data-target='manage-books'>Manage books<i class="material-icons right">arrow_drop_down</i></a></li>
            <li><a href="receive-book">Receive Book</a></li>

            <%
                if (staff.isAdmin()) {
            %>

            <li>
                <a class='dropdown-trigger'href='#' data-target='manage-users'>Manage users
                    <i class="material-icons right">arrow_drop_down</i>
                </a>
            </li>
            <li><a href="campuses">Campuses</a></li>

            <ul id='manage-users' class='dropdown-content'>
                <li><a href="register-staff">Add staff</a></li>
                <li><a href="register-student">Add Student</a></li>
                <li><a href="register-professor">Add Professor</a></li>
                <li><a href="users">View Staff</a></li>
                <li><a href="students">View Students</a></li>
                <li><a href="professors">View Professors</a></li>
            </ul>
            <%
                }
            %>

            <li>
                <a href="#" class="dropdown-trigger" data-target="profile-dropdown">
                    <i class="valign-wrapper">
                        <img  style="height: 30px; width: 30px;" src="assets/img/background.jpg" alt="" class="responsive-img circle valign-wrapper">
                        &nbsp;
                        <span style="font-style: normal; font-size: 14px"><%=staff%></span>
                        <i class="material-icons right">arrow_drop_down</i>
                    </i>
                </a>
            </li>
            <ul id='manage-books' class='dropdown-content'>
                <li><a href="new-book">Add book</a></li>
                <li><a href="new-e-book">Add e-book</a></li>
                <li><a href="books">View books</a></li>
                <li><a href="e-books">View e-books</a></li>
            </ul>

            <ul id='profile-dropdown' class='dropdown-content'>
                <li><a href="profile">Profile</a></li>
                <li><a href="logout">Logout</a></li>
            </ul>

            <%
            } else if (user instanceof Student) {
                    Student student = (Student) user;
            %>
            <li><a href="student">Home</a></li>
            <li><a class='dropdown-trigger' href='#' data-target='find-books-students'>Find book<i class="material-icons right">arrow_drop_down</i></a></li>
            <ul id='find-books-students' class='dropdown-content'>
                <li><a href="books">books</a></li>
                <li><a href="e-books">e-books</a></li>
            </ul>
            <li>
                <a href="#" class="dropdown-trigger" data-target="profile-student">
                    <i class="valign-wrapper">
                        <img  style="height: 30px; width: 30px;" src="assets/img/background.jpg" alt="" class="responsive-img circle valign-wrapper">
                        &nbsp;
                        <span style="font-style: normal; font-size: 14px"><%=student%></span>
                        <i class="material-icons right">arrow_drop_down</i>
                    </i>
                </a>
            </li>
            <ul id='profile-student' class='dropdown-content'>
                <li><a href="profile">Profile</a></li>
                <li><a href="logout">Logout</a></li>
            </ul>
            <%
            } else if (user instanceof Professor) {
                    Professor professor = (Professor) user;
            %>
            <li><a href="professor">Home</a></li>
            <li><a class='dropdown-trigger' href='#' data-target='find-books-prof'>Find book<i class="material-icons right">arrow_drop_down</i></a></li>
            <ul id='find-books-prof' class='dropdown-content'>
                <li><a href="books">books</a></li>
                <li><a href="e-books">e-books</a></li>
            </ul>
            <li>
                <a href="#" class="dropdown-trigger" data-target="profile-professor">
                    <i class="valign-wrapper">
                        <img  style="height: 30px; width: 30px;" src="assets/img/background.jpg" alt="" class="responsive-img circle valign-wrapper">
                        &nbsp;
                        <span style="font-style: normal; font-size: 14px"><%=professor%></span>
                        <i class="material-icons right">arrow_drop_down</i>
                    </i>
                </a>
            </li>
            <ul id='profile-professor' class='dropdown-content wrapper'>
                <li><a href="profile">Profile</a></li>
                <li><a href="logout">Logout</a></li>
            </ul>
            <%
            } else  {
                    session.invalidate();
                    response.sendRedirect("index.jsp");
                    return;
            }
            %>
        </ul>


<%--        Mobile--%>
        <ul id="nav-mobile" class="sidenav pink darken-4">
            <li>
                <h1 class="p-2">LMS</h1>
            </li>
            <%
                if (user == null) {
            %>
            <li><a href="index.jsp">Home</a></li>
            <li><a href="#">About</a></li>
            <li><a href="#">Contact</a></li>
            <%
            } else if (user instanceof Staff) {
                Staff staff = (Staff) user;
            %>
            <li><a href="staff">Home</a></li>
            <li><a class='dropdown-trigger' href='#' data-target='manage-books1'>Manage books<i class="material-icons right">arrow_drop_down</i></a></li>
            <li><a href="receive-book">Receive Book</a></li>
            <li>
                <a href="#" class="dropdown-trigger" data-target="profile-dropdown1">
                    <i class="valign-wrapper">
                        <img  style="height: 30px; width: 30px;" src="assets/img/background.jpg" alt="" class="responsive-img circle valign-wrapper">
                        &nbsp;
<%--                        <span style="font-style: normal; font-size: 14px"><%=staff%></span>--%>
                        <i class="material-icons right">arrow_drop_down</i>
                    </i>
                </a>
            </li>

            <ul id='manage-books1' class='dropdown-content'>
                <li><a href="new-book">Add book</a></li>
                <li><a href="new-e-book">Add e-book</a></li>
                <li><a href="books">View books</a></li>
                <li><a href="e-books">View e-books</a></li>
            </ul>

            <%
                if (staff.isAdmin()) {
            %>

            <li>
                <a class='dropdown-trigger'href='#' data-target='manage-users1'>Manage users
                     <i class="material-icons right">arrow_drop_down</i>
                 </a>
            </li>
            <li><a href="campuses">Campuses</a></li>

            <ul id='manage-users1' class='dropdown-content'>
                <li><a href="register-staff">Add staff</a></li>
                <li><a href="register-student">Add Student</a></li>
                <li><a href="register-professor">Add Professor</a></li>
                <li><a href="users">View Staff</a></li>
                <li><a href="students">View Students</a></li>
                <li><a href="professors">View Professors</a></li>
            </ul>
            <%
                }
            %>

            <ul id='profile-dropdown1' class='dropdown-content'>
                <li><a href="profile">Profile</a></li>
                <li><a href="logout">Logout</a></li>
            </ul>

            <%
            } else if (user instanceof Student) {
                Student student = (Student) user;
            %>
            <li><a href="student">Home</a></li>
            <li><a class='dropdown-trigger' href='#' data-target='find-books-students1'>Find book<i class="material-icons right">arrow_drop_down</i></a></li>
            <ul id='find-books-students1' class='dropdown-content'>
                <li><a href="books">books</a></li>
                <li><a href="e-books">e-books</a></li>
            </ul>
            <li>
                <a href="#" class="dropdown-trigger" data-target="profile-student1">
                    <i class="valign-wrapper">
                        <img  style="height: 30px; width: 30px;" src="assets/img/background.jpg" alt="" class="responsive-img circle valign-wrapper">
                        &nbsp;
<%--                        <span style="font-style: normal; font-size: 14px"><%=student%></span>--%>
                        <i class="material-icons right">arrow_drop_down</i>
                    </i>
                </a>
            </li>
            <ul id='profile-student1' class='dropdown-content'>
                <li><a href="profile">Profile</a></li>
                <li><a href="logout">Logout</a></li>
            </ul>
            <%
            } else if (user instanceof Professor) {
                Professor professor = (Professor) user;
            %>
            <li><a href="professor">Home</a></li>
            <li><a class='dropdown-trigger' href='#' data-target='find-books-prof1'>Find book<i class="material-icons right">arrow_drop_down</i></a></li>
            <ul id='find-books-prof1' class='dropdown-content'>
                <li><a href="books">books</a></li>
                <li><a href="e-books">e-books</a></li>
            </ul>
            <li>
                <a href="#" class="dropdown-trigger" data-target="profile-professor1">
                    <i class="valign-wrapper">
                        <img  style="height: 30px; width: 30px;" src="assets/img/background.jpg" alt="" class="responsive-img circle valign-wrapper">
                        &nbsp;
<%--                        <span style="font-style: normal; font-size: 14px"><%=professor%></span>--%>
                        <i class="material-icons right">arrow_drop_down</i>
                    </i>
                </a>
            </li>
            <ul id='profile-professor1' class='dropdown-content wrapper'>
                <li><a href="profile">Profile</a></li>
                <li><a href="logout">Logout</a></li>
            </ul>
            <%
                } else  {
                    session.invalidate();
                    response.sendRedirect("index.jsp");
                    return;
                }
            %>
        </ul>
        <a href="#" data-target="nav-mobile" class="sidenav-trigger"><i class="material-icons">menu</i></a>
    </div>
    <script>
        $(document).ready(function (e) {
            $('.dropdown-trigger').dropdown();
        })
    </script>
</nav>
