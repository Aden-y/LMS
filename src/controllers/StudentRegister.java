package controllers;

import dao.StudentDAO;
import models.Student;
import services.MailerService;
import services.PasswordGeneratorService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

@WebServlet(name = "StudentRegister", urlPatterns = {"/register-student"})
public class StudentRegister extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String studentNumber = request.getParameter("StudentNumber"),
                firstName  = request.getParameter("FirstName"),
                lastName = request.getParameter("LastName"),
                phone = request.getParameter("Phone"),
                email = request.getParameter("Email"),
                sex = request.getParameter("Sex"),
                department = request.getParameter("Department"),
                password = PasswordGeneratorService.generate(6);
        Date dateOfBirth = Date.valueOf(request.getParameter("DateOfBirth"));
        int campusNo = Integer.parseInt("CampusNo");
        StudentDAO.create(new Student( studentNumber, firstName, lastName, phone, email, sex, department, password, dateOfBirth, campusNo));
        Student student = StudentDAO.get(studentNumber);
        String subject = "Registration in the School Library Management System",
                message = "You have been registered as as student into the school Library.\n" +
                        "User your student number "+student.getStudentNumber()+" and password "+student.getPassword()+" to access the system.\n" +
                        "Your borrower ID is "+student.getBorrowerId();
        MailerService.sendMessage(student.getEmail(), subject, message);

        request.setAttribute("message", "Student registered. Details sent to email "+student.getEmail());
        request.getRequestDispatcher("register-student").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("register-student").forward(request, response);
    }
}
