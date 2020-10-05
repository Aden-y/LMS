<%@ page import="java.util.List" %>
<%@ page import="models.*" %><%--
  Created by IntelliJ IDEA.
  User: User
  Date: 9/23/2020
  Time: 8:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="templates/header.html"/>
<%
    Object user = session.getAttribute("user");
//    if (user == null) {
//        session.invalidate();
//        response.sendRedirect("index.jsp");
//        return;
//    }
    List<Book> books = (List<Book>) request.getAttribute("books");
    List<BookCategory> categories = (List<BookCategory>) request.getAttribute("categories");
    List<Campus> campuses = (List<Campus>) request.getAttribute("campuses");

    if (books == null || campuses == null || categories == null) {
        response.sendRedirect("books");
        return;
    }
%>
<body>
    <jsp:include page="templates/nav.jsp"/>
<div class="p-2">
    <h4 class="title center color-primary">Library Books</h4>
    <div class="row">
        <div class="input-field col l4 s12 m4">
            <form action="books" method="post">
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
        <div class="input-field col l4 s12 m4">
            <form action="books" method="post">
                <select name="CategoryIdFilter" id="CategoryIdFilter">
                    <option value="" disabled selected>Select category</option>
                    <%
                        for (BookCategory category: categories) {
                    %>
                    <option value="<%=category.getCategoryId()%>"><%=category.getCategoryName()%></option>
                    <%
                        }
                    %>
                </select>
                <label>Filter by  category</label>
                <input type="submit" name="CategoryFilter" hidden id="CategoryFilter">
            </form>
        </div>
        <div class="input-field col l4 s12 m4">
            <form method="post" action="books">
                <input type="search" placeholder="Search by title" id="search">
            </form>
        </div>
    </div>
    <div>
        <table class="highlight">
            <thead>
            <tr>
                <th>ISBN</th>
                <th>Title</th>
                <th>Actual Copies</th>
                <th>Copies Available</th>
                <th>Shelf</th>
                <%
                    if (user != null) {
                %>
                <th>Action</th>
                <%
                    }
                %>
            </tr>
            </thead>

            <tbody>
            <%
                for (Book book : books) {
            %>
            <tr class="book-row">
                <td><%=book.getISBNCode()%></td>
                <td class="book-title">
                    <%=book.getTitle()%>
                </td>
                <td><%=book.getCopiesActual()%></td>
                <td><%=book.getCopiesAvailable()%></td>
                <td><%=book.getShelf()%></td>

                <%
                    if (user instanceof Student) {
                        Student student = (Student) user;
                %>
                <td>
                    <form action="books" method="post">
                        <input name="ISBNCode" value="<%=book.getISBNCode()%>" hidden>
                        <%
                            if (book.canRequest(student.getBorrowerId())) {
                        %>
                        <input type="submit" name="StudentRequestBook" class="btn-small pink darken-4" value="Request">
                        <%
                            }else{
                        %>
                        <input disabled type="submit" name="StudentRequestBook" class="btn-small pink darken-4" value="Request">
                        <%
                            }
                        %>

                    </form>
                </td>
                <%
                    } else if (user instanceof Professor){
                        Professor professor = (Professor) user;
                %>
                <td>
                    <form action="books" method="post">
                        <input name="ISBNCode" value="<%=book.getISBNCode()%>" hidden>

                        <%
                            if (book.canRequest(professor.getEmploymentId())) {
                        %>
                        <input type="submit" name="ProfessorRequestBook" class="btn-small pink darken-4" value="Request">
                        <%
                        }else{
                        %>
                        <input disabled type="submit" name="ProfessorRequestBook" class="btn-small pink darken-4" value="Request">
                        <%
                            }
                        %>
                    </form>
                </td>
                <%
                    } else if (user instanceof Staff) {
                %>
                <td>
                    <form action="books" method="post">
                        <input name="ISBNCode" value="<%=book.getISBNCode()%>" hidden>
                        <input type="submit" name="EditBook" class="btn-small pink darken-4" value="Edit">
                    </form>
                </td>
                <%
                    }
                %>
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
    
    function searchByTitle(word) {
        $('.book-row').each(function () {
            var tr = $(this);
            var td =  tr.find('.book-title');
            var title = td.text().toLocaleLowerCase();
            if (title.includes(word)) {
                tr.removeClass('d-none');
            }else {
                tr.addClass('d-none')
            }
        })
    }

    $('#search').keyup(function (e) {
        searchByTitle(this.value).toLocaleLowerCase();
    })

    $('#search').keydown(function (e) {
        searchByTitle(this.value).toLocaleLowerCase();
    })

    $('#CampusIdFilter').change(function (e) {
        document.getElementById('CampusFilter').click();
    })
    $('#CategoryIdFilter').change(function (e) {
        document.getElementById('CategoryFilter').click();
    })
</script>
</html>
