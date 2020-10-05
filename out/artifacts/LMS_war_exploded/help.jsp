<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 10/5/2020
  Time: 3:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="templates/header.html"/>
<body>
<jsp:include page="templates/nav.jsp"/>
<div class="p-2">
    <h4 class="title color-primary center">How it works</h4>
    <div id="about">
        <h6 class="title color-primary ">About LMS</h6>
        <p>
            <strong>LMS</strong> is short abbreviation for Library Management System.<br>
            The system manages books in the library allowing students and professors to access and borrow books.

        </p>
    </div>

    <div id="access">
        <h6 class="title color-primary ">Accessing the system</h6>
        <p>To access  the system you have to login to your respective role. i.e <br>
            <ul>
                <li>Staff - Librarian</li>
                <li>Student </li>
                <li>Professor</li>
            </ul>
        </p>

        <p><a href="index.jsp">Go to login page</a> </p>
    </div>

    <div id="registration">
        <h6 class="title color-primary ">Registration</h6>
        <p>All users are registered by an admin. There are three types of users Librarian(Staff), Student and Professor</p>
    </div>

    <div id="books">
        <h6 class="title color-primary ">Books</h6>
        <p>Students and professors are able to view and borrow books. Clicking on the books option in the nav bar will lead you to the books page where you
        will be able to request to borrow a book. <br>
        Once you request for a book, your request has to be accepted by a Librarian.<br>
        <strong>Note :</strong> You can only borrow one book if you are a student. The maximum time you can spend with the book if 14 days (2 weeks)</p>
    </div>
</div>
</body>
</html>
