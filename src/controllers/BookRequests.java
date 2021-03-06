package controllers;

import dao.BookRequestDAO;
import models.Staff;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "BookRequests", urlPatterns = {"/book-requests"})
public class BookRequests extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Staff staff = (Staff) request.getSession().getAttribute("user");
        request.setAttribute("requests", BookRequestDAO.findByCampus(staff.getCampusNo()));
        request.getRequestDispatcher("book-requests.jsp").forward(request, response);
    }
}
