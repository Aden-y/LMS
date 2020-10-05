package controllers;

import dao.CampusDAO;
import dao.StaffDAO;
import models.Staff;
import services.MailerService;
import services.PasswordGeneratorService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "StaffRegister", urlPatterns = {"/register-staff"})
public class StaffRegister extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       String firstName = request.getParameter("FirstName"),
               lastName  = request.getParameter("LastName"),
               phone  = request.getParameter("Phone"),
               email = request.getParameter("Email"),
               //userId = request.getParameter("UserId"),
               password = PasswordGeneratorService.generate(6);
       int campusNo = Integer.parseInt(request.getParameter("CampusNo"));
        if (StaffDAO.findByEmail(email) != null) {
            request.setAttribute("error", "The email address has been used to register another staff.");
        }else {
            int userId = StaffDAO.create(new  Staff(firstName, lastName, phone, email, password, false, campusNo));

            String subject = "Staff registration at Library Management System",
                    message =  "You have been successfully registered as a Staff.\n" +
                            "Password : "+password+"\n" +
                            "User Id  :"+userId;
            MailerService.sendMessage(email, subject, message);
            request.setAttribute("message", "Staff registered successfully. Details emailed at "+email);
            request.setAttribute("campuses", CampusDAO.all());
        }
        request.getRequestDispatcher("register-staff.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("campuses", CampusDAO.all());
        request.getRequestDispatcher("register-staff.jsp").forward(request, response);
    }

}
