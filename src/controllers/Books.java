package controllers;

import dao.*;
import models.BookRequest;
import models.Professor;
import models.ProfessorBookRequest;
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

        if (request.getParameter("ProfessorRequestBook") != null) {
            Professor professor = (Professor) request.getSession().getAttribute("user");
            int ISBNCode = Integer.parseInt(request.getParameter("ISBNCode"));
            ProfessorBookRequest bookRequest = new ProfessorBookRequest(ISBNCode, professor.getEmploymentId());
            ProfessorBookRequestDAO.create(bookRequest);
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
