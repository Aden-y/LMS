package controllers;

import dao.CampusDAO;
import models.Campus;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Campuses", urlPatterns = {"/campuses"})
public class Campuses extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("NewCampus") != null) {
            String campusName = request.getParameter("CampusName");
            CampusDAO.create(new Campus(campusName));
            response.sendRedirect("campuses");
            return;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("campuses", CampusDAO.all());
        request.getRequestDispatcher("campuses.jsp").forward(request, response);
    }
}
