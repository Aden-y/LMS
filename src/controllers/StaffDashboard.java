package controllers;

import dao.BookRequestDAO;
import models.Staff;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "StaffDashboard", urlPatterns = {"/staff"})
public class StaffDashboard extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("ApproveRequest") != null) {
            Staff staff = (Staff) request.getSession().getAttribute("user");
            BookRequestDAO.accept(BookRequestDAO.get(Integer.parseInt(request.getParameter("RequestId"))),staff.getUserId());
            response.sendRedirect("staff");
            return;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Staff staff = (Staff) request.getSession().getAttribute("user");
            request.setAttribute("requests", BookRequestDAO.findByCampus(staff.getCampusNo()));
            request.getRequestDispatcher("staff.jsp").forward(request, response);
        }catch (Exception e){
            request.getSession().invalidate();
            response.sendRedirect("index.jsp");
        }
    }
}
