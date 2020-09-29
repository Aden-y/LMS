package controllers;

import dao.BookCategoryDAO;
import dao.EBookDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "EBooks", urlPatterns = {"/e-books"})
public class EBooks extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("e-books", EBookDAO.all());
        request.setAttribute("categories", BookCategoryDAO.all());
        request.getRequestDispatcher("e-books.jsp").forward(request, response);
    }
}