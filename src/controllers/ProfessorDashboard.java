package controllers;

import dao.ProfessorBookRequestDAO;
import dao.ProfessorBorrowDAO;
import models.Professor;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ProfessorDashboard", urlPatterns = {"/professor"})
public class ProfessorDashboard extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("CancelRequest")  != null) {
            ProfessorBookRequestDAO.delete(Integer.parseInt(request.getParameter("RequestId")));
            response.sendRedirect("professor");
            return;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Professor professor = (Professor) request.getSession().getAttribute("user");
            request.setAttribute("requests", ProfessorBookRequestDAO.findByBorrowerId(professor.getEmploymentId()));
            request.setAttribute("borrowed", ProfessorBorrowDAO.get(professor.getEmploymentId()));
            request.getRequestDispatcher("professor.jsp").forward(request, response);
        }catch (Exception e) {
            e.printStackTrace();
            request.getSession().invalidate();
            response.sendRedirect("index.jsp");
        }
    }
}
