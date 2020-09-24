package controllers;

import dao.BookRequestDAO;
import models.Staff;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "IssueBook")
public class IssueBook extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("IssueBook") != null) {
            int requestId = Integer.parseInt(request.getParameter("RequestId"));
            Staff staff  = (Staff) request.getSession().getAttribute("user");
            BookRequestDAO.accept(BookRequestDAO.get(requestId), staff.getUserId());
        }

        response.sendRedirect("book-requests");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
