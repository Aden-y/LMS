package controllers;

import dao.BookCategoryDAO;
import dao.BookDAO;
import dao.BookRequestDAO;
import dao.CampusDAO;
import models.BookRequest;
import models.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Books", urlPatterns = {"/books"})
public class Books extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("StudentRequestBook") != null) {
            Student student = (Student) request.getSession().getAttribute("user");
            int ISBNCode = Integer.parseInt(request.getParameter("ISBNCode"));
            BookRequest bookRequest = new BookRequest(student.getBorrowerId(), ISBNCode);
            BookRequestDAO.create(bookRequest);
            response.sendRedirect("books");
            return;
        }

        if (request.getParameter("EditBook")  != null) {
            request.setAttribute("book", BookDAO.get(Integer.parseInt(request.getParameter("ISBNCode"))));
            request.getRequestDispatcher("edit-book.jsp").forward(request, response);
            return;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("books", BookDAO.all());
        request.setAttribute("campuses", CampusDAO.all());
        request.setAttribute("categories", BookCategoryDAO.all());
        request.getRequestDispatcher("books.jsp").forward(request, response);
    }
}
