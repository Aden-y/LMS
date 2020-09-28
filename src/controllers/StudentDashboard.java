package controllers;

import dao.BookRequestDAO;
import dao.BorrowerDAO;
import models.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "StudentDashboard", urlPatterns = {"/student"})
public class StudentDashboard extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("CancelRequest")  != null) {
            BookRequestDAO.delete(Integer.parseInt(request.getParameter("RequestId")));
            response.sendRedirect("student");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Student student = (Student) request.getSession().getAttribute("user");
            request.setAttribute("requests", BookRequestDAO.findByBorrowerId(student.getBorrowerId()));
            request.setAttribute("borrowed", BorrowerDAO.get(student.getBorrowerId()));
            request.getRequestDispatcher("student.jsp").forward(request, response);
        }catch (Exception e) {
            e.printStackTrace();
            request.getSession().invalidate();
            response.sendRedirect("index.jsp");
        }
    }
}
