package controllers;

import dao.ProfessorDAO;
import models.Professor;
import services.MailerService;
import services.PasswordGeneratorService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ProfessorRegister", urlPatterns = {"/register-professor"})
public class ProfessorRegister extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String employmentId = request.getParameter("EmploymentId"),
                firstName  = request.getParameter("FirstName"),
                lastName = request.getParameter("LastName"),
                phone = request.getParameter("Phone"),
                email = request.getParameter("Email"),
                department = request.getParameter("Department"),
                password = PasswordGeneratorService.generate(6);
        int employmentYear = Integer.parseInt(request.getParameter("EmploymentYear"));
        ProfessorDAO.create(new Professor( employmentId, firstName, lastName, phone, email, department, password, employmentYear));
        String subject = "Professor registration at School Library System",
                message = "You have been registered successfully as a Professor in the School Library System\n" +
                        "Access the system with the following details.\n" +
                        "Employment Number : "+employmentId+"\n" +
                        "Password          :"+password;
        //MailerService.sendMessage(email, subject, message);
        request.setAttribute("message", "Professor registered successfully. Credentials emailed at "+email);
        request.getRequestDispatcher("register-professor.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("register-professor.jsp").forward(request, response);
    }
}
