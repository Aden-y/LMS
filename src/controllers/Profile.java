package controllers;

import dao.ProfessorDAO;
import dao.StaffDAO;
import dao.StudentDAO;
import models.Professor;
import models.Staff;
import models.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Profile", urlPatterns = {"/profile"})
public class Profile extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Object user = request.getSession().getAttribute("user");
        String email = request.getParameter("Email"),
                phone  = request.getParameter("Phone"),
                newPassword = request.getParameter("NewPassword");
        if (user instanceof Staff) {
            Staff staff = (Staff) user;
            staff.setEmail(email);
            staff.setPhone(phone);
            if (!newPassword.equals("")) {
                staff.setPassword(newPassword);
            }
            StaffDAO.updateProfile(staff);
        }else if (user instanceof Student) {
            Student student = (Student) user;
            student.setEmail(email);
            student.setPhone(phone);
            if (!newPassword.equals("")) {
                student.setPassword(newPassword);
            }
            StudentDAO.updateProfile(student);
        }else if (user instanceof Professor) {
            Professor professor = (Professor) user;
            professor.setEmail(email);
            professor.setPhone(phone);
            if (!newPassword.equals("")) {
                professor.setPassword(newPassword);
            }
            ProfessorDAO.updateProfile(professor);
        }
        response.sendRedirect("profile.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("profile.jsp");
    }
}
