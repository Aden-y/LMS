package controllers;

import dao.BorrowerDAO;
import dao.ProfessorBorrowDAO;
import models.Borrower;
import models.ProfessorBorrow;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ReceiveBook", urlPatterns = {"/receive-book"})
public class ReceiveBook extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("ReceiveFromStudent") != null) {
            int borrowerId = Integer.parseInt(request.getParameter("BorrowerId"));
            Borrower borrower = BorrowerDAO.get(borrowerId);
            if (borrower == null) {
                request.setAttribute("error", "No record found for the borrower.");
            }else {
                request.setAttribute("borrower", borrower);
            }
            request.getRequestDispatcher("receive-book.jsp").forward(request, response);
            return;
        }

        if (request.getParameter("ReceiveFromProfessor") != null) {
            List<ProfessorBorrow> borrows = ProfessorBorrowDAO.get(request.getParameter("EmploymentNo").trim());
            request.setAttribute("borrows", borrows);
            request.getRequestDispatcher("receive-book.jsp").forward(request, response);
            return;
        }

        if (request.getParameter("ClearProfessor") != null) {
            String employmentNo = request.getParameter("EmploymentNo");
            int ISBNCode = Integer.parseInt(request.getParameter("ISBNCode"));
            ProfessorBorrowDAO.clear(employmentNo, ISBNCode );
            List<ProfessorBorrow> borrows = ProfessorBorrowDAO.get(employmentNo);
            request.setAttribute("borrows", borrows);
            request.getRequestDispatcher("receive-book.jsp").forward(request, response);
            return;
        }

        if (request.getParameter("ClearStudent") != null) {
            BorrowerDAO.clear(Integer.parseInt(request.getParameter("BorrowerId")));
            response.sendRedirect("receive-book");
            return;
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("receive-book.jsp");
    }
}
