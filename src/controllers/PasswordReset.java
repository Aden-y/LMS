package controllers;

import dao.PasswordResetTokenDAO;
import dao.ProfessorDAO;
import dao.StaffDAO;
import dao.StudentDAO;
import models.PasswordResetToken;
import models.Professor;
import models.Staff;
import models.Student;
import services.MailerService;
import services.PasswordGeneratorService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "PasswordReset", urlPatterns = {"/reset-password"})
public class PasswordReset extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("RequestCode") != null) {
            String role = request.getParameter("Role"),
                    email = request.getParameter("Email");
            boolean userFound = false;
            if (role.equals("Staff")) {
                Staff staff = StaffDAO.findByEmail(email.trim());
                userFound = staff != null;
            }else if (role.equals("Student")) {
                Student student = StudentDAO.findByEmail(email.trim());
                userFound = student != null;
            }else{
                Professor professor = ProfessorDAO.findByEmail(email.trim());
                userFound = professor != null;
            }
            if (userFound) {
                PasswordResetToken token = new PasswordResetToken(role, PasswordGeneratorService.generateCode(), email);
                PasswordResetTokenDAO.create(token);
                MailerService.sendMessage(email, "Password Reset", "Your password reset token is: "+token.getToken());
                request.setAttribute("message", "Password reset code sent to the email "+email+". Validate the code to reset password");
                request.getSession().setAttribute("role", role);
            }else {
                request.setAttribute("error", "No "+role+" registered with the email "+email);
            }
            request.getRequestDispatcher("reset-password.jsp").forward(request, response);
            return;
        }else if (request.getParameter("ValidateCode") != null) {

            String role = (String) request.getSession().getAttribute("role");
            if (role == null) {
                request.setAttribute("error", "Please request code first");
                request.getRequestDispatcher("reset-password.jsp").forward(request, response);
                return;
            }
            String code = request.getParameter("Code");
            PasswordResetToken token = PasswordResetTokenDAO.fetch(role, code.trim());
            if (token == null){
                request.setAttribute("error", "Could not validate this token. You can request another");
            }else {
                request.getSession().setAttribute("email", token.getEmail());
                request.setAttribute("Ok", true);
            }
            request.getRequestDispatcher("reset-password.jsp").forward(request, response);
            return;
        }else if (request.getParameter("ChangePassword") != null) {
            String role = (String) request.getSession().getAttribute("role"),
            email = (String) request.getSession().getAttribute("email"),
             newPassword = request.getParameter("NewPassword");
            if (role.equals("Student")) {
                Student student = StudentDAO.findByEmail(email);
                student.setPassword(newPassword);
                StudentDAO.updateProfile(student);
            }else if (role.equals("Staff")) {
                Staff staff = StaffDAO.findByEmail(email);
                staff.setPassword(newPassword);
                StaffDAO.updateProfile(staff);
            }else if (role.equals("Professor")) {
                Professor professor = ProfessorDAO.findByEmail(email);
                professor.setPassword(newPassword);
                ProfessorDAO.updateProfile(professor);
            }
            PasswordResetTokenDAO.delete(role, email);
            request.setAttribute("updated", true);
            request.getRequestDispatcher("reset-password.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("reset-password.jsp");
    }
}
