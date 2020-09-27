package controllers;

import dao.CampusDAO;
import dao.StaffDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Users", urlPatterns = {"/users"})
public class Users extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("campuses", CampusDAO.all());
        request.setAttribute("users", StaffDAO.all());
        request.getRequestDispatcher("users.jsp").forward(request, response);
    }
}
